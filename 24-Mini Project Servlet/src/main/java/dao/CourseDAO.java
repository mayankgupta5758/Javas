package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Course;
import util.DBConnection;

public class CourseDAO {

	private Connection connection = DBConnection.conncetToDataBase();

	public boolean addCourse(Course course) {
		String query = "insert into course(c_name, duration, fees, trainer_name) values (?,?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, course.getcName());
			preparedStatement.setString(2, course.getDuration());
			preparedStatement.setDouble(3, course.getFees());
			preparedStatement.setString(4, course.getTrainerName());

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

	public List<Course> seeAllCourse() {
		String query = "select * from course";
		List<Course> list = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int c_id = resultSet.getInt("c_id");
				String name = resultSet.getString("c_name");
				String duration = resultSet.getString("duration");
				double fees = resultSet.getDouble("fees");
				String trainerName = resultSet.getString("trainer_name");

				list.add(new Course(c_id, name, duration, fees, trainerName));
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Course getCourseById(int id) {
		String query = "select * from course where c_id = ?";
		Course course = null;

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int c_id = resultSet.getInt("c_id");
				String name = resultSet.getString("c_name");
				String duration = resultSet.getString("duration");
				double fees = resultSet.getDouble("fees");
				String trainerName = resultSet.getString("trainer_name");

				course = new Course(c_id, name, duration, fees, trainerName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return course;
	}

	public boolean updateCourse(Course course) {
		String query = "update course set c_name=?, duration=?, fees=?, trainer_name=? where c_id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, course.getcName());
			preparedStatement.setString(2, course.getDuration());
			preparedStatement.setDouble(3, course.getFees());
			preparedStatement.setString(4, course.getTrainerName());
			preparedStatement.setInt(5, course.getcId());

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

	public String deleteCourse(int id) {
		String query = "delete from course where c_id=?";

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			int rowAffected = ps.executeUpdate();
			if (rowAffected > 0) {
				return "Course Deleted Successfully";
			}
			
			return "Failed To Delete Course";
		} catch (SQLException e) {
			return "Cannot Delete Course. Students Are Enrolled.";
		}
	}

	public int totalNumberOfCourse() {
		String query = "select count(*) as c from course";
		int totalCourse = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalCourse = resultSet.getInt("c");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalCourse;
	}
}
