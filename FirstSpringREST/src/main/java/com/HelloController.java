package com;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //from web bind
//controller + response body - hover over it. also method specific mapping- get, post
public class HelloController {

	@RequestMapping("hello")
	public String hello() {
		System.out.println("Welcome to Spring REST-console");
		return "Welcome to Spring REST-web";
	}
	
}
