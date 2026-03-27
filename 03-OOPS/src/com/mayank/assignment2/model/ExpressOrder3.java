package com.mayank.assignment2.model;

public class ExpressOrder3 extends Order3 {

	public ExpressOrder3(int id, String name, double amount) throws InvalidOrderException3 {
        super(id, name, amount);
        System.out.println("ExpressOrder Constructor Called");
    }

    public boolean verifyOrder() {
        return amount >= 500;
    }

    public void processOrder() {
        System.out.println("Express order shipped quickly for " + customerName);
    }
}