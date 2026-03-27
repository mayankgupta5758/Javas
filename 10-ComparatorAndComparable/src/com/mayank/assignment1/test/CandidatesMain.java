package com.mayank.assignment1.test;

import java.util.*;
import com.mayank.assignment1.model.*;

public class CandidatesMain {
public static void main(String[] args) {
	try (Scanner scanner = new Scanner(System.in)) {

		ArrayList<Candidates> list = new ArrayList<>();

		boolean chk = true;

		while (chk) {

			System.out.println("\nPress 1 to Add Candidate");
			System.out.println("Press 2 to Exit");

			int num;

			try {
				num = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Enter number only.");
				scanner.next();
				continue;
			}

			if (num == 1) {

				scanner.nextLine(); 

				String name;
				int age;

				while (true) {
					System.out.print("Enter Name: ");
					name = scanner.nextLine();

					if (name.trim().isEmpty()) {
						System.out.println("Name cannot be empty.");
						continue;
					}
					break;
				}

				while (true) {
					try {
						System.out.print("Enter Age: ");
						age = scanner.nextInt();

						if (age < 0) {
							System.out.println("Age cannot be negative.");
							continue;
						}

						break;

					} catch (InputMismatchException e) {
						System.out.println("Invalid age. Enter integer only.");
						scanner.next();
					}
				}

				list.add(new Candidates(name, age));

			} else if (num == 2) {
				chk = false;
			} else {
				System.out.println("Enter 1 or 2 only.");
			}
		}

		Collections.sort(list, new CandidatesComparator());

		System.out.println("\nSorted Candidates:");

		for (Candidates s : list) {
			System.out.println(s.name + " " + s.age);
		}
	}
}
}
