package com.softserve.edu.rs.data.users;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.atqc.data.CSVUtils;
import com.softserve.edu.atqc.data.IExternalData;

public final class UserUtils {
	private String filename;
	private IExternalData externalData;

	public UserUtils() {
		filename = "/users.csv";
		externalData = new CSVUtils();
	}

	public UserUtils(String filename, IExternalData externalData) {
		this.filename = filename;
		this.externalData = externalData;
	}

	public List<IUser> getAllUsers() {
		return getAllUsers(this.getClass().getResource(filename).getPath().substring(1));
	}

	public List<IUser> getAllUsers(String absoluteFilePath) {
		List<IUser> users = new ArrayList<IUser>();
		for (List<String> row : externalData.getAllCells(absoluteFilePath)) {
			if (row.get(4).toLowerCase().contains("phonenumber")
					|| row.get(10).toLowerCase().contains("data")) {
				continue;
			}
			users.add(
					User.get()
					.setPerson(Person.get()
									.setFirstname(row.get(0))
									.setLastname(row.get(1))
									.setEmail(row.get(2))
									.build()
									.setMiddlename(row.get(3))
									.setPhonenumber(row.get(4))
							)
					.setAccount(Account.get()
									.setLogin(row.get(5))
									.setPassword(row.get(6))
									.setRole(row.get(7))
									.setStatus(row.get(8))
									.setCommunity(row.get(9))
									.build()
									.setData(row.get(10))
									.setRegisterNumber(row.get(11))
									.setRegistratorNumber(row.get(12))
									.setVolumeNumber(row.get(13))
							)
					.build()
					.setAddress(Address.get()
							.setRegion(row.get(14))
							.setDistrict(row.get(15))
							.setCity(row.get(16))
							.setStreet(row.get(17))
							.setBuilding(row.get(18))
							.setFlat(row.get(19))
							.setPostcode(row.get(20))
							)
					.setPassport(Passport.get()
							.setSeria(row.get(21))
							.setNumber(row.get(22))
							.setPublished(row.get(23))
							)
					);
		}
		return users;
	}

}
