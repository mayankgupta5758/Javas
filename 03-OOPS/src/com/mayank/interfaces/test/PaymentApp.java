package com.mayank.interfaces.test;

import java.util.Scanner;
import com.mayank.interfaces.model.*;

public class PaymentApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\nChoose Payment Method:");
            System.out.println("1. Credit Card");
            System.out.println("2. Debit Card");
            System.out.println("3. UPI");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            if (choice == 4) {
                System.out.println("Thank You! Exiting...");
                break;
            }

            Payment payment = null;
            double amount;

            switch (choice) {
                case 1:
                	System.out.print("Enter Amount: ");
                    amount = sc.nextDouble();
                    if(amount < 0) {
                    	System.out.println("Enter Positive Amount: ");
                    	break;
                    } 
                    payment = new CreditCardPayment();
                    break;
                case 2:
                	System.out.print("Enter Amount: ");
                    amount = sc.nextDouble();
                    if(amount < 0) {
                    	System.out.println("Enter Positive Amount: ");
                    	break;
                    } 
                    payment = new DebitCardPayment();
                    break;
                case 3:
                	System.out.print("Enter Amount: ");
                    amount = sc.nextDouble();
                    if(amount < 0) {
                    	System.out.println("Enter Positive Amount: ");
                    	break;
                    } 
                    payment = new UPIPayment();
                    break;
                default:
                    System.out.println("Invalid Choice! Try Again.");
                    continue;  
            }

            if (payment != null) {
                payment.processPayment(amount);
            }
        }

        sc.close();
    }
}