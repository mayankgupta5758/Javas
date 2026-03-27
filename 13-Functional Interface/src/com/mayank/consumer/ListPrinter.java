package com.mayank.consumer;

import java.util.*;
import java.util.function.Consumer;

public class ListPrinter {

	public static void main(String[] args) {

		Consumer<List<String>> printList = list -> {
			list.forEach(System.out::println);
		};

		List<String> names = Arrays.asList("Mayank", "Rohan", "Amit");

		printList.accept(names);
	}
}