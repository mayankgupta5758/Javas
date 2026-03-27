package com.mayank.arrayofobject.model;

public class OnlineCourse extends Course {

	private double platformFee;

	public OnlineCourse(int courseId, String courseName, double baseFee, double platformFee) {

		super(courseId, courseName, baseFee, "Online");
		this.platformFee = platformFee;
	}

	@Override
	public double calculateFee() {
		return baseFee + platformFee;
	}
}