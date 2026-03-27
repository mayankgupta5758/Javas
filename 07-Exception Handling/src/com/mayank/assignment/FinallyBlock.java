package com.mayank.assignment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FinallyBlock {
	
	public static void useFinallyBlock() {
		double balance = 10000;
		try(Scanner scanner = new Scanner(System.in)) {
			System.out.println("Enter amount to withdraw.");
			double amount = scanner.nextDouble();
			
			if(amount > balance) {
				System.out.println("Insufficent Balance.");
				throw new ArithmeticException("Insufficent Balance.");
			}
			System.out.println("The balance is: " + (balance - amount));
		} catch (InputMismatchException e) {
			System.out.println("Enter Double value only!!!");
		} finally {
			System.out.println("Transaction session ended.");
		}
	}
	public static void main(String[] args) {
		useFinallyBlock();
	}
}
