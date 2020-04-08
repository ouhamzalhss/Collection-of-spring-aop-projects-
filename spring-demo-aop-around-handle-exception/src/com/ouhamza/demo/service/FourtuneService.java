package com.ouhamza.demo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class FourtuneService {
	
	public String getFortune() {
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Except heavy traffic this morning";
	}

	public String getFortune(boolean isActive) {
		// TODO Auto-generated method stub
		if(!isActive) {
			throw new RuntimeException("Major accident!");
		}
		return "Except heavy traffic this morning";
	}

}
