package com.mayank.arrayofobject.test;

import java.util.Scanner;
import com.mayank.arrayofobject.model.*;

public class Company {

	public static boolean validateName(String name) {
		return name != null && name.matches("^[A-Za-z ]+$");
	}

	public static boolean validateAmount(double amount) {
		return amount > 0;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter maximum number of employees: ");
		int n = scanner.nextInt();
		scanner.nextLine();

		Employee[] employees = new Employee[n];
		int count = 0;
		int id = 1000;

		while (true) {

			System.out.println("\n===== COMPANY MENU =====");
			System.out.println("1. Add Full-Time Employee");
			System.out.println("2. Add Part-Time Employee");
			System.out.println("3. Add Intern");
			System.out.println("4. Show All Employees & Salaries");
			System.out.println("5. Show Total Employees");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {

			case 1:

				if (count >= n) {
					System.out.println("Employee storage full!");
					break;
				}

				String name1;
				while (true) {
					System.out.print("Enter Employee Name: ");
					name1 = scanner.nextLine();
					if (validateName(name1))
						break;
					System.out.println("Invalid Name!");
				}

				System.out.print("Enter Basic Salary: ");
				double basic = scanner.nextDouble();

				System.out.print("Enter HRA: ");
				double hra = scanner.nextDouble();

				System.out.print("Enter Bonus: ");
				double bonus = scanner.nextDouble();

				employees[count++] = new FullTimeEmployee(name1.trim(), ++id, basic, hra, bonus);

				break;

			case 2:

				if (count >= n) {
					System.out.println("Employee storage full!");
					break;
				}

				String name2;
				while (true) {
					System.out.print("Enter Employee Name: ");
					name2 = scanner.nextLine();
					if (validateName(name2))
						break;
					System.out.println("Invalid Name!");
				}

				System.out.print("Enter Hours Worked: ");
				int hours = scanner.nextInt();

				System.out.print("Enter Hourly Rate: ");
				double rate = scanner.nextDouble();

				employees[count++] = new PartTimeEmployee(name2.trim(), ++id, hours, rate);

				break;

			case 3:

				if (count >= n) {
					System.out.println("Employee storage full!");
					break;
				}

				String name3;
				while (true) {
					System.out.print("Enter Employee Name: ");
					name3 = scanner.nextLine();
					if (validateName(name3))
						break;
					System.out.println("Invalid Name!");
				}

				System.out.print("Enter Stipend: ");
				double stipend = scanner.nextDouble();

				employees[count++] = new Intern(name3.trim(), ++id, stipend);

				break;

			case 4:

				if (count == 0) {
					System.out.println("No Employees Found!");
					break;
				}

				System.out.println("\n--- Employee List ---");
				for (int i = 0; i < count; i++) {
					System.out.println("ID: " + employees[i].getEmployeeId() + ", Name: "
							+ employees[i].getEmployeeName() + ", Type: " + employees[i].getEmployeeType()
							+ ", Salary: " + employees[i].calculateSalary());
				}
				break;

			case 5:
				System.out.println("Total Employees Created: " + Employee.getTotalEmployees());
				break;

			case 6:
				System.out.println("Exiting Program...");
				scanner.close();
				return;

			default:
				System.out.println("Invalid Choice!");
			}
		}
	}
}