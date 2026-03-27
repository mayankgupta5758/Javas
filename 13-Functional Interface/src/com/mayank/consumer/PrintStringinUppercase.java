package com.mayank.consumer;

import java.util.function.Consumer;

public class PrintStringinUppercase {

	public static void main(String[] args) {
		Consumer<String> cons = (str) -> System.out.println(str.toUpperCase());
		
		cons.accept("hello");
	}

}
