package com.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	// http://localhost:9191/singlequeryparam?name=Steven
	
	@RequestMapping(value = "singlequeryparam")
	public String queryParam(@RequestParam("name") String name) {
		return "Welcome user using query param"+name;
	}
	
	// http://localhost:9191/singlepathparam/Steven
	
	@RequestMapping(value = "singlepathparam/{name}")
	public String pathParam(@PathVariable("name") String name) {
		return "Welcome user using path param"+name;
	}
}
