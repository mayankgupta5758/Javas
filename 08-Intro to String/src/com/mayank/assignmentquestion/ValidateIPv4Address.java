package com.mayank.assignmentquestion;

import java.util.Scanner;

public class ValidateIPv4Address {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the IPv4 address: ");
		String address = scanner.nextLine();
		
		String[] splitAddress = address.split("\\.");
		if(splitAddress.length != 4) {
			System.out.println("Invalid IPv4 address.");
			return;
		}
		
		for(String i: splitAddress) {
			if(!i.matches("\\d+") || Integer.parseInt(i) < 0 || Integer.parseInt(i) > 255 || i.charAt(i.length()-1) == 0) {
				System.out.println("Invalid IPv4 address.");
				return;
			}
		}		
		System.out.println("IPv4 address is corret.");
		
	}

}
