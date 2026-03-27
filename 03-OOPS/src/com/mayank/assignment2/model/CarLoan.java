package com.mayank.assignment2.model;

public class CarLoan extends Loan implements EligibilityCheck {
    public CarLoan(int id, String name, double amount, double rate) throws Exception {
        super(id, name, amount, rate);
    }

    @Override
    public double calculateRepayment(int years) {
        return principalAmount + (principalAmount * interestRate * years / 100);
    }

    @Override
    public boolean checkEligibility(double income, int creditScore) {
        return income > 30000 && creditScore > 650;
    }
    
    @Override
    public void display() {
    	System.out.println("-------------------------");
    	System.out.println("Car Loan.");
    	super.display();
    	System.out.println("-------------------------");
    }
}