package com.mayank.example;

import java.util.function.Predicate;

public class PredInterface {
	public static void main(String[] args) {
		/*
		 * Predicate Predicate is a pre defined functional interface in Java 8 that
		 * takes one argument and returns a boolean value. It is mainly used for
		 * condition testing.
		 */
//		Predicate<Integer> p1 = (num) -> {
//			if (num % 2 == 0) {
//				return true;
//			}else {
//			return false;
//			}
//		};
		Predicate<Integer> p1 = (num) -> num % 2 == 0;
		System.out.println(p1.test(10));
		System.out.println(p1.test(11));
		
//		Predicate p2 = (str) -> str.equals("S"); // lakin hum keval object ke method hi use kar sekta hai or koi orp. nahi kar sekta.
//		System.out.println(p2.test("S"));
//		System.out.println(p2.test("SS"));
		
//		Ye methods tumhe multiple conditions combine karne dete hain default methods.
		Predicate<Integer> p3 = num -> num > 10;
		Predicate<Integer> p2 = num -> num % 2 == 0;
		Predicate<Integer> result = p3.and(p2);
		System.out.println(result.test(12)); // true
		System.out.println(result.test(9));  // false
		
		Predicate<Integer> result1 = p3.or(p2);
		System.out.println(result1.test(9)); // true (odd but <10)
		
//		condition ka opposite
		Predicate<Integer> p = num -> num % 2 == 0;
		Predicate<Integer> notEven = p.negate();
		System.out.println(notEven.test(10)); // false
		System.out.println(notEven.test(11)); // true
		
		
		Predicate<String> p4 = Predicate.isEqual("Mayank"); // static ex.
		System.out.println(p4.test("Mayank")); // true
		System.out.println(p4.test("Rahul"));  // false
		
//		| Method      | Type     | Use             |
//		| ----------- | -------- | --------------- |
//		| `test()`    | abstract | condition check |
//		| `and()`     | default  | AND logic       |
//		| `or()`      | default  | OR logic        |
//		| `negate()`  | default  | NOT logic       |
//		| `isEqual()` | static   | equality check  |
	}
}
