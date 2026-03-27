package com.mayank.assignment1.model;

import java.util.Comparator;

public class FlightsComparator implements Comparator<Flights> {

    @Override
    public int compare(Flights f1, Flights f2) {
        return Double.compare(f1.fare, f2.fare);
    }
}