package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Account;
import com.service.AccountService;

@RestController
@RequestMapping("account")
public class AccountController {

	@Autowired
	AccountService accountService;
// curl -X POST http://localhost:8383/account/create -H "Content-Type:application/json" -d '{"accno":100,"name":"Steven","amount":5000,"emailid":"steven@gmail.com"}'

	@PostMapping(value = "create",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String createAccount(@RequestBody Account account) {
		return accountService.createAccount(account);
	}
	
	// curl -X PUT http://localhost:8383/account/withdraw -H "Content-Type:application/json" -d '{"accno":100,"amount":200}'
	
	@PutMapping(value = "withdraw",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String withDrawn(@RequestBody Account account) {
		return accountService.withdrawn(account);
	}
	
	// curl -X PUT http://localhost:8383/account/deposit -H "Content-Type:application/json" -d '{"accno":100,"amount":500}'
	
	@PutMapping(value = "deposit",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String deposit(@RequestBody Account account) {
		return accountService.deposit(account);
	}
	
	// curl -X GET http://localhost:8383/account/findBalance/100
	
	@GetMapping(value = "findBalance/{accno}")
	public String findBalance(@PathVariable("accno") int accno) {
		return accountService.findBalance(accno);
	}
	// curl -X GET http://localhost:8383/account/findAccno/steven@gmail.com 
	
	@GetMapping(value = "findAccno/{emailid}")
	public int findAccno(@PathVariable("emailid") String emailid) {
		return accountService.findAccno(emailid);
	}
}
