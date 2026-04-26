package com.mayank.jdbcassignment.model;

public class Student {
	private int id;
	private String name;
	private int age;
	private int b_id;

	public Student(String name, int age, int branch) {
		this.name = name;
		this.age = age;
		this.b_id = branch;
	}

	public Student(int id, String name, int age, int branch) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.b_id = branch;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getBranchId() {
		return b_id;
	}
}