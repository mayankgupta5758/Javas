package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static final String url = "jdbc:mysql://localhost:3306/student_course_db";
	private static final String user = "root";
	private static final String password = "mayank@12";
	
	public static Connection conncetToDataBase() {
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected Successfully...");
			return connection;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
