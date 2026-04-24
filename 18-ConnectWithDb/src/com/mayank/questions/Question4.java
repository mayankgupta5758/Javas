package com.mayank.questions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Question4 {
//	Fetch and display a student record based on a given id.

	public static void main(String[] args) {
		try {
			ConnectionToDb connectionToDb = new ConnectionToDb();
			Connection connection = connectionToDb.conncetToDataBase();

			String query = "Select * from student where id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 2);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String branch = resultSet.getString("branch");
				int marks = resultSet.getInt("marks");

				System.out.println("| " + id + " | " + name + " | " + age + " | " + branch + " | " + marks + " |");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
