package com.mayank.abstraction.model;

public class Metro extends Transport {

    private int stations;

    public Metro(String routeId, double baseFare, int stations) {
        super(routeId, baseFare);
        this.stations = stations;
    }

    @Override
    protected double calculateFare() {
        return baseFare + (stations * 5);
    }
}