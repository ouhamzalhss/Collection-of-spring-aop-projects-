package com.ouhamza.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ouhamza.demo.service.FourtuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring contanier
		FourtuneService fourtuneService = context.getBean(FourtuneService.class);

		System.out.println("Main aroundDemo: calling getFortue() ");
		System.out.println(fourtuneService.getFortune());
		System.out.println("Finiched");

		// close the context
		context.close();
	}

}
