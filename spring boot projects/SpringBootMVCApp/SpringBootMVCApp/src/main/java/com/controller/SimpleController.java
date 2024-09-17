package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SimpleController {
	// http://localhost:9191/
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String openPage() {
		System.out.println("index page open");
		return "index";		// using view resolver it check page inside 
							// template folder 
	}
	
	// http://localhost:9191/loginPage
	@RequestMapping(value = "loginPage",method = RequestMethod.GET)
	public String loginPage() {
		System.out.println("login page open");
		return "login";		// using view resolver it check page inside 
							// template folder 
	}
	
}
