package com.mayank.assignment.question6.model;

public abstract class Product implements Comparable<Product> {

	protected int productId;
	protected String name;
	protected String category;
	protected double price;
	protected ProductStatus status;

	public Product(int id, String name, String category, double price) {
		this.productId = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.status = ProductStatus.ACTIVE;
	}

	public int getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	public ProductStatus getStatus() {
		return status;
	}

	public void setStatus(ProductStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product Id: " + productId + " | Name: " + name + " | Category: " + category + " | Price: " + price
				+ " | Status: " + status;
	}

	@Override
	public int compareTo(Product p) {
		return this.productId - p.productId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Product))
			return false;
		Product p = (Product) obj;
		return this.productId == p.productId;
	}

	@Override
	public int hashCode() {
		return productId;
	}
}