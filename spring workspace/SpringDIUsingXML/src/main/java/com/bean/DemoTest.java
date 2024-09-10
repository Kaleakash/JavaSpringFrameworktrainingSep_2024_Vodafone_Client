package com.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class DemoTest {

	public static void main(String[] args) {
//		Employee emp1 = new Employee();
//		emp1.display();
//		Employee emp2 = new Employee();
//		emp2.display();
		
		Resource res = new ClassPathResource("beans.xml");  // load xml file 	
		BeanFactory bean = new XmlBeanFactory(res);			// created BeanFactory interface reference
		
//		Employee e1 = (Employee)bean.getBean("emp1");
//		e1.display();
//		
//		Employee e2 = (Employee)bean.getBean("emp1");
//		e2.display();
//		System.out.println("---------------");
//		Employee e3 = (Employee)bean.getBean("emp2");
//		e3.display();
//		
//		Employee e4 = (Employee)bean.getBean("emp2");
//		e4.display();
		
		Employee e5 = (Employee)bean.getBean("emp1");
		System.out.println(e5);    // it will call toString method to get details 
		
		Employee e6 = (Employee)bean.getBean("emp2");
		System.out.println(e6);
		
		Employee e7 = (Employee)bean.getBean("emp3");
		System.out.println(e7);
		
		Employee e8 = (Employee)bean.getBean("emp4");
		System.out.println(e8);
	}

}
