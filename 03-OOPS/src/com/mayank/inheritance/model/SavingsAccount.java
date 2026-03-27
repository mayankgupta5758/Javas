package com.mayank.inheritance.model;

public class SavingsAccount extends Account {

	private double minBalance;

	public SavingsAccount(int accountNumber, String holderName, double balance, double minBalance) {
		super(accountNumber, holderName, balance, "Savings");
		this.minBalance = minBalance;
	}

	@Override
	public String withdraw(double amount) {

		if (balance - amount < minBalance) {
			return "Minimum Balance must be maintained: " + minBalance;
		}

		return super.withdraw(amount);
	}
}