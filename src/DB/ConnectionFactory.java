package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
public Connection getConnection() throws ClassNotFoundException, SQLException {
		
	
		String driverName = "com.mysql.cj.jdbc.Driver";
		
		String connectionURL = "jdbc:mysql://localhost/ruay";

		String username = "root";
		String password = "";	

		System.out.println("-------- MariaDB JDBC Connection Testing ------");

		try {

			Class.forName(driverName);

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your MariaDB JDBC Driver?");
			e.printStackTrace();
		}

		Connection connection = null;
		System.out.println("MariaDB JDBC Driver Registered!");

		try {

			connection = DriverManager.getConnection(connectionURL, username, password);

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		
		System.out.println("Connected to database");
		return connection;
	}
}
