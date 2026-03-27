package com.mayank.assignment.question4.model;

public abstract class Hospital {
	protected String name;
	protected int age;
	
	public Hospital(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}
