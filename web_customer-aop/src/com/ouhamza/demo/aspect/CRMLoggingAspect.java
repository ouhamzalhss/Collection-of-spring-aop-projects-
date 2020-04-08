package com.ouhamza.demo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	private static Logger logger = Logger.getLogger(CRMLoggingAspect.class.getName());
	
	// setup pointcut declaration for controllers
	@Pointcut("execution(* com.ouhamza.demo.controller.*.*(..) )")
	public void forControllerPackage() {}
	
	// setup pointcut declaration for services
	@Pointcut("execution(* com.ouhamza.demo.service.*.*(..) )")
	public void forServicePackage() {}
	
	// setup pointcut declaration for dao
	@Pointcut("execution(* com.ouhamza.demo.dao.*.*(..) )")
	public void forDaoPackage() {}
	
	// setup pointcut declaration for app
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	public void forApp() {}
	
	// Add Before advice 
	@Before("forApp()")
	public void before(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		logger.warning("\n========> in @Before call method :" + method);
		
		Object[] args = joinPoint.getArgs();
		for(Object tempArg : args) {
			logger.info("The argument : "+ tempArg);
		}
	}
	
	@AfterReturning(
			pointcut="forApp()",
			returning="theResult"
			)
	public void afterReturning(JoinPoint joinPoint, Object theResult) {
		
		String theMethod = joinPoint.getSignature().toShortString();
		logger.info("in @AfterReturning call method :"+ theMethod);
		
		logger.info("The result return : "+theResult);
	}
}
