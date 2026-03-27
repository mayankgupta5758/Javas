package com.mayank.assignment.question3.model;

public class PostGraducateStudent extends Student {
	private String type;

	public PostGraducateStudent(int studentId, String name, String department, double totalPercentage) {
		super(studentId, name, department, totalPercentage);
		type = "PG";
	}

	protected String getType() {
		return type;
	}
}
