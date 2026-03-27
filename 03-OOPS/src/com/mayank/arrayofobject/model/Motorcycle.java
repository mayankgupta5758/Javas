package com.mayank.arrayofobject.model;

public class Motorcycle extends Vehicle {

	public Motorcycle(int vehicleId, double baseRate) {
		super(vehicleId, "Motorcycle", baseRate);
	}

	@Override
	public double calculateToll() {
		return baseRate;
	}

	public double calculateToll(double discountPercent) {
		double toll = calculateToll();
		return toll - (toll * discountPercent / 100);
	}
}