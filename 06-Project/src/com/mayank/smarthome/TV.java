package com.mayank.smarthome;

public class TV implements Controllable {

	@Override
	public void turnOn() {
		System.out.println("TV Turn On...");
	}

	@Override
	public void turnOff() {
		System.out.println("TV Turn Off!!!");
	}

	@Override
	public void setMode(String mode) {
		if(mode.equals("HD")) {
			System.out.println("TV mode set to HD.");
			return;
		} else if(mode.equals("4K")) {
			System.out.println("TV mode set to 4K.");
			return;
		}
		System.out.println("Enter HD or 4K.");
	}

}
