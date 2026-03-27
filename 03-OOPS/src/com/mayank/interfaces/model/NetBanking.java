package com.mayank.interfaces.model;

public class NetBanking implements PaymentGateway {

    @Override
    public void pay(double amount) {
        System.out.println("Processing Net Banking payment of ₹" + amount);
        System.out.println("Net Banking payment successful ✅");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunding ₹" + amount + " via Net Banking");
        System.out.println("Refund successful ✅");
    }
}