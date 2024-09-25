package com.service;



import java.util.Optional;

import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entity.Gpay;
import com.repository.GpayRepository;

@Service
public class GpayService {

	@Autowired
	GpayRepository gpayRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	public String createAccount(String emailid) {
		try {	
		//int accno = restTemplate.getForObject("http://localhost:8383/account/findAccno/"+emailid, Integer.class);
			int accno = restTemplate.getForObject("http://ACCOUNT-MICRO-SERVICE/account/findAccno/"+emailid, Integer.class);
		Gpay gpay = new Gpay();
		gpay.setAccno(accno);
		
		gpayRepository.save(gpay);
		
		return "Gpay Account created successfully";
		}catch(Exception e) {
			System.err.println(e);
			return "Account not exists, So Gpay Account didn't create";
		}
	}
	
	public String findAccountBalance(int gpayid) {
		Optional<Gpay> result = gpayRepository.findById(gpayid);
		if(result.isPresent()) {
			Gpay gpay= result.get();
			int accno = gpay.getAccno();
			//return restTemplate.getForObject("http://localhost:8383/account/findBalance/"+accno,String.class);
			return restTemplate.getForObject("http://ACCOUNT-MICRO-SERVICE/account/findBalance/"+accno,String.class);
		}else {
			return "Gpay Account not present";
		}
	}
	
}







