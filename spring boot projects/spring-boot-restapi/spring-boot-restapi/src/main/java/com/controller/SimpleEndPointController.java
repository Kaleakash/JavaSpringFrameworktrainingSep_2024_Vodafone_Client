package com.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController   			// @Controller + @ResponseBody 
public class SimpleEndPointController {

	
	@RequestMapping(value = "hi",method = RequestMethod.GET)
	public String sayHi() {
		return "Welcome to rest api with say Hi Message";
	}
	
	@RequestMapping(value = "text",method = RequestMethod.GET,produces = MediaType.TEXT_PLAIN_VALUE)
	public String sayText() {
		return "<h2>Welcome to rest api with say Hi Message - text</h2>";
	}
	
	@RequestMapping(value = "html",method = RequestMethod.GET,produces = MediaType.TEXT_HTML_VALUE)
	public String sayHtml() {
		return "<h2>Welcome to rest api with say Hi Message - HTML</h2>";
	}
	
	@RequestMapping(value = "xml",method = RequestMethod.GET,produces = MediaType.TEXT_XML_VALUE)
	public String sayXml() {
		return "<h2>Welcome to rest api with say Hi Message - XML</h2>";
	}
}



