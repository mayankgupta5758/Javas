package com.mayank.abstraction.model;

public class EmergencyPatient extends Patient {

    private double emergencySurcharge;

    public EmergencyPatient(int id, String name, double treatmentCost, double emergencySurcharge) {
        super(id, name);
        this.baseAmount = treatmentCost;
        this.emergencySurcharge = emergencySurcharge;
    }

    @Override
    protected double calculateCharges() {
        return baseAmount + emergencySurcharge;
    }
}
