package com.mayank.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class TemperatureConverter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<Double, Double> tempCon = (temp) -> (temp * (9 / 5)) + 32;

		System.out.println(tempCon.apply(.00));
		System.out.println(tempCon.apply(20.0));
		System.out.println(tempCon.apply(37.0));
		
	}

}
