package com.mayank.abstraction.model;

public class OutPatient extends Patient {

    private double consultationFee;

    public OutPatient(int id, String name, double consultationFee) {
        super(id, name);
        this.consultationFee = consultationFee;
    }

    @Override
    protected double calculateCharges() {
        return consultationFee;
    }
}
