package com.mayank.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalOps {
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3);

		// 1. collect
		list.stream().skip(1).collect(Collectors.toList());
		list.stream().skip(1).toList();
//		stream original stream ko change nahi kerta 

		// 2. forEach
		list.stream().forEach(x -> System.out.println(x));

		// 3. reduce : Combines elements to produce a single result
		Optional<Integer> optionalInteger = list.stream().reduce(Integer::sum);
		System.out.println(optionalInteger.get());

		// 4. count

		// 5. anyMatch, allMatch, noneMatch
		boolean b = list.stream().anyMatch(x -> x % 2 == 0);
		System.out.println(b);
		boolean b1 = list.stream().allMatch(x -> x > 0);
		System.out.println(b1);
		boolean b2 = list.stream().noneMatch(x -> x < 0);
		System.out.println(b2);
		
		// 6. findAny, findFirst
		System.out.println(list.stream().findAny().get());
		System.out.println(list.stream().findFirst().get());
		
		
//		ex.
		String setence = "Hello World";
		IntStream str = setence.chars(); // string se esa convert kerta hai stream me.
		System.out.println(str.filter(x -> x == 'l').count());
		
//		statefull and atateless.
		Stream s = List.of("A", "B", "C").stream();
		 
		long count = s.count(); 
		long count2 = s.count();
		System.out.println(count + " " + count2); // give exception.
		 

	}
}
