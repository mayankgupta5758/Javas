package com.mayank.assignment1.sorted;

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
	public static void sortNumbers() {
		List<Integer> list = Arrays.asList(5, 2, 9, 1, 3);
		list.stream().sorted().forEach(System.out::println);
	}

	public static void sortStrings() {
		List<String> list = Arrays.asList("banana", "apple", "grape", "mango");
		list.stream().sorted().forEach(System.out::println);
	}

	public static void sortReverse() {
		List<String> list = Arrays.asList("Rahul", "Amit", "Neha", "Karan");
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}

	public static void sortByLength() {
		List<String> list = Arrays.asList("Rahul", "Amit", "Neha", "Karan");
		list.stream().sorted((a, b) -> a.length() - b.length()).forEach(System.out::println);
	}

	public static void sortWordsByLength() {
		List<String> list = Arrays.asList("apple", "kiwi", "banana", "grape");
		list.stream().sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);
	}

	public static void sortStudentsByMarks() {
		List<Student> list = Arrays.asList(new Student("Rahul", 75), new Student("Amit", 50), new Student("Neha", 90));
		list.stream().sorted(Comparator.comparingInt(Student::getMarks)).forEach(System.out::println);
	}

	public static void main(String[] args) {
		sortNumbers();
		sortStrings();
		sortReverse();
		sortByLength();
		sortWordsByLength();
		sortWordsByLength();
	}
}
