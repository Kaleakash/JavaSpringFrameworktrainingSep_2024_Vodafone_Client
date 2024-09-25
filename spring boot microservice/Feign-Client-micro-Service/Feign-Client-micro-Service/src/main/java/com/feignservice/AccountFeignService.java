package com.feignservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ACCOUNT-MICRO-SERVICE")
public interface AccountFeignService {

	@GetMapping(value = "account/findBalance/{accno}")
	public String findBalance(@PathVariable("accno") int accno);	// account service specification 
}
