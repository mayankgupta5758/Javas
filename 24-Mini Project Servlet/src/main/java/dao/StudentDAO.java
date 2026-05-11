package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import util.DBConnection;

public class StudentDAO {

	private Connection connection = DBConnection.conncetToDataBase();

	public boolean addStudent(Student student) {
		String query = "insert into student(s_name, email, phone, age, city) values (?,?,?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, student.getsName());
			preparedStatement.setString(2, student.getEmail());
			preparedStatement.setString(3, student.getPhone());
			preparedStatement.setInt(4, student.getAge());
			preparedStatement.setString(5, student.getCity());

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

	public List<Student> seeAllStudent() {
		String query = "select * from student";
		List<Student> list = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int s_id = resultSet.getInt("s_id");
				String name = resultSet.getString("s_name");
				String email = resultSet.getString("email");
				int age = resultSet.getInt("age");
				String city = resultSet.getString("city");
				String phone = resultSet.getString("phone");

				list.add(new Student(s_id, name, email, phone, age, city));
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Student getStudentById(int id) {
		String query = "select * from student where s_id = ?";
		Student student = null;

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int s_id = resultSet.getInt("s_id");
				String name = resultSet.getString("s_name");
				String email = resultSet.getString("email");
				int age = resultSet.getInt("age");
				String city = resultSet.getString("city");
				String phone = resultSet.getString("phone");

				student = new Student(s_id, name, email, phone, age, city);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	public boolean updateStudent(Student student) {
		String query = "update student set s_name=?, email=?, age=?, city=?, phone=? where s_id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, student.getsName());
			preparedStatement.setString(2, student.getEmail());
			preparedStatement.setInt(3, student.getAge());
			preparedStatement.setString(4, student.getCity());
			preparedStatement.setString(5, student.getPhone());
			preparedStatement.setInt(6, student.getsId());
			
			int rowAffected = preparedStatement.executeUpdate();
			
			if(rowAffected > 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteStudent(int id) {
		String query = "delete from student where s_id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			
			int rowAffected = preparedStatement.executeUpdate();
			
			if(rowAffected > 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
