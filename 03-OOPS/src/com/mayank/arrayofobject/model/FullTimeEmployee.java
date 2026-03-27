package com.mayank.arrayofobject.model;

public class FullTimeEmployee extends Employee {

	private double hra;
	private double bonus;

	public FullTimeEmployee(String name, int id, double basicSalary, double hra, double bonus) {

		super(name, id, basicSalary, "Full-Time");
		this.hra = hra;
		this.bonus = bonus;
	}

	@Override
	public double calculateSalary() {
		return baseSalary + hra + bonus;
	}
}