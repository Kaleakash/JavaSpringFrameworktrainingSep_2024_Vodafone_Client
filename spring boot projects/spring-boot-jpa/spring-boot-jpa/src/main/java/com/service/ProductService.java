package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProductDao;
import com.entity.Product;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;
	
	public String storeProduct(Product product) {
		if(product.getPrice()<1000) {
			return "Product price must be > 1000";
		}if(productDao.storeProduct(product)>0) {
			return "Product stored";
		}else {
			return "Product didn't store";
		}
	}
	
	public List<Product> findAllProducts() {
		return productDao.findAllProduct();
	}
	
	public String updateProductPrice(Product product) {
		if(productDao.updateProductPrice(product)>0) {
			return "Product price updated";
		}else {
			return "Product price didn't update";
		}
	}
	public String deleteProduct(int pid) {
		if(productDao.deleteProduct(pid)>0) {
			return "Record deleted successfully";
		}else {
			return "Record not present";
		}
	}
	
	public Product findProduct(int pid) {
		return productDao.searchProductByPid(pid);
	}
}



