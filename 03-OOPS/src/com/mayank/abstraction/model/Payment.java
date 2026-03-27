package com.mayank.abstraction.model;

public abstract class Payment {

    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public boolean validateAmount() {
        if (amount > 0) {
            return true;
        }
        System.out.println("Invalid Amount! Amount must be greater than 0.");
        return false;
    }

    public abstract void processPayment();

    public void generateReceipt() {
        System.out.println("Receipt Generated.");
        System.out.println("Paid Amount: ₹" + amount);
        System.out.println("---------------------------");
    }
}