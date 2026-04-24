package com.mayank.assignment.model;

public class UserClass {
	String name;
	int age;
	
	public UserClass(String name, int age) {
		if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        
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
