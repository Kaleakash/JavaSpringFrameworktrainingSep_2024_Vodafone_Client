package com.main;

import java.util.List;
import java.util.Scanner;

import com.bean.Product;
import com.service.ProductService;

public class App {

	public static void main(String[] args) {
	ProductService ps = new ProductService();
	Scanner sc = new Scanner(System.in);
	
	// insert query 
//	System.out.println("Enter the pid");
//	int pid = sc.nextInt();
//	System.out.println("Enter the pname");
//	String pname = sc.next();
//	System.out.println("Enter the price");
//	float price  = sc.nextFloat();
//	Product p1 = new Product(pid,pname,price);
//	String result = ps.storeProduct(p1);
//	System.out.println(result);
	
	List<Product> listofproduct = ps.findAllProduct();
	for(Product p :listofproduct) {
		System.out.println(p);    // call toString method 
	}
	}

}
