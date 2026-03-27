package com.mayank.interfaces.model;

public class Bike implements Vehicle {

	@Override
	public void start() {
		System.out.println("Bike Start...");
	}

	@Override
	public void stop() {
		System.out.println("Bike Stop!!!");
	}

	@Override
	public void fuelType(String typeofFuel) {
		if(typeofFuel.equals("Petrol")) {
			System.out.println("Petrol Type");
			return;
		}
		System.out.println("only Petrol Allowed.");
	}

}
