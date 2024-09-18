package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
			mm.addAttribute("bb", "Add Product");
		return "index";
	}
	@RequestMapping(value = "addProduct",method = RequestMethod.POST)
	public String addProduct(Product pp, Model mm,@RequestParam("mySubmitButton") String buttonValue) {
		String result="";
		if(buttonValue.equals("Add Product")) {
			result = productService.storeProduct(pp);	
		}else {
			result = productService.updateProductPrice(pp);
			mm.addAttribute("bb", "Add Product");
		}
		mm.addAttribute("msg", result);
		pp.setPid(0);
		pp.setPname("");
		pp.setPrice(0.0f);
		List<Product> products = productService.findAllProducts();
		mm.addAttribute("products", products);
		mm.addAttribute("product", pp);
		return "index";
	}
	
	@RequestMapping(value = "deleteProduct",method = RequestMethod.GET)
	public String deleteProduct(Product pp, Model mm, @RequestParam("pid") int pid) {
		System.out.println("delete method called.."+pid);
		String result = productService.deleteProduct(pid);
		mm.addAttribute("msg", result);
		pp.setPid(0);
		pp.setPname("");
		pp.setPrice(0.0f);
		List<Product> products = productService.findAllProducts();
		mm.addAttribute("products", products);
		mm.addAttribute("product", pp);
		mm.addAttribute("bb", "Add Product");
		return "index";
	}
	
	@RequestMapping(value = "updateProductInfo",method = RequestMethod.GET)
	public String findProductInfo(Product pp, Model mm, @RequestParam("pid") int pid) {
		// hold product record retrieve from db.
		pp = productService.findProduct(pid);
		List<Product> products = productService.findAllProducts();
		mm.addAttribute("products", products);
		mm.addAttribute("product", pp);
		mm.addAttribute("bb", "Update Product");
		return "index";
	}
}





