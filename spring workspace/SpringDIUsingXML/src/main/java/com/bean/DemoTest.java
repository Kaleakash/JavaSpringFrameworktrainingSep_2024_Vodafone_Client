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
		Employee e1 = (Employee)bean.getBean("emp1");
		e1.display();
		
		Employee e2 = (Employee)bean.getBean("emp1");
		e2.display();
		System.out.println("---------------");
		Employee e3 = (Employee)bean.getBean("emp2");
		e3.display();
		
		Employee e4 = (Employee)bean.getBean("emp2");
		e4.display();
	}

}
