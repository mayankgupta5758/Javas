package com.mayank.example;

import java.util.function.Consumer;

public class ConsInterface {
	public static void main(String[] args) {
		/*
		 * Consumer A Consumer is a pre defined functional interface in Java 8 that
		 * takes one input and returns nothing. It is mainly used to perform any
		 * operation where you don't need to return anything.
		 */

		Consumer<String> c5 = (String name) -> {
			System.out.println("Name is: " + name);
		};
		c5.accept("Hello");

		
//		andThen()
//		👉 Multiple consumers ko chain karne ke liye
//		andThen() me:
//		Pehla consumer execute hota hai
//		Fir dusra
		Consumer<String> c1 = str -> System.out.println("Hello " + str);
		Consumer<String> c2 = str -> System.out.println("Bye " + str);
		Consumer<String> result = c1.andThen(c2);
		result.accept("Mayank");

	}
}
