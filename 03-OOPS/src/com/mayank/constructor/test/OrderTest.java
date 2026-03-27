package com.mayank.constructor.test;

import java.util.Scanner;

import com.mayank.constructor.model.DiscountedOrder;
import com.mayank.constructor.model.Order;
import com.mayank.constructor.model.Product;

public class OrderTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter Product Price: ");
		double price = scanner.nextDouble();

		System.out.println("Enter Stock Quantity: ");
		int stock = scanner.nextInt();

		Product product = new Product(price, stock);

		System.out.println("Enter Order Quantity: ");
		int quantity = scanner.nextInt();

		System.out.println("Press 1 for Discounted Order or 2 for Normal Order:");
		int choice = scanner.nextInt();

		Order order;

		if (choice == 1) {

			System.out.println("Enter Discount Percentage: ");
			double discount = scanner.nextDouble();

			order = new DiscountedOrder(product, quantity, discount);
			System.out.println("Discounted Order Created Successfully.");

		} else {

			order = new Order(product, quantity);
			System.out.println("Normal Order Created Successfully.");
		}

		System.out.println("\n--- Order Details ---");
		System.out.println("Order ID: " + order.getOrderId());
		System.out.println("Total Amount: " + order.getTotalAmount());

		scanner.close();
	}
}
