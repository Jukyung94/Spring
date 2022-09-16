package com.study;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class HeloController {
	
	@RequestMapping("/{num}") //annotation with variables to create paths
	public String index(@PathVariable int num, Model model) { //
	int res = 0;
	for(int i = 1; i <= num; i++) {
		res += i;
	}
	model.addAttribute("msg", "total: " + res);
	return "index";
	}	
}


//before 22/9/16
//@RestController //Annotation to use Rest Controller
//public class HeloController {
//	
//	@RequestMapping("/") //annotation to mapping url
//	public String index() {
//		return "Hello Spring-Boot World";
//	}
//	
////	@RequestMapping("/{num}") //annotation with variables to create paths
////	public String pagebyNum(@PathVariable int num) { //
////		int res = 0;
////		for(int i = 1; i <= num; i++) {
////			res += i;
////		}
////		return "total: " + res;
////	}
//	
//	//0913
//	String[] names = {"kim", "lee", "park", "choi", "jo"};
//	String[] mails = {"kim@tuuyano.com", "lee@flower", "park@yamda", "choi@happy", "jo@baseball"};
//	
//	@RequestMapping("/{id}")
//	public DataObject datas(@PathVariable int id) {
//		return new DataObject(id, names[id], mails[id]); //return amount is a DataObject(JSON)
//	}
//}
//
////new class and getter, setter
//class DataObject {
//	private int id;
//	private String name;
//	private String value;
//	
//	public DataObject(int id, String name, String value) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.value = value;
//	}
//	
//	public int getId() {return id;}
//	
// 	public void setId(int id) {this.id = id;}
// 	
// 	public String getName() { return name;}
// 	
// 	public void setName(String name) {
// 		this.name = name;
// 	}
// 	
// 	public String getValue() {
// 		return value;
// 	}
// 	
// 	public void setValue(String value) {
// 		this.value = value;
// 	}
//}
