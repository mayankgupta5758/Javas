package com.mayank.assignment2.model;

public abstract class Order3 implements OrderVerification3 {

    public int orderId;
    String customerName;
    double amount;

    static String systemName;

    static {
        systemName = "E-Commerce Fulfillment System";
        System.out.println("System Loaded: " + systemName);
    }

    public Order3(int id, String name, double amount) throws InvalidOrderException3 {

        System.out.println("Order Constructor Called");

        if (id <= 0)
            throw new InvalidOrderException3("Invalid Order ID");

        if (amount < 0)
            throw new InvalidOrderException3("Order amount cannot be negative");

        this.orderId = id;
        this.customerName = name;
        this.amount = amount;
    }

    public abstract void processOrder();

    public void display() {
        System.out.println("ID: " + orderId +
                " Customer: " + customerName +
                " Amount: " + amount);
    }
}
