package com.mayank.assignment2.studentresultprocessingsystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.mayank.assignment2.EmployeeManagementAnalyticsSystem.UtilityFunction;

class Student {
	int rollNo;
	String name;
	String standard;
	int marks;
	String section;

	Student(int rollNo, String name, String standard, int marks, String section) {
		this.rollNo = rollNo;
		this.name = name;
		this.standard = standard;
		this.marks = marks;
		this.section = section;
	}

	public int getMarks() {
		return marks;
	}

	public String getSection() {
		return section;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return rollNo + " | " + name + " | " + standard + " | Marks: " + marks + " | Section: " + section;
	}
}

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		int n = UtilityFunction.getValidInt(sc, "Enter number of students: ");

		for (int i = 0; i < n; i++) {
			System.out.println("\nEnter details of Student " + (i + 1));

			int roll = UtilityFunction.getValidInt(sc, "Roll No: ");
			String name = getValidString("Name: ");
			String std = getValidString("Standard: ");
			int marks = getValidMarks("Marks (0-100): ");
			String section = getValidString("Section: ");

			list.add(new Student(roll, name, std, marks, section));
		}

		System.out.println("\nPassed Students:");
		list.stream().filter(s -> s.getMarks() >= 40).forEach(System.out::println);

		System.out.println("\nTop 3 Students:");
		list.stream().sorted(Comparator.comparingInt(Student::getMarks).reversed()).limit(3)
				.forEach(System.out::println);

		System.out.println("\nGrouped by Section:");
		Map<String, List<Student>> grouped = list.stream().collect(Collectors.groupingBy(Student::getSection));
		grouped.forEach((k, v) -> System.out.println(k + " -> " + v));

		System.out.println("\nCount Section-wise:");
		Map<String, Long> count = list.stream()
				.collect(Collectors.groupingBy(Student::getSection, Collectors.counting()));
		System.out.println(count);

		System.out.println("\nAverage Marks Section-wise:");
		Map<String, Double> avg = list.stream()
				.collect(Collectors.groupingBy(Student::getSection, Collectors.averagingInt(Student::getMarks)));
		System.out.println(avg);

		System.out.println("\nNames in Uppercase:");
		list.stream().map(s -> s.getName().toUpperCase()).forEach(System.out::println);

		boolean fullMarks = list.stream().anyMatch(s -> s.getMarks() == 100);

		System.out.println("\nAny student scored full marks? " + fullMarks);
	}

	static int getValidMarks(String msg) {
		while (true) {
			try {
				System.out.print(msg);
				int marks = Integer.parseInt(sc.nextLine());
				if (marks < 0 || marks > 100)
					throw new Exception();
				return marks;
			} catch (Exception e) {
				System.out.println("Marks must be between 0 and 100.");
			}
		}
	}

	static String getValidString(String msg) {
		while (true) {
			System.out.print(msg);
			String s = sc.nextLine().trim();
			if (!s.isEmpty())
				return s;
			System.out.println("Input cannot be empty.");
		}
	}
}