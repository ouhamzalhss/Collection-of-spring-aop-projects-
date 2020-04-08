package com.ouhamza.demo.dao;

import org.springframework.stereotype.Component;

import com.ouhamza.demo.Account;

@Component
public class AccountDao {
	private String name;
	private String serviceCode;
	
	
	public void addAccount(Account account,boolean state) {
		System.out.println(getClass()+" Adding an account....");
	}


	public String getName() {
		System.out.println(getClass()+" Adding an getName....");
		return name;
	}


	public void setName(String name) {
		System.out.println(getClass()+" Adding an setName....");
		this.name = name;
	}


	public String getServiceCode() {
		System.out.println(getClass()+" Adding an getServiceCode....");
		return serviceCode;
	}


	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+" Adding an setServiceCode....");
		this.serviceCode = serviceCode;
	}

}
