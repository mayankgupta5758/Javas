package com.mayank.assignment.model;

public class MultipleExceptionScenarios {

    public double withdraw(double balance, double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance.");
        }

        return balance - amount;
    }
}