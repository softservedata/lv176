package com.softserve.edu.rs.tests;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.sql.Connection;

public class JDBC_Exper {

	public static void main(String[] args) {
		Connection cn = null;
		ResultSet rs = null;
		try {
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/registrator_db", "root", "root");
			Statement st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM list_of_resouces");
			Map<Integer, String> res = new HashMap<>();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(3);
				res.put(id, name);
			}
			if (res.size() > 0) {
				System.out.println(res);
			} else {
				System.out.println("Not found");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
