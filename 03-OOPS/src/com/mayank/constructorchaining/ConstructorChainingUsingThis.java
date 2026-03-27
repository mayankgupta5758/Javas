package com.mayank.constructorchaining;

class BankAccount {

	private String name;
	private double balance;

	// Constructor 1
	public BankAccount(String name) {
		System.out.println("calling constructor 1");
		this(name, 0); 
	}

	// Constructor 2
	public BankAccount(String name, double balance) {
		System.out.println("calling constructor 2");
		this.name = name;
		this.balance = balance;
	}
}

public class ConstructorChainingUsingThis {

	public static void main(String[] args) {
		BankAccount acc = new BankAccount("Mayank");
//		this() must be first statement inside constructor.
//		Step by step:
//			Constructor 1 call hoga
//			this(name, 0) constructor 2 ko call karega
//			Constructor 2 object initialize karega
	}

}
