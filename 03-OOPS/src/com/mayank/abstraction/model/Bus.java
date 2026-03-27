package com.mayank.abstraction.model;


public class Bus extends Transport {

    private double distance;

    public Bus(String routeId, double baseFare, double distance) {
        super(routeId, baseFare);  
        this.distance = distance;
    }

    @Override
    protected double calculateFare() {
        return baseFare + (distance * 2);
    }
}