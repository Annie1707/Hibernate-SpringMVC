package com.practice.springmvcdemo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {
	
	String firstName;
	
	@NotNull(message="is required")
  	@Size(min=1, message= "is required")
	String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

}
