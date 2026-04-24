package com.mayank.questions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Question1 {
//	Insert a new student record into the student table.
	public static void main(String[] args) {
		try {
			ConnectionToDb connectionToDb = new ConnectionToDb();
			Connection connection = connectionToDb.conncetToDataBase();

			String query = "Insert into student(name, age, branch, marks) values (?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "Vivo");
			preparedStatement.setInt(2, 22);
			preparedStatement.setString(3, "CSE");
			preparedStatement.setInt(4, 42);
			
			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println("Rows Affected: " + rowsAffected);

			connectionToDb.printTableData();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
