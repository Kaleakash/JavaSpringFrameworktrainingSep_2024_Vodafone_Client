package com.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.feignservice.AccountFeignService;


@Service
public class AccountService {

	@Autowired
	AccountFeignService accountFeignService;
	
	public String findBalance(int accno) {
		return accountFeignService.findBalance(accno);
		// base upon result if we want to connect its own db or other task we can performs. 
	}
}
