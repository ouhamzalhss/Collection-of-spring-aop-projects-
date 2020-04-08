package com.ouhamza.demo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class TransactionAspect {
	
	// create pointcut declaration for any method
	@Pointcut("execution(* com.ouhamza.demo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// create pointcut declaration for getters
	@Pointcut("execution(* com.ouhamza.demo.dao.*.get*(..))")
	public void forGetters() {}
	
	// create pointcut declaration for setters
	@Pointcut("execution(* com.ouhamza.demo.dao.*.set*(..))")
	public void forSetters() {}
	
	// create pointCut declaration except getters and setters
	@Pointcut("forDaoPackage() && !(forGetters() || forSetters() )")
	public void exceptGettersAndSetters() {}
	
	// apply pointcut declaration to advice
	@Before("exceptGettersAndSetters()")
	public void beforeAddAccount() {
		System.out.println("\n =====> add transaction aspect ");
	}
	


}
