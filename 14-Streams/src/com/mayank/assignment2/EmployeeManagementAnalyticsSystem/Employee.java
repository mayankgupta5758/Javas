package com.mayank.assignment2.EmployeeManagementAnalyticsSystem;

class Employee {
	int employeeId;
	String name;
	String department;
	double salary;
	int experience;
	boolean activeStatus;

	Employee(int employeeId, String name, String department, double salary, int experience, boolean activeStatus) {
		this.employeeId = employeeId;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.experience = experience;
		this.activeStatus = activeStatus;
	}

	public String getDepartment() {
		return department;
	}

	public double getSalary() {
		return salary;
	}

	public boolean isActiveStatus() {
		return activeStatus;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return employeeId + " | " + name + " | " + department + " | ₹" + salary + " | Exp: " + experience
				+ " | Active: " + activeStatus;
	}
}
