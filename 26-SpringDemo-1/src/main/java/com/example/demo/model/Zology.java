package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Zology implements IScience{
	
	public Zology() {
		System.out.println("Zology Constructor.");
	}

	@Override
	public String study() {
		return "Learning About Animal Science.";
	}

}
