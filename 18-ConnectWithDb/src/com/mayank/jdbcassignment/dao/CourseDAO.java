package com.mayank.jdbcassignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.mayank.jdbcassignment.model.Course;
import com.mayank.jdbcassignment.util.InputValidation;

public class CourseDAO {

	public int getCourseId(Connection connection, Scanner scanner) {
		String query = "SELECT * FROM courses";
		List<Course> courses = new ArrayList<>();

		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("c_id");
				String name = rs.getString("c_name");

				courses.add(new Course(id, name));
				System.out.println("Id: " + id + " | Name: " + name);
			}
			int c_id;
			while (true) {
				c_id = InputValidation.getValidInt(scanner, "Enter Course ID to enroll: ");
				for (Course c : courses) {
					if (c.getC_id() == c_id) {
						return c.getC_id();
					}
				}
				System.out.println("Invalid Course ID, try again!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
