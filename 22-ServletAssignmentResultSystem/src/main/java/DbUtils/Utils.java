package DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {
	
	private static final String url = "jdbc:mysql://localhost:3306/result";
	private static final String user = "root";
	private static final String password = "mayank@12";
	
	public Connection conncetToDataBase() throws ClassNotFoundException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected Successfully...");
			return connection;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
