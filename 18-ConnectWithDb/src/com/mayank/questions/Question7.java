package com.mayank.questions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Question7 {
//	Update the name of a student using their id.

	public static void main(String[] args) {
		try {
			ConnectionToDb connectionToDb = new ConnectionToDb();
			Connection connection = connectionToDb.conncetToDataBase();

			String query = "update student set name = ? where id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "Redmi");
			preparedStatement.setInt(2, 10);
			
			int rowsAffected = preparedStatement.executeUpdate();
			System.out.println("Rows Affected: " + rowsAffected);
			
			connectionToDb.printTableData();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
