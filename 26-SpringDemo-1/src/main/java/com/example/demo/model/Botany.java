package com.example.demo.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Botany implements IScience{

	public Botany() {
		System.out.println("Botany Constructor.");
	}
	
	@Override
	public String study() {
		return "Learning About Plant's Science.";
	}

}
