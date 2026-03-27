package com.mayank.abstraction.model;

public abstract class Patient {

    private int patientId;
    private String name;

    protected double baseAmount;  

    public Patient(int patientId, String name) {
        this.patientId = patientId;
        this.name = name;
    }

    public void generateBill() {

        double charges = calculateCharges();  

        double tax = charges * 0.05;
        double finalAmount = charges + tax;

        System.out.println("\n----- BILL -----");
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Base Charges: ₹" + charges);
        System.out.println("Tax (5%): ₹" + tax);
        System.out.println("Final Amount: ₹" + finalAmount);
        System.out.println("-------------------------");
    }

    protected abstract double calculateCharges();
}