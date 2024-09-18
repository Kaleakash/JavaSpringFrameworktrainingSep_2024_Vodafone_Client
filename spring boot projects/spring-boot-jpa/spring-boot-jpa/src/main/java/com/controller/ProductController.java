package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Product;
import com.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String indexPage(Product pp, Model mm) {
		List<Product> products = productService.findAllProducts();
		mm.addAttribute("products", products);
		mm.addAttribute("product", pp);
		return "index";
	}
	@RequestMapping(value = "addProduct",method = RequestMethod.POST)
	public String addProduct(Product pp, Model mm) {
		String result = productService.storeProduct(pp);
		System.out.println(result);
		mm.addAttribute("msg", result);
		pp.setPid(0);
		pp.setPname("");
		pp.setPrice(0.0f);
		List<Product> products = productService.findAllProducts();
		mm.addAttribute("products", products);
		mm.addAttribute("product", pp);
		return "index";
	}
}





