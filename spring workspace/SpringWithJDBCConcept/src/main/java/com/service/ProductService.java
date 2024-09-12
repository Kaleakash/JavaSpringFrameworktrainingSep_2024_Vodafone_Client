package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Product;
import com.dao.ProductDao;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;
	
	public String storeProduct(Product product) {
		if(product.getPrice()<1000) {
			return "Product price must be > 1000";
		}else if(productDao.storeProduct(product)>0) {
			return "Product stored";
		}else {
			return "Product didn't store";
		}
	}
	
	public String deleteProduct(int pid) {
		if(productDao.deleteProduct(pid)>0) {
			return "Product deleted successfully";
		}else {
			return "Product not present";
		}
	}
	public String updateProductPrice(Product product) {
		if(productDao.updateProductPrice(product)>0) {
			return "Product updated successfully";
		}else {
			return "Product not present";
		}
	}
	
	public List<Product> findAll() {
		return productDao.findAll();
	}
}
