package com.mayank.assignment2.model;

public class StandardOrder3 extends Order3 {

    public StandardOrder3(int id, String name, double amount) throws InvalidOrderException3 {
        super(id, name, amount);
        System.out.println("StandardOrder Constructor Called");
    }

    public boolean verifyOrder() {
        return amount >= 100;
    }

    public void processOrder() {
        System.out.println("Standard order processed for " + customerName);
    }
}