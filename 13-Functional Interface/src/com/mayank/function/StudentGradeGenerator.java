package com.mayank.function;

import java.util.*;
import java.util.function.Function;

public class StudentGradeGenerator {

	public static void main(String[] args) {

		Function<Integer, String> getGrade = marks -> {
			if (marks >= 75)
				return "A";
			else if (marks >= 50)
				return "B";
			else
				return "Fail";
		};

		List<Integer> marksList = Arrays.asList(85, 67, 45, 90, 52);

		marksList.forEach(marks -> System.out.println("Marks: " + marks + " -> Grade: " + getGrade.apply(marks)));
	}
}