package com.jpajwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {
	
	@GetMapping("/api/hello")
	public String hello() {
		return "hello from spring";
	}
	
	@GetMapping("/api/user")
	public String userPage() {
		return "user page";
	}
	
	@GetMapping("/api/admin")
	public String adminPage() {
		return "admin page";
	}

}
