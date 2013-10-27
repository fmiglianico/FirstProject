package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class RestaurantDAO {

	//Static final attributes
	private static final String DB_NAME = "ortva";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";
	
	//Singleton instance
	private static RestaurantDAO instance;
	
	private Properties connectionProps = null;
	
	private RestaurantDAO() {
		connectionProps = new Properties();
		connectionProps.put("user", DB_USER);
		connectionProps.put("password", DB_PASSWORD);

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.err.println("Error in DBHandler constructor: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public Connection getConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"
					+ DB_NAME, connectionProps);
		} catch (Exception e) {
			System.err.println("Error in getConn: " + e.getMessage());
			e.printStackTrace();
		}
		return conn;
	}

	public ResultSet executeQueryRS(Connection conn, String query) {
		Statement statement = null;
		ResultSet rs = null;

		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(query);

		} catch (Exception e) {
			System.err.println("Error in executeQueryRS:" + e.getMessage());
		}
		return rs;
	}

	public boolean executeQuery(Connection conn, String query) {
		Statement statement = null;
		try {
			statement = conn.createStatement();
			statement.executeUpdate(query);
			return true;

		} catch (Exception e) {
			System.err.println("Error in executeQuery:" + e.getMessage());
		}
		return false;
	}
	
	public static RestaurantDAO getInstance() {
		if(instance == null)
			instance = new RestaurantDAO();
		return instance;
	}

}