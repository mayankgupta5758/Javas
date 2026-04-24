package com.mayank.questions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Question3 {
//	Display all records from the student table.

	public static void main(String[] args) {
		try {
			ConnectionToDb connectionToDb = new ConnectionToDb();
			Connection connection = connectionToDb.conncetToDataBase();

			String query = "Select * from student";

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
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
		}
	}
}
