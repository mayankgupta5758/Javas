package com.mayank.assignment.question6.test;

import java.time.LocalDate;
import java.util.Scanner;

import com.mayank.assignment.question3.model.InputValidator;
import com.mayank.assignment.question6.model.ElectronicProduct;
import com.mayank.assignment.question6.model.GroceryProduct;
import com.mayank.assignment.question6.model.InventoryManager;

public class InventoryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryManager im = new InventoryManager();
        boolean run = true;

        while (run) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 Add Electronic");
            System.out.println("2 Add Grocery");
            System.out.println("3 Display All");
            System.out.println("4 Display by Category");
            System.out.println("5 Sort by ID");
            System.out.println("6 Sort by Price");
            System.out.println("7 Request Return");
            System.out.println("8 Process Return");
            System.out.println("9 Remove Product");
            System.out.println("10 Exit");

            int ch = InputValidator.getValidInt(sc, "Enter choice: ");
            try {
                switch (ch) {
                case 1:
                    int id = InputValidator.getValidInt(sc, "ID: ");
                    String name = InputValidator.getValidString(sc, "Name: ");
                    String cat = InputValidator.getValidString(sc, "Category: ");
                    double price = InputValidator.getValidInt(sc, "Price: ");
                    int w = InputValidator.getValidInt(sc, "Warranty: ");
                    im.addProduct(new ElectronicProduct(id, name, cat, price, w));
                    break;

                case 2:
                    id = InputValidator.getValidInt(sc, "ID: ");
                    name = InputValidator.getValidString(sc, "Name: ");
                    cat = InputValidator.getValidString(sc, "Category: ");
                    price = InputValidator.getValidInt(sc, "Price: ");
                    System.out.println("Enter Expiry Day/Month/Year.");
                    LocalDate exp = null;
                    boolean chk = true;
                    while (chk) {
                        try {
                            int year = InputValidator.getValidInt(sc, "Enter Year: ");
                            int month = InputValidator.getValidInt(sc, "Enter Month: ");
                            int day = InputValidator.getValidInt(sc, "Enter Day: ");

                            exp = LocalDate.of(year, month, day);
                            chk = false;

                        } catch (Exception e) {
                            System.out.println("Invalid date! Try again.");
                        }
                    }
                    im.addProduct(new GroceryProduct(id, name, cat, price, exp));
                    break;

                case 3:
                    im.displayAll();
                    break;

                case 4:
                    cat = InputValidator.getValidString(sc, "Category: ");
                    im.displayByCategory(cat);
                    break;

                case 5:
                    im.sortById();
                    break;

                case 6:
                    im.sortByPrice();
                    break;

                case 7:
                    id = InputValidator.getValidInt(sc, "Product ID: ");
                    im.requestReturn(id);
                    break;

                case 8:
                    im.processReturn();
                    break;

                case 9:
                    id = InputValidator.getValidInt(sc, "Remove ID: ");
                    im.removeProduct(id);
                    break;

                case 10:
                	System.out.println("Exiting...");
                    run = false;
                    break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}