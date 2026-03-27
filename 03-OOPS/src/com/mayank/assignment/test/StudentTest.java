package com.mayank.assignment.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.mayank.assignment.model.*;

public class StudentTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[10];
        int i = 0;

        while (true) {

            try {

                System.out.println("\n1. Add Regular Student");
                System.out.println("2. Add Scholarship Student");
                System.out.println("3. Show All Students");
                System.out.println("4. Exit");

                System.out.print("Enter choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                if (choice == 4) {
                	System.out.println("Exiting...");
                    break;
                }

                switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    String name = "";
                    boolean chk = true;

                    while (chk) {

                        System.out.print("Enter Name: ");
                        name = sc.nextLine();

                        if (name.matches("[a-zA-Z ]+") && name.trim().length() >= 2) {
                            chk = false;
                        } else {
                            System.out.println("Invalid name! Use alphabets only (min 2 chars).");
                        }
                    }

                    chk = true;
                    String course = "";

                    while (chk) {

                        System.out.print("Enter Course: ");
                        course = sc.nextLine();

                        if (course.matches("[a-zA-Z ]+") && course.trim().length() >= 2) {
                            chk = false;
                        } else {
                            System.out.println("Invalid course name! Use alphabets only (min 2 chars).");
                        }
                    }

                    chk = true;
                    double fee = 0;

                    while (chk) {

                        System.out.print("Enter Fee: ");
                        fee = sc.nextDouble();

                        if (fee > 0) {
                            chk = false;
                        } else {
                            System.out.println("Invalid fee! Enter positive number.");
                        }
                    }

                    students[i++] = new RegularStudent(id, name, course, fee);
                    break;

                case 2:

                    System.out.print("Enter Student ID: ");
                    int id2 = sc.nextInt();
                    sc.nextLine();

                    String name2 = "";
                    chk = true;

                    while (chk) {

                        System.out.print("Enter Name: ");
                        name2 = sc.nextLine();

                        if (name2.matches("[a-zA-Z ]+") && name2.trim().length() >= 2) {
                            chk = false;
                        } else {
                            System.out.println("Invalid name! Use alphabets only (min 2 chars).");
                        }
                    }

                    chk = true;
                    String course2 = "";

                    while (chk) {

                        System.out.print("Enter Course: ");
                        course2 = sc.nextLine();

                        if (course2.matches("[a-zA-Z ]+") && course2.trim().length() >= 2) {
                            chk = false;
                        } else {
                            System.out.println("Invalid course name! Use alphabets only (min 2 chars).");
                        }
                    }

                    chk = true;
                    double fee2 = 0;

                    while (chk) {

                        System.out.print("Enter Fee: ");
                        fee2 = sc.nextDouble();

                        if (fee2 > 0) {
                            chk = false;
                        } else {
                            System.out.println("Invalid fee! Enter positive number.");
                        }
                    }

                    students[i++] = new ScholarshipStudent(id2, name2, course2, fee2);
                    break;

                case 3:

                    System.out.println("\n--- Student Records ---");

                    for (int j = 0; j < i; j++) {
                        students[j].display();
                    }

                    break;

                default:
                    System.out.println("Invalid Choice");
                }

            } catch (InputMismatchException e) {

                System.out.println("Invalid input! Please enter correct data type.");
                sc.nextLine(); 
            }
        }

        sc.close();
    }
}