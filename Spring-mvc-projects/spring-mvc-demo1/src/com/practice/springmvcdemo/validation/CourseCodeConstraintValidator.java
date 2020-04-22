package com.practice.springmvcdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{

	private String[] coursePrefix;
	
	@Override
	public void initialize(CourseCode args0) {
		coursePrefix=args0.value();
	}
	
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorConstraint) {
		// TODO Auto-generated method stub
		boolean result = false;
		if(theCode!=null)
		{
//			boolean result = theCode.startsWith(coursePrefix);
			for(String string:coursePrefix) {
				result=theCode.startsWith(string);
				if(result)
					break;
			}
		}
		else
			result= true;
		return result;
	}
		
}
