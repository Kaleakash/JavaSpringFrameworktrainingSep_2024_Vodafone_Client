package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public String storeProduct(Product product) {
		if(productRepository.existsById(product.getPid())) {
			return "Product is must be unique";
		}else {
			productRepository.save(product);
			return "Product informaton stored successfully";
		}
	}
	
	public String updateProductDetails(Product product) {
		Optional<Product> result = productRepository.findById(product.getPid());
		if(result.isPresent()) {
		Product p	= result.get();
		p.setPrice(product.getPrice());
		p.setQty(product.getQty());
		productRepository.saveAndFlush(p);
		return "Product details updated successfully";
		}else {
			return "Product not present";
		}
	}
	
	public String deletedProduct(int pid) {
		Optional<Product> result = productRepository.findById(pid);
		if(result.isPresent()) {
			productRepository.deleteById(pid);
		return "Product deleted successfully";
		}else {
			return "Product not present";
		}
	}
	
	public String findProduct(int pid) {
		Optional<Product> result = productRepository.findById(pid);
		if(result.isPresent()) {
		Product p	= result.get();
			return p.toString();
		}else {
			return "Product not present";
		}
	}
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public List<Product> findProductByPrice(float price){
		return productRepository.findProductByPrice(price);
	}
	
	public String updateProductDetailsWithCustomQuery(Product product) {
		if(productRepository.updateProductQtyUsingPrice(product.getQty(), product.getPrice())>0) {
			return "Product updated successfully";
		}else {
			return "Product didn't update";
		}
	}
}
