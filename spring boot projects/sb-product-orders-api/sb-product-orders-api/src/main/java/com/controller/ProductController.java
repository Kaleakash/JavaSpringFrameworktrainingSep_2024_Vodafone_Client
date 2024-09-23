package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Product;
import com.service.ProductService;

@RestController
@RequestMapping("products")	// http://localhost:9191/products/*
public class ProductController {

	@Autowired
	ProductService productService;
//curl -X GET http://localhost:9191/products/findAll
	@GetMapping(value = "findAll",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> findAll() {
		return productService.findAll();
	}
// curl -X POST http://localhost:9191/products/store -H "Content-Type:application/json" -d '{"pid":100,"pname":"TV","price":56000,"qty":10}'
	
	@PostMapping(value = "store",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeProdcut(@RequestBody Product product) {
		return productService.storeProduct(product);
	}
}
