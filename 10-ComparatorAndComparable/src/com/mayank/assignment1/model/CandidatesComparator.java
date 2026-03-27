package com.mayank.assignment1.model;

import java.util.Comparator;

public class CandidatesComparator implements Comparator<Candidates> {
	public int compare(Candidates s1, Candidates s2) {
		int nameSort = s1.name.compareTo(s2.name);

		if (nameSort != 0) {
			return nameSort;
		}

		return s1.age - s2.age;
	}
}