package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstClientController {

	@GetMapping(value = "")
	public String greeting() {
		return "Welcome to Spring boot with first client in micro service";
	}
}
