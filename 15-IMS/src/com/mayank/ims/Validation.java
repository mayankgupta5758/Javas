package com.mayank.ims;

import java.util.Scanner;

public class Validation {
    public static int getValidInt(Scanner sc, String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid number! Try again.");
            }
        }
    }

    public static double getValidDouble(Scanner sc, String msg) {
        while (true) {
            try {
                System.out.print(msg);
                double val = Double.parseDouble(sc.nextLine());
                if (val < 0)
                    throw new Exception();
                return val;
            } catch (Exception e) {
                System.out.println("Invalid price! Enter positive number.");
            }
        }
    }

    public static String getValidString(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine();
            if (!input.trim().isEmpty())
                return input;
            System.out.println("Input cannot be empty!");
        }
    }
}

