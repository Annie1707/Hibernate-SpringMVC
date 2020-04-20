package com.practice.springmvcdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/showform")
	public String showForm(Model model) {
		//create student
		Student student = new Student();
		//add student to model
		model.addAttribute("student", student);
		//model.addAttribute("theCountryOptions", countryOptions); 
		return "student-form";
	}
	
	@RequestMapping("/processform")
	public String processForm(@ModelAttribute("student") Student student) {
		//log the input data
		System.out.println(student.getFirstName() + " "+student.getLastName());
		return "student-confirmation";
	}

}
