package com.softserve.edu.rs.utils;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.sql.Connection;

public class JDBC_Exper {

	public static void main(String[] args) {
		Connection cn = null;
		ResultSet rs = null;
		Object[][] res1=new Object[][] { {
			new ArrayList<ResourceBrief>(Arrays.asList(
					new ResourceBrief("PlotC", "земельний", "123:44:35:445:34567:3459", new Date(2016, 04, 13)),
					new ResourceBrief("ДілянкаА", "земельний", "123:66:99:678:78868:1235", new Date(2016, 03, 15)),
					new ResourceBrief("ДілянкаБ", "земельний", "123:44:35:445:34567:3457", new Date(2016, 03, 16)),
					new ResourceBrief("ДілянкаВ", "земельний", "123:66:99:678:78868:3100", new Date(2016, 05, 15)),
					new ResourceBrief("ДілянкаВ", "земельний", "123:66:99:678:78868:3101", new Date(2016, 05, 15)),
					new ResourceBrief("ДілянкаВ", "земельний", "123:66:99:678:78868:3103", new Date(2016, 05, 15)),
					new ResourceBrief("ДілянкаВ", "земельний", "123:66:99:678:78868:3100", new Date(2016, 05, 15)),
					new ResourceBrief("ДілянкаЕ", "земельний", "123:44:35:445:34567:1380", new Date(2016, 05, 24)),
					new ResourceBrief("ДілянкаК", "земельний", "123:44:35:445:34567:1321", new Date(2016, 05, 24)),
					new ResourceBrief("ДілянкаМ", "земельний", "123:66:99:678:78868:1123", new Date(2016, 05, 24)),
					new ResourceBrief("ДілянкаН", "земельний", "123:44:35:445:34567:1096",
							new Date(2016, 05, 24)),
			new ResourceBrief("ділянкаП", "земельний", "123:66:99:678:78868:1222", new Date(2016, 05, 24)),
			new ResourceBrief("ДілянкаР", "земельний", "123:44:35:445:34567:2133", new Date(2016, 05, 24)),
			new ResourceBrief("ДілянкаУ", "земельний", "123:44:35:445:34567:1290", new Date(2016, 05, 24)),
			new ResourceBrief("ДіілянкаО", "земельний", "123:44:35:445:34567:1100", new Date(2016, 05, 24)),
			new ResourceBrief("ЧастотаММ", "радіочастотний", "123:33:33:333:33333:2222",
					new Date(2016, 04, 13)))) } };
					System.out.println(res1[0][0]);
					System.out.println(res1[0].length);
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
