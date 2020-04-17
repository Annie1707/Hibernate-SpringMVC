package com.practice.springmvcdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	
	@RequestMapping("/showform")
	public String showForm() {
		return "helloworld-form";
	}
	
	
	@RequestMapping("/processForm")
	public String formResult() {
		return "helloworld";
	}
	
	@RequestMapping("/processForm2")
	public String formResult2(HttpServletRequest request, Model model) {
		
		String name = request.getParameter("studentName");
		name =name.toUpperCase();
		String result = "yo! "+name;
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processForm3")
	public String formResult3(@RequestParam("studentName") String name, Model model) {
		name =name.toUpperCase();
		String result = "Hey "+name;
		model.addAttribute("message",result);
		
		return "helloworld";
	}
	
	 

}
