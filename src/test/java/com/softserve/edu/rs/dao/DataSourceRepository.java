package com.softserve.edu.rs.dao;

import java.sql.Driver;
import java.sql.SQLException;

import com.softserve.edu.atqc.exceptions.GeneralCustomException;

public final class DataSourceRepository {

	private final static String FAILED_JDBC_DRIVER = "Failed to Create JDBC Driver";
	private static volatile DataSourceRepository instance = null;

	private DataSourceRepository() {
	}

	public static DataSourceRepository get() {
		if (instance == null) {
			synchronized (DataSourceRepository.class) {
				if (instance == null) {
					instance = new DataSourceRepository();
				}
			}
		}
		return instance;
	}

	// TODO Demo
	public DataSource getJtdsMsSqlLocal() {
		return new DataSource(new net.sourceforge.jtds.jdbc.Driver(),
				"jdbc:jtds:sqlserver://CLASS02/Lv176;instance=SQLEXPRESS;", "db176", "db176");
	}

	// TODO Demo
	public DataSource getJtdsMsSqlSsu() {
        return new DataSource(new net.sourceforge.jtds.jdbc.Driver(),
                "jdbc:jtds:sqlserver://ssu-sql12/ssu-oms;instance=tc;", "ssu-oms", "ssu-oms");
    }
	
	public DataSource getConnectorMySqlLocalHost() {
		Driver jdbcDriver;
		try {
			jdbcDriver = new com.mysql.jdbc.Driver();
		} catch (SQLException e) {
            throw new GeneralCustomException(FAILED_JDBC_DRIVER, e);
		}
        return new DataSource(jdbcDriver,
                "jdbc:mysql://localhost:3306/registrator_db", "root", "root");
    }

}
