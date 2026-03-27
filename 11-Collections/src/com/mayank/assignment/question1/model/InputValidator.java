package com.mayank.assignment.question1.model;

import java.util.Scanner;

public class InputValidator {

    public static int getValidInt(Scanner sc, String msg) {

        while (true) {
            System.out.print(msg);
            if (sc.hasNextInt()) {
                return sc.nextInt();
            }

            else {
                System.out.println("Invalid number. Try again.");
                sc.next();
            }
        }
    }

    public static String getValidString(Scanner sc, String msg) {

        while (true) {
            System.out.print(msg);
            String input = sc.next();
            
            if (input.matches("[a-zA-Z ]+"))
                return input;
            else
                System.out.println("Invalid name. Only letters allowed.");
        }
    }
}