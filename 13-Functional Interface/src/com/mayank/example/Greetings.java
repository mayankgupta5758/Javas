package com.mayank.example;

@FunctionalInterface
public interface Greetings {
	void greet();

	static void r() {
		System.out.println("iuhg");
	}

	default void r1() {
		System.out.println("iuhg");
	}
}

@FunctionalInterface
interface WhyGreet extends Greetings {
	// This is also an functional Interface but,
	// 1. There is no abstract method in the Child interface why, because Parent has
	// already One.
	// 2. If we have abstract method then Child is not Functional Interface, but can
	// have default and static method.
	// 3. We can override the Parent Method but like
	void greet(); // we can do this.

}