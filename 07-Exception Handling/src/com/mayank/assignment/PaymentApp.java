package com.mayank.assignment;

public class PaymentApp {

    public static void processPayment() {

        try {
            String card = null;
            System.out.println(card.length()); 

        } catch (NullPointerException e) {

            throw new RuntimeException("Payment processing failed", e);
        }
    }

    public static void main(String[] args) {

        try {
            processPayment();

        } catch (RuntimeException e) {

            System.out.println("Main Exception: " + e);

            Throwable cause = e.getCause();

            while (cause != null) {
                System.out.println("Caused by: " + cause);
                cause = cause.getCause();
            }
        }
    }
}