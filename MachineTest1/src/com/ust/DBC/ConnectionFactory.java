package com.ust.DBC;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionFactory {
/*
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";

	// Database credentials
	static final String USER = "system";
	static final String PASS = "faith";
*/
	
	static Connection connection = null;
	
	public static Properties loadPropertiesFile() throws Exception {

		Properties prop = new Properties();
		prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties"));
		
		//InputStream in = new FileInputStream("E:\\DemoServletWebApp\\DemoThreeTierServletApp\\src\\jdbc.properties");
		//InputStream in = new FileInputStream("src/jdbc.properties");
		//prop.load(in);
		//in.close();
		
		return prop;
	}

	public static Connection getConnection() throws Exception {
		try {
			
			//Load Properties File
			Properties prop = loadPropertiesFile();
			
			String driverClass = prop.getProperty("ORACLEJDBC.JDBC_DRIVER");
			String url = prop.getProperty("ORACLEJDBC.DB_URL");
			String username = prop.getProperty("ORACLEJDBC.USER");
			String password = prop.getProperty("ORACLEJDBC.PASS");
			
			// STEP 2: Register JDBC driver
			Class.forName(driverClass);
			// DriverManager.registerDriver(new Driver());
	
			return DriverManager.getConnection(url, username, password);
			
		} catch (SQLException ex) {
			throw new RuntimeException("Error connecting to the database", ex);
		}
	}

	
	
	
	
	/**
	 * Test Connection
	 * 
	 * @throws Exception
	 */
/*
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		connection = ConnectionFactory.getConnection();
		System.out.println("Connected to database");
	}	
*/
		/*
		
		// STEP 4: Creating statement
		System.out.println("Creating statement...");
		Statement stmt = connection.createStatement();

		// STEP 5: Execute a query
		System.out.println("Executing Query...");
		String sql;
		sql = "SELECT First_Name FROM Employees where Employee_ID=43";
		ResultSet rs = stmt.executeQuery(sql);

		// STEP 6: Processing Result set
		// System.out.print(String.format("\033[H\033[2J"));
		System.out.println("Processing Result set...");

		rs.next();
		String fName = rs.getString("First_Name");
		System.out.print("First Name: " + fName + "\n");
		
		*/
	

}
