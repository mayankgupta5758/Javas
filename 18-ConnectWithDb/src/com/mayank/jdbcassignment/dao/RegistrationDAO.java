package com.mayank.jdbcassignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mayank.jdbcassignment.model.Registration;
import com.mayank.jdbcassignment.model.Student;

public class RegistrationDAO {

	public void addCourse(Connection connection, int studentId, Registration registration) {
		try {
			connection.setAutoCommit(false);

			Student student = new StudentDAO().getStudentById(connection, studentId);
			if (student == null) {
				System.out.println("Student Not Found!");
				connection.rollback();
				return;
			}

			String checkQuery = "SELECT * FROM registration WHERE student_id = ? AND c_id = ?";
			try (PreparedStatement checkPs = connection.prepareStatement(checkQuery)) {
				checkPs.setInt(1, studentId);
				checkPs.setInt(2, registration.getCourseId());

				ResultSet rs = checkPs.executeQuery();
				if (rs.next()) {
					System.out.println("Course already registered!");
					connection.rollback();
					return;
				}
			}

			String insertQuery = "INSERT INTO registration(student_id, c_id, fees_paid) VALUES (?, ?, ?)";
			try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
				ps.setInt(1, studentId);
				ps.setInt(2, registration.getCourseId());
				ps.setDouble(3, registration.getFeesPaid());

				int rows = ps.executeUpdate();
				if (rows > 0) {
					connection.commit();
					System.out.println("Course Registered Successfully");
				} else {
					connection.rollback();
					System.out.println("Registration Failed");
				}
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

	public void updateCourseFee(Connection connection, int studentId, Registration registration) {
		try {
			Student student = new StudentDAO().getStudentById(connection, studentId);
			if (student == null) {
				System.out.println("Student Not Found!");
				return;
			}

			String query = "UPDATE registration SET fees_paid = ? WHERE reg_id = ? AND student_id = ?";
			try (PreparedStatement ps = connection.prepareStatement(query)) {
				ps.setDouble(1, registration.getFeesPaid());
				ps.setInt(2, registration.getRegId());
				ps.setInt(3, studentId);

				int rows = ps.executeUpdate();
				if (rows > 0) {
					System.out.println("Fee updated for " + student.getName());
				} else {
					System.out.println("Invalid Registration ID or Student mismatch!");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void cancelStudentRegistration(Connection connection, int regId, int studentId) {
		try {
			Student student = new StudentDAO().getStudentById(connection, studentId);
			if (student == null) {
				System.out.println("Student Not Found!");
				return;
			}

			String query = "DELETE FROM registration WHERE reg_id = ? AND student_id = ?";

			try (PreparedStatement ps = connection.prepareStatement(query)) {
				ps.setInt(1, regId);
				ps.setInt(2, studentId);

				int rows = ps.executeUpdate();
				if (rows > 0) {
					System.out.println("Registration cancelled for " + student.getName());
				} else {
					System.out.println("Invalid reg_id or student mismatch!");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void highPayingStudentDetail(Connection connection) {
		String query = "SELECT s.id, s.name, SUM(r.fees_paid) AS total_fee " + "FROM student s "
				+ "JOIN registration r ON s.id = r.student_id " + "GROUP BY s.id, s.name " + "ORDER BY total_fee DESC "
				+ "LIMIT 1";

		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
			if (rs.next()) {
				String name = rs.getString("name");
				double totalFee = rs.getDouble("total_fee");
				System.out.println("Student " + name + " has Paid Maximum Fees: " + totalFee);
			} else {
				System.out.println("No registration data found!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void countStudentCourseWise(Connection connection) {
		String query = "SELECT c.c_name AS course_name, COUNT(r.student_id) AS total_students " + "FROM courses c "
				+ "LEFT JOIN registration r ON c.c_id = r.c_id " + "GROUP BY c.c_id, c.c_name";

		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				String course = rs.getString("course_name");
				int count = rs.getInt("total_students");
				System.out.println("| " + course + " | " + count + " |");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Registration> getStudentCourseDetails(Connection connection, int studentId) {
		List<Registration> list = new ArrayList<>();
		String query = "SELECT reg_id, student_id, c_id, fees_paid FROM registration WHERE student_id = ?";
		try (PreparedStatement ps = connection.prepareStatement(query)) {
			ps.setInt(1, studentId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int regId = rs.getInt("reg_id");
				int sid = rs.getInt("student_id");
				int cId = rs.getInt("c_id");
				double fee = rs.getDouble("fees_paid");

				list.add(new Registration(regId, sid, cId, fee));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
