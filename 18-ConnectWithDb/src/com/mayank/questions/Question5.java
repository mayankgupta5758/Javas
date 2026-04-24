package com.mayank.questions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Question5 {
//	Display all students whose marks are greater than a given value.

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in);) {
			
			System.out.print("Enter the marks: ");
			int marksInput = scanner.nextInt();
			
			ConnectionToDb connectionToDb = new ConnectionToDb();
			Connection connection = connectionToDb.conncetToDataBase();

			String query = "select * from student where marks > ?";

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, marksInput);
			
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
