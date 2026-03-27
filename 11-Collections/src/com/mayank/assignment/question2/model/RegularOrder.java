package com.mayank.assignment.question2.model;

public class RegularOrder extends Order {
    private String deliveryType;
    public RegularOrder(int id, String name, double amount, String deliveryType) {
        super(id, name, amount);
        this.deliveryType = deliveryType;
    }

    @Override
    public String toString() {
        return super.toString() + " | Delivery: " + deliveryType;
    }
}