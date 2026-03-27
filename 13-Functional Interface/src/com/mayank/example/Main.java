package com.mayank.example;

public class Main {
	public static void main(String[] args) {
		Greetings g1 = () -> {
			System.out.println("Hello World.");
		};
		g1.greet(); // If we not write this sout print nothing
	}
}