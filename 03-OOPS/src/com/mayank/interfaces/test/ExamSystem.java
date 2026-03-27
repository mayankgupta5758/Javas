package com.mayank.interfaces.test;

import java.util.Scanner;

import com.mayank.interfaces.model.*;

public class ExamSystem {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ExamEvaluator evaluator = null;

		while (true) {

			System.out.println("Select Exam Type");
			System.out.println("1. Theory Exam");
			System.out.println("2. Practical Exam");
			System.out.println("3. Online Quiz");
			System.out.println("4. Exit");

			System.out.print("Enter choice: ");
			int choice = sc.nextInt();

			if (choice == 4) {
				System.out.println("Exiting...");
				break;
			}

			switch (choice) {

			case 1:
				evaluator = new TheoryExam();
				break;

			case 2:
				evaluator = new PracticalExam();
				break;

			case 3:
				evaluator = new OnlineQuiz();
				break;

			default:
				System.out.println("Invalid input! Try again.");
				continue;
			}
			double marks;

			while (true) {
				System.out.print("Enter marks (0-100): ");
				marks = sc.nextDouble();

				if (marks >= 0 && marks <= 100)
					break;
				else
					System.out.println("Invalid marks! Try again.");
			}

			evaluator.evaluateMarks(marks);
			String grade = evaluator.calculateGrade();

			System.out.println("RESULT");

			if (grade.equals("Fail")) {
				System.out.println("Status: FAIL");
			} else {
				System.out.println("Status: PASS");
			}

			System.out.println("Grade: " + grade);
		}

		sc.close();
	}
}