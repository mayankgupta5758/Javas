package com.mayank.inheritance.test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mayank.inheritance.model.*;

public class NotificationTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of notifications: ");
        int n = scanner.nextInt();
        scanner.nextLine();   

        if (n <= 0) {
            System.out.println("Number must be greater than 0.");
            return;
        }

        Notification[] notifications = new Notification[n];
        int i = 0;

        while (i < n) {

            System.out.println("\nChoose Notification Type:");
            System.out.println("1. Email");
            System.out.println("2. SMS");
            System.out.println("3. Push");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            System.out.println("Enter Recipient: ");
            String recipient = scanner.nextLine();

            if (recipient.trim().isEmpty()) {
                System.out.println("Recipient cannot be empty.");
                continue;
            }

            System.out.println("Enter Message: ");
            String message = scanner.nextLine();

            if (message.trim().isEmpty()) {
                System.out.println("Message cannot be empty.");
                continue;
            }

            if (choice == 1) {
            	Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
            	Matcher matcher = emailPattern.matcher(recipient);
                boolean result = matcher.matches();

                if (!result) {
                    System.out.println("Invalid email format.");
                    continue;
                }

                notifications[i] = new EmailNotification(recipient, message);
                i++;

            } else if (choice == 2) {
            	Pattern mobliePattern = Pattern.compile("^[1-9][0-9]{9}$");
            	Matcher matcher = mobliePattern.matcher(recipient);
                boolean result = matcher.matches();
            	

                if (!result) {
                    System.out.println("Mobile number must be 10 digits.");
                    continue;
                }

                boolean valid = true;
                for (int j = 0; j < recipient.length(); j++) {
                    if (!Character.isDigit(recipient.charAt(j))) {
                        valid = false;
                        break;
                    }
                }

                if (!valid) {
                    System.out.println("Mobile number must contain digits only.");
                    continue;
                }

                notifications[i] = new SMSNotification(recipient, message);
                i++;

            } else if (choice == 3) {

                notifications[i] = new PushNotification(recipient, message);
                i++;

            } else {
                System.out.println("Invalid choice.");
            }
        }


        for (Notification nObj : notifications) {
            nObj.send();
        }

        scanner.close();
    }
}
