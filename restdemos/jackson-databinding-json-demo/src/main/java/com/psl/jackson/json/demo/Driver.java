package com.psl.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);
			System.out.println("the object is: \n\n"+student);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
