package com.mayank.arrayofobject.model;

public class Course {

	private int courseId;
	private String courseName;
	protected double baseFee;
	private String courseType;

	private static int totalCourses = 0;

	public Course(int courseId, String courseName, double baseFee, String courseType) {

		this.courseId = courseId;
		this.courseName = courseName;
		this.baseFee = baseFee;
		this.courseType = courseType;

		totalCourses++;
	}

	public double calculateFee() {
		return baseFee;
	}

	public int getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getCourseType() {
		return courseType;
	}

	public static int getTotalCourses() {
		return totalCourses;
	}
}