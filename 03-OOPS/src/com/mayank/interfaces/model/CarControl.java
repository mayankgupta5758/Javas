package com.mayank.interfaces.model;

public class CarControl implements VehicleControl {

    private boolean isStarted = false;
    private int currentGear = 0;

    @Override
    public void start() {
        if (!isStarted) {
            isStarted = true;
            System.out.println("Car started");
        } else {
            System.out.println("Car already started!");
        }
    }

    @Override
    public void stop() {
        if (isStarted) {
            isStarted = false;
            currentGear = 0;
            System.out.println("Car stopped.");
        } else {
            System.out.println("Car is already off!");
        }
    }

    @Override
    public void changeGear(int gear) {
        if (!isStarted) {
            System.out.println("Start the car first!");
            return;
        }

        if (gear >= 1 && gear <= 5) {
            currentGear = gear;
            System.out.println("Car gear changed to: " + currentGear);
        } else {
            System.out.println("Car has only 1 to 5 gears!");
        }
    }
}