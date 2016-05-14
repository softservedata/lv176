package com.softserve.edu.rs.data.users;

import java.util.Random;

public final class UserRepository {
    private static volatile UserRepository instance = null;

	private UserRepository() {
	}
	
    public static UserRepository get() {
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
		// TODO Read from file
		return User.get()
					.setPerson(Person.get()
									.setFirstname("Адміністратор")
									.setLastname("Адміністратор")
									.setEmail("admin@admin.com")
									.build()
									.setMiddlename("Адміністратор")
									.setPhonenumber("")
							)
					.setAccount(Account.get()
									.setLogin("admin")
									.setPassword("admin")
									.setRole("Адміністратор")
									.setStatus("Активний")
									.setCommunity("Україна")
									.build()
									.setData("")
									.setRegisterNumber("0")
									.setRegistratorNumber("0")
									.setVolumeNumber("0")
							)
					.build()
					.setAddress(Address.get()
							.setRegion("Львівська")
							.setDistrict("Галицький")
							.setCity("Львів")
							.setStreet("Вітовського")
							.setBuilding("48")
							.setFlat("31")
							.setPostcode("00000")
							)
					.setPassport(Passport.get()
							.setSeria("AA")
							.setNumber("00000")
							.setPublished("Народом України")
							);
	}

	public IUser getCommissioner() {
		// TODO Read from file
		return User.get()
					.setPerson(Person.get()
									.setFirstname("Petro")
									.setLastname("Petro")
									.setEmail("petro@ukr.net")
									.build()
									.setMiddlename("")
									.setPhonenumber("")
							)
					.setAccount(Account.get()
									.setLogin("commissioner")
									.setPassword("commissioner")
									.setRole("Уповноважений")
									.setStatus("Активний")
									.setCommunity("Україна")
									.build()
									.setData("")
									.setRegisterNumber("")
									.setRegistratorNumber("")
									.setVolumeNumber("")
							)
					.build()
					.setAddress(Address.get()
							.setRegion("")
							.setDistrict("")
							.setCity("")
							.setStreet("")
							.setBuilding("")
							.setFlat("")
							.setPostcode("")
							)
					.setPassport(Passport.get()
							.setSeria("КС")
							.setNumber("098989")
							.setPublished("")
							);
	}

	public IUser getEmpty() {
		// TODO Read from file
		return User.get()
					.setPerson(Person.get()
									.setFirstname("")
									.setLastname("")
									.setEmail("")
									.build()
									.setMiddlename("")
									.setPhonenumber("")
							)
					.setAccount(Account.get()
									.setLogin("")
									.setPassword("")
									.setRole("")
									.setStatus("")
									.setCommunity("")
									.build()
									.setData("")
									.setRegisterNumber("")
									.setRegistratorNumber("")
									.setVolumeNumber("")
							)
					.build()
					.setAddress(Address.get()
							.setRegion("")
							.setDistrict("")
							.setCity("")
							.setStreet("")
							.setBuilding("")
							.setFlat("")
							.setPostcode("")
							)
					.setPassport(Passport.get()
							.setSeria("")
							.setNumber("")
							.setPublished("")
							);
	}
	public static int randomCharacter() {
	    Random r = new Random();
	    int random =  r.nextInt(1000000);
	    return random;
	}
	public IUser getRandomUser() {
		// TODO Read from file
		return User.get()
					.setPerson(Person.get()
									.setFirstname("tester")
									.setLastname("tester")
									.setEmail("testr"+randomCharacter()+ "@ukr.net")
									.build()
									.setMiddlename("")
									.setPhonenumber("")
							)
					.setAccount(Account.get()
							.setLogin("tester"+randomCharacter())
									.setPassword("tester")
									.setRole("")
									.setStatus("")
									.setCommunity("Україна")
									.build()
									.setData("")
									.setRegisterNumber("")
									.setRegistratorNumber("")
									.setVolumeNumber("")
							)
					.build()
					.setAddress(Address.get()
							.setRegion("")
							.setDistrict("")
							.setCity("")
							.setStreet("")
							.setBuilding("")
							.setFlat("")
							.setPostcode("")
							)
					.setPassport(Passport.get()
							.setSeria("КС")
							.setNumber("789098")
							.setPublished("")
							);
	}

	
	
	
	
	
	
}
