package com.mayank.assignment1.map;

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
	public static void convertToUpper() {
		List<String> list = Arrays.asList("rahul", "amit", "neha");
		list.stream().map(String::toUpperCase).forEach(System.out::println);
	}

	public static void squareNumbers() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> result = list.stream().map(n -> n * n).toList();
		System.out.println(result);
	}

	public static void squareNumbersAgain() {
		List<Integer> list = Arrays.asList(6, 7, 8);
		List<Integer> result = list.stream().map(n -> n * n).toList();
		System.out.println(result);
	}

	public static void prefixNames() {
		List<String> list = Arrays.asList("Rahul", "Amit", "Neha");
		list.stream().map(name -> "Mr./Ms. " + name).forEach(System.out::println);
	}

	public static void applyDiscount() {
		List<Double> prices = Arrays.asList(1000.0, 500.0, 200.0);
		List<Double> result = prices.stream().map(p -> p * 0.9).toList();
		System.out.println(result);
	}

	public static void addGraceMarks() {
		List<Student> list = Arrays.asList(new Student("Rahul", 30), new Student("Amit", 50), new Student("Neha", 20));
		List<Student> result = list.stream().map(s -> {
			if (s.getMarks() < 35) {
				return new Student(s.getName(), s.getMarks() + 5);
			}
			return s;
		}).toList();
		result.forEach(System.out::println);
	}

	public static void main(String[] args) {
		convertToUpper();
		squareNumbers();
		squareNumbersAgain();
		prefixNames();
		applyDiscount();
		addGraceMarks();
	}

}
