package com.mayank.arrayofobject.test;

import java.util.Scanner;
import com.mayank.arrayofobject.model.*;

public class TollBoothApp {

	public static boolean validateAmount(double amount) {
		return amount > 0;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter maximum vehicles to process: ");
		int size = sc.nextInt();

		Vehicle[] vehicles = new Vehicle[size];
		int count = 0;
		int id = 1000;

		while (true) {

			System.out.println("\n===== TOLL MENU =====");
			System.out.println("1. Add Car");
			System.out.println("2. Add Truck");
			System.out.println("3. Add Motorcycle");
			System.out.println("4. Process & Show All Vehicles");
			System.out.println("5. Show Total Toll Collected");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");

			int choice = sc.nextInt();

			switch (choice) {

			case 1:

				if (count >= size) {
					System.out.println("Vehicle storage full!");
					break;
				}

				System.out.print("Enter Base Rate: ");
				double carRate = sc.nextDouble();

				if (!validateAmount(carRate)) {
					System.out.println("Invalid Amount!");
					break;
				}

				vehicles[count++] = new Car(++id, carRate);

				System.out.println("Car Added!");
				break;

			case 2:

				if (count >= size) {
					System.out.println("Vehicle storage full!");
					break;
				}

				System.out.print("Enter Base Rate: ");
				double truckRate = sc.nextDouble();

				System.out.print("Enter Number of Axles: ");
				int axles = sc.nextInt();

				vehicles[count++] = new Truck(++id, truckRate, axles);

				System.out.println("Truck Added!");
				break;

			case 3:

				if (count >= size) {
					System.out.println("Vehicle storage full!");
					break;
				}

				System.out.print("Enter Base Rate: ");
				double bikeRate = sc.nextDouble();

				vehicles[count++] = new Motorcycle(++id, bikeRate);

				System.out.println("Motorcycle Added!");
				break;

			case 4:

				if (count == 0) {
					System.out.println("No Vehicles Available!");
					break;
				}

				System.out.println("\n--- Vehicle List ---");

				for (int i = 0; i < count; i++) {

					double toll = vehicles[i].calculateToll();

					Vehicle.updateTotals(toll);

					System.out.println("ID: " + vehicles[i].getVehicleId() + ", Type: " + vehicles[i].getVehicleType()
							+ ", Toll: " + toll);
				}

				break;

			case 5:
				System.out.println("Total Vehicles Processed: " + Vehicle.getTotalVehiclesProcessed());

				System.out.println("Total Toll Collected: " + Vehicle.getTotalTollCollected());
				break;

			case 6:
				System.out.println("Exiting...");
				sc.close();
				return;

			default:
				System.out.println("Invalid Choice!");
			}
		}
	}
}