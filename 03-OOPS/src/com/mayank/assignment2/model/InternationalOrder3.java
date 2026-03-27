package com.mayank.assignment2.model;

public class InternationalOrder3 extends Order3 {

    public InternationalOrder3(int id, String name, double amount) throws InvalidOrderException3 {
        super(id, name, amount);
        System.out.println("InternationalOrder Constructor Called");
    }

    public boolean verifyOrder() {
        return amount >= 1000;
    }

    public void processOrder() {
        System.out.println("International order processed with customs check for " + customerName);
    }
}