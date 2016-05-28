package com.softserve.edu.rs.data.users;

import java.util.List;

import com.softserve.edu.atqc.data.ExcelUtils;

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

    // TODO
	//public IUser getAdmin()
	//public IUser getRegistrator()
	//public IUser getCommissioner()
	//public IUser getCoOwner()
	//public IUser getNewUser()
	//
	//public List<IUser> getAdminDB()
	
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
									.setFirstname("Андрій")
									.setLastname("Іванов")
									.setEmail("andr@gmail.com")
									.build()
									.setMiddlename("Петрович")
									.setPhonenumber("")
							)
					.setAccount(Account.get()
									.setLogin("commissioner")
									.setPassword("commissioner")
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
							.setRegion("Киівська")
							.setDistrict("Троєщина")
							.setCity("Львів")
							.setStreet("Стрийська")
							.setBuilding("43")
							.setFlat("43")
							.setPostcode("34345")
							)
					.setPassport(Passport.get()
							.setSeria("КС")
							.setNumber("43545")
							.setPublished("Львівським")
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
	
	public IUser getRegistrator(){
		// TODO Read from file
		return User.get().
				setPerson(Person.get()
						.setFirstname("Regisytator")
						.setLastname("Registrator")
						.setEmail("rr@ukr.net")
						.build()
						)
				.setAccount(Account.get()
						.setLogin("registrator")
						.setPassword("registrator")
						.setRole("REGISTRATOR")
						.setStatus("ACTIVE")
						.setCommunity("Україна")
						.build()
						.setData("")
						.setRegisterNumber("14")
						.setRegistratorNumber("804:23:17:026:79000:")
						.setVolumeNumber("12345")
						)
				.build();	
	}
	
	public IUser getCoOwner(){
		
		return User.get()
				.setPerson(Person.get()
						.setFirstname("User")
						.setLastname("User")
						.setEmail("rrd@ukr.net")
						.build())
				.setAccount(Account.get()
						.setLogin("user")
						.setPassword("user")
						.setRole("co-owner")
						.setStatus("active")
						.setCommunity("Україна")
						.build())
				.build();
				
		
	}
	
    public List<IUser> getExistUsersCVS() {
        return new UserUtils().getAllUsers();
    }

    public List<IUser> getExistUsersExcel() {
        return new UserUtils("/users.xlsx", new ExcelUtils()).getAllUsers();
    }
    
    public List<IUser> getRegistratorExcel() {
        return new UserUtils("/users.xlsx", new ExcelUtils()).getAllRegistartors();
    }
    
    public List<IUser> getCoOwnerExcel() {
        return new UserUtils("/users.xlsx", new ExcelUtils()).getAllCoOwners();
    }

}
