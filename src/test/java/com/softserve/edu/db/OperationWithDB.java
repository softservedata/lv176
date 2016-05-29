package com.softserve.edu.db;

import com.softserve.edu.atqc.loggers.LoggerUtils;
import com.softserve.edu.users.IUser;

public class OperationWithDB {
	//for active users
	private static final String DELETE_REGISTRATION_NUMBER_OF_THE_RESOURCE_OF_USER = "DELETE FROM registration_number_of_the_resource WHERE user_id = (SELECT a.user_id FROM address a LEFT JOIN users u on u.user_id = a.user_id WHERE u.login = '%s')";
	private static final String DELETE_ADDRESS_OF_USER = "DELETE FROM address WHERE user_id = (SELECT a.user_id FROM passport_data a LEFT JOIN users u on u.user_id = a.user_id WHERE u.login = '%s')";
	private static final String DELETE_PASSPORT_DATA_OF_USER = "DELETE FROM passport_data WHERE user_id = (SELECT a.registrator_id FROM tomes a LEFT JOIN users u on u.user_id = a.registrator_id WHERE u.login = '%s')";
	private static final String DELETE_TOMES_OF_USER = "DELETE FROM tomes WHERE registrator_id = (SELECT user_id FROM users  WHERE login = '%s')";
	private static final String DELETE_USER = "DELETE FROM users WHERE login = '%s'";
	//for non confirmed users
	private static final String DELETE_PASSPORT_DATA_OF_NON_CONFIRMED_USER = "DELETE FROM passport_data WHERE user_id = (SELECT a.user_id FROM address a LEFT JOIN users u on u.user_id = a.user_id WHERE u.login = '%s')";
	private static final String DELETE_ADDRESS_OF_NON_CONFIRMED_USER = "DELETE FROM address WHERE user_id = (SELECT user_id FROM users WHERE login = '%s')";
	
	public static void deleteActiveUser(IUser user) {
		try {
			ConnectionToDB.getConnection().prepareStatement(String.format(DELETE_REGISTRATION_NUMBER_OF_THE_RESOURCE_OF_USER, user.getAccount().getLogin())).executeUpdate();
			ConnectionToDB.getConnection().prepareStatement(String.format(DELETE_ADDRESS_OF_USER, user.getAccount().getLogin())).executeUpdate();
			ConnectionToDB.getConnection().prepareStatement(String.format(DELETE_PASSPORT_DATA_OF_USER, user.getAccount().getLogin())).executeUpdate();
			ConnectionToDB.getConnection().prepareStatement(String.format(DELETE_TOMES_OF_USER, user.getAccount().getLogin())).executeUpdate();
			ConnectionToDB.getConnection().prepareStatement(String.format(DELETE_USER, user.getAccount().getLogin())).executeUpdate();
		} catch (Exception e) {
			LoggerUtils.get().errorLog("Some problem with SQL query" + e.getStackTrace());
		}
	}
	
	public static void deleteNonConfirmedUser(IUser user) {
		try {
			ConnectionToDB.getConnection().prepareStatement(String.format(DELETE_PASSPORT_DATA_OF_NON_CONFIRMED_USER, user.getAccount().getLogin())).executeUpdate();
			ConnectionToDB.getConnection().prepareStatement(String.format(DELETE_ADDRESS_OF_NON_CONFIRMED_USER, user.getAccount().getLogin())).executeUpdate();
			ConnectionToDB.getConnection().prepareStatement(String.format(DELETE_USER, user.getAccount().getLogin())).executeUpdate();
		} catch (Exception e) {
			LoggerUtils.get().errorLog("Some problem with SQL query" + e.getStackTrace());
		}
	}
}
