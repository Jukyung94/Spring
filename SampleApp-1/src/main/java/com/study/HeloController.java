package com.study;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; //import requestMethod  220917
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam; //import param 220917
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView; //import ModelandView header 220917

@Controller
public class HeloController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("msg", "폼을 전송해주세요.");
		return mav;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send( //폼이 전송한 값은 send method로 받는다
			@RequestParam(value="check1", required=false)boolean check1, //value는 선택값, required는 필수여부. 필수일경우 매개변수는 반드시 인수로 전달
			@RequestParam(value="radio1", required=false)String radio1,
			@RequestParam(value="select1", required=false)String select1,
			@RequestParam(value="select2", required=false)String[] select2,
			ModelAndView mav) {
		
		String res=""; //결과
		try {
			res = "check:" + check1 +
				"radio:" + radio1 +
				"select:" + select1 +
				"\nselect2:";
		} catch (NullPointerException e) {}
		try {
			res +=  select2[0];
			for(int i = 1; i < select2.length; i++) {
				res += ", " + select2[i];
			}
		} catch (NullPointerException e) {
			res += "null";
		}
		
		mav.addObject("msg", res);
		mav.setViewName("index");
		return mav;
	}
	
	
//	@RequestMapping("/{num}") //annotation with variables to create paths
//	public ModelAndView index(@PathVariable int num, ModelAndView mav) { //
//	int res = 0;
//	for(int i = 1; i <= num; i++) {
//		res += i;
//	}
//	//model
//	//model.addAttribute("msg", "total: " + res);
//	
//	//model and view
//	mav.addObject("msg", "total: " + res);
//	mav.setViewName("index"); //setViewName 없이 return만 하게되면 템플릿을 찾지 못하고 오류 발생.
//	return mav;
//	}	
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
