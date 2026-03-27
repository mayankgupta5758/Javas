package com.mayank.constructorchaining;

class Product {

	protected double price;

	public Product(double price) {
		this.price = price;
		System.out.println("Product constructor called");
	}

	public double getPrice() {
		return price;
	}
}

class DiscountedProduct extends Product {

	private double discount;

	public DiscountedProduct(double price) {
		this(price, 0); // constructor chaining
	}

	public DiscountedProduct(double price, double discount) {
		super(price); // parent constructor
		this.discount = discount;
		System.out.println("DiscountedProduct constructor called");
	}

	public double getFinalPrice() {
		return price - (price * discount / 100);
	}
}

public class CombinedExampleThisAndSuper {

	public static void main(String[] args) {

		// Object 1 (without discount)
		DiscountedProduct p1 = new DiscountedProduct(1000);

		System.out.println("Final Price: " + p1.getFinalPrice());

		System.out.println("-------------------");

		// Object 2 (with discount)
		DiscountedProduct p2 = new DiscountedProduct(2000, 10);

		System.out.println("Final Price: " + p2.getFinalPrice());
	}

}
