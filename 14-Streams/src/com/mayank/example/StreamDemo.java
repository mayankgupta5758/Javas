package com.mayank.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
	public static void main(String[] args) {
//		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//		System.out.println(list.stream().filter(x -> x % 2 == 0).count());
//		
		//// Converting Streams
//		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
//		Stream<Integer> stream1 = list1.stream();
//		
//		String[] arr = {"a", "b", "c", "d"};
//		Stream<String> stream2 = Arrays.stream(arr);
//		
//		Stream<String> stream3 = Stream.of("A", "B", "C", "D");
//		
		//// Infinite stream
//		Stream<Integer> stream4 = Stream.generate(()->1).limit(100);
//		List<Integer> stream5 = Stream.iterate(1, x -> x+1).limit(100).collect(Collectors.toList()); 
//		stream5.forEach(System.out::println);
//		
//		List<Integer> list11 = List.of(1, 2, 3, 4, 5);
//		 
//		Spliterator<Integer> spliterator = list11.spliterator();
//		 
//		Spliterator<Integer> sp = List.of(1, 2, 3).spliterator();
//		 
//		sp.tryAdvance(System.out::println);
//		sp.forEachRemaining(System.out::println);

		Spliterator<Integer> sp1 = List.of(1, 2, 3, 4).spliterator();

		Spliterator<Integer> sp2 = sp1.trySplit();

		sp1.forEachRemaining(System.out::print);
		System.out.println();
		sp2.forEachRemaining(System.out::print);
		
		List.of ("A", "BB", "CCC")
		.stream ()
		.peek (System. out::println)
		.filter(s -> s.length() > 1)
		.forEach (System. out::println) ;

	}
}
