package com.mayank.example;

import java.util.Arrays;
import java.util.List;

public class MethodReference {

	public static void main(String[] args) {
//		use method without invoking & in place of lambda function.
		
		List<String> students = Arrays.asList("Ram", "Shyam", "Ghanshyam");
		students. forEach(x -> System. out.println(x));
		students. forEach(System. out::println) ;
	}

}
