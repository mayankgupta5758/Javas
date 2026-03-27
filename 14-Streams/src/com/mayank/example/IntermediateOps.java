package com.mayank.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOps {
	public static void main(String[] args) {

// Intermediate operations transform a stream into another stream
// They are lazy, meaning they don't execute until a terminal operation is invoked.

		// 1. Filter()
		List<String> list = Arrays.asList("Akshit", "Ram", "Shyam", "Ghanshyam", "Akshit");
		Stream<String> filteredStream = list.stream().filter(x -> x.startsWith("A"));
//		no filtering at this point.
		long res = list.stream().filter(x -> x.startsWith("A")).count();
		System.out.println(res);

		// 2. map()
		Stream<String> steam = list.stream().map(String::toUpperCase);

		// 3. sorted
		Stream<String> stream2 = list.stream().sorted();
		Stream<String> stream3 = list.stream().sorted((a, b) -> a.length() - b.length());
		
		// 4. distinct()
		System.out.println(list.stream().filter(x->x.startsWith("A")).distinct().count());
		
		// 5. limit()
		System.out.println(Stream.iterate(1, x->x+1).limit(100).count());
		
		// 6. skip() start 11 se ho jayagi lakin op 100 hi hoga.
		System.out.println(Stream.iterate(1, x->x+1).skip(10).limit(100).count());
		
//		takewhile, dropWhile
		List<Integer> input = List.of(3,2,7,3,78,2,8,0);
		List<Integer> output = input.stream().takeWhile(x->x%2 == 0).toList();
		List<Integer> first3 = IntStream.rangeClosed(1,10).boxed().skip(3).toList();
		System.out.println(output);

		

	}
}