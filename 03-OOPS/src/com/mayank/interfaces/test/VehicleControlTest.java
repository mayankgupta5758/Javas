package com.mayank.interfaces.test;
import java.util.Scanner;

import com.mayank.interfaces.model.*;

public class VehicleControlTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VehicleControl vehicle = null;

        while (true) {

            System.out.println("Select Vehicle");
            System.out.println("1. Car");
            System.out.println("2. Bike");
            System.out.println("3. Truck");
            System.out.println("4. Control Vehicle");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    vehicle = new CarControl();
                    System.out.println("Car selected.");
                    break;

                case 2:
                    vehicle = new BikeControl();
                    System.out.println("Bike selected.");
                    break;

                case 3:
                    vehicle = new TruckControl();
                    System.out.println("Truck selected.");
                    break;

                case 4:

                    if (vehicle == null) {
                        System.out.println("Please select a vehicle first!");
                        break;
                    }

                    while (true) {

                        System.out.println("\n--- Control Menu ---");
                        System.out.println("1. Vehicle Off");
                        System.out.println("2. Vehicle On");
                        System.out.println("3. Change Gear");
                        System.out.println("4. Back");

                        System.out.print("Enter choice: ");
                        int control = sc.nextInt();

                        switch (control) {

                            case 1:
                                vehicle.stop();
                                break;

                            case 2:
                                vehicle.start();
                                break;

                            case 3:
                                System.out.print("Enter gear number: ");
                                int gear = sc.nextInt();
                                vehicle.changeGear(gear);
                                break;

                            case 4:
                                System.out.println("Going back...");
                                break;

                            default:
                                System.out.println("Invalid input! Try again.");
                                continue;
                        }

                        if (control == 4)
                            break;
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid input! Try again.");
            }
        }
    }
}