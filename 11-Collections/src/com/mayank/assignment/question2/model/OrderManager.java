package com.mayank.assignment.question2.model;

import java.util.*;
import com.mayank.assignment.question2.exception.*;

public class OrderManager {
	private Set<Order> orders = new HashSet<>();
	private Map<String, List<Order>> customerMap = new HashMap<>();
	private Queue<Integer> dispatchQueue = new LinkedList<>();

	private Order find(int id) throws OrderNotFoundException {
		for (Order o : orders) {
			if (o.getOrderId() == id)
				return o;
		}
		throw new OrderNotFoundException("Order not found");
	}

	public void addOrder(Order o) {
		if (orders.add(o)) {
			if (!customerMap.containsKey(o.getCustomerName())) {
				customerMap.put(o.getCustomerName(), new ArrayList<>());
			}
			customerMap.get(o.getCustomerName()).add(o);
			System.out.println("Order added");
		} else {
			System.out.println("Duplicate order not allowed");
		}
	}

	public void displayAll() throws EmptyDataException {
		if (orders.isEmpty())
			throw new EmptyDataException("No orders");
		for (Order o : orders) {
			System.out.println(o.toString());
		}		
	}

	public void displayByCustomer(String name) throws EmptyDataException {
		if (!customerMap.containsKey(name))
			throw new EmptyDataException("No orders for this customer");
		for (Order o : customerMap.get(name)) {
			System.out.println(o);
		}
	}

	public void sortById() {
		List<Order> list = new ArrayList<>(orders);
		Collections.sort(list);
		for (Order o : list) {
			System.out.println(o);
		}
	}

	public void sortByAmount() {
		List<Order> list = new ArrayList<>(orders);
		Collections.sort(list, new Comparator<Order>() {
			public int compare(Order o1, Order o2) {
				return (int) (o1.getAmount() - o2.getAmount());
			}
		});

		for (Order o : list) {
			System.out.println(o);
		}
	}

	public void addToDispatch(int id) throws OrderNotFoundException {
		Order o = find(id);
		if (o.getStatus() == OrderStatus.CREATED) {
			dispatchQueue.offer(id);
			o.setStatus(OrderStatus.IN_QUEUE);
			System.out.println("Added to dispatch queue");
		} else {
			System.out.println("Already processed or cancelled");
		}
	}

	public void processDispatch() throws OrderNotFoundException {
		if (dispatchQueue.isEmpty()) {
			System.out.println("No orders in queue");
			return;
		}
		int id = dispatchQueue.poll();
		Order o = find(id);
		o.setStatus(OrderStatus.DISPATCHED);
		System.out.println("Order dispatched: " + o.getOrderId());
	}

	public void cancelOrder(int id) throws OrderNotFoundException {
		Iterator<Order> it = orders.iterator();
		boolean found = false;
		while (it.hasNext()) {
			Order o = it.next();
			if (o.getOrderId() == id) {
				o.setStatus(OrderStatus.CANCELLED);
				it.remove();
				customerMap.get(o.getCustomerName()).remove(o);
				found = true;
				System.out.println("Order cancelled");
				break;
			}
		}
		if (!found)
			throw new OrderNotFoundException("Order not found");
	}
}