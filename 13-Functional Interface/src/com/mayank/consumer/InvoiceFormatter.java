package com.mayank.consumer;

import java.util.function.Consumer;

class Invoice {
	String itemName;
	int quantity;
	int price;

	public Invoice(String itemName, int quantity, int price) {
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}
}

public class InvoiceFormatter {

	public static void main(String[] args) {

		Consumer<Invoice> printInvoice = inv -> {
			int total = inv.quantity * inv.price;
			System.out.println("Item: " + inv.itemName + " | Quantity: " + inv.quantity + " | Total: ₹" + total);
		};

		Invoice i1 = new Invoice("Pen", 2, 10);
		Invoice i2 = new Invoice("Notebook", 3, 50);
		Invoice i3 = new Invoice("Pencil", 5, 5);

		printInvoice.accept(i1);
		printInvoice.accept(i2);
		printInvoice.accept(i3);
	}
}