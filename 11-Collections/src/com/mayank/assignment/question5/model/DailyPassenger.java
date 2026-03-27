package com.mayank.assignment.question5.model;

public class DailyPassenger extends Passenger {

    private String passType;

    public DailyPassenger(int id, String name, int route, String passType) {
        super(id, name, route);
        this.passType = passType;
    }

    @Override
    public String toString() {
        return super.toString() + " | Pass: " + passType;
    }
}