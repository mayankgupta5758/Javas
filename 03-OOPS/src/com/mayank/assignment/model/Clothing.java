package com.mayank.assignment.model;

public class Clothing extends Product {

	public Clothing(int productId, String name, double price) {
		super(productId, name, price);
	}
	
	@Override
	public void showDetails() {
		System.out.println("Clothing Product.");
		super.showDetails();
	}

}
