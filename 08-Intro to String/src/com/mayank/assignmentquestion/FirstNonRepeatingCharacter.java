package com.mayank.assignmentquestion;

import java.util.Scanner;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the String: ");
		String string = scanner.nextLine();
		int[] freq = new int[256];
		scanner.close();
		
		for(char ch: string.toCharArray()) {
			freq[ch]++;
		}
		
		for(char ch: string.toCharArray()) {
			if(freq[ch] == 1) {
				System.out.println("First Non-Repeating Character: " + ch);
				return;
			}
		}
		System.out.println("There is no Non-Repeating Character.");
	}

}
