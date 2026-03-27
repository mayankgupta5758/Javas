package com.mayank.abstraction.model;

public class Taxi extends Transport {

    private double distance;
    private double time;   

    public Taxi(String routeId, double baseFare,
                double distance, double time) {

        super(routeId, baseFare);
        this.distance = distance;
        this.time = time;
    }

    @Override
    protected double calculateFare() {
        return baseFare + (distance * 10) + (time * 2);
    }
}