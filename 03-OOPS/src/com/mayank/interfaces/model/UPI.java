package com.mayank.interfaces.model;

public class UPI implements PaymentGateway {

    @Override
    public void pay(double amount) {
        System.out.println("Processing UPI payment of ₹" + amount);
        System.out.println("UPI payment successful ✅");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunding ₹" + amount + " via UPI");
        System.out.println("Refund successful ✅");
    }
}