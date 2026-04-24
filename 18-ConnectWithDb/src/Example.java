import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Example {
	private static final String url = "jdbc:mysql://localhost:3306/example";
	private static final String user = "root";
	private static final String password = "mayank@12";

	/*
	 * public static void printTableusingStatement(Connection con) { try { Statement
	 * stmt = con.createStatement();
	 * 
	 * ResultSet rs = stmt.executeQuery("SELECT * FROM student");
	 * 
	 * while (rs.next()) { int id = rs.getInt("id"); String name =
	 * rs.getString("name"); int age = rs.getInt("age"); String branch =
	 * rs.getString("branch"); int marks = rs.getInt("marks");
	 * 
	 * System.out.println(id + " | " + name + " | " + age + " | " + branch + " | " +
	 * marks); }
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); } }
	 */

	public static void printTableusingPreparedStatement(Connection con) {
		try {
			String query = "Select * from student";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			System.out.println("________________________________");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String branch = rs.getString("branch");
				int marks = rs.getInt("marks");
				System.out.println("| " + id + " | " + name + " | " + age + " | " + branch + " | " + marks + " |");
			}
			System.out.println("_________________________________");

		} catch (SQLException e) {
			e.getMessage();
		}
	}

	public static void main(String[] args) {

		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected Successfully...");

			printTableusingPreparedStatement(connection);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
