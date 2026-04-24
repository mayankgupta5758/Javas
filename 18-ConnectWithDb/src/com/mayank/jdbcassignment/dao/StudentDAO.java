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
		try {
			String query = "INSERT INTO student(name, age, branch) values (?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, student.getBranch());

			int rowAffected = preparedStatement.executeUpdate();
			if (rowAffected > 0) {
				System.out.println("Student Data Added Successfully...");
				return;
			}
			System.out.println("Student Data Added Failed!!");

		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public void viewAllStudentDataWithCourse(Connection connection) {
		System.out.println("________________________________");

		String query = "SELECT s.id, s.name, " + "COUNT(r.course_name) AS total_courses, "
				+ "GROUP_CONCAT(r.course_name SEPARATOR ', ') AS courses " + "FROM student s "
				+ "LEFT JOIN registration r ON s.id = r.student_id " + "GROUP BY s.id, s.name";

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
		try {
			String query = "select s.age as ages, s.name as name, r.course_name as course_name, s.branch as branch, r.fees_paid as fee"
					+ " from student s join registration r on s.id = r.student_id where s.id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.next()) {
				System.out.println("Student Not Found Or Not Enrolled in any Course!!!");
				return;
			}

			do {
				String name = resultSet.getString("name");
				String branch = resultSet.getString("branch");
				int age = resultSet.getInt("ages");
				String course_name = resultSet.getString("course_name");
				double fee = resultSet.getDouble("fee");

				System.out.println("| " + id + " | " + name + " | " + age + " | " + branch + " | " + course_name + " | "
						+ fee + " | ");

			} while (resultSet.next());

		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public Student getStudentById(Connection connection, int id) {
		Student student = null;
		try {
			String query = "select * from student where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String name = resultSet.getString("name");
				String branch = resultSet.getString("branch");
				int age = resultSet.getInt("age");
				student = new Student(id, name, age, branch);
//				System.out.println("| " + id + " | " + name + " | " + age + " | " + branch + " | ");
				return student;
			}
			System.out.println("Student Not Found!!!");

		} catch (SQLException e) {
			e.getMessage();
		}
		return student;
	}

	public void updateStudentDetails(Connection connection, int id, Student student) {
		try {
			String query = "Update student set name = ?, age = ?, branch = ? where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, student.getBranch());
			preparedStatement.setInt(4, id);

			int rowAffected = preparedStatement.executeUpdate();
			if (rowAffected > 0) {
				System.out.println("Student Data Updated Successfully...");
				return;
			}
			System.out.println("Student Data Updated Failed!!");

		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public void deleteStudentDetails(Connection connection, int id) {
		try {
			connection.setAutoCommit(false);

			Student student = getStudentById(connection, id);
			if (student == null) {
				System.out.println("Student not Found!!!");
				connection.rollback();
				return;
			}

			String query2 = "delete from registration where student_id = ?";
			PreparedStatement ps2 = connection.prepareStatement(query2);
			ps2.setInt(1, id);
			ps2.executeUpdate();

			String query1 = "delete from student where id = ?";
			PreparedStatement ps1 = connection.prepareStatement(query1);
			ps1.setInt(1, id);
			int rowAffected1 = ps1.executeUpdate();

			if (rowAffected1 > 0) {
				connection.commit();
				System.out.println("Student Data Deleted Successfully...");
			} else {
				connection.rollback();
				System.out.println("Delete failed!");
			}

		} catch (Exception e) {
			try {
				if (connection != null) {
					connection.rollback();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.setAutoCommit(true);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
