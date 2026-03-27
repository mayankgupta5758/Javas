package com.mayank.assignment.test;

import java.util.Scanner;
import com.mayank.assignment.model.*;

public class HospitalTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Staff[] staffArray = new Staff[10];
		int i = 0;

		while (true) {
			System.out.println("\n1. Add Doctor");
			System.out.println("2. Add Nurse");
			System.out.println("3. Show All Staff");
			System.out.println("4. Exit");

			int choice = ValidationClass.getValidInt(sc, "Enter choice: ");
			if (choice == 4)
				break;

			switch (choice) {
			case 1:
				int id = ValidationClass.getValidInt(sc, "Enter ID: ");
				String name = ValidationClass.getValidString(sc, "Enter Name: ");
				String dept = ValidationClass.getValidString(sc, "Enter Department: ");
				String spec = ValidationClass.getValidString(sc, "Enter Specialization: ");
				Status status = ValidationClass.getValidateStatus(sc, "Enter Status.");
				staffArray[i++] = new Doctor(id, name, dept, spec, status);
				break;
			case 2:
				int id2 = ValidationClass.getValidInt(sc, "Enter ID: ");
				String name2 = ValidationClass.getValidString(sc, "Enter Name: ");
				String dept2 = ValidationClass.getValidString(sc, "Enter Department: ");
				int shift = ValidationClass.getValidInt(sc, "Enter Shift Hours: ");
				Status status2 = ValidationClass.getValidateStatus(sc, "Enter Status.");
				staffArray[i++] = new Nurse(id2, name2, dept2, shift, status2);
				break;
			case 3:
				System.out.println("Hospital Staff Records");
				for (int j = 0; j < i; j++) {
					staffArray[j].display();
				}
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}
		sc.close();
	}
}