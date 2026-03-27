package com.mayank.smarthome;

public class Speaker implements Controllable {

	@Override
	public void turnOn() {
		System.out.println("Speaker Turn On...");
	}

	@Override
	public void turnOff() {
		System.out.println("Speaker Turn Off!!!");
	}

	@Override
	public void setMode(String mode) {
		if(mode.equals("Bass")) {
			System.out.println("Speaker mode set to Bass.");
			return;
		} else if(mode.equals("Loud")) {
			System.out.println("Speaker mode set to Loud.");
			return;
		}
		System.out.println("Enter Bass or Loud.");
	}

}
