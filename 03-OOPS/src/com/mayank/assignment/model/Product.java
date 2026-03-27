package com.mayank.assignment.model;

public class Product {
	private int productId;
	protected String name;
	private double price;
	
	public Product(int productId, String name, double price) {
		this.productId = productId;
		this.name = name;
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
	
	protected void setPrice(double price) {
		this.price = price;
	}
	
	public void showDetails() {
		System.out.println("Product id is: " + productId);
		System.out.println("Product name is: " + name);
		System.out.println("Product price is: " + price);
	}
}
