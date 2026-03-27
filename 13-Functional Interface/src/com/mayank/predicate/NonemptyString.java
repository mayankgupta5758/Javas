package com.mayank.predicate;

import java.util.*;
import java.util.function.Predicate;

public class NonemptyString {

	public static void main(String[] args) {
		Predicate<String> isEmpty = (str) -> str.isEmpty();
		
		List<String> list = Arrays.asList("", "Java", "Spring", "", "No");
		for (String str : list) {
			if(!isEmpty.test(str)) {
				System.out.println(str);
			}
		}
	}

}
