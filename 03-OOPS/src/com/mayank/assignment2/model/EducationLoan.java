package com.mayank.assignment2.model;

public class EducationLoan extends Loan implements EligibilityCheck {
    public EducationLoan(int id, String name, double amount, double rate) throws Exception {
        super(id, name, amount, 0);
    }

    @Override
    public double calculateRepayment(int years) {
        return principalAmount;
    }

    @Override
    public boolean checkEligibility(double income, int creditScore) {
        return creditScore > 600;
    }
    
    @Override
    public void display() {
    	System.out.println("-------------------------");
    	System.out.println("Education Loan.");
    	super.display();
    	System.out.println("-------------------------");
    }
}