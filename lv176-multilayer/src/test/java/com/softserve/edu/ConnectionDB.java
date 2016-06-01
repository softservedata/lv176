package com.softserve.edu;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionDB {

	private static Connection conection = null;

	public static Connection getConnection() throws SQLException {
		if (conection == null) {
			synchronized (ConnectionDB.class) {
				if (conection == null) {
					conection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/registrator_db",
							"root", "root");

				}
			}
		}

		return conection;
	}

}
