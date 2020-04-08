package com.ouhamza.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ouhamza.demo.dao.AccountDao;

public class MainDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring contanier
		AccountDao accountDao = context.getBean(AccountDao.class);
		
		// call the business method
		accountDao.addAccount(new Account("ouhamza","120-ACD"),true);

		// call getter / setters methods
		accountDao.setName("x");
		accountDao.setServiceCode("20");
		String name = accountDao.getName();
		String code = accountDao.getServiceCode();
		// close the context
		context.close();
	}

}
