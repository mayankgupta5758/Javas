package com.mayank.supplier;

import java.util.function.Supplier;

public class RandomNumberGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Supplier<Double> randomGenerate = () -> Math.random();
		System.out.println(randomGenerate.get());
		System.out.println(randomGenerate.get());
		System.out.println(randomGenerate.get());
		System.out.println(randomGenerate.get());
		System.out.println(randomGenerate.get());
	}

}
