package com.mayank.assignment;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NestedTryCatch {
	public static void main(String[] args) {
		int[] arr = new int[3];
		String f;
		try(Scanner scanner = new Scanner(System.in)) {
			try {
				System.out.println(arr[9]);
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("can not access that index.");
			}
			System.out.println("Enter 0th index value: ");
			arr[0] = scanner.nextInt();
			System.out.println("Enter 1st index value: ");
			arr[1] = scanner.nextInt();
			arr[2] = arr[0] / arr[1];
			System.out.println("Array is: [" + arr[0] + ", " + arr[1] + ", " + arr[2] + " ]");
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException occur" + e);
		} catch (InputMismatchException e) {
            System.out.println("Please enter integers only.");
        }
	}

}
