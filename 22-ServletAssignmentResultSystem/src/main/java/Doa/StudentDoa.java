package Doa;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import DbUtils.Utils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import resultPortal.Student;

public class StudentDoa {
	Utils utils = new Utils();

	public void addStudent(Student student) {
		Utils utils = new Utils();
		Connection connection;
		try {
			connection = utils.conncetToDataBase();

			System.out.println(connection + "poiuytrewqasdfghjkl,mnbvcx");

			String query = "INSERT INTO student_result (name, rollno, marks1, marks2, marks3) "
					+ "VALUES (?, ?, ?, ?, ?)";

			try {
				PreparedStatement preparedStatement = connection.prepareStatement(query);

				preparedStatement.setString(1, student.getName());
				preparedStatement.setInt(2, student.getRollno());
				preparedStatement.setInt(3, student.getMarks1());
				preparedStatement.setInt(4, student.getMarks2());
				preparedStatement.setInt(5, student.getMarks3());

				int rowsAffected = preparedStatement.executeUpdate();

				if (rowsAffected > 0) {
					System.out.println("Data Inserted Successfully!");
				} else {
					System.out.println("Data Not Inserted!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showAllStudentResult(HttpServletRequest req, HttpServletResponse resp) {

		Connection connection;
		try {
			connection = utils.conncetToDataBase();

			String query = "select * from student_result";

			try {
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet resultSet = preparedStatement.executeQuery();

				List<Student> list = new ArrayList<>();

				while (resultSet.next()) {
					Student s = new Student();

					s.setName(resultSet.getString("name"));
					s.setRollno(resultSet.getInt("rollno"));
					s.setMarks1(resultSet.getInt("marks1"));
					s.setMarks2(resultSet.getInt("marks2"));
					s.setMarks3(resultSet.getInt("marks3"));

					list.add(s);
				}

				req.setAttribute("studentList", list);
				RequestDispatcher rd = req.getRequestDispatcher("show.jsp");
				try {
					rd.forward(req, resp);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateStudentDetails(Student student) {
		String query = "update student_result set marks1 = ?, marks2 = ?, marks3 = ? where rollno = ?";

		Connection connection = null;
		try {
			connection = utils.conncetToDataBase();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			int rowAffected = preparedStatement.executeUpdate();

			if (rowAffected > 0) {
				System.out.println("Data Updated Successfully.");
				return;
			}
			System.out.println("Data Not Updated.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteStudentDetails(Student student) {
		String query = "delete from student_result where rollno = ?";

		Connection connection = null;
		try {
			connection = utils.conncetToDataBase();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			int rowAffected = preparedStatement.executeUpdate();

			if (rowAffected > 0) {
				System.out.println("Data Deleted Successfully.");
				return;
			}
			System.out.println("Data Not Deleted.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
