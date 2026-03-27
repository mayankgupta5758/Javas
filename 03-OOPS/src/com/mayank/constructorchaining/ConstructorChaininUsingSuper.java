package com.mayank.constructorchaining;

class Account {

    protected double balance;

    public Account(double balance) {
        this.balance = balance;
        System.out.println("Parent constructor called");
    }
}

class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount(double balance, double interestRate) {
        super(balance);   // calling parent constructor
        this.interestRate = interestRate;
        System.out.println("Child constructor called");
    }
}


public class ConstructorChaininUsingSuper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SavingsAccount acc = new SavingsAccount(1000, 5);

	}

}
