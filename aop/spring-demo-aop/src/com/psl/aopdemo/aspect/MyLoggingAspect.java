package com.psl.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {
	
	//@Before("execution(public void addAccount())")
	@Pointcut("execution(* com.psl.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* com.psl.aopdemo.dao.*.get*(..))")
	private void forGetters() {}
	
	@Pointcut("execution(* com.psl.aopdemo.dao.*.set*(..))")
	private void forSetters() {}
	
	@Pointcut("forDaoPackage() && !(forGetters() || forSetters())")
	private void forAllExceptGettersAndSetters() {}
	
	
//	@Before("forDaoPackage()")
//	public void beforeAddAccountAdvice() {
//		System.out.println("executing before addAccount() method");
//	}
	
	
	@Before("forAllExceptGettersAndSetters()")
	public void beforeAddAdvice() {
		System.out.println("============>executing advice");
	}
	
}
