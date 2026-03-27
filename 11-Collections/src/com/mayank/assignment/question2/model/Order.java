package com.mayank.assignment.question2.model;

public abstract class Order implements Comparable<Order> {
	protected int orderId;
	protected String customerName;
	protected double amount;
	protected OrderStatus status;

	public Order(int id, String name, double amount) {
		this.orderId = id;
		this.customerName = name;
		this.amount = amount;
		this.status = OrderStatus.CREATED;
	}

	public int getOrderId() {
		return orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public double getAmount() {
		return amount;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Order Id: " + orderId + " | " + "Customer Name: " + customerName + " | " + "Amount: " + amount + " | "
				+ "Order Status: " + status;
	}

	@Override
	public int compareTo(Order o) {
		return this.orderId - o.orderId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Order))
			return false;
		Order o = (Order) obj;
		return this.orderId == o.orderId;
	}

	@Override
	public int hashCode() {
		return orderId;
	}
}