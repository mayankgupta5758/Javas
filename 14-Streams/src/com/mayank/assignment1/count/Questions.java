package com.mayank.assignment1.count;

import java.util.Arrays;
import java.util.List;

class Student {
	String name;
	int marks;

	Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}

	int getMarks() {
		return marks;
	}

	String getName() {
		return name;
	}

	public String toString() {
		return name + " - " + marks;
	}
}

public class Questions {
	public static void countPassedStudents() {
		List<Student> list = Arrays.asList(new Student("Rahul", 30), new Student("Amit", 50), new Student("Neha", 70));
		long count = list.stream().filter(s -> s.getMarks() >= 40).count();
		System.out.println(count);
	}

	public static void countEvenOdd() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		long even = list.stream().filter(n -> n % 2 == 0).count();
		long odd = list.stream().filter(n -> n % 2 != 0).count();
		System.out.println("Even: " + even);
		System.out.println("Odd: " + odd);
	}

	public static void countEven() {
		List<Integer> list = Arrays.asList(2, 5, 8, 9, 10);
		long count = list.stream().filter(n -> n % 2 == 0).count();
		System.out.println(count);
	}

	public static void countPassedStudentsAgain() {
		List<Student> list = Arrays.asList(new Student("Karan", 20), new Student("Priya", 45), new Student("Riya", 60));
		long count = list.stream().filter(s -> s.getMarks() >= 40).count();
		System.out.println(count);
	}

	public static void countUppercaseA() {
		List<String> list = Arrays.asList("apple", "banana", "avocado", "grape");
		long count = list.stream().map(String::toUpperCase).filter(s -> s.startsWith("A")).count();
		System.out.println(count);
	}

	public static void countExpensiveAfterDiscount() {
		List<Double> prices = Arrays.asList(1000.0, 600.0, 400.0, 300.0);
		long count = prices.stream().map(p -> p * 0.8).filter(p -> p > 500).count();
		System.out.println(count);
	}

	public static void main(String[] args) {
		countPassedStudents();
		countEvenOdd();
		countEven();
		countPassedStudentsAgain();
		countUppercaseA();
		countExpensiveAfterDiscount();
	}
}
