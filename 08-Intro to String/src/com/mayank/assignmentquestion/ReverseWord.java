package com.mayank.assignmentquestion;

import java.util.Scanner;

public class ReverseWord {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Sentence: ");
		String sentence = scanner.nextLine();
		StringBuilder reverseString = new StringBuilder();
		
		String[] newSentence = sentence.split(" ");
		for(String str: newSentence) {
			StringBuilder rev = new StringBuilder(str).reverse();
			reverseString.append(rev).append(" ");
		}
		
		System.out.println(reverseString.toString());
	}

}
