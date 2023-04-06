package com.surveys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
	
	public static final String DB_URL = "jdbc:mysql://localhost:3306/socialsurveying?useSSL=false";
	public static final String DB_USER = "root"; 
	public static final String DB_PASSWORD = "0900xs0800";   

	private Connection connection;
	
	public DBConnectionManager() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}
	
	public Connection getConnection(){
		return this.connection;
	}
}