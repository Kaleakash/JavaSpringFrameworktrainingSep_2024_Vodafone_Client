package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	public ModelAndView sayHello() {
		System.out.println("I Came Here");
		ModelAndView mav =new ModelAndView();
		mav.setViewName("display1.jsp");
		return mav;
	}
}
