package com.mayank.ims;

public class ReoderService {
    private final static int threshold = 5;

    public boolean chkThreshold(int totlaStock) {
        return totlaStock <= threshold;
    }
    public void placeOrder(Product prod) {
        System.out.println("Reorder placed for product: " + prod.getName());
    }
}
