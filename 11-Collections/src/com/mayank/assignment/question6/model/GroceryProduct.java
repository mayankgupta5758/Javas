package com.mayank.assignment.question6.model;

import java.time.LocalDate;

public class GroceryProduct extends Product {

    private LocalDate expiryDate;

    public GroceryProduct(int id, String name, String category, double price, LocalDate expiryDate) {
        super(id, name, category, price);
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return super.toString() + " | Expiry: " + expiryDate.getYear()+"/"+expiryDate.getMonth()+"/"+expiryDate.getDayOfMonth();
    }
}