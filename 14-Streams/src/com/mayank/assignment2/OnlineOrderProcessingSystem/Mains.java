package com.mayank.assignment2.OnlineOrderProcessingSystem;

import java.util.*;
import java.util.stream.Collectors;

class Order {
	int orderId;
	String customerName;
	String category;
	double amount;
	String status;

	Order(int orderId, String customerName, String category, double amount, String status) {
		this.orderId = orderId;
		this.customerName = customerName;
		this.category = category;
		this.amount = amount;
		this.status = status;
	}

	public int getOrderId() {
		return orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCategory() {
		return category;
	}

	public double getAmount() {
		return amount;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return orderId + " | " + customerName + " | " + category + " | ₹" + amount + " | " + status;
	}
}

public class Mains {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		List<Order> list = new ArrayList<>();
		int n = getValidInt("Enter number of orders: ");

		for (int i = 0; i < n; i++) {
			System.out.println("\nEnter details of Order " + (i + 1));
			int id = getValidInt("Order ID: ");
			String name = getValidString("Customer Name: ");
			String category = getValidString("Category: ");
			double amount = getValidDouble("Amount: ");
			String status = getValidStatus("Status (completed/cancelled/pending): ");
			list.add(new Order(id, name, category, amount, status));
		}

		System.out.println("\nCompleted Orders:");
		list.stream().filter(o -> o.getStatus().equalsIgnoreCase("completed")).forEach(System.out::println);

		double totalRevenue = list.stream().filter(o -> o.getStatus().equalsIgnoreCase("completed"))
				.map(Order::getAmount).reduce(0.0, Double::sum);

		System.out.println("\nTotal Revenue: ₹" + totalRevenue);

		System.out.println("\nOrders Grouped by Category:");
		Map<String, List<Order>> grouped = list.stream().collect(Collectors.groupingBy(Order::getCategory));
		grouped.forEach((k, v) -> System.out.println(k + " -> " + v));

		System.out.println("\nHighest Order:");
		list.stream().max(Comparator.comparingDouble(Order::getAmount)).ifPresent(System.out::println);

		long cancelledCount = list.stream().filter(o -> o.getStatus().equalsIgnoreCase("cancelled")).count();

		System.out.println("\nCancelled Orders Count: " + cancelledCount);

		System.out.println("\nOrderId -> Amount Map:");
		Map<Integer, Double> map = list.stream().collect(Collectors.toMap(Order::getOrderId, Order::getAmount));
		System.out.println(map);

		System.out.println("\nCustomer Names Sorted by Order Amount:");
		list.stream().sorted(Comparator.comparingDouble(Order::getAmount).reversed()).map(Order::getCustomerName)
				.forEach(System.out::println);
	}

	static int getValidInt(String msg) {
		while (true) {
			try {
				System.out.print(msg);
				return Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Invalid number. Try again.");
			}
		}
	}

	static double getValidDouble(String msg) {
		while (true) {
			try {
				System.out.print(msg);
				double val = Double.parseDouble(sc.nextLine());
				if (val < 0)
					throw new Exception();
				return val;
			} catch (Exception e) {
				System.out.println("Invalid amount. Try again.");
			}
		}
	}

	static String getValidString(String msg) {
		while (true) {
			System.out.print(msg);
			String s = sc.nextLine().trim();
			if (!s.isEmpty())
				return s;
			System.out.println("Input cannot be empty.");
		}
	}

	static String getValidStatus(String msg) {
		while (true) {
			System.out.print(msg);
			String s = sc.nextLine().toLowerCase();
			if (s.equals("completed") || s.equals("cancelled") || s.equals("pending")) {
				return s;
			}
			System.out.println("Enter only: completed / cancelled / pending");
		}
	}
}