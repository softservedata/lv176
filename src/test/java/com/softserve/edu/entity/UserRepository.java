package com.softserve.edu.entity;

import java.util.Date;

public final class UserRepository {
	private static volatile UserRepository instance = null;

	private UserRepository() {
	}

	public static UserRepository getInstance() {
		if (instance == null) {
			synchronized (UserRepository.class) {
				if (instance == null) {
					instance = new UserRepository();
				}
			}
		}
		return instance;
	}

	public IUser getAdmin() {
		return User.get()
				.setPerson(Person.get().setFirstName("Адміністратор").setLastName("Адміністратор")
						.setEmail("admin@admin.com").build().setMiddlename("Адміністратор").setPhonenumber(""))
				.setAccount(Account.get().setLogin("admin").setPassword("admin").setRole("ADMIN")
						.setStatus("ACTIVE").setCommunity("Україна").build().setDate("").setRegisterNumber("0")
						.setRegistratorNumber("0").setVolumeNumber("0")).build()
				.setAddress(Address.get().setRegion("Львівська").setDistrict("Галицький").setCity("Львів")
						.setStreet("Вітовського").setBuilding("48").setFlat("31").setPostcode("00000"))
				.setPassport(Passport.get().setPassportSeria("AA").setPassportNumber("00000").setPublishedByData("Народом України"));
	}
	
	public IUser getCommissioner() {
		return User.get()
				.setPerson(Person.get().setFirstName("Commissioner").setLastName("Commissioner")
						.setEmail("commissioner@gmail.com").build().setMiddlename("Commissioner").setPhonenumber(""))
				.setAccount(Account.get().setLogin("commissioner").setPassword("commissioner").setRole("COMMISSIONER")
						.setStatus("ACTIVE").setCommunity("Україна").build().setDate("").setRegisterNumber("0")
						.setRegistratorNumber("0").setVolumeNumber("0")).build()
				.setAddress(Address.get().setRegion("Львівська").setDistrict("Сихівський").setCity("Львів")
						.setStreet("Червоної калини").setBuilding("48").setFlat("5").setPostcode("00000"))
				.setPassport(Passport.get().setPassportSeria("ВС").setPassportNumber("124568").setPublishedByData("Народом України"));
	}

	public IUser getUser() {
		return User.get()
				.setPerson(Person.get().setFirstName("ivanko").setLastName("ivanko")
						.setEmail("ivanko" + System.currentTimeMillis() + "@gmail.com").build().setMiddlename("ivanko").setPhonenumber("+380980000000"))
				.setAccount(Account.get().setLogin("ivanko" + System.currentTimeMillis()).setPassword("ivanko").setRole("CO-OWNER")
						.setStatus("ACTIVE").setCommunity("Україна").build().setDate(new Date().toString()).setRegisterNumber("0")
						.setRegistratorNumber("0").setVolumeNumber("0")).build()
				.setAddress(Address.get().setRegion("Lviv").setDistrict("Lviv").setCity("Lviv")
						.setStreet("Червоної калини").setBuilding("50").setFlat("50").setPostcode("0332"))
				.setPassport(Passport.get().setPassportSeria("ВК").setPassportNumber("354895").setPublishedByData("Народом України"));
	}
	
	public IUser getEmpty() {
		return User.get()
				.setPerson(Person.get().setFirstName("").setLastName("").setEmail("").build().setMiddlename("")
						.setPhonenumber(""))
				.setAccount(Account.get().setLogin("").setPassword("").setRole("").setStatus("").setCommunity("")
						.build().setDate("").setRegisterNumber("").setRegistratorNumber("").setVolumeNumber(""))
				.build()
				.setAddress(Address.get().setRegion("").setDistrict("").setCity("").setStreet("").setBuilding("")
						.setFlat("").setPostcode(""))
				.setPassport(Passport.get().setPassportSeria("").setPassportNumber("").setPublishedByData(""));
	}
}
