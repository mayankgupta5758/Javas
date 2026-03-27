package com.mayank.predicate;

import java.util.function.Predicate;

public class OddNumberChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Predicate<Integer> isOddOrEven = (n) -> n % 2 != 0;
		
		for(int i=1;i<=10;i++) {
			if(isOddOrEven.test(i)) {
				System.out.println(i);
			}
		}
	}

}
