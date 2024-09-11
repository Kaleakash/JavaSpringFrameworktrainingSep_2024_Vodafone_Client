package com.service;

import java.util.Iterator;
import java.util.List;

import com.bean.Product;
import com.dao.ProductDao;

public class ProductService {
	ProductDao pd = new ProductDao();
	
	public String storeProduct(Product product) {
		if(product.getPrice()<1000) {
			return "Price must be > 1000";
		}else if(pd.storeProduct(product)>0) {
			return "Product stored in db";
		}else {
			return "Product didn't store";
		}
	}
	
	public String deleteProduct(int pid) {
		if(pd.deleteProduct(pid)>0) {
			return "Product deleted successfully";
		}else {
			return "Product not present";
		}
	
	}
	
	public String updateProductPrice(Product product) {
		if(pd.updateProductPrice(product)>0) {
			return "Product price updated successfully";
		}else {
			return "Product not present";
		}
	}
	
	public List<Product> findAllProduct() {
		List<Product> listOfProduct = pd.findProducts();
		Iterator<Product> li = listOfProduct.iterator();
		while(li.hasNext()) {
			Product p = li.next();
			float discount = p.getPrice()-p.getPrice()*0.10f;
			p.setPrice(discount);
		}
		
		return listOfProduct;
	}
}
