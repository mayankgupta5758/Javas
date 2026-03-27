package com.mayank.smarthome;

public class Fan implements Controllable {

	@Override
	public void turnOn() {
		System.out.println("Fan Turn On...");
	}

	@Override
	public void turnOff() {
		System.out.println("Fan Turn Off!!!");
	}

	@Override
	public void setMode(String mode) {
		if(mode.equals("High")) {
			System.out.println("Fan mode set to High.");
			return;
		} else if(mode.equals("Low")) {
			System.out.println("Fan mode set to Low.");
			return;
		}
		System.out.println("Enter High or Low.");
	}

}
