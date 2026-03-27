package com.mayank.arrayofobject.test;

import java.util.Scanner;
import com.mayank.arrayofobject.model.*;

public class UniversityApp {

	public static boolean validateName(String name) {
		return name != null && name.matches("^[A-Za-z ]+$");
	}

	public static boolean validateFee(double fee) {
		return fee > 0;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter maximum number of courses: ");
		int size = sc.nextInt();
		sc.nextLine();

		Course[] courses = new Course[size];
		int count = 0;
		int id = 1000;

		while (true) {

			System.out.println("\n===== MENU =====");
			System.out.println("1. Add Online Course");
			System.out.println("2. Add Regular Course");
			System.out.println("3. Show All Courses");
			System.out.println("4. Show Total Courses");
			System.out.println("5. Exit");
			System.out.print("Enter choice: ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:

				if (count >= size) {
					System.out.println("Course storage full!");
					break;
				}

				String name1;
				while (true) {
					System.out.print("Enter Course Name: ");
					name1 = sc.nextLine();
					if (validateName(name1))
						break;
					System.out.println("Invalid Name! Only alphabets allowed.");
				}

				double base1;
				while (true) {
					System.out.print("Enter Base Fee: ");
					base1 = sc.nextDouble();
					if (validateFee(base1))
						break;
					System.out.println("Fee must be positive!");
				}

				double pf;
				while (true) {
					System.out.print("Enter Platform Fee: ");
					pf = sc.nextDouble();
					if (validateFee(pf))
						break;
					System.out.println("Fee must be positive!");
				}

				sc.nextLine();

				courses[count++] = new OnlineCourse(++id, name1, base1, pf);

				System.out.println("Online Course Added!");
				break;

			case 2:

				if (count >= size) {
					System.out.println("Course storage full!");
					break;
				}

				String name2;
				while (true) {
					System.out.print("Enter Course Name: ");
					name2 = sc.nextLine();
					if (validateName(name2))
						break;
					System.out.println("Invalid Name! Only alphabets allowed.");
				}

				double base2;
				while (true) {
					System.out.print("Enter Base Fee: ");
					base2 = sc.nextDouble();
					if (validateFee(base2))
						break;
					System.out.println("Fee must be positive!");
				}

				double lf;
				while (true) {
					System.out.print("Enter Lab Fee: ");
					lf = sc.nextDouble();
					if (validateFee(lf))
						break;
					System.out.println("Fee must be positive!");
				}

				sc.nextLine();

				courses[count++] = new RegularCourse(++id, name2, base2, lf);

				System.out.println("Regular Course Added!");
				break;

			case 3:

				if (count == 0) {
					System.out.println("No Courses Available!");
					break;
				}

				System.out.println("\n--- Course List ---");
				for (int i = 0; i < count; i++) {
					System.out.println("ID: " + courses[i].getCourseId() + ", Name: " + courses[i].getCourseName()
							+ ", Type: " + courses[i].getCourseType() + ", Final Fee: " + courses[i].calculateFee());
				}
				break;

			case 4:
				System.out.println("Total Courses Created: " + Course.getTotalCourses());
				break;

			case 5:
				System.out.println("Exiting Program...");
				sc.close();
				return;

			default:
				System.out.println("Invalid Choice!");
			}
		}
	}
}