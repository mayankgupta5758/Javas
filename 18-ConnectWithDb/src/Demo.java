import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo {
	public static void printTable(Connection con) {
		try {
//             3. Create Statement
			Statement stmt = con.createStatement();

			// 4. Execute Query
			ResultSet rs = stmt.executeQuery("SELECT * FROM student");

			// 5. Process Result
			while (rs.next()) {
				int id = rs.getInt("studentid");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				int rollno = rs.getInt("rollnumber");

				System.out.println(id + " | " + name + " | " + age + " | " + rollno);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertIntoTableUsingStatement(Connection con) {
		try {
			Statement stmt = con.createStatement();
			int studentid = 30;
			int rollnumber = 151;
			String name = "UnKnown";
			int age = 21;
			double percentage = 85.5;

			String query = String.format("INSERT INTO student (studentid, rollnumber, name, age, percentage) "
					+ "VALUES (%d, %d, '%s', %d, %.2f)", studentid, rollnumber, name, age, percentage);
			int rowsAffected = stmt.executeUpdate(query);

			if (rowsAffected > 0) {
				System.out.println("Data Inserted Successfully!");
			} else {
				System.out.println("Data Not Inserted!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateDataFromTableUsingStatement(Connection con) {
		try {
			Statement stmt = con.createStatement();

			String query = String.format("UPDATE student set percentage = %.2f where studentid = %d", 98.2, 30);
			int rowsAffected = stmt.executeUpdate(query);

			if (rowsAffected > 0) {
				System.out.println("Data Updated Successfully!");
			} else {
				System.out.println("Data Not Updated!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteDataFromTableUsingStatement(Connection con) {
		try {
			Statement stmt = con.createStatement();

			String query = "Delete from student where studentid = 30";
			int rowsAffected = stmt.executeUpdate(query);

			if (rowsAffected > 0) {
				System.out.println("Data Deleted Successfully!");
			} else {
				System.out.println("Data Not Deleted!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertIntoTableUsingPreparedStatement(Connection con) {
		try {
//			Statement stmt = con.createStatement();
			String query = "INSERT INTO student (studentid, rollnumber, name, age, percentage) "
					+ "VALUES (?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = con.prepareStatement(query); // yaha tak vo complie ho chuki hogi.
			preparedStatement.setInt(1, 31);
			preparedStatement.setInt(2, 190);
			preparedStatement.setString(3, "Vivo");
			preparedStatement.setInt(4, 23);
			preparedStatement.setDouble(5, 89.0);
			int rowsAffected = preparedStatement.executeUpdate(); // yaha pe execute hogi.

			if (rowsAffected > 0) {
				System.out.println("Data Inserted Successfully!");
			} else {
				System.out.println("Data Not Inserted!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void batchProcessing(Connection con) {
		try {
			String query = "INSERT INTO student (studentid, rollnumber, name, age, percentage) "
					+ "VALUES (?, ?, ?, ?, ?)";

			PreparedStatement preparedStatement = con.prepareStatement(query); // yaha tak vo complie ho chuki hogi.
			preparedStatement.setInt(1, 32);
			preparedStatement.setInt(2, 190);
			preparedStatement.setString(3, "Vivo");
			preparedStatement.setInt(4, 23);
			preparedStatement.setDouble(5, 89.0);
			preparedStatement.addBatch();

			preparedStatement.setInt(1, 33);
			preparedStatement.setInt(2, 190);
			preparedStatement.setString(3, "Oppo");
			preparedStatement.setInt(4, 23);
			preparedStatement.setDouble(5, 89.0);
			preparedStatement.addBatch();

			preparedStatement.setInt(1, 31);
			preparedStatement.setInt(2, 190);
			preparedStatement.setString(3, "Redmi");
			preparedStatement.setInt(4, 23);
			preparedStatement.setDouble(5, 89.0);
			preparedStatement.addBatch();

			int[] rowsAffected = preparedStatement.executeBatch(); // yaha pe execute hogi.
//agar succes execute hua to 1 store hoga array me nahi to 0.

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void transction(Connection connection) {
		try {
			connection.setAutoCommit(false);
			String debit_query = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
			String credit_query = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";
			PreparedStatement debitPreparedStatement = connection.prepareStatement(debit_query);
			PreparedStatement creditPreparedStatement = connection.prepareStatement(credit_query);
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Account Number: ");
			int account_number = scanner.nextInt();
			System.out.println("Enter Amount: ");
			double amount = scanner.nextDouble();
			debitPreparedStatement.setDouble(1, amount);

			debitPreparedStatement.setInt(2, 101);
			creditPreparedStatement.setDouble(1, amount);
			creditPreparedStatement.setInt(2, 102);
			debitPreparedStatement.executeUpdate();
			creditPreparedStatement.executeUpdate();
			if (isSufficient(connection, 101, amount)) {
				connection.commit();
				System.out.println("Transction Successsfully!!! ");
			} else {
				connection.rollback();
				System.out.println("Transction Failed!!!");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static boolean isSufficient(Connection connection, int account_number, double amount) {
		try {
			String query = "SELECT balance FROM accounts WHERE account_number = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, account_number);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				double current_balance = resultSet.getDouble("balance");
				if (amount > current_balance) {
					return false;
				}
				return true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "mayank@12");

			System.out.println("-----------------------------------------------------");
			System.out.println("Connected Successfully");
			System.out.println("-----------------------------------------------------");
			printTable(con);
			System.out.println("-----------------------------------------------------");
			insertIntoTableUsingPreparedStatement(con);
			System.out.println("-----------------------------------------------------");
			printTable(con);
			System.out.println("-----------------------------------------------------");
			updateDataFromTableUsingStatement(con);
			System.out.println("-----------------------------------------------------");
			printTable(con);
			System.out.println("-----------------------------------------------------");
			deleteDataFromTableUsingStatement(con);
			System.out.println("-----------------------------------------------------");
			printTable(con);
			System.out.println("-----------------------------------------------------");
			insertIntoTableUsingPreparedStatement(con);
			System.out.println("-----------------------------------------------------");
			printTable(con);
			System.out.println("-----------------------------------------------------");

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}