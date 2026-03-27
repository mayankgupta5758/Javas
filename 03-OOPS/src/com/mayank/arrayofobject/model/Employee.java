package com.mayank.arrayofobject.model;

public class Employee {

	private int employeeId;
	private String employeeName;
	protected double baseSalary;
	private String employeeType;

	private static int totalEmployees = 0;

	public Employee(String employeeName, int employeeId, double baseSalary, String employeeType) {

		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.baseSalary = baseSalary;
		this.employeeType = employeeType;

		totalEmployees++;
	}

	public double calculateSalary() {
		return baseSalary;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public static int getTotalEmployees() {
		return totalEmployees;
	}
}