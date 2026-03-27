package com.mayank.abstraction.model;

public class WalletPayment extends Payment {

    public WalletPayment(double amount) {
        super(amount);
    }

    @Override
    public void processPayment() {

        if (!validateAmount())
            return;

        double fee = amount * 0.01;
        double total = amount + fee;

        System.out.println("Processing Wallet Payment...");
        System.out.println("Processing Fee (1%): ₹" + fee);
        System.out.println("Total Deducted: ₹" + total);

        generateReceipt();
    }
}