package ar.edu.itba.it.paw.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseManager {
	
	private static DatabaseManager databasemanager = null;

	protected DatabaseManager() {
		
	}

	public static DatabaseManager getInstance() {
		if(databasemanager == null) {
			databasemanager = new DatabaseManager();
		}
		return databasemanager;
	}
	
	public Connection getConnection(){
		
		Connection connection=null;
		
		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");
 
		try {
 
			Class.forName("org.postgresql.Driver");
 
		} catch (ClassNotFoundException e) {
 
			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return null;
 
		}
 
		System.out.println("PostgreSQL JDBC Driver Registered!");
 
 
		try {
 
			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/hotelapp", "valserber",
					"valepos");
 
		} catch (SQLException e) {
 
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
 
		}
 
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		return connection;
	}
	
	public ResultSet executeQuery(String query){
		DatabaseManager dbm = DatabaseManager.getInstance();
		ResultSet cursor=null;
		Statement stm=null;
		Connection connection = dbm.getConnection();
		try {
			stm= connection.createStatement();
			if(stm.execute(query)){
				cursor= stm.executeQuery(query);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cursor;
	}
	
	
	public void closeConnection(Connection connection, Statement stm){
		try {
			connection.commit();
			stm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
