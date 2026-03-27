package com.mayank.inheritance.model;

public class Account {

	protected int accountNumber;
	protected String holderName;
	protected double balance;
	protected String accountType;

	public Account(int accountNumber, String holderName, double balance, String accountType) {

		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.balance = balance;
		this.accountType = accountType;
	}

	public String deposit(double amount) {
		if (amount <= 0)
			return "Invalid Deposit Amount!";

		balance += amount;
		return "Deposit Successful. Balance: " + balance;
	}

	public String withdraw(double amount) {
		if (amount <= 0)
			return "Invalid Withdrawal Amount!";

		if (amount > balance)
			return "Insufficient Balance!";

		balance -= amount;
		return "Withdrawal Successful. Balance: " + balance;
	}

	public void displayDetails() {
		System.out.println("Account No: " + accountNumber);
		System.out.println("Account Holder: " + holderName);
		System.out.println("Account Type: " + accountType);
		System.out.println("Bank Balance: " + balance);
	}

	public String checkBalance() {
		return "Current Balance: " + balance;
	}
}