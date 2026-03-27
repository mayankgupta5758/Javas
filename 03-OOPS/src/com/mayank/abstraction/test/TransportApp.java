package com.mayank.abstraction.test;

import java.util.Scanner;
import com.mayank.abstraction.model.*;

public class TransportApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Transport[] transports = new Transport[10];
        int count = 0;

        while (true) {

            System.out.println("1. Add Bus");
            System.out.println("2. Add Metro");
            System.out.println("3. Add Taxi");
            System.out.println("4. Print All Tickets");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) {
                System.out.println("Exiting System...");
                sc.close();
                return;
            }

            if (choice == 4) {

                if (count == 0) {
                    System.out.println("No transport entries available!");
                    continue;
                }

                System.out.println("\nPrinting Tickets...\n");

                for (int i = 0; i < count; i++) {
                    transports[i].printTicket(); 
                }
                continue;
            }

            if (count >= transports.length) {
                System.out.println("Storage Full!");
                continue;
            }

            System.out.print("Enter Route ID: ");
            String routeId = sc.nextLine();

            System.out.print("Enter Base Fare: ");
            double baseFare = sc.nextDouble();

            Transport transport = null;

            switch (choice) {

                case 1:
                    System.out.print("Enter Distance (km): ");
                    double busDistance = sc.nextDouble();

                    transport = new Bus(routeId, baseFare, busDistance);
                    break;

                case 2:
                    System.out.print("Enter Number of Stations: ");
                    int stations = sc.nextInt();

                    transport = new Metro(routeId, baseFare, stations);
                    break;

                case 3:
                    System.out.print("Enter Distance (km): ");
                    double taxiDistance = sc.nextDouble();

                    System.out.print("Enter Time (minutes): ");
                    double time = sc.nextDouble();

                    transport = new Taxi(routeId, baseFare, taxiDistance, time);
                    break;

                default:
                    System.out.println("Invalid Choice!");
                    continue;
            }

            transports[count++] = transport;
            System.out.println("Transport Entry Added Successfully!");
        }
    }
}