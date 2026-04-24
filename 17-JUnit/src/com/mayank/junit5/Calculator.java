package com.mayank.junit5;

	/*
	 * Maven is a powerful project management tool based on the Project Object Model
	 * (POM). It simplifies the build process and helps manage dependencies and
	 * documentation for Java-based projects. JUNIT-5 - Junit-5 is composed of several different
	 * modules. Junit Platform + Junit Jupiter + Junit Vintage.
	 * 
	 * Junit Vintage - Provide support for Junit 3 and 4 Backend compatibility.
	 * Junit Jupiter - New programming and extension model for writing tests. New
	 * annotations. TestEngine implementation. Junit Platform - TestEngine API.
	 * Responsible for launching testing framework on JVM.
	 */

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public boolean isPositive(int num) {
        return num > 0;
    }
}