package com.mayank.assignment.question5.model;

public class TouristPassenger extends Passenger {

    private String hotelName;

    public TouristPassenger(int id, String name, int route, String hotelName) {
        super(id, name, route);
        this.hotelName = hotelName;
    }

    @Override
    public String toString() {
        return super.toString() + " | Hotel: " + hotelName;
    }
}