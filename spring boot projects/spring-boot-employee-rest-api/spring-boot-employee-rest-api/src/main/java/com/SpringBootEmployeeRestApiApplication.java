package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com")	// enable @Restcontroller, @service @repository 
@EntityScan(basePackages = "com.entity")				// enable @entity 
@EnableJpaRepositories(basePackages = "com.repository")	// enable spring jpa data 
public class SpringBootEmployeeRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmployeeRestApiApplication.class, args);
		System.err.println("spring boot with rest api up!");
	}

}
