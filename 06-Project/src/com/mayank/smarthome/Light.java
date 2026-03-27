package com.mayank.smarthome;

public class Light implements Controllable {

	@Override
	public void turnOn() {
		System.out.println("Light Turn On...");
	}

	@Override
	public void turnOff() {
		System.out.println("Light Turn Off!!!");
	}

	@Override
	public void setMode(String mode) {		
		if(mode.equals("High")) {
			System.out.println("Light mode set to High.");
			return;
		} else if(mode.equals("Dim")) {
			System.out.println("Light mode set to Dim.");
			return;
		}
		System.out.println("Enter High or Dim.");
	}

}
