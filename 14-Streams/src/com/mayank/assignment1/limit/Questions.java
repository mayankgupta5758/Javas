package com.mayank.assignment1.limit;

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

	public static void limitNames() {
		List<String> list = Arrays.asList("Rahul", "Amit", "Neha", "Karan", "Priya");
		list.stream().limit(3).forEach(System.out::println);
	}

	public static void topFiveNumbers() {
		List<Integer> list = Arrays.asList(5, 9, 1, 7, 3, 10, 6);
		list.stream().sorted(Comparator.reverseOrder()).limit(5).forEach(System.out::println);
	}

	public static void sumFirstFourEven() {
		List<Integer> list = Arrays.asList(1, 2, 4, 6, 3, 8, 10);
		int sum = list.stream().filter(n -> n % 2 == 0).limit(4).mapToInt(Integer::intValue).sum();
		System.out.println(sum);
	}

	public static void longestWords() {
		List<String> list = Arrays.asList("apple", "banana", "kiwi", "watermelon", "grape");
		list.stream().sorted((a, b) -> b.length() - a.length()).limit(3).forEach(System.out::println);
	}

	public static void limitProducts() {
		List<Product> list = Arrays.asList(new Product("Phone", 15000), new Product("Pen", 20),
				new Product("Shoes", 1200), new Product("Bag", 800), new Product("Book", 300));
		list.stream().filter(p -> p.getPrice() > 500).limit(2).forEach(System.out::println);
	}

	public static void main(String[] args) {
		limitNames();
		topFiveNumbers();
		sumFirstFourEven();
		longestWords();
		limitProducts();
	}
}
