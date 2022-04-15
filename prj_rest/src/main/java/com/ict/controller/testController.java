package com.ict.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class testController {
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "hello HEllo";
	}
	
}
