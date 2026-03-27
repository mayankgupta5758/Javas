package com.mayank.assignment1.test;

import java.util.*;

import com.mayank.assignment1.model.*;

public class FlightsMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        List<Flights> list = new ArrayList<>();

        int n = 0;
        while (true) {
            try {
                System.out.print("Enter number of flights: ");
                n = sc.nextInt();

                if (n <= 0) {
                    System.out.println("Number must be greater than 0.");
                    continue;
                }

                break;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter integer only.");
                sc.next();
            }
        }

        sc.nextLine(); 

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter Flight " + (i + 1));

            String airline;
            double fare;

            while (true) {
                System.out.print("Enter Airline Name: ");
                airline = sc.nextLine();

                if (airline.trim().isEmpty()) {
                    System.out.println("Airline name cannot be empty.");
                    continue;
                }

                break;
            }

            while (true) {
                try {
                    System.out.print("Enter Fare: ");
                    fare = sc.nextDouble();

                    if (fare < 0) {
                        System.out.println("Fare cannot be negative.");
                        continue;
                    }

                    break;

                } catch (InputMismatchException e) {
                    System.out.println("Invalid fare. Enter number only.");
                    sc.next();
                }
            }

            sc.nextLine(); 
            list.add(new Flights(airline, fare));
        }

        Collections.sort(list, new FlightsComparator());

        System.out.println("\nSorted Flights (Lowest Fare First):");

        for (Flights f : list) {
            System.out.println(f.airline + " " + f.fare);
        }

        sc.close();
	}

}
