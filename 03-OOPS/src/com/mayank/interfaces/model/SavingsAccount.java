package com.mayank.interfaces.model;

public class SavingsAccount implements AccountOperations {

    private double balance;
    private static final double WITHDRAW_LIMIT = 20000;

    public SavingsAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited Successfully.");
    }

    public void withdraw(double amount) {
        if (amount > WITHDRAW_LIMIT) {
            System.out.println("Withdrawal limit exceeded! Max 20000 allowed.");
        } else if (amount > balance) {
            System.out.println("Insufficient Balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal Successful.");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}