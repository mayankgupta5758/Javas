package com.mayank.assignment.question3.model;

import java.util.*;

public class Student {
	private int studentId;
	private String name;
	private String department;
	private double totalPercentage;

	public Student(int studentId, String name, String department, double totalPercentage) {
		this.studentId = studentId;
		this.name = name;
		this.department = department;
		this.totalPercentage = totalPercentage;
	}

	public int getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public double getTotalPercentage() {
		return totalPercentage;
	}

	public void setTotalPercentage(double percentage) {
		this.totalPercentage = percentage;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (!(obj instanceof Student))
			return false;

		Student b = (Student) obj;
		return this.studentId == b.studentId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(studentId);
	}

	@Override
	public String toString() {
		return "ID: " + studentId + " | Name: " + name + " | Department: " + department;
	}
}
