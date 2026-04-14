package com.mayank.ims;

abstract public class Product {
    protected int productId;
    protected String name;

    Product(int productId, String name) {

        this.productId = productId;
        this.name = name;
    }

    public int productId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product Id: " + productId + "Product Name: " + name;

    }
}
