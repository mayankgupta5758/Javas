package com.mayank.questions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Question2 {
//	Insert 5 student records using batch processing.


	public static void main(String[] args) {
		try {
			ConnectionToDb connectionToDb = new ConnectionToDb();
			Connection connection = connectionToDb.conncetToDataBase();

			String query = "Insert into student(name, age, branch, marks) values (?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, "Rahul");
	        preparedStatement.setInt(2, 20);
	        preparedStatement.setString(3, "CSE");
	        preparedStatement.setInt(4, 85);
	        preparedStatement.addBatch();

	        preparedStatement.setString(1, "Neha");
	        preparedStatement.setInt(2, 21);
	        preparedStatement.setString(3, "IT");
	        preparedStatement.setInt(4, 90);
	        preparedStatement.addBatch();

	        preparedStatement.setString(1, "Amit");
	        preparedStatement.setInt(2, 22);
	        preparedStatement.setString(3, "ECE");
	        preparedStatement.setInt(4, 75);
	        preparedStatement.addBatch();

	        preparedStatement.setString(1, "Priya");
	        preparedStatement.setInt(2, 19);
	        preparedStatement.setString(3, "ME");
	        preparedStatement.setInt(4, 80);
	        preparedStatement.addBatch();

	        preparedStatement.setString(1, "Karan");
	        preparedStatement.setInt(2, 23);
	        preparedStatement.setString(3, "Civil");
	        preparedStatement.setInt(4, 70);
	        preparedStatement.addBatch();
			
			preparedStatement.executeBatch();

			connectionToDb.printTableData();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
