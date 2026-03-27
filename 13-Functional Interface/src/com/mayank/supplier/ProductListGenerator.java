package com.mayank.supplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ProductListGenerator {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Light", "Speaker", "TV", "Toy", "Fan");
		Supplier<List<String>> productName = () -> list;
		
		productName.get().forEach(System.out::println);
	}
}
