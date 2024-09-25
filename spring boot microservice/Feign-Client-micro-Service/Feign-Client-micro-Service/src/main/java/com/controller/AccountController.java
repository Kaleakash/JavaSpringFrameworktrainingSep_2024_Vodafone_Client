package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.AccountService;

@RestController
@RequestMapping("feign")
public class AccountController {

	@Autowired
	AccountService accountService;
// curl -X GET http://localhost:8585/feign/findbalance/100
	
	@GetMapping(value = "findbalance/{accno}")
	public String findBalance(@PathVariable("accno") int accno) {
		return accountService.findBalance(accno);
	}
}
