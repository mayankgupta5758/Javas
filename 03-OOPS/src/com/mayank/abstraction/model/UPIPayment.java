package com.mayank.abstraction.model;

public class UPIPayment extends Payment {

    public UPIPayment(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() {

        if (!validateAmount())
            return;

        System.out.println("Processing UPI Payment...");
        System.out.println("No Processing Fee.");
        System.out.println("Total Deducted: ₹" + amount);

        generateReceipt();
    }
}