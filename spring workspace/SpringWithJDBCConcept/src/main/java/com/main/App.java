package com.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Product;
import com.service.ProductService;

public class App {

	public static void main(String[] args) {
	ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	Scanner sc = new Scanner(System.in);
	int choice;
	String con;
	int pid;
	String pname;
	float price;
	String result;
	ProductService ps= (ProductService)ac.getBean("productService"); // id name using camel naming rule 
		do {
	System.out.println("1: Add Product, 2:Delete, 3:Update product price 4: view all product");
	System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:Product p1 = (Product)ac.getBean("product");
					System.out.println("Enter the product id");
					pid = sc.nextInt();
					System.out.println("Enter the product pname");
					pname = sc.next();
					System.out.println("Enter the product price");
					price = sc.nextFloat();
					p1.setPid(pid);
					p1.setPname(pname);
					p1.setPrice(price);
					result = ps.storeProduct(p1);
					System.out.println(result);
					break;

			default:System.out.println("wrong choice");
				break;
			}
			System.out.println("Do you want to continue?");
			con = sc.next();
		} while (con.equalsIgnoreCase("y"));
		System.out.println("Thank you!");
		ac.close();
		sc.close();
	}

}
