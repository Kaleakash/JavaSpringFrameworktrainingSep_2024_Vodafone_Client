package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com")	// @RestController, @Service,@Repository etc
@EntityScan(basePackages = "com.entity")			// Enable @Entity 
public class SbProductOrdersApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbProductOrdersApiApplication.class, args);
		System.out.println("spring boot up");
	}

}
