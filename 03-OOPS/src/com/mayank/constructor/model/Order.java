package com.mayank.constructor.model;

public class Order {

	private static int counter = 5000;

	protected final int orderId;
	protected Product product;
	protected int quantity;
	protected double totalAmount;

	public Order(Product product, int quantity) {
		this.orderId = ++counter;
		if (product == null) {
			System.out.println("Product cannot be null");
			return;
		} else if (quantity <= 0) {
			System.out.println("Quantity must be greater than 0");
			return;
		}
		this.product = product;
		this.quantity = quantity;
		this.totalAmount = product.getPrice() * quantity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public int getOrderId() {
		return orderId;
	}
}
