package com.mayank.interfaces.model;

public class DebitCardPayment implements Payment {

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Debit Card payment of ₹" + amount);
    }
}