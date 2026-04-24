package com.mayank.questions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Question8 {
//	Update both branch and marks of a student based on their id.

	public static void main(String[] args) {
		try {
			ConnectionToDb connectionToDb = new ConnectionToDb();
			Connection connection = connectionToDb.conncetToDataBase();

			String query = "update student set branch = ?, marks = ? where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "ME");
			preparedStatement.setInt(2, 89);
			preparedStatement.setInt(3, 7);
			
			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println("Rows Affected: " + rowsAffected);
			
			connectionToDb.printTableData();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
