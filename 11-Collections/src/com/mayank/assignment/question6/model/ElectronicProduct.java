package com.mayank.assignment.question6.model;

public class ElectronicProduct extends Product {

    private int warrantyMonths;

    public ElectronicProduct(int id, String name, String category, double price, int warranty) {
        super(id, name, category, price);
        this.warrantyMonths = warranty;
    }

    @Override
    public String toString() {
        return super.toString() + " | Warranty: " + warrantyMonths + " months";
    }
}