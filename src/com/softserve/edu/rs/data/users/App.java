package com.softserve.edu.rs.data.users;

public class App {

	public static void main(String[] args) {

		IUser user = User.get()
				.setPerson(
						Person.get()
							.setFirstname("firstname")
							.setLastname("lastname")
							.setEmail("email")
							.build()
							.setMiddlename("middlename")
						)
				.setAccount(
						Account.get()
							.setLogin("login")
							.setPassword("password")
							.setRole("")
							.setStatus("")
							.setCommunity("community")
							.build()
							.setData("data")
						)
				.build();
		((Address)(user.getAddress())).setCity("city").setDistrict("dis");
	}
	
}
