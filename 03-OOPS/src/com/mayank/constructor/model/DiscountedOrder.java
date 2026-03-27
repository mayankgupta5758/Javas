package com.mayank.constructor.model;


public class DiscountedOrder extends Order {

    private double discountPercentage;

    public DiscountedOrder(Product product, int quantity, double discountPercentage) {

        super(product, quantity);   

        if (discountPercentage < 0 || discountPercentage > 100) {
        	System.out.println("Invalid discount percentage"); return;}

        this.discountPercentage = discountPercentage;

        // Apply discount AFTER parent calculation
        double discountAmount = totalAmount * (discountPercentage / 100);
        this.totalAmount = totalAmount - discountAmount;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }
}
