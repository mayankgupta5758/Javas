package com.mayank.assignment.model;

public class Electronics extends Product{

	public Electronics(int productId, String name, double price) {
		super(productId, name, price);
	}
	
	@Override
	public void showDetails() {
		System.out.println("Electronics Product.");
		super.showDetails();
	}

}
