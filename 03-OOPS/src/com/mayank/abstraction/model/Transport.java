package com.mayank.abstraction.model;


public abstract class Transport {

    protected String routeId;
    protected double baseFare;

    public Transport(String routeId, double baseFare) {
        this.routeId = routeId;
        this.baseFare = baseFare;
    }

    public void printTicket() {
        double fare = calculateFare();

        System.out.println("\n----- TICKET -----");
        System.out.println("Route ID: " + routeId);
        System.out.println("Base Fare: ₹" + baseFare);
        System.out.println("Final Fare: ₹" + fare);
        System.out.println("-------------------");
    }

    protected abstract double calculateFare();
}