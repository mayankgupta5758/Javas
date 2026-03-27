package com.mayank.arrayofobject.model;

public class Car extends Vehicle {

	public Car(int vehicleId, double baseRate) {
		super(vehicleId, "Car", baseRate);
	}

	@Override
	public double calculateToll() {
		return baseRate + 20;
	}

	public double calculateToll(boolean isVIP) {
		if (isVIP)
			return baseRate;
		return calculateToll();
	}
}