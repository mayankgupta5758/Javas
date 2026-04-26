package com.mayank.jdbcassignment.service;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.mayank.jdbcassignment.dao.BranchDAO;
import com.mayank.jdbcassignment.dao.CourseDAO;
import com.mayank.jdbcassignment.dao.RegistrationDAO;
import com.mayank.jdbcassignment.dao.StudentDAO;
import com.mayank.jdbcassignment.model.Registration;
import com.mayank.jdbcassignment.model.Student;
import com.mayank.jdbcassignment.util.DbConnecter;
import com.mayank.jdbcassignment.util.InputValidation;

public class StudentService {
	private StudentDAO studentDAO = new StudentDAO();
	private RegistrationDAO registrationDAO = new RegistrationDAO();
	private Connection connection = DbConnecter.conncetToDataBase();

	public void start(Scanner scanner) {
		boolean play = true;
		while (play) {
			System.out.println("---------------------------------------");
			System.out.println("1. Add Student");
			System.out.println("2. Register for Course");
			System.out.println("3. View All Students with Courses");
			System.out.println("4. Search Student by ID With Course");
			System.out.println("5. Update Student Details");
			System.out.println("6. Update Course Fee");
			System.out.println("7. Cancel Registration");
			System.out.println("8. Delete Student");
			System.out.println("9. High Paying Students Report");
			System.out.println("10. Course-wise Student Count");
			System.out.println("11. Exit");
			System.out.println("12. Search Student by ID");
			System.out.println("---------------------------------------");

			int otp = InputValidation.getValidInt(scanner, "Enter value from 1 to 12: ");

			switch (otp) {
			case 1:
				addStudent(connection, scanner);
				break;
			case 2:
				registeredForCourse(connection, scanner);
				break;
			case 3:
				viewAllStudent(connection);
				break;
			case 4:
				getStudentByIdWithCourse(connection, scanner);
				break;
			case 5:
				updateStudentDetails(connection, scanner);
				break;
			case 6:
				updatePriceForCourse(connection, scanner);
				break;
			case 7:
				cancelStudentRegistration(connection, scanner);
				break;
			case 8:
				deleteStudentDetails(connection, scanner);
				break;
			case 9:
				highStudentMaxFeePaid(connection);
				break;
			case 10:
				getStudentCourseWiseDetail(connection);
				break;
			case 11:
				play = false;
				System.out.println("Exiting.....");
				break;
			case 12:
				getStudetById(connection, scanner);
				break;
			default:
				System.out.println("Enter 1 to 12 only!!!");
				break;
			}
		}
	}

	public void addStudent(Connection connection, Scanner scanner) {
	    String name = InputValidation.getValidString(scanner, "Enter Name: ");
	    name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
	    int age = InputValidation.getValidInt(scanner, "Enter Age: ");
	    int b_id = new BranchDAO().getBranchId(connection, scanner);

	    Student student = new Student(name, age, b_id);

	    studentDAO.addStudent(connection,scanner, student);
	}

	public void viewAllStudent(Connection connection) {
		studentDAO.viewAllStudentDataWithCourse(connection);
	}

	public void getStudentByIdWithCourse(Connection connection, Scanner scanner) {
		int id = InputValidation.getValidInt(scanner, "Enter Student Id: ");
		Student student = studentDAO.getStudentById(connection, id);
		if (student == null) {
			System.out.println("Student Not Found!!!");
			return;
		}
		studentDAO.getStudentByIdWithCourse(connection, id);
	}
	
	public void getStudetById(Connection connection, Scanner scanner) {
		int id = InputValidation.getValidInt(scanner, "Enter Student Id: ");
		Student student = studentDAO.getStudentById(connection, id);
		if (student == null) {
			System.out.println("Student Not Found!!!");
			return;
		}
		System.out.println("| " + id + " | " + student.getName() + " | " + student.getAge() + " | " + student.getBranchId() + " | ");
	}

	public void updateStudentDetails(Connection connection, Scanner scanner) {
		int id = InputValidation.getValidInt(scanner, "Enter Student Id: ");
		Student student = studentDAO.getStudentById(connection, id);
		if (student == null) {
			System.out.println("Student Not Found!!!");
			return;
		}
		String newName = InputValidation.getValidString(scanner, "Enter new Name: ");
		newName = newName.substring(0,1).toUpperCase() + newName.substring(1).toLowerCase();

		int newBranchId = new BranchDAO().getBranchId(connection, scanner);

		int newAge = InputValidation.getValidInt(scanner, "Enter new Age: ");
		student = new Student(newName, newAge, newBranchId);
		studentDAO.updateStudentDetails(connection, id, student);
	}

	public void deleteStudentDetails(Connection connection, Scanner scanner) {
		int id = InputValidation.getValidInt(scanner, "Enter Student Id: ");
		Student student = studentDAO.getStudentById(connection, id);
		if (student == null) {
			System.out.println("Student Not Found!!!");
			return;
		}
		studentDAO.deleteStudentDetails(connection, id);
	}

	public void registeredForCourse(Connection connection, Scanner scanner) {
		int studentId = InputValidation.getValidInt(scanner, "Enter Student Id: ");
		Student student = studentDAO.getStudentById(connection, studentId);
		if (student == null) {
			System.out.println("Student Not Found!!!");
			return;
		}
		int c_id = new CourseDAO().getCourseId(connection, scanner);

		double fees_paid;
		do {
			fees_paid = InputValidation.getValidDouble(scanner, "Enter Fees Paid: ");

			if (fees_paid <= 0) {
				System.out.println("Fees must be greater than 0!");
			}

		} while (fees_paid <= 0);

		Registration registration = new Registration(studentId, c_id, fees_paid);

		registrationDAO.addCourse(connection, studentId, registration);
	}

	public void updatePriceForCourse(Connection connection, Scanner scanner) {
		int studentId = InputValidation.getValidInt(scanner, "Enter Student Id: ");
		Student student = studentDAO.getStudentById(connection, studentId);
		if (student == null) {
			System.out.println("Student Not Found!!!");
			return;
		}

		int rigId = InputValidation.getValidInt(scanner, "Enter registration Id: ");
		List<Registration> list = registrationDAO.getStudentCourseDetails(connection, studentId);
		if (list == null || list.isEmpty()) {
			System.out.println("Student Not Enrolled in Any Course!!!");
			return;
		}
		
		boolean found = false;
	    for (Registration r : list) {
	        if (r.getRegId() == rigId) {
	            found = true;
	            break;
	        }
	    }

	    if (!found) {
	        System.out.println("Student Not Enrolled in this Course!!!");
	        return;
	    }

		double new_fees_paid;
		do {
			new_fees_paid = InputValidation.getValidDouble(scanner, "Enter new Fees Paid: ");

			if (new_fees_paid <= 0) {
				System.out.println("Fees must be greater than 0!");
			}

		} while (new_fees_paid <= 0);

		Registration registration = null;
		for (Registration r : list) {
			if (r.getRegId() == rigId) {
				registration = new Registration(r.getRegId(), r.getStudentId(), r.getCourseId(), new_fees_paid);
			}
		}
		if (registration == null) {
			System.out.println("Student Not Enrolled in any Course!!!");
			return;
		}

		registrationDAO.updateCourseFee(connection, studentId, registration);
	}

	public void cancelStudentRegistration(Connection connection, Scanner scanner) {
		int studentId = InputValidation.getValidInt(scanner, "Enter Student Id: ");
		Student student = studentDAO.getStudentById(connection, studentId);
		if (student == null) {
			System.out.println("Student Not Found!!!");
			return;
		}
		int regId = InputValidation.getValidInt(scanner, "Enter registration Id: ");
		List<Registration> list = registrationDAO.getStudentCourseDetails(connection, studentId);
		if (list == null || list.isEmpty()) {
			System.out.println("Student Not Enrolled in Any Course!!!");
			return;
		}

		registrationDAO.cancelStudentRegistration(connection, regId, studentId);
	}

	public void highStudentMaxFeePaid(Connection connection) {
		registrationDAO.highPayingStudentDetail(connection);
	}

	public void getStudentCourseWiseDetail(Connection connection) {
		registrationDAO.countStudentCourseWise(connection);
	}
}
