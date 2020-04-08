package com.ouhamza.demo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembreDao {
	
	public void addAccount() {
		System.out.println(getClass()+" Adding an membre ship ....");
	}

}
