package com.mayank.assignment.question3.model;

public class UnderGraduateStudent extends Student {
	private String type;

	UnderGraduateStudent(int studentId, String name, String department, double totalPercentage) {
		super(studentId, name, department, totalPercentage);
		type = "UG";
	}

	public String getType() {
		return type;
	}
}
