package com.mayank.encapsulation.model;


public class BankAccount {
//	static int counter = 100000;
//	private final String accountNumber = "BAN"+counter++;
	private String accountHolderName;
	private double balance;
	
	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public void depositeMoney(int amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Successfully Added to Amount.");
		} else {
			System.out.println("Enter Invalid Amount.");
		}
	}

	public void withdrawMoney(int amount) {
		if (amount <= balance && amount > 0) {
			balance -= amount;
		} else {
			System.out.println("Enter Invalid Amount.");
		}

	}

	public void checkBalance() {
		System.out.println("Your Bank Balance is: " + balance + "Rs.");
	}


//	private void calculateInterest() {
//		balance += balance * 0.05;
//	}
}
