package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Registration;
import util.DBConnection;

public class RegistrationDAO {

	private Connection connection = DBConnection.conncetToDataBase();

	public boolean addRegistration(Registration registration) {
		String query = "insert into registration(student_id, course_id, registration_date, status) values(?,?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, registration.getStudentId());
			preparedStatement.setInt(2, registration.getCourseId());
			preparedStatement.setDate(3, registration.getRegistrationDate());
			preparedStatement.setString(4, registration.getStatus());

			int rowAffected = preparedStatement.executeUpdate();
			return rowAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Registration> seeAllRegistration() {
		String query = "select * from registration";
		List<Registration> list = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int r_id = resultSet.getInt("registration_id");
				int s_id = resultSet.getInt("student_id");
				int c_id = resultSet.getInt("course_id");
				Date date = resultSet.getDate("registration_date");
				String status = resultSet.getString("status");

				list.add(new Registration(r_id, s_id, c_id, date, status));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public String getNameByStudentId(int id) {
		String query = "select s_name from student where s_id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return resultSet.getString("s_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getNameByCourseId(int id) {
		String query = "select c_name from course where c_id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				return resultSet.getString("c_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

	public Registration getRegistrationById(int id) {
		String query = "select * from registration where registration_id=?";
		Registration registration = null;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int r_id = resultSet.getInt("registration_id");
				int s_id = resultSet.getInt("student_id");
				int c_id = resultSet.getInt("course_id");
				Date date = resultSet.getDate("registration_date");
				String status = resultSet.getString("status");

				registration = new Registration(r_id, s_id, c_id, date, status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registration;
	}

	public boolean updateRegistration(Registration registration) {
		String query = "update registration set student_id=?, course_id=?, registration_date=?, status=? where registration_id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, registration.getStudentId());
			preparedStatement.setInt(2, registration.getCourseId());
			preparedStatement.setDate(3, registration.getRegistrationDate());
			preparedStatement.setString(4, registration.getStatus());
			preparedStatement.setInt(5, registration.getRegistrationId());

			int rowAffected = preparedStatement.executeUpdate();
			return rowAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteRegistration(int id) {
		String query = "delete from registration where registration_id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);

			int rowAffected = preparedStatement.executeUpdate();
			if (rowAffected > 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public int totalNumberOfRegistration() {
		String query = "select count(*) as c from registration";
		int totalRegistration = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalRegistration = resultSet.getInt("c");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalRegistration;
	}

	public List<Registration> filterRegistration(String studentId, String courseId, String status) {
		List<Registration> list = new ArrayList<>();
		String query = "select * from registration where 1=1";
		if (studentId != null && !studentId.isEmpty()) {
			query += " and student_id=" + studentId;
		}

		if (courseId != null && !courseId.isEmpty()) {
			query += " and course_id=" + courseId;
		}

		if (status != null && !status.isEmpty()) {
			query += " and status='" + status + "'";
		}

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Registration(rs.getInt("registration_id"), rs.getInt("student_id"), rs.getInt("course_id"),
						rs.getDate("registration_date"), rs.getString("status")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean alreadyRegistered(int studentId, int courseId, String status) {
		String query = "select * from registration where student_id=? and course_id=? and status = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, studentId);
			ps.setInt(2, courseId);
			ps.setString(3, status);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean alreadyRegisteredForUpdate(int registrationId, int studentId, int courseId) {
		String query = "select * from registration " + "where student_id=? and course_id=? "
				+ "and registration_id != ?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, studentId);
			ps.setInt(2, courseId);
			ps.setInt(3, registrationId);

			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}