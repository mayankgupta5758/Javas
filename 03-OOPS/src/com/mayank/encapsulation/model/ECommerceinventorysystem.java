package com.mayank.encapsulation.model;

public class ECommerceinventorysystem {

//	private static int counter = 1000;
//	private final String productId = "P" + counter++;
	private String productName;
	private double price;
	private int stockQuantity;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price <= 0) {
			System.out.println("Invalid Price!!!");
		} else {
			this.price = price;
		}
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		if (stockQuantity <= 0) {
			System.out.println("Invalid Stock Quantity!!!");
		} else {
			this.stockQuantity = stockQuantity;
	        System.out.println("Product Created Successfully");
		}
	}

	public void updatePrice(double newPrice, boolean isAdmin) {
		if (!isAdmin) {
			System.out.println("Only admin can update price");
		} else {
			if (validatePrice(newPrice)) {
				this.price = newPrice;
			} else {
				System.out.println("Invalid Price!!!");
			}
		}
	}

	public void changeStock(int quantity) {
		if(validateStock(quantity)) {
			setStockQuantity(quantity);;
		} else {
			System.out.println("Invalid Stock!!!");
		}
	}

	private boolean validatePrice(double price) {
		if (price < 0) {
			return false;
		}
		return true;
	}

	private boolean validateStock(int quantity) {
		if (quantity <= 0) {
			return false;
		}
		return true;
	}
}
