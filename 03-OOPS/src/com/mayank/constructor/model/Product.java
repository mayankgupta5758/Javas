package com.mayank.constructor.model;

public class Product {

	private static int counter = 100;
	private final int productId;
	private double price;
	private int stockQuantity;

	public Product(double price) {
		this(price, 0);
	}

	public Product(double price, int stockQuantity) {

		this.productId = counter++;
		if (price <= 0) {
			System.out.println("Price must be greater than 0");
			return;
		}

		this.price = price;
		this.setStockQuantity(stockQuantity);
	}

	public double getPrice() {
		return price;
	}

	public int getProductId() {
		return productId;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
}
