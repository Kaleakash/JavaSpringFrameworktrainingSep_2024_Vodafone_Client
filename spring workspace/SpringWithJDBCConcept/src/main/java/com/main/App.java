package com.main;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
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
	System.out.println("1: Add Product, 2:Delete, 3:Update product price 4: view all product 5: view all product as map");
	System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1: Product p1 = (Product)ac.getBean("product");
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
					
			case 2:System.out.println("Enter the product id to delete");
			      pid = sc.nextInt();
			      result = ps.deleteProduct(pid);
			      System.out.println(result);
			      break;
			      
			case 3:System.out.println("Enter the product pid");
			      pid = sc.nextInt();
			      System.out.println("Enter the product price to update");
			      price = sc.nextFloat();
			      Product p2 = (Product)ac.getBean("product");
			      p2.setPid(pid);
			      p2.setPrice(price);
			      result = ps.updateProductPrice(p2);
			      System.out.println(result);
			      break;
			      
			case 4:List<Product> listOfProduct = ps.findAll();
			      for(Product p : listOfProduct) {
			    	  System.out.println(p);
			      }
			      break;
			case 5: List<Map<String, Object>> list = ps.findAllProductAsMap();
					Iterator<Map<String,Object>> li = list.iterator();
					while(li.hasNext()) {
						Map<String, Object> mm = li.next();
						System.out.println(mm);
					}
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
