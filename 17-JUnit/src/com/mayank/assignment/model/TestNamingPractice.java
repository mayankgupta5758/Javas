package com.mayank.assignment.model;

public class TestNamingPractice {
	double balance;

	public TestNamingPractice(double balance) {
		if(balance < 0) {
			throw new IllegalArgumentException("Balance can't be negative.");
		}
		
		this.balance = balance;
	}

	public void deposite(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("can't deposite Negative amount.");
		}

		balance += amount;
	}

	public void withdraw(double amount) {
		if (amount <= 0) {
			throw new IllegalArgumentException("can't withdraw Negative amount.");
		}

		balance -= amount;
	}

	public double getBalance() {
		return balance;
	}
}
