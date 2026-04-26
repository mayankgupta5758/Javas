package com.mayank.jdbcassignment.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnecter {

	private static final String url = "jdbc:mysql://localhost:3306/again";
	private static final String user = "root";
	private static final String password = "mayank@12";

	public static Connection conncetToDataBase() {
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected Successfully...");
			return connection;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static void printTableData() {
		System.out.println("________________________________");
		try {
			Connection connection = conncetToDataBase();
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
			e.getMessage();
		}
		System.out.println("_________________________________");
	}
}
