package com.mayank.arrayofobject.model;

public class RegularCourse extends Course {

	private double labFee;

	public RegularCourse(int courseId, String courseName, double baseFee, double labFee) {

		super(courseId, courseName, baseFee, "Regular");
		this.labFee = labFee;
	}

	@Override
	public double calculateFee() {
		return baseFee + labFee;
	}
}