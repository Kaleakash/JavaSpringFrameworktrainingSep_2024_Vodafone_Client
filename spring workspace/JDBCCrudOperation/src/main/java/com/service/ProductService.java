package com.service;

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
}
