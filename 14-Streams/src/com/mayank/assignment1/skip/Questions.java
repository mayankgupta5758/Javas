package com.mayank.assignment1.skip;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Product {
	String name;
	int price;

	Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	int getPrice() {
		return price;
	}

	public String toString() {
		return name + " - ₹" + price;
	}
}

public class Questions {

	public static void skipNames() {
		List<String> list = Arrays.asList("Rahul", "Amit", "Neha", "Karan", "Priya");
		list.stream().skip(3).forEach(System.out::println);
	}

	public static void skipTopSalaries() {
		List<Integer> list = Arrays.asList(50000, 70000, 30000, 90000, 60000);
		list.stream().sorted(Comparator.reverseOrder()).skip(2).forEach(System.out::println);
	}

	public static void skipEvenNumbers() {
		List<Integer> list = Arrays.asList(1, 2, 4, 6, 3, 8, 10);
		list.stream().filter(n -> n % 2 == 0).skip(2).forEach(System.out::println);
	}

	public static void skipExpensiveProducts() {
		List<Product> list = Arrays.asList(new Product("Phone", 15000), new Product("Pen", 20),
				new Product("Shoes", 1200), new Product("Bag", 800), new Product("Book", 300));
		list.stream().filter(p -> p.getPrice() > 500).skip(2).forEach(System.out::println);
	}

	public static void skipLongWords() {
		List<String> list = Arrays.asList("cat", "apple", "banana", "dog", "grape", "kiwi");
		list.stream().filter(s -> s.length() > 3).skip(3).forEach(System.out::println);
	}

	public static void main(String[] args) {
		skipNames();
		skipTopSalaries();
		skipEvenNumbers();
		skipExpensiveProducts();
		skipLongWords();
	}
}
