package com.mayank.jdbcassignment.model;

public class Registration {
	private int regId;
	private int studentId;
	private int c_id;
	private double feesPaid;

	public Registration(int studentId, int courseName, double feesPaid) {
		this.studentId = studentId;
		this.c_id = courseName;
		this.feesPaid = feesPaid;
	}

	public Registration(int regId, int studentId, int courseName, double feesPaid) {
		this.regId = regId;
		this.studentId = studentId;
		this.c_id = courseName;
		this.feesPaid = feesPaid;
	}

	public int getRegId() {
		return regId;
	}

	public int getStudentId() {
		return studentId;
	}

	public int getCourseId() {
		return c_id;
	}

	public double getFeesPaid() {
		return feesPaid;
	}
}
