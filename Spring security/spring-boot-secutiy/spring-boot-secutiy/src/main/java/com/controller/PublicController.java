package com.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublicController {

	@GetMapping(value = "")
	public String greeting() {
		return "Welcome to Spring security Api";
	}
}
