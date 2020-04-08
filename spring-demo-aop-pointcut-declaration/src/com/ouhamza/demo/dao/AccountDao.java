package com.ouhamza.demo.dao;

import org.springframework.stereotype.Component;

import com.ouhamza.demo.Account;

@Component
public class AccountDao {
	
	public void addAccount(Account account,boolean state) {
		System.out.println(getClass()+" Adding an account....");
	}

}
