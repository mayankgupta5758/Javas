package com.mayank.assignment.model;

public class CurrentAccount extends BankAccount {

    private static final double OVERDRAFT_LIMIT = 10000;

    public CurrentAccount(String name, double balance) {
        super(name, balance);
    }

    @Override
    public void withdraw(double amount) throws InvalidAmountException {

        if (getBalance() - amount < -OVERDRAFT_LIMIT) {
            System.out.println("Overdraft limit exceeded.");
        } else {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawn: " + amount);
        }
    }
}