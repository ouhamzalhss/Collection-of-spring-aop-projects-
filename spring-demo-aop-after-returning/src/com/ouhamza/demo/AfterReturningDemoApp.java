package com.ouhamza.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ouhamza.demo.dao.AccountDao;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring contanier
		AccountDao accountDao = context.getBean(AccountDao.class);
		
		// call the business method
		List<Account> accounts = accountDao.findAccounts();
		
		// display the accounts
		for(Account account: accounts) {
			System.out.println("Name: "+ account.getName());
		}

		// close the context
		context.close();
	}

}
