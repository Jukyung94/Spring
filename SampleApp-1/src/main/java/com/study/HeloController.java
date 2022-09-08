package com.study;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController //Annotation to use Rest Controller
public class HeloController {
	
	@RequestMapping("/") //annotation to mapping url
	public String index() {
		return "Hello Spring-Boot World";
	}
	
	@RequestMapping("/{num}") //annotation with variables to create paths
	public String pagebyNum(@PathVariable int num) {
		int res = 0;
		for(int i = 1; i <= num; i++) {
			res += i;
		}
		return "total: " + res;
	}
	

}
