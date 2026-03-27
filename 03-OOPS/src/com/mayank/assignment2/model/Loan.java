package com.mayank.assignment2.model;

public abstract class Loan {
	protected int loanId;
	protected String borrowerName;
	protected double principalAmount;
	protected double interestRate;

//	static {
//		System.out.println("Loan System Configuration Loaded...");
//	}

	public int getLoanId() {
		return loanId;
	}

	public Loan(int loanId, String borrowerName, double principalAmount, double interestRate) throws InvalidLoanException {
		if (principalAmount <= 0)
			throw new InvalidLoanException("Loan amount cannot be negative");
		if (interestRate < 0)
			throw new InvalidLoanException("Interest rate invalid");
		this.loanId = loanId;
		this.borrowerName = borrowerName;
		this.principalAmount = principalAmount;
		this.interestRate = interestRate;
//		System.out.println("Loan Constructor Called");
	}

	public abstract double calculateRepayment(int years);

	public void display() {
		System.out.println("Loan ID : " + loanId);
		System.out.println("Borrower : " + borrowerName);
		System.out.println("Principal : " + principalAmount);
		System.out.println("Interest : " + interestRate);
	}
}