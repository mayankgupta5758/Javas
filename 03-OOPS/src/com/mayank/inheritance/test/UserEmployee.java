package com.mayank.inheritance.test;

import java.util.Scanner;
import com.mayank.inheritance.model.*;

public class UserEmployee {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of Employees: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Number must be greater than 0.");
            return;
        }

        Employee[] arr = new Employee[n];
        int i = 0;

        while (true) {

            System.out.println("\nPress 1 for Full Time Employee.");
            System.out.println("Press 2 for Part Time Employee.");
            System.out.println("Press 3 for Contract Employee.");
            System.out.println("Press 4 for Show All Employees.");
            System.out.println("Press 0 for Exit");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    if (i >= n) {
                        System.out.println("Employee limit reached!");
                        break;
                    }

                    scanner.nextLine();
                    System.out.println("Enter Employee Name: ");
                    String name = scanner.nextLine();

                    if (name.trim().isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        break;
                    }

                    System.out.println("Enter Basic Salary: ");
                    double basic = scanner.nextDouble();
                    if (basic < 0) {
                        System.out.println("Basic salary cannot be negative.");
                        break;
                    }

                    System.out.println("Enter HRA: ");
                    double hra = scanner.nextDouble();
                    if (hra < 0) {
                        System.out.println("HRA cannot be negative.");
                        break;
                    }

                    System.out.println("Enter DA: ");
                    double da = scanner.nextDouble();
                    if (da < 0) {
                        System.out.println("DA cannot be negative.");
                        break;
                    }

                    arr[i] = new FullTimeEmployee(i + 1, name, basic, hra, da);
                    i++;
                    System.out.println("Full Time Employee Added Successfully.");
                    break;

                case 2:
                    if (i >= n) {
                        System.out.println("Employee limit reached!");
                        break;
                    }

                    scanner.nextLine();
                    System.out.println("Enter Employee Name: ");
                    name = scanner.nextLine();

                    if (name.trim().isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        break;
                    }

                    System.out.println("Enter Hours Worked: ");
                    int hours = scanner.nextInt();
                    if (hours < 0) {
                        System.out.println("Hours cannot be negative.");
                        break;
                    }

                    System.out.println("Enter Hourly Rate: ");
                    double rate = scanner.nextDouble();
                    if (rate < 0) {
                        System.out.println("Hourly rate cannot be negative.");
                        break;
                    }

                    arr[i] = new PartTimeEmployee(i + 1, name, hours, rate);
                    i++;
                    System.out.println("Part Time Employee Added Successfully.");
                    break;

                case 3:
                    if (i >= n) {
                        System.out.println("Employee limit reached!");
                        break;
                    }

                    scanner.nextLine();
                    System.out.println("Enter Employee Name: ");
                    name = scanner.nextLine();

                    if (name.trim().isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        break;
                    }

                    System.out.println("Enter Fixed Amount: ");
                    double fixed = scanner.nextDouble();
                    if (fixed < 0) {
                        System.out.println("Fixed amount cannot be negative.");
                        break;
                    }

                    System.out.println("Enter Tax: ");
                    double tax = scanner.nextDouble();
                    if (tax < 0) {
                        System.out.println("Tax cannot be negative.");
                        break;
                    }

                    if (tax > fixed) {
                        System.out.println("Tax cannot be greater than Fixed Amount.");
                        break;
                    }

                    arr[i] = new ContractEmployee(i + 1, name, fixed, tax);
                    i++;
                    System.out.println("Contract Employee Added Successfully.");
                    break;

                case 4:
                    if (i == 0) {
                        System.out.println("No employees added yet.");
                    } else {
                        for (int j = 0; j < i; j++) {
                            arr[j].displayEmployee();
                        }
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid Option.");
            }
        }
    }
}
