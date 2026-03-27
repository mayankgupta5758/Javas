package com.mayank.interfaces.test;

import java.util.Scanner;
import com.mayank.interfaces.model.*;

public class BankApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AccountOperations account = null;
        double balance = 0;  

        while (true) {

            System.out.println("Select Account Type");
            System.out.println("1. Savings Account");
            System.out.println("2. Current Account");
            System.out.println("3. Loan Account");
            System.out.println("4. Exit");
            System.out.println("5. Switch Account");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 4) {
                System.out.println("Thank You for Banking with Us.");
                break;
            }

            switch (choice) {

                case 1:
                    if (account == null) {
                        System.out.print("Enter Initial Amount: ");
                        balance = sc.nextDouble();
                    }
                    account = new SavingsAccount(balance);
                    break;

                case 2:
                    if (account == null) {
                        System.out.print("Enter Initial Amount: ");
                        balance = sc.nextDouble();
                    }
                    account = new CurrentAccount(balance);
                    break;

                case 3:
                    if (account == null) {
                        System.out.print("Enter Initial Amount: ");
                        balance = sc.nextDouble();
                    }
                    account = new LoanAccount(balance);
                    break;

                case 5:
                    if (account == null) {
                        System.out.println("No account to switch! Select account first.");
                        continue;
                    }
                    System.out.println("Switching account...");
                    continue;

                default:
                    System.out.println("Invalid Choice! Try again.");
                    continue;
            }

            while (true) {

                System.out.println("\n--- Account Menu ---");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Back");

                System.out.print("Enter option: ");
                int option = sc.nextInt();

                switch (option) {

                    case 1:
                        System.out.print("Enter Amount to Deposit: ");
                        double dep = sc.nextDouble();
                        account.deposit(dep);
                        balance += dep; 
                        break;

                    case 2:
                        System.out.print("Enter Amount to Withdraw: ");
                        double wd = sc.nextDouble();
                        account.withdraw(wd);
                        balance -= wd; 
                        break;

                    case 3:
                        account.checkBalance();
                        break;

                    case 4:
                        System.out.println("Going Back...");
                        break;

                    default:
                        System.out.println("Invalid Option! Try again.");
                        continue;
                }

                if (option == 4)
                    break;
            }
        }

        sc.close();
    }
}