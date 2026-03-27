package com.mayank.assignment.model;

public class BankAccount {

    private double balance;
    protected String name;

    public BankAccount(String name, double balance) {
    	this.name = name;

        if (balance < 0) {
            System.out.println("Invalid initial balance. Setting to 0.");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) throws InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive.");
        }

        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) throws InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException("Withdraw amount must be positive.");
        }

        if (amount > balance) {
            System.out.println("Insufficient Balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }
}