package com.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration						// we were writing using xml file before spring boot. 
@EnableWebSecurity
public class MySecurity {

	@Bean
	public UserDetailsService userDetails() {
	List<UserDetails> users = new ArrayList<UserDetails>();
	// 1st options 
//	users.add(User.withDefaultPasswordEncoder().username("akash").password("123").build());
//	users.add(User.withDefaultPasswordEncoder().username("steven").password("321").build());
//	users.add(User.withDefaultPasswordEncoder().username("john").password("246").build());
	
	// 2nd options 
	
//	users.add(User.withUsername("akash").password("{noop}123").build());
//	users.add(User.withUsername("steven").password("{noop}321").build());
//	users.add(User.withUsername("john").password("{noop}246").build());
	
	// 3rd options 
	String firstUserPassword = "123";
	String secondUserPassword = "321";
	System.out.println(firstUserPassword+" "+secondUserPassword);
	String firstUserEncodePassword = passwordEncorder().encode(firstUserPassword);
	String secondUserEncodePassword = passwordEncorder().encode(secondUserPassword);
	System.out.println(firstUserEncodePassword+" "+secondUserEncodePassword);
	
	users.add(User.withUsername("akash").password(firstUserEncodePassword).build());
	users.add(User.withUsername("steven").password(secondUserEncodePassword).build());

	
	return new InMemoryUserDetailsManager(users);	
	}
	
	@Bean
	public PasswordEncoder passwordEncorder() {
		return new BCryptPasswordEncoder();
	}
}