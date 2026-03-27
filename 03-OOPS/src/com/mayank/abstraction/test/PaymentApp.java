package com.mayank.abstraction.test;

import java.util.Scanner;
import com.mayank.abstraction.model.*;

public class PaymentApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Payment[] payments = new Payment[10]; 
        int count = 0;

        while (true) {

            System.out.println("\n===== DIGITAL PAYMENT MENU =====");
            System.out.println("1. Credit Card Payment (2% Fee)");
            System.out.println("2. UPI Payment (No Fee)");
            System.out.println("3. Wallet Payment (1% Fee)");
            System.out.println("4. Process All Payments");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("Thank you for using Payment System!");
                sc.close();
                return;
            }

            if (choice == 4) {

                if (count == 0) {
                    System.out.println("No Payments to Process!");
                    continue;
                }

                System.out.println("\nProcessing All Payments...\n");

                for (int i = 0; i < count; i++) {
                    payments[i].processPayment();  
                }

                continue;
            }

            System.out.print("Enter Payment Amount: ");
            double amount = sc.nextDouble();

            Payment payment = null;

            switch (choice) {

                case 1:
                    payment = new CreditCardPayment(amount);
                    break;

                case 2:
                    payment = new UPIPayment(amount);
                    break;

                case 3:
                    payment = new WalletPayment(amount);
                    break;

                default:
                    System.out.println("Invalid Choice!");
                    continue;
            }

            if (count < payments.length) {
                payments[count++] = payment;
                System.out.println("Payment Added Successfully!");
            } else {
                System.out.println("Payment Storage Full!");
            }
        }
    }
}