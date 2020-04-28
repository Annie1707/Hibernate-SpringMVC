package com.psl.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {
	
	//@Before("execution(public void addAccount())")
	@Before("execution(* add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("executing before addAccount() method");
	}
}
