package com.mayank.assignment.model;

public class DivisionException {

	public double divide(int a, int b) {
		if (b == 0) {
			throw new IllegalArgumentException("Can't divide by Zero.");
		}
		return a / b;
	}
}
