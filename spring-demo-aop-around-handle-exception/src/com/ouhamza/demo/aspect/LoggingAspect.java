package com.ouhamza.demo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.weaver.tools.cache.GeneratedCachedClassHandler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ouhamza.demo.Account;
import com.ouhamza.demo.AroundWithLoggerDemoApp;

@Component
@Aspect
public class LoggingAspect {
	
	private Logger mylogger = Logger.getLogger(getClass().getName());

	@Before("execution(* com.ouhamza.demo.dao.*.add*(..))")
	public void beforeAddAccount(JoinPoint joinPoint) {
		
		// display the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		mylogger.info(methodSignature.toString());
		
		// display the method params
		Object[] params = joinPoint.getArgs();
		for(Object p: params) {
			mylogger.info(p.toString());
			if(p instanceof Account) {
				Account account = (Account) p;
				mylogger.info(account.getName());
				mylogger.info(account.getLevel());
			}
		}
		
		mylogger.info("\n =====> add Logging aspect ");
	}
	

	@AfterReturning(
			pointcut="execution(* com.ouhamza.demo.dao.*.findAccounts(..))", 
			returning="result")
	public void afterReturningAdvice(JoinPoint joinPoint, List<Account> result) {
		
		// print out witch method we are advising on
		String method =  joinPoint.getSignature().toShortString();
		mylogger.info("excution of method : "+method);
		
		//print out the result of the method call
		mylogger.info("the result is: "+ result);
		
		// let's post-process the data. let's modify it;
		convertAccountsNameToUppercase(result);
				
	}
	
	@AfterThrowing(
			pointcut="execution(* com.ouhamza.demo.dao.*.findAccounts(..))", 
			throwing="execption")
	public void afterReturningAdvice(JoinPoint joinPoint, Throwable execption) {
		// print out witch method we are advising on
		String method =  joinPoint.getSignature().toShortString();
		mylogger.info("\nexcution of method : "+method);
		// print out the exception 
		mylogger.info("\n@AfterThrowing advice: "+ execption);
	}

	
	@After("execution(* com.ouhamza.demo.dao.*.findAccounts(..))")
	public void afterFindAccounts(JoinPoint joinPoint) {
		// print out witch method call on
		String method = joinPoint.getSignature().toShortString();
		mylogger.info("\n in @After advice we call method :" + method);
	}

	private void convertAccountsNameToUppercase(List<Account> result) {
		// TODO Auto-generated method stub
		for(Account account: result) {
			account.setName(account.getName().toUpperCase());
		}
	}
	
	@Around("execution(* com.ouhamza.demo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		// print out witch method call on
		String method = proceedingJoinPoint.getSignature().toShortString();
		mylogger.info("\n in @Around advice we call method :" + method);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		Object result = null;
		// let's execute the method
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Exception e) {
			mylogger.warning(e.getMessage());
			result = "Major exception handle by @Around Advice";
		}
		
		
		// get begin timestamp
		long end = System.currentTimeMillis();
		
		mylogger.info("the durration : "+ (end - begin) / 1000 + " Secondes");
		return result;
	}

}
