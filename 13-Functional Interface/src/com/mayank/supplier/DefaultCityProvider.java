package com.mayank.supplier;

import java.util.Scanner;
import java.util.function.Supplier;

public class DefaultCityProvider {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Supplier<String> defaultCity = () -> "Pune";
		System.out.print("Enter name: ");
		String userInput = scanner.nextLine();
		String city = (userInput == null || userInput.isEmpty()) ? defaultCity.get() : userInput;

		System.out.println("City is: " + city);
		scanner.close();
	}
}