package com.psl.dpringdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psl.dpringdemo.entity.Student;
import com.psl.dpringdemo.exceptionhandling.StudentNotFound;

@RestController
@RequestMapping("/api")
public class StudentController {
	private static List<Student> students = new ArrayList<>();
	
	@PostConstruct
	public void loadData(){
		students.add(new Student(0,"anushi", "agrawal"));
		students.add(new Student(1,"disha","behrani"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return students;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId){
		if((studentId>=students.size())||(studentId<0))
			throw new StudentNotFound("Student not found with id: "+studentId);
		return students.get(studentId);
	}
}
