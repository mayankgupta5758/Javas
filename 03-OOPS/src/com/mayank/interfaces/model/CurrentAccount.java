package com.mayank.interfaces.model;

public class CurrentAccount implements AccountOperations {

    private double balance;

    public CurrentAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Amount Deposited Successfully.");
    }

    public void withdraw(double amount) {
        if (amount > balance) {
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