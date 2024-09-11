package com.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.config.MyConfiguration;

public class DemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("partially xml base");
		//ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//		Address add = (Address)ac.getBean("address"); 
//		System.out.println(add);
//		add.setState("Kar");
//		add.setCity("Bangalore");
//		System.out.println(add);
//		Employee emp = (Employee)ac.getBean("employee");
//		System.out.println(emp);
//		ac.close();
		
		System.out.println("purely annotation base");
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
		Address add = (Address)ac.getBean("address"); 
		System.out.println(add);
		add.setState("Kar");
		add.setCity("Bangalore");
		System.out.println(add);
		Employee emp = (Employee)ac.getBean("employee");
		System.out.println(emp);
		ac.close();
	}

}
