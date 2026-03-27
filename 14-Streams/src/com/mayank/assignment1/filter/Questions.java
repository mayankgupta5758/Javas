package com.mayank.assignment1.filter;

import java.util.Arrays;
import java.util.List;

class Student {
	String name;
	double marks;

	Student(String name, double marks) {
		this.name = name;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return name + " - ₹" + marks;
	}
}

class Product {
	private String name;
	private int price;

	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return name + " - ₹" + price;
	}
}

public class Questions {

	public static void printEvenNumber() {
		List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		list.stream().filter(x -> x % 2 == 0).forEach(System.out::println);
	}

	public static void startWithLetterA() {
		List<String> list = List.of("Ankush", "Mayank", "Akash", "Lol", "Yash");
		list.stream().filter(x -> x.startsWith("A")).forEach(System.out::println);
	}

	public static void printStudentsAbove60() {
		List<Student> list = Arrays.asList(new Student("Rahul", 75), new Student("Amit", 55), new Student("Neha", 90),
				new Student("Priya", 35), new Student("Karan", 60));
		list.stream().filter(s -> s.marks >= 60).forEach(System.out::println);
	}

	public static void printNonEmptyStrings() {
		List<String> list = List.of("Ankush", "Mayank", "Akash", "Lol", "Yash");
		list.stream().filter(s -> s != null && !s.trim().isEmpty()).forEach(System.out::println);
	}

	public static void printExpensiveProducts() {
		List<Product> products = Arrays.asList(new Product("Phone", 15000), new Product("Pen", 20),
				new Product("Headphones", 800), new Product("Notebook", 100), new Product("Shoes", 1200));
		products.stream().filter(p -> p.getPrice() > 500).forEach(System.out::println);
	}

	public static void printPassedStudents() {
		List<Student> list = Arrays.asList(new Student("Rahul", 75), new Student("Amit", 55), new Student("Neha", 90),
				new Student("Priya", 35), new Student("Karan", 60));
		list.stream().filter(s -> s.marks >= 40).forEach(System.out::println);
	}

	public static void main(String[] args) {

		printEvenNumber();
		startWithLetterA();
		printStudentsAbove60();
		printNonEmptyStrings();
		printExpensiveProducts();
		printPassedStudents();

	}

}
