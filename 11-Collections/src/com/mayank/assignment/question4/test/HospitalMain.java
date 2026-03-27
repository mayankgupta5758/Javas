package com.mayank.assignment.question4.test;

import java.util.Scanner;
import com.mayank.assignment.question4.model.*;
import com.mayank.assignment.question3.model.InputValidator;

public class HospitalMain {
	public static void main(String[] args) {
		
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		HospitalManger hm = new HospitalManger(); 

		while (run) {
			System.out.println("----------------------------------------------------");
			System.out.println("1. Add Patient");
			System.out.println("2. Add Doctor");
			System.out.println("3. Allocate Doctor To Patients");
			System.out.println("4. Call Next Patient");
			System.out.println("5. Discharge Patient");
			System.out.println("6. Remove Discharged Patients");
			System.out.println("7. Show All Patients");
			System.out.println("8. Show All Doctors");
			System.out.println("9. Exit");
			System.out.println("----------------------------------------------------");

			int choice = InputValidator.getValidInt(scanner, "Enter choice: ");
			switch (choice) {

			case 1:
				int pid = InputValidator.getValidInt(scanner, "Enter Patient ID: ");
				String pname = InputValidator.getValidString(scanner, "Enter Patient Name: ");
				int age = InputValidator.getValidInt(scanner, "Enter Age: ");

				Patient p = new Patient(pname, age, pid);
				hm.addPatient(p);
				System.out.println("----------------------------------------------------");
				break;

			case 2:
				int did = InputValidator.getValidInt(scanner, "Enter Doctor ID: ");
				String dname = InputValidator.getValidString(scanner, "Enter Doctor Name: ");
				int dage = InputValidator.getValidInt(scanner, "Enter Age: ");

				Doctor d = new Doctor(dname, dage, did);
				hm.addDoctor(d);
				System.out.println("----------------------------------------------------");
				break;
				
			case 3: 
				hm.allocateDoctorToPatient();
				System.out.println("----------------------------------------------------");
				break;

			case 4:
				did = InputValidator.getValidInt(scanner, "Enter Doctor ID: ");
				hm.callNextPatient(did);
				System.out.println("----------------------------------------------------");
				break;

			case 5:
				pid = InputValidator.getValidInt(scanner, "Enter Patient ID: ");
				hm.dischargePatient(pid);
				System.out.println("----------------------------------------------------");
				break;

			case 6:
				hm.removeDischargePatient();
				System.out.println("----------------------------------------------------");
				break;

			case 7:
				hm.showAllPatients();
				System.out.println("----------------------------------------------------");
				break;

			case 8:
				hm.showAllDoctors();
				System.out.println("----------------------------------------------------");
				break;

			case 9:
				run = false;
				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid choice!");
			}
		}

		scanner.close();
	}
}