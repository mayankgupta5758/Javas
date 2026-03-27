package com.mayank.inheritance.model;

public class CurrentAccount extends Account {

	private double overdraftLimit;

	public CurrentAccount(int accountNumber, String holderName, double balance, double overdraftLimit) {
		super(accountNumber, holderName, balance, "Current");
		this.overdraftLimit = overdraftLimit;
	}

	@Override
	public String withdraw(double amount) {

		if (balance - amount < -overdraftLimit) {
			return "Overdraft Limit Exceeded!";
		}

		balance -= amount;
		return "Withdrawal Successful. Balance: " + balance;
	}
}