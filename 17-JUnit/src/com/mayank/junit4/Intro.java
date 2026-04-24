package com.mayank.junit4;

public class Intro {
	/*
	 * Unit Testing · Testing specific units of code independently .
	 * 
	 * Advantages of unit testing . Find bugs early . Easy to fix bugs . Reduce the
	 * cost and time
	 * 
	 * How to be perform unit Test · JUNIT- most popular framework for unit testing
	 * · JUNIT-4 . JUNIT-5
	 * 
	 * · Then what is Mockito . Its mocking framework
	 * 
	 */
	
	public int sum(int a, int b) {
		return a+b;
	}
	
	public int sumAnyNum(int... num) {
		int s = 0;
		for (int i : num) {
			s+=i;
		}
		return s;
	}
}
