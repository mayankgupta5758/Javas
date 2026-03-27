package com.mayank.assignment2.test;

import java.util.Scanner;
import com.mayank.assignment2.model.*;

public class HospitalApp2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HospitalService2[] services = new HospitalService2[10];
		int count = 0;

		boolean run = true;
		while (run) {
			System.out.println("\n===== HOSPITAL MENU =====");
			System.out.println("1 Add General Consultation");
			System.out.println("2 Add Surgery");
			System.out.println("3 Add Diagnostic Test");
			System.out.println("4 Display Services");
			System.out.println("5 Exit");

			int choice = InputValidator2.getValidInt(sc, "Enter choice: ");

			try {
				switch (choice) {
				case 1:
					int id = InputValidator2.getValidInt(sc, "Enter Service ID: ");
					String name = InputValidator2.getValidName(sc, "Enter Patient Name: ");
					double fee = InputValidator2.getValidDouble(sc, "Enter Fee: ");
					services[count++] = new GeneralConsultation2(id, name, fee);
					break;

				case 2:

					id = InputValidator2.getValidInt(sc, "Enter Service ID: ");
					name = InputValidator2.getValidName(sc, "Enter Patient Name: ");
					fee = InputValidator2.getValidDouble(sc, "Enter Fee: ");

					services[count++] = new Surgery2(id, name, fee);

					break;

				case 3:
					id = InputValidator2.getValidInt(sc, "Enter Service ID: ");
					name = InputValidator2.getValidName(sc, "Enter Patient Name: ");
					fee = InputValidator2.getValidDouble(sc, "Enter Fee: ");
					services[count++] = new DiagnosticTest2(id, name, fee);
					break;

				case 4:
					for (int i = 0; i < count; i++) {
						services[i].display();
					}
					break;

				case 5:
					run = false;
					System.out.println("System Closed");
					break;

				default:
					System.out.println("Invalid Choice");
				}
			} catch (InvalidServiceException2 e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}
}