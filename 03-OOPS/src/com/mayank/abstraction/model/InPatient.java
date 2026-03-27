package com.mayank.abstraction.model;


public class InPatient extends Patient {

    private double roomCharges;

    public InPatient(int id, String name, double treatmentCost, double roomCharges) {
        super(id, name);
        this.baseAmount = treatmentCost;
        this.roomCharges = roomCharges;
    }

    @Override
    protected double calculateCharges() {
        return baseAmount + roomCharges;
    }
}