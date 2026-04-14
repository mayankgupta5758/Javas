package com.mayank.ims;

import java.time.LocalDate;

public class PreishableProduct extends Product {
    protected LocalDate expiryDate;

    PreishableProduct(int productId, String name, LocalDate expiryDate) {
        super(productId, name);
        this.expiryDate = expiryDate;
    }

        @Override
    public String toString() {
        return "Product Id: " + productId + "Product Name: " + name + " Expiry Date: " + expiryDate;
    }
    
}
