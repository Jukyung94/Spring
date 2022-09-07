package com.study;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Annotation to use Rest Controller
public class HeloController {
	
	@RequestMapping("/") //annotation to mapping url
	public String index() {
		return "Hello Spring-Boot World";
	}
	

}
