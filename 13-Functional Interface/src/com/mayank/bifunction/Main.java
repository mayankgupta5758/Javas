package com.mayank.bifunction;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class Main {
	public static void main(String[] args) {
		BiPredicate<Integer, Integer> biPred = (x, y) -> x % 2 == 0 && y % 2 == 0;
		System.out.println(biPred.test(2, 4));
		
		BiFunction<String, String, Integer> biFunc = (x,y) -> x.length() + y.length();
		System.out.println(biFunc.apply("mayank", "gupta"));
		
		BiConsumer<Integer, Integer> biCons = (x, y) -> System.out.println(x+y);
		biCons.accept(2, 5);
		
		List<String> names = Arrays.asList("Java", "Spring", "Angular");
		names.forEach(System.out::println);
		names.forEach(name -> System.out.println(name));
	}
}
