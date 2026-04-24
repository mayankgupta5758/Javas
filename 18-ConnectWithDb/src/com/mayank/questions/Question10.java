package com.mayank.questions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Question10 {
//	Delete a student record using their id.
	
	public static void main(String[] args) {
		try {
			ConnectionToDb connectionToDb = new ConnectionToDb();
			Connection connection = connectionToDb.conncetToDataBase();

			String query = "delete from student where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 1);
			
			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println("Rows Affected: " + rowsAffected);
			
			connectionToDb.printTableData();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
