package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.GpayService;

@RestController
@RequestMapping("gpay")
public class GpayController {

	@Autowired
	GpayService gpayService;

	
//	curl -X POST http://localhost:8484/gpay/create/steven@gmail.com	
	
	@PostMapping(value = "create/{emailid}")
	public String createAccount(@PathVariable("emailid") String emailid) {
		return gpayService.createAccount(emailid);
	}
	
//	curl -X GET http://localhost:8484/gpay/find/1	
	@GetMapping(value = "find/{gpayid}")
	public String createAccount(@PathVariable("gpayid")int gpayid) {
		return gpayService.findAccountBalance(gpayid);
	}
}
