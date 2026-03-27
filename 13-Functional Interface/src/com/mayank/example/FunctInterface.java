package com.mayank.example;

import java.util.function.Function;

public class FunctInterface {
	public static void main(String[] args) {
		/*
		 * Function A Function is a pre defined functional interface in Java 8 that
		 * takes one input and returns some output. It is used for transforming data.
		 */
		
		Function<String, Integer> f1 = (str) -> {
			return str.length();
		};
		System.out.println(f1.apply("Hello"));
		
		
//		andThen()
//		👉 Pehle current function chalega, phir next
		Function<Integer, Integer> multiply = x -> x * 2;
		Function<Integer, Integer> add = x -> x + 3;
		Function<Integer, Integer> result = multiply.andThen(add);
		System.out.println(result.apply(5)); // (5*2)+3 = 13
		
		
//		compose()
//		👉 Pehle second function chalega, phir current
		Function<Integer, Integer> result1 = multiply.compose(add);
		System.out.println(result1.apply(5)); // (5+3)*2 = 16
		
//		| Method      | Order          |
//		| ----------- | -------------- |
//		| `andThen()` | first → second |
//		| `compose()` | second → first |
		
		
//		identity()
//		👉 Same input return karta hai
		Function<Integer, Integer> identity = Function.identity();
		System.out.println(identity.apply(5)); // 5

	}
}
