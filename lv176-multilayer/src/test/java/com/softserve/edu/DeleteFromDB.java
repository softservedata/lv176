package com.softserve.edu;

import java.sql.SQLException;

import com.softserve.edu.rs.data.users.IUser;

public class DeleteFromDB {
	
	    private static final String REGISTRATION_NUMBER_OF_THE_RESOURCE_OF_USER = "DELETE FROM registration_number_of_the_resource WHERE user_id = (SELECT address.user_id FROM address  LEFT JOIN users on users.user_id = address.user_id WHERE users.login = '%s')";
		private static final String ADDRESS_OF_USER = "DELETE FROM address WHERE user_id = (SELECT passport_data.user_id FROM passport_data  LEFT JOIN users  on users.user_id = passport_data.user_id WHERE users.login = '%s')";
		private static final String PASSPORT_DATA_OF_USER = "DELETE FROM passport_data WHERE user_id = (SELECT tomes.registrator_id FROM tomes  LEFT JOIN users  on users.user_id = tomes.registrator_id WHERE users.login = '%s');";
		private static final String TOMES_OF_USER = "DELETE FROM tomes WHERE registrator_id = (SELECT users.user_id FROM users  WHERE login = '%s')";
		private static final String USER = "DELETE FROM users WHERE login = '%s'";
	
		public static void deleteUser(IUser user)  {
			
			try {
			
			ConnectionDB.getConnection().createStatement().execute(String.format(REGISTRATION_NUMBER_OF_THE_RESOURCE_OF_USER,user.getAccount().getLogin()));
			ConnectionDB.getConnection().createStatement().execute(String.format(ADDRESS_OF_USER,user.getAccount().getLogin()));
			ConnectionDB.getConnection().createStatement().execute(String.format(PASSPORT_DATA_OF_USER,user.getAccount().getLogin()));
			ConnectionDB.getConnection().createStatement().execute(String.format(TOMES_OF_USER,user.getAccount().getLogin()));
			ConnectionDB.getConnection().createStatement().execute(String.format(USER,user.getAccount().getLogin()));
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

}
