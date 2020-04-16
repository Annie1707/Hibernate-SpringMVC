package com.practice.springmvcdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
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
	
	 

}
