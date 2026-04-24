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
				System.out.println("Student Not Found!!!");
				connection.rollback();
				return;
			}

			List<Registration> list = getStudentCourseDetails(connection, studentId);
			for (Registration r : list) {
				if (r.getCourseName().equalsIgnoreCase(registration.getCourseName())) {
					System.out.println("Don't add Duplicate course.");
					connection.rollback();
					return;
				}
			}

			String query = "insert into registration(student_id, course_name, fees_paid) values (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, registration.getCourseName());
			preparedStatement.setDouble(3, registration.getFeesPaid());

			int rowAffected = preparedStatement.executeUpdate();

			if (rowAffected > 0) {
				System.out.println(
						"Student " + student.getName() + " is Register for Course " + registration.getCourseName());
				connection.commit();
				return;
			}
			System.out.println("Student Not registered for the Course.");
			connection.rollback();

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.getMessage();
		}
	}

	public void updateCourseFee(Connection connection, int studentId, Registration registration) {
		Student student = new StudentDAO().getStudentById(connection, studentId);
		if (student == null) {
			System.out.println("Student Not Found!!!");
			return;
		}

		try {
			String query = "update registration set fees_paid = ? where reg_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDouble(1, registration.getFeesPaid());
			preparedStatement.setInt(2, registration.getRegId());

			int rowAffected = preparedStatement.executeUpdate();

			if (rowAffected > 0) {
				System.out.println("Student " + student.getName() + " fee updated Successfully.");
				return;
			}
			System.out.println("Student fee not Updated.");

		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public void cancelStudentRegistration(Connection connection, int regId, int studentId) {
		Student student = new StudentDAO().getStudentById(connection, studentId);
		if (student == null) {
			System.out.println("Student Not Found!!!");
			return;
		}

		List<Registration> list = getStudentCourseDetails(connection, studentId);
		boolean found = false;
		for (Registration r : list) {
			if (r.getRegId() == regId) {
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("Student Not Enrolled in this Course!!!");
			return;
		}

		try {
			String query = "delete from registration where reg_id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, regId);

			int rowAffected = ps.executeUpdate();

			if (rowAffected > 0) {
				System.out.println("Student " + student.getName() + " registration cancelled successfully.");
			} else {
				System.out.println("Cancellation failed!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void highPayingStudentDetail(Connection connection) {
		try {
			int studentId = 0;
			int maxFeePaid = 0;
			String name = "";
			String query1 = "select count(*), sum(fees_paid) as sss, student_id "
					+ "from registration group by student_id order by sss desc limit 1";

			PreparedStatement preparedStatement1 = connection.prepareStatement(query1);

			ResultSet resultSet1 = preparedStatement1.executeQuery();

			if (resultSet1.next()) {
				maxFeePaid = resultSet1.getInt("sss");
				studentId = resultSet1.getInt("student_id");
			}

			String query2 = "select name from student where id = ?";

			PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
			preparedStatement2.setInt(1, studentId);

			ResultSet resultSet2 = preparedStatement2.executeQuery();

			if (resultSet2.next()) {
				name = resultSet2.getString("name");
			}

			if (studentId == 0 || maxFeePaid == 0 || name == null || name.trim().isEmpty()) {
				System.out.println("Something Went Wrong!!!");
				return;
			}

			System.out.println("Student " + name + " has Paid Maximum Fees " + maxFeePaid);
		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public void countStudentCourseWise(Connection connection) {
		String query = " select r.course_name as cn, count(*) as cc from student s join registration r on s.id = r.student_id group by r.course_name";

		try (PreparedStatement ps = connection.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				int count = rs.getInt("cc");
				String courses = rs.getString("cn");

				if (courses == null) {
					courses = "No Course";
				}

				System.out.println("| " + courses + " | " + count + " |");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Registration> getStudentCourseDetails(Connection connection, int studentId) {
		List<Registration> list = new ArrayList<Registration>();
		try {
			String query = "select reg_id, student_id, course_name, fees_paid from registration where student_id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, studentId);

			ResultSet resultSet2 = preparedStatement.executeQuery();

			while (resultSet2.next()) {
				int id = resultSet2.getInt("student_id");
				int reg_id = resultSet2.getInt("reg_id");
				String c_name = resultSet2.getString("course_name");
				double fee = resultSet2.getDouble("fees_paid");
				list.add(new Registration(reg_id, id, c_name, fee));
			}
		} catch (SQLException e) {
			e.getMessage();
		}
		return list;
	}
}
