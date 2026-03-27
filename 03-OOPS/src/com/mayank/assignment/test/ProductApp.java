package com.mayank.assignment.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.mayank.assignment.model.*;

public class ProductApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        Product[] products = new Product[10];
        int i = 0;

        while (true) {

            try {
                System.out.println("\n1. Add Electronics Product");
                System.out.println("2. Add Clothing Product");
                System.out.println("3. Show All Product");
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

                    System.out.print("Enter Product ID: ");
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
                    double price = 0;

                    while (chk) {

                        System.out.print("Enter Price: ");
                        price = sc.nextDouble();

                        if (price > 0) {
                            chk = false;
                        } else {
                            System.out.println("Invalid price! Enter positive number.");
                        }
                    }

                    products[i++] = new Electronics(id, name, price);
                    break;

                case 2:

                	System.out.print("Enter Product ID: ");
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
                    double price2 = 0;

                    while (chk) {

                        System.out.print("Enter Price: ");
                        price2 = sc.nextDouble();

                        if (price2 > 0) {
                            chk = false;
                        } else {
                            System.out.println("Invalid price! Enter positive number.");
                        }
                    }
                    products[i++] = new Clothing(id2, name2, price2);
                    break;

                case 3:

                    System.out.println("\n--- Products Records ---");

                    for (int j = 0; j < i; j++) {
                    	System.out.println();
                        products[j].showDetails();
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
