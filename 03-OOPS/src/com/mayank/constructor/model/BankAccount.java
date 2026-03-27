package com.mayank.constructor.model;

public class BankAccount {

    private String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName, double balance) {
        this.setAccountHolderName(accountHolderName);
        if (balance > 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
            System.out.println("Invalid initial balance. Set to 0.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount Deposited Successfully.");
        } else {
            System.out.println("Enter positive amount.");
        }
    }

    public double getBalance() {
        return balance;
    }

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
}
