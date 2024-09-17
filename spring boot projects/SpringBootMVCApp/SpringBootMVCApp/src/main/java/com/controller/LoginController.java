package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

	@RequestMapping(value = "checkLoginDetails",method = RequestMethod.GET)
	public String checkLoginDetailsUsingGet(HttpServletRequest req) {		// DI for request object. 
		String emailid = req.getParameter("emailid");
		String password = req.getParameter("password");
		if(emailid.equals("akash@gmail.com") && password.equals("123")) {
			return "success";
		}else {
			return "failure";
		}
	}
	
	@RequestMapping(value = "checkLoginDetails",method = RequestMethod.POST)
	public String checkLoginDetailsUsingPost(HttpServletRequest req) {		// DI for request object. 
		String emailid = req.getParameter("emailid");
		String password = req.getParameter("password");
		if(emailid.equals("akash@gmail.com") && password.equals("123")) {
			return "success";
		}else {
			return "failure";
		}
	}
}
