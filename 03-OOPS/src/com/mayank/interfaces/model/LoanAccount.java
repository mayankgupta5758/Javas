package com.mayank.interfaces.model;

public class LoanAccount implements AccountOperations {

    private double loanAmount;

    public LoanAccount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void deposit(double amount) {
        loanAmount -= amount;
        System.out.println("Loan Repayment Successful.");
    }

    public void withdraw(double amount) {
        System.out.println("Withdrawal Not Allowed in Loan Account.");
    }

    public void checkBalance() {
        System.out.println("Outstanding Loan: " + loanAmount);
    }
}