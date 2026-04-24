
public class Intro {
	/*
	 * What Is JDBC and JDBC Drivers
	 * 
	 * JDBC (Java Database Connectivity) is a Java API for connecting and
	 * interacting with databases. JDBC drivers are software components that provide
	 * the necessary functionality to connect Java applications to different types
	 * of databases.
	 * 
	 * There are four types of JDBC drivers:
	 * 
	 * 1. Type 1: JDBC-ODBC Bridge Driver -> sabse purana hai outdated ho chuka hai
	 * c me likha hai. performance or scalability issue hai.
	 * 
	 * 2. Type 2: Native-API Partly Java Driver -> ye vendor provide kerta hai like
	 * mysql, orcale, posgresql.jiski api hogi uska hi db use kerna padega.
	 * 
	 * 3. Type 3: Network Protocol Pure Java Driver -> middleware hote hote hai usme
	 * convert kerta hai api call ko.
	 * 
	 * 4. Type 4: Thin Driver (also known as the Direct to Database Pure Java
	 * Driver)-> direct api call ko convert kerta hai db me.
	 * 
	 * Each type of driver has its own advantages and is suitable for different
	 * scenarios.
	 * 
	 * JDBC Components In addition to the JDBC drivers, there are several other
	 * components that make up the JDBC API, including:
	 * 
	 * . DriverManager Class
	 * 
	 * · Connection interface
	 * 
	 * . Statement and PreparedStatement interfaces
	 * 
	 * . ResultSet interface
	 * 
	 * These components work together to provide a powerful and flexible API for
	 * working with databases in Java.
	 * 
	 * Program Flow 1. Connect your IDE With Database using necessary Connector 2.
	 * Load Necessary Drivers 3. Create Connection 4. Create Statement 5. Execute
	 * Query
	 * 
	 * 
	 * String query = String.
	 * format("INSERT INTO student (studentid, rollnumber, name, age, percentage) "
	 * + "VALUES (%d, %d, '%s', %d, %.2f)", studentid, rollnumber, name, age,
	 * percentage); agar ye hum bar bar chalenga to Statement interface me ye dikat
	 * hogi ki bar-bar java and sql dono bar basr complie karenga is se bach ne ke
	 * liya hum PreparedStatement ka use kerta hai.
	 */
}
