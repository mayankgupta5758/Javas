package com.mayank.assignmentquestion;

import java.util.*;

public class SentenceFormatter {
	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter the sentence: ");
			String sentence = scanner.nextLine();
			sentence = sentence.trim().toLowerCase();
			sentence = sentence.substring(0, 1).toUpperCase() + sentence.substring(1);
			String formattedSentence = sentence.replaceAll("fun", "interesting");
			
			String[] words = sentence.split(" ");

			System.out.println("Formatted Sentence: " + formattedSentence);
			System.out.println("Total words: " + words.length);
			System.out.println("First word: " + words[0]);
			System.out.println("First word: " + words[words.length-1]);
		} catch (InputMismatchException e) {
			System.out.println("Enter String only.");
		} catch (Exception e) {
			System.out.println("Some Exception occur: " + e);
		}
	}
}
