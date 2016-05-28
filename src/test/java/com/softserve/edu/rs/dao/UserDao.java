package com.softserve.edu.rs.dao;

import java.sql.Date;

import com.softserve.edu.rs.entity.UserDB;
import com.softserve.edu.rs.entity.UserDB.UserDBQueries;

public class UserDao extends ADao<UserDB> {
	private static volatile UserDao instance = null;

	private UserDao() {
		super();
		init();
	}

	public static UserDao get() {
		if (instance == null) {
			synchronized (UserDao.class) {
				if (instance == null) {
					instance = new UserDao();
				}
			}
		}
		return instance;
	}

	// TODO Create abstract method in ADao
	private void init() {
		for (UserDBQueries userDBQueries : UserDBQueries.values()) {
			sqlQueries.put(userDBQueries.name(), userDBQueries);
		}
	}

	protected UserDB createInstance(String[] args) {
		return new UserDB(Long.parseLong(args[0] == null ? "0" : args[0]),
				Long.parseLong(args[1] == null ? "0" : args[1]),
				Long.parseLong(args[2] == null ? "0" : args[2]),
				Long.parseLong(args[3] == null ? "0" : args[3]),
				Long.parseLong(args[4] == null ? "0" : args[4]),
				//TODO
				//Date.valueOf(args[5] == null ? "26.05.2016" : args[5]),
				new Date(2016,5,26),
				args[6] == null ? new String() : args[6],
				Long.parseLong(args[7] == null ? "0" : args[7]),
				args[8] == null ? new String() : args[8],
				//Date.valueOf(args[9] == null ? "26.05.2016" : args[9]),
				new Date(2016,5,26),
				args[10] == null ? new String() : args[10],
				args[11] == null ? new String() : args[11],
				args[12] == null ? new String() : args[12],
				args[13] == null ? new String() : args[13],
				args[14] == null ? new String() : args[14],
				args[15] == null ? new String() : args[15],
				Long.parseLong(args[16] == null ? "0" : args[16]),
				Long.parseLong(args[17] == null ? "0" : args[17]));
	}

	protected String[] getFields(UserDB entity) {
		String[] fields = new String[10];
		fields[0] = entity.getUserId().toString();
		fields[1] = entity.getAccountNonExpired().toString();
		fields[2] = entity.getAccountNonLocked().toString();
		fields[3] = entity.getAttempts().toString();
		fields[4] = entity.getCredentialsNonExpired().toString();
		fields[5] = entity.getDateOfAccession().toString();
		fields[6] = entity.getEmail();
		fields[7] = entity.getEnabled().toString();
		fields[8] = entity.getFirstname();
		fields[9] = entity.getLastModified().toString();
		fields[10] = entity.getLastname();
		fields[11] = entity.getLogin();
		fields[12] = entity.getMiddlename();
		fields[13] = entity.getPassword();
		fields[14] = entity.getPhonenumber();
		fields[15] = entity.getStatus();
		fields[16] = entity.getRoleId().toString();
		fields[17] = entity.getTerritorialCommunityId().toString();
		return fields;
	}

	public UserDB getUserDBByLogin(String login) {
		for (UserDB userDB : getByFieldName("Login", login)) {
			System.out.println("ID = " + userDB.getId()
				+ "  getFirstname = " + userDB.getFirstname() 
				+ "  getLogin = " + userDB.getLogin()
				+ "  getTerritorialCommunityId = " + userDB.getTerritorialCommunityId());
		}
		return getByFieldName("Login", login).get(0);
	}

	// TODO DELETE Method
	// public boolean deleteById(Long id) {
	// return super.deleteById(id);
	// }

}
