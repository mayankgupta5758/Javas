package com.mayank.interfaces.model;

public class Car implements Vehicle {

	@Override
	public void start() {
		System.out.println("Car Start...");
	}

	@Override
	public void stop() {
		System.out.println("Car Stop!!!");
	}

	@Override
	public void fuelType(String typeofFuel) {
		if (typeofFuel.equals("Petrol")) {
			System.out.print("Petrol Type");
			return;
		}
		System.out.print("Diesel Type.");
	}

}
