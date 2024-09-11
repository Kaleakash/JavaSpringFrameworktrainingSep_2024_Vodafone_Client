package com.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Address add = (Address)ac.getBean("address"); 
		System.out.println(add);
		add.setState("Kar");
		add.setCity("Bangalore");
		System.out.println(add);
		Employee emp = (Employee)ac.getBean("employee");
		System.out.println(emp);
	}

}
