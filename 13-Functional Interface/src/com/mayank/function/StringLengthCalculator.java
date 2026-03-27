package com.mayank.function;

import java.util.*;
import java.util.function.Function;

public class StringLengthCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<String, Integer> calcLength = (str) -> str.length();
		
		List<String> name = Arrays.asList("Mayank", "Rohan", "Yes");
		name.forEach(str -> System.out.println(calcLength.apply(str)));
	}

}
