package com.mayank.assignment.question3.test;

import java.util.*;

import com.mayank.assignment.question3.model.*;

public class StudentMain {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		StudentRecordManager srm = new StudentRecordManager();

		while (run) {
			System.out.println("--------------------------------------------------------------------");
			System.out.println("Press 1 for Add Student.");
			System.out.println("Press 2 for Remove Student Via StudentId.");
			System.out.println("Press 3 for Find Particular Student Record.");
			System.out.println("Press 4 for show All Student Record.");
			System.out.println("Press 5 to Remove Student who Not Pass Eligibility Condition.");
			System.out.println("Press 6 to Show Student Group By Department.");
			System.out.println("Press 7 for see Sorted Record.");
			System.out.println("Press 8 for Exit.");
			System.out.println("--------------------------------------------------------------");

			int key = InputValidator.getValidInt(scanner, "Enter 1, 2, 3, 4, 5, 6, 7, 8: ");
			switch (key) {
			case 1:
				String name = InputValidator.getValidString(scanner, "Enter Student Name: ");
				int id = InputValidator.getValidInt(scanner, "Enter Student Id: ");
				String department = InputValidator.getValidString(scanner, "Enter Department Name: ");
				int numberOfSubject = InputValidator.getValidInt(scanner, "Enter Number of Subject: ");

				int i = 0;
				List<SubjectMarks> subjectsMarks = new ArrayList<>();
				while (i < numberOfSubject) {
					String subjectName = InputValidator.getValidString(scanner, "Enter Subject Name: ");
					double marks = InputValidator.getValidDouble(scanner, "Enter Subject Marks: ");
					SubjectMarks sujMarks = new SubjectMarks(subjectName, marks);
					subjectsMarks.add(sujMarks);
					i++;
				}
				srm.addSubjectMarks(id, subjectsMarks);
				Student student = new Student(id, name, department, 0);
				srm.addStudent(student);
				break;

			case 2:
				id = InputValidator.getValidInt(scanner, "Enter Id to Remove: ");
				srm.removeStudent(id);
				break;

			case 3:
				id = InputValidator.getValidInt(scanner, "Enter Id to Remove: ");
				Student std = srm.findStudentWithId(id);
				if(std != null) {
				System.out.println("ID: " + std.getStudentId() + " | Name: " + std.getName() + " | Department: "
						+ std.getDepartment() + " | Percentage: " + std.getTotalPercentage());
				}
				break;

			case 4:
				srm.showAllStudentMarks();
				break;

			case 5:
				srm.eligibilityCondition();
				break;

			case 6:
				String dept = InputValidator.getValidString(scanner, "Enter Department: ");
				srm.showStudentGroupByDepartment(dept);
				break;

			case 7:
				srm.seeSortedResult();
				break;

			case 8:
				run = false;
				System.out.println("Exiting....");
				break;

			default:
				break;
			}
		}
		scanner.close();
	}

}
