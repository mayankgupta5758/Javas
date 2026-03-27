package com.mayank.abstraction.test;

import java.util.Scanner;

import com.mayank.abstraction.model.*;

public class HospitalApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Patient[] patients = new Patient[10];
        int count = 0;
        int patientId = 100;

        while (true) {

            System.out.println("\n===== HOSPITAL MENU =====");
            System.out.println("1. Add InPatient");
            System.out.println("2. Add OutPatient");
            System.out.println("3. Add EmergencyPatient");
            System.out.println("4. Generate All Bills");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 0) {
                System.out.println("Exiting Hospital System...");
                sc.close();
                return;
            }

            if (choice == 4) {

                if (count == 0) {
                    System.out.println("No patients available!");
                    continue;
                }

                System.out.println("\nGenerating Bills...\n");

                for (int i = 0; i < count; i++) {
                    patients[i].generateBill();  // Template Method Call
                }
                continue;
            }

            if (count >= patients.length) {
                System.out.println("Patient storage full!");
                continue;
            }

            System.out.print("Enter Patient Name: ");
            String name = sc.nextLine();

            Patient patient = null;

            switch (choice) {

                case 1:
                    System.out.print("Enter Treatment Cost: ");
                    double treatment = sc.nextDouble();

                    System.out.print("Enter Room Charges: ");
                    double room = sc.nextDouble();

                    patient = new InPatient(++patientId, name, treatment, room);
                    break;

                case 2:
                    System.out.print("Enter Consultation Fee: ");
                    double consult = sc.nextDouble();

                    patient = new OutPatient(++patientId, name, consult);
                    break;

                case 3:
                    System.out.print("Enter Treatment Cost: ");
                    double treat = sc.nextDouble();

                    System.out.print("Enter Emergency Surcharge: ");
                    double emergency = sc.nextDouble();

                    patient = new EmergencyPatient(++patientId, name, treat, emergency);
                    break;

                default:
                    System.out.println("Invalid Choice!");
                    continue;
            }

            patients[count++] = patient;
            System.out.println("Patient Added Successfully!");
        }
    }
}