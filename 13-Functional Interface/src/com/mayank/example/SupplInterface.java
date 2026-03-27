package com.mayank.example;

import java.util.function.Supplier;

public class SupplInterface {
	public static void main(String[] args) {
//	Supplier
//	A Supplier is a pre defined functional interface in Java 8 that
//	does not take any input but returns a value.
//	It is mainly used when you want to generate or supply data.
		
		Supplier<Integer> random = () -> (int)(Math.random() * 100);
		System.out.println(random.get());
	}
}
