package com.mayank.ims;

import java.time.LocalDate;

public class ForFIFO {
    protected int quantity;
    LocalDate date;
    protected double price;

    public ForFIFO(int quantity, LocalDate date, double price) {
        this.quantity = quantity;
        this.date = date;
        this.price = price;
    }
}
