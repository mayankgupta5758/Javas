package com.mayank.assignment.model;

public class GroupedAssertions {
	String name;
	int age;
	String status;

	public GroupedAssertions(String name, int age, String status) {
		if (name == null) {
			throw new IllegalArgumentException("Name can't be Empty.");
		}
		if (age < 0) {
			throw new IllegalArgumentException("age can't be Negative.");
		}

		this.name = name;
		this.age = age;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStatus() {
		return status;
	}
}
