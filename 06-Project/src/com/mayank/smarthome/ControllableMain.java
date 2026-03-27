package com.mayank.smarthome;

import java.util.Scanner;

public class ControllableMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Controllable[] devices = new Controllable[100];
        String[] history = new String[500];

        int deviceCount = 0;
        int historyCount = 0;

        Controllable device = null;

        while (true) {

            System.out.println("SMART HOME MENU");
            System.out.println("1. Add Light");
            System.out.println("2. Add Fan");
            System.out.println("3. Add TV");
            System.out.println("4. Add Speaker");
            System.out.println("5. Control Last Added Device");
            System.out.println("6. Show All Activities");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

            case 1:
                device = new Light();
                devices[deviceCount++] = device;
                history[historyCount++] = "Light Added";
                System.out.println("Light Added Successfully.");
                break;

            case 2:
                device = new Fan();
                devices[deviceCount++] = device;
                history[historyCount++] = "Fan Added";
                System.out.println("Fan Added Successfully.");
                break;

            case 3:
                device = new TV();
                devices[deviceCount++] = device;
                history[historyCount++] = "TV Added";
                System.out.println("TV Added Successfully.");
                break;

            case 4:
                device = new Speaker();
                devices[deviceCount++] = device;
                history[historyCount++] = "Speaker Added";
                System.out.println("Speaker Added Successfully.");
                break;

            case 5:

                if (deviceCount == 0) {
                    System.out.println("No device added yet.");
                    break;
                }

                device = devices[deviceCount - 1]; 

                while (true) {

                    System.out.println("\n1. Turn ON");
                    System.out.println("2. Turn OFF");
                    System.out.println("3. Set Mode");
                    System.out.println("4. Back");

                    int op = scanner.nextInt();
                    scanner.nextLine();

                    if (op == 4)
                        break;

                    switch (op) {

                    case 1:
                        device.turnOn();
                        history[historyCount++] = "Device Turned ON";
                        break;

                    case 2:
                        device.turnOff();
                        history[historyCount++] = "Device Turned OFF";
                        break;

                    case 3:
                        if (device instanceof Light) {
                            System.out.println("Light Mode: High or Dim");
                        } 
                        else if (device instanceof Fan) {
                            System.out.println("Fan Mode: High or Low");
                        } 
                        else if (device instanceof TV) {
                            System.out.println("TV Mode: HD or 4K");
                        } 
                        else if (device instanceof Speaker) {
                            System.out.println("Speaker Mode: Loud or Bass");
                        }
                        System.out.print("Enter Mode: ");
                        String mode = scanner.nextLine();
                        device.setMode(mode);
                        history[historyCount++] = "Mode Set To: " + mode;
                        break;

                    default:
                        System.out.println("Invalid Option");
                    }
                }
                break;

            case 6:

                System.out.println("\n===== ACTIVITY HISTORY =====");

                if (historyCount == 0) {
                    System.out.println("No activities yet.");
                } else {
                    for (int i = 0; i < historyCount; i++) {
                        System.out.println((i + 1) + ". " + history[i]);
                    }
                }
                break;

            case 7:
                System.out.println("Exiting Smart Home...");
                scanner.close();
                return;

            default:
                System.out.println("Invalid Choice.");
            }
        }
    }
}