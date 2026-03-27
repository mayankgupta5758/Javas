package com.mayank.arrayofobject.model;

public class Vehicle {

    private int vehicleId;
    private String vehicleType;

    protected double baseRate;

    private static int totalVehiclesProcessed = 0;
    private static double totalTollCollected = 0;

    public Vehicle(int vehicleId, String vehicleType, double baseRate) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.baseRate = baseRate;
    }

	public double calculateToll() {
        return baseRate;
    }

    public static void updateTotals(double tollAmount) {
        totalVehiclesProcessed++;
        totalTollCollected += tollAmount;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public static int getTotalVehiclesProcessed() {
        return totalVehiclesProcessed;
    }

    public static double getTotalTollCollected() {
        return totalTollCollected;
    }
}