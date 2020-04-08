package com.ouhamza.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ouhamza.demo.dao.AccountDao;
import com.ouhamza.demo.dao.MembreDao;

public class MainDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring contanier
		AccountDao accountDao = context.getBean(AccountDao.class);
		MembreDao membre = context.getBean(MembreDao.class);
		
		// call the business method
		accountDao.addAccount(new Account(),true);
		membre.addAccount();
		
		// close the context
		context.close();
	}

}
