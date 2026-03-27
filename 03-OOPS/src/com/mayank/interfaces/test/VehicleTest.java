package com.mayank.interfaces.test;

import java.util.Scanner;
import com.mayank.interfaces.model.*;

public class VehicleTest {

    public static boolean validateFuelType(String name) {
        return name != null && name.matches("^[A-Za-z]+$");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Vehicle vehicle = null;
        String typeofFuel = null;

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Select Bike");
            System.out.println("2. Select Car");
            System.out.println("3. Start Vehicle");
            System.out.println("4. Stop Vehicle");
            System.out.println("5. Set Fuel Type");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

            case 1:
                vehicle = new Bike();
                System.out.println("Bike Selected.");
                break;

            case 2:
                vehicle = new Car();
                System.out.println("Car Selected.");
                break;

            case 3:
                if (vehicle != null)
                    vehicle.start();
                else
                    System.out.println("Please select a vehicle first.");
                break;

            case 4:
                if (vehicle != null)
                    vehicle.stop();
                else
                    System.out.println("Please select a vehicle first.");
                break;

            case 5:
                if (vehicle != null) {
                    while (true) {
                        System.out.print("Enter Fuel Type: ");
                        typeofFuel = sc.nextLine();

                        if (validateFuelType(typeofFuel))
                            break;

                        System.out.println("Invalid Fuel Type! Only alphabets allowed.");
                    }
                    vehicle.fuelType(typeofFuel);
                } else {
                    System.out.println("Please select a vehicle first.");
                }
                break;

            case 6:
                System.out.println("Thank You! Exiting...");
                sc.close();
                return;

            default:
                System.out.println("Invalid Choice! Try Again.");
            }
        }
    }
}