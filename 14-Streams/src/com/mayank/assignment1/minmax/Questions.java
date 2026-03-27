package com.mayank.assignment1.minmax;

import java.util.Arrays;
import java.util.Comparator;
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

	public String toString() {
		return name + " - " + marks;
	}
}

public class Questions {

	public static void findMinNumber() {
		List<Integer> list = Arrays.asList(5, 2, 9, 1, 3);
		int min = list.stream().min(Integer::compareTo).get();
		System.out.println(min);
	}

	public static void findMaxLengthString() {
		List<String> list = Arrays.asList("apple", "banana", "kiwi", "watermelon");

		String result = list.stream().max(Comparator.comparingInt(String::length)).get();
		System.out.println(result);
	}

	public static void findTopStudent() {
		List<Student> list = Arrays.asList(new Student("Rahul", 75), new Student("Amit", 50), new Student("Neha", 90));
		Student top = list.stream().max(Comparator.comparingInt(Student::getMarks)).get();
		System.out.println(top);
	}

	public static void findLargestEven() {
		List<Integer> list = Arrays.asList(5, 2, 8, 1, 10, 3);
		int maxEven = list.stream().filter(n -> n % 2 == 0).max(Integer::compareTo).get();
		System.out.println(maxEven);
	}

	public static void main(String[] args) {
		findMinNumber();
		findMaxLengthString();
		findTopStudent();
		findLargestEven();
	}
}
