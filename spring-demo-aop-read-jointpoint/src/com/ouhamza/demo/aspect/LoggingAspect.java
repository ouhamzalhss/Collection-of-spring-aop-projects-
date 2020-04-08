package com.ouhamza.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ouhamza.demo.Account;

@Component
@Aspect
public class LoggingAspect {
	

	@Before("execution(* com.ouhamza.demo.dao.*.add*(..))")
	public void beforeAddAccount(JoinPoint joinPoint) {
		
		// display the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println(methodSignature);
		
		// display the method params
		Object[] params = joinPoint.getArgs();
		for(Object p: params) {
			System.out.println(p);
			if(p instanceof Account) {
				Account account = (Account) p;
				System.out.println(account.getName());
				System.out.println(account.getLevel());
			}
		}
		
		System.out.println("\n =====> add Logging aspect ");
	}
	


}
