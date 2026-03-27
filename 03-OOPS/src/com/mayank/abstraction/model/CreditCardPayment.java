package com.mayank.abstraction.model;

public class CreditCardPayment extends Payment {

    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() {

        if (!validateAmount())
            return;

        double fee = amount * 0.02;
        double total = amount + fee;

        System.out.println("Processing Credit Card Payment...");
        System.out.println("Processing Fee (2%): ₹" + fee);
        System.out.println("Total Deducted: ₹" + total);

        generateReceipt();
    }
}