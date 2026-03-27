package com.mayank.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Student {
	String name;
	double marks;

	public Student(String name, double marks) {
		this.name = name;
		this.marks = marks;
	}
}

public class StudentPassFilter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Predicate<Student> ismarksCheck = s -> s.marks >= 40;
		List<Student> std = Arrays.asList(new Student("A", 33), new Student("B", 99), new Student("C", 60),
				new Student("D", 41), new Student("E", 12), new Student("F", 74));
		
		for (Student s : std) {
			if(ismarksCheck.test(s)) {
				System.out.println(s.name);
			}
		}
	}

}
