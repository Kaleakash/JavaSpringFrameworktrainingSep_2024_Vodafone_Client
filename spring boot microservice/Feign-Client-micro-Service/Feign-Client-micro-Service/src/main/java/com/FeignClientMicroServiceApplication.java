package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com")
@EnableDiscoveryClient
@EnableFeignClients
public class FeignClientMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignClientMicroServiceApplication.class, args);
		System.err.println("Feign Micro service client up ");
	}

}
