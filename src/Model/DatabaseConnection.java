package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private Connection sqlConnection = null;
	private String sqlUsername = "demouser";
	private String sqlPassword = "demopassword";
	private String sqlUrl = "jdbc:mysql://localhost:3306/demo";
	
	
	public DatabaseConnection() {
		connect();
	}
	
	
	private void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (java.lang.ClassNotFoundException ex) {
			System.out.print("ClassNotFoundException: ");
			System.out.println(ex.getMessage());
		}
		try {
			sqlConnection = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
		} catch (SQLException e) {
			handleError("Error connecting to SQL server.", e);
		}
	}
	
	
	public void disconnect() {
		try {
			sqlConnection.close();
		} catch (SQLException e) {
			handleError("Error disconnecting from SQL server.", e);
		}
	}
	
	
	public Connection getConnection() {
		if (sqlConnection == null) {
			connect();
		}
		return sqlConnection;
	}
	

	public void handleError( String definition, SQLException e ) {
			System.out.println(definition);
			System.out.println("Message: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("ErrorCode: " + e.getErrorCode());
	}
	
}





