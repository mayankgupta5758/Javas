package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Biology implements IScience {

	public Biology() {
		System.out.println("Biology Constructor.");
	}
	
	@Override
	public String study() {
		return "Study Biology";
	}

}
