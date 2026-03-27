package com.mayank.interfaces.model;

public class CreditCard implements PaymentGateway {

    @Override
    public void pay(double amount) {
        System.out.println("Processing Credit Card payment of ₹" + amount);
        System.out.println("Credit Card payment successful ✅");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunding ₹" + amount + " to Credit Card");
        System.out.println("Refund successful ✅");
    }
}