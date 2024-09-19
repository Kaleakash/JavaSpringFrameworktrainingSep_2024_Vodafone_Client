package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@RequestMapping(value = "say",method = RequestMethod.GET)
	public @ResponseBody String sayHello() {
		System.out.println("I came here");
		return "Welcome to Spring boot with rest api";
	}
}
