package com.mayank.assignment.model;

public class SavingsAccount extends BankAccount {

    private static final double MIN_BALANCE = 500;

    public SavingsAccount(String name, double balance) {
        super(name, balance);
    }

    @Override
    public void withdraw(double amount) throws InvalidAmountException {

        if (getBalance() - amount < MIN_BALANCE) {
            System.out.println("Minimum balance of 500 must be maintained.");
        } else {
            super.withdraw(amount);
        }
    }
}