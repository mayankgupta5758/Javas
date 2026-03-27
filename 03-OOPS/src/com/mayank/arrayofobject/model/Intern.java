package com.mayank.arrayofobject.model;

public class Intern extends Employee {

	private double stipend;

	public Intern(String name, int id, double stipend) {

		super(name, id, stipend, "Intern");
		this.stipend = stipend;
	}

	@Override
	public double calculateSalary() {
		return stipend;
	}
}