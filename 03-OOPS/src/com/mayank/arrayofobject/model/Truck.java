package com.mayank.arrayofobject.model;

public class Truck extends Vehicle {

	private int numberOfAxles;

	public Truck(int vehicleId, double baseRate, int numberOfAxles) {
		super(vehicleId, "Truck", baseRate);
		this.numberOfAxles = numberOfAxles;
	}

	@Override
	public double calculateToll() {
		return baseRate + (numberOfAxles * 50);
	}

	public double calculateToll(int extraLoadCharge) {
		return calculateToll() + extraLoadCharge;
	}
}