package com.ouhamza.demo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ouhamza.demo.service.FourtuneService;

public class AroundWithLoggerDemoApp {
	
	private static Logger mylogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring contanier
		FourtuneService fourtuneService = context.getBean(FourtuneService.class);

		mylogger.info("Main aroundDemo: calling getFortue() ");
		mylogger.info(fourtuneService.getFortune());
		mylogger.info("Finiched");

		// close the context
		context.close();
	}

}
