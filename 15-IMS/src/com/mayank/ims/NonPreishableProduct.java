package com.mayank.ims;

public class NonPreishableProduct extends Product {
    protected String brand;

    NonPreishableProduct(int productId, String name, String brand) {
        super(productId, name);
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product Id: " + productId + "Product Name: " + name + " Brand: " + brand;
    }
}
