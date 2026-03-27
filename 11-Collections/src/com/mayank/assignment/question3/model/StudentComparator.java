package com.mayank.assignment.question3.model;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		int percentageCompare = Double.compare(o2.getTotalPercentage(), o1.getTotalPercentage());

		if (percentageCompare != 0)
			return percentageCompare;

		return o1.getName().compareTo(o2.getName());
	}

}

