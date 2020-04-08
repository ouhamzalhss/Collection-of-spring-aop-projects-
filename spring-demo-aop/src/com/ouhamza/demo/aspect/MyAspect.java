package com.ouhamza.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	// @Before("execution(* add*(com.ouhamza.demo.Account))")
	@Before("execution(* add*(com.ouhamza.demo.Account,..))")
	public void beforeAddAccount() {
		System.out.println("\n =====> add @Before advice on addAccount() ");
	}

}
