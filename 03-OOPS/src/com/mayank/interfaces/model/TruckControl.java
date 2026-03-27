package com.mayank.interfaces.model;

public class TruckControl implements VehicleControl {

    private boolean isStarted = false;
    private int currentGear = 0;

    @Override
    public void start() {
        if (!isStarted) {
            isStarted = true;
            System.out.println("Truck started");
        } else {
            System.out.println("Truck already started!");
        }
    }

    @Override
    public void stop() {
        if (isStarted) {
            isStarted = false;
            currentGear = 0;
            System.out.println("Truck stopped.");
        } else {
            System.out.println("Truck already off!");
        }
    }

    @Override
    public void changeGear(int gear) {
        if (!isStarted) {
            System.out.println("Start the truck first!");
            return;
        }

        if (gear >= 1 && gear <= 10) {
            currentGear = gear;
            System.out.println("Truck gear changed to: " + currentGear);
        } else {
            System.out.println("Truck has only 1 to 10 gears!");
        }
    }
}