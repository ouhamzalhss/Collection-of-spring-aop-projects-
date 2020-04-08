package com.ouhamza.demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	// create pointcut declaration
	@Pointcut("execution(* add*(com.ouhamza.demo.Account,..))")
	public void forDaoPackage() {}
	
	
	// apply pointcut declaration to advice
	@Before("forDaoPackage()")
	public void beforeAddAccount() {
		System.out.println("\n =====> add transaction aspect ");
	}
	
	// apply pointcut declaration to advice
	@Before("forDaoPackage()")
	public void afterAddAccount() {
		System.out.println("\n =====> add logging aspect ");
	}

}
