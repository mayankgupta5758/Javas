package com.mayank.inheritance.model;

public class Employee {

	protected int empId;
	protected String name;

	public Employee(int empId, String name) {
		this.empId = empId;
		this.name = name;
	}

	public double calculateSalary() {
		return 0; 
	}

	public void displayEmployee() {
		System.out.println("Employee ID: " + empId);
		System.out.println("Employee Name: " + name);
		System.out.println("Salary: " + calculateSalary());
		System.out.println("----------------------------");
	}
}
