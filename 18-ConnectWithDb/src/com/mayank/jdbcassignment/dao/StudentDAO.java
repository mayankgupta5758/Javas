package com.mayank.jdbcassignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.mayank.jdbcassignment.model.Student;
import com.mayank.jdbcassignment.util.DbConnecter;

public class StudentDAO {
	DbConnecter dbConnecter = new DbConnecter();

	public void addStudent(Connection connection, Scanner scanner, Student student) {
		String query = "INSERT INTO student (id, name, age, b_id) VALUES (?, ?, ?, ?)";
		try (PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setInt(3, student.getAge());
			ps.setInt(4, student.getBranchId());

			int rows = ps.executeUpdate();
			if (rows > 0) {
				System.out.println("Student Data Added Successfully");
			} else {
				System.out.println("Failed to add student");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void viewAllStudentDataWithCourse(Connection connection) {
		System.out.println("________________________________");
		String query = "SELECT s.id, s.name, COUNT(c.c_id) AS total_courses, "
				+ "GROUP_CONCAT(c.c_name SEPARATOR ', ') AS courses FROM student s "
				+ "LEFT JOIN registration r ON s.id = r.student_id LEFT JOIN courses c ON r.c_id = c.c_id "
				+ "GROUP BY s.id, s.name";

		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");
				int count = rs.getInt("total_courses");
				String courses = rs.getString("courses");

				if (courses == null) {
					courses = "No Course";
				}
				System.out.println("| " + id + " | " + name + " | " + count + " | " + courses + " |");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("________________________________");
	}

	public void getStudentByIdWithCourse(Connection connection, int id) {
		String query = "SELECT s.id, s.name, s.age, b.b_name, c.c_name, r.fees_paid FROM student s "
				+ "LEFT JOIN branch b ON s.b_id = b.b_id LEFT JOIN registration r ON s.id = r.student_id "
				+ "LEFT JOIN courses c ON r.c_id = c.c_id WHERE s.id = ?";

		try (PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			boolean found = false;
			while (rs.next()) {
				found = true;

				String name = rs.getString("name");
				int age = rs.getInt("age");
				String branch = rs.getString("b_name");
				String course = rs.getString("c_name");
				double fee = rs.getDouble("fees_paid");
				if (course == null) {
					course = "No Course";
				}
				System.out.println(
						"| " + id + " | " + name + " | " + age + " | " + branch + " | " + course + " | " + fee + " |");
			}
			if (!found) {
				System.out.println("Student Not Found!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Student getStudentById(Connection connection, int id) {
		Student student = null;
		String query = "SELECT * FROM student WHERE id = ?";

		try (PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				int b_id = rs.getInt("b_id");
				student = new Student(id, name, age, b_id);
				return student;
			}
			System.out.println("Student Not Found!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	public void updateStudentDetails(Connection connection, int id, Student student) {
		String query = "UPDATE student SET name = ?, age = ?, b_id = ? WHERE id = ?";

		try (PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setString(1, student.getName());
			ps.setInt(2, student.getAge());
			ps.setInt(3, student.getBranchId());
			ps.setInt(4, id);

			int rows = ps.executeUpdate();
			if (rows > 0) {
				System.out.println("Student Data Updated Successfully");
			} else {
				System.out.println("Student Not Found / Update Failed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteStudentDetails(Connection connection, int id) {
		try {
			connection.setAutoCommit(false);

			String query1 = "DELETE FROM registration WHERE student_id = ?";
			try (PreparedStatement ps1 = connection.prepareStatement(query1)) {
				ps1.setInt(1, id);
				ps1.executeUpdate();
			}

			String query2 = "DELETE FROM student WHERE id = ?";
			int rows;

			try (PreparedStatement ps2 = connection.prepareStatement(query2)) {
				ps2.setInt(1, id);
				rows = ps2.executeUpdate();
			}

			if (rows > 0) {
				connection.commit();
				System.out.println("Student Data Deleted Successfully");
			} else {
				connection.rollback();
				System.out.println("Student Not Found / Delete Failed");
			}
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();

		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
