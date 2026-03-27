package com.mayank.assignment1.toArray;

import java.util.Arrays;
import java.util.List;

public class Questions {

	public static void listToArray() {
		List<String> list = Arrays.asList("apple", "banana", "mango");
		String[] arr = list.stream().toArray(String[]::new);
		System.out.println(Arrays.toString(arr));
	}

	public static void arraySum() {
		int[] arr = { 1, 2, 3, 4, 5 };
		int sum = Arrays.stream(arr).sum();
		System.out.println(sum);
	}

	public static void arrayToUppercase() {
		String[] arr = { "apple", "banana", "grape" };
		Arrays.stream(arr).map(String::toUpperCase).forEach(System.out::println);
	}

	public static void arrayToList() {
		String[] arr = { "rahul", "amit", "neha" };
		List<String> list = Arrays.stream(arr).toList();
		System.out.println(list);
	}

	public static void main(String[] args) {
		listToArray();
		arraySum();
		arrayToUppercase();
		arrayToList();
	}
}
