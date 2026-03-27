package com.mayank.interfaces.model;

public class BikeControl implements VehicleControl {

    private boolean isStarted = false;
    private int currentGear = 0;

    @Override
    public void start() {
        if (!isStarted) {
            isStarted = true;
            System.out.println("Bike started");
        } else {
            System.out.println("Bike already started!");
        }
    }

    @Override
    public void stop() {
        if (isStarted) {
            isStarted = false;
            currentGear = 0;
            System.out.println("Bike stopped.");
        } else {
            System.out.println("Bike already off!");
        }
    }

    @Override
    public void changeGear(int gear) {
        if (!isStarted) {
            System.out.println("Start the bike first!");
            return;
        }
        if (gear >= 1 && gear <= 4) {
            currentGear = gear;
            System.out.println("Bike gear changed to: " + currentGear);
        } else {
            System.out.println("Bike has only 1 to 4 gears!");
        }
    }
}