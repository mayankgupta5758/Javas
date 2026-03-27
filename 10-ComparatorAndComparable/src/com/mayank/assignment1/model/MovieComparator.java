package com.mayank.assignment1.model;

import java.util.Comparator;

public class MovieComparator implements Comparator<Movie>{
	@Override
    public int compare(Movie m1, Movie m2) {

        int yearCompare = m2.year - m1.year;

        if (yearCompare != 0) {
            return yearCompare;
        }

        return m1.title.compareTo(m2.title);
    }
}
