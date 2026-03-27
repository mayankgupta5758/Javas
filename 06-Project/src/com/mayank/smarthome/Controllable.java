package com.mayank.smarthome;

interface Controllable {
	void turnOn();

	void turnOff();

	void setMode(String mode);
}