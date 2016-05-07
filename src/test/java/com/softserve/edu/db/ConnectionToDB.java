package com.softserve.edu.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDB {
	private static final String URL_TO_DB = "jdbc:mysql://localhost:3306/registrator_db";
	private static final String LOGIN_TO_DB = "root";
	private static final String PASSWORD_TO_DB = "root";
	private static volatile Connection instanceConnection = null;

	public static Connection getConnection() throws SQLException {
		if (instanceConnection == null) {
			synchronized (ConnectionToDB.class) {
				if (instanceConnection == null) {
					instanceConnection = DriverManager.getConnection(URL_TO_DB, LOGIN_TO_DB, PASSWORD_TO_DB);
				}
			}
		}
		return instanceConnection;
	}
}
