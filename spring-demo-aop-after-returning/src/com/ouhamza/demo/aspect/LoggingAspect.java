package com.ouhamza.demo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	

	@AfterReturning(
			pointcut="execution(* com.ouhamza.demo.dao.*.findAccounts(..))", 
			returning="result")
	public void afterReturningAdvice(JoinPoint joinPoint, List<Account> result) {
		
		// print out witch method we are advising on
		String method =  joinPoint.getSignature().toShortString();
		System.out.println("excution of method : "+method);
		
		//print out the result of the method call
		System.out.println("the result is: "+ result);
		
		// let's post-process the data. let's modify it;
		convertAccountsNameToUppercase(result);
				
	}


	private void convertAccountsNameToUppercase(List<Account> result) {
		// TODO Auto-generated method stub
		for(Account account: result) {
			account.setName(account.getName().toUpperCase());
		}
	}

}
