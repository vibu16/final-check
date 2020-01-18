package com.cognizant.moviecruiser.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionHandler {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class current = ConnectionHandler.class;
			ClassLoader currentLoader = current.getClassLoader();
			InputStream input = currentLoader.getResourceAsStream("connection.properties");

			Properties prop = new Properties();
			prop.load(input);
			Class.forName(prop.getProperty("driver"));

			String url = prop.getProperty("connection-url");
			String user = prop.getProperty("user");
			String pass = prop.getProperty("password");

			con = DriverManager.getConnection(url, user, pass);

		} catch (Exception ex) {
			System.out.println(ex);
		}
		return con;
	}
}
