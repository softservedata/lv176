package com.softserve.edu.rs.data.users;

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
									.setFirstname("�����������")
									.setLastname("�����������")
									.setEmail("admin@admin.com")
									.build()
									.setMiddlename("�����������")
									.setPhonenumber("")
							)
					.setAccount(Account.get()
									.setLogin("admin")
									.setPassword("admin")
									.setRole("�����������")
									.setStatus("��������")
									.setCommunity("������")
									.build()
									.setData("")
									.setRegisterNumber("0")
									.setRegistratorNumber("0")
									.setVolumeNumber("0")
							)
					.build()
					.setAddress(Address.get()
							.setRegion("��������")
							.setDistrict("���������")
							.setCity("����")
							.setStreet("³���������")
							.setBuilding("48")
							.setFlat("31")
							.setPostcode("00000")
							)
					.setPassport(Passport.get()
							.setSeria("AA")
							.setNumber("00000")
							.setPublished("������� ������")
							);
	}

	public IUser getRegistrator() {
		// TODO Read from file
		return User.get()
					.setPerson(Person.get()
									.setFirstname("����")
									.setLastname("�����")
									.setEmail("mushkin_o@ukr.net")
									.build()
									.setMiddlename("����������")
									.setPhonenumber("")
							)
					.setAccount(Account.get()
									.setLogin("registrator")
									.setPassword("registrator")
									.setRole("����������")
									.setStatus("��������")
									.setCommunity("������")
									.build()
									.setData("")
									.setRegisterNumber("1")
									.setRegistratorNumber("1")
									.setVolumeNumber("1")
							)
					.build()
					.setAddress(Address.get()
							.setRegion("��������")
							.setDistrict("���������")
							.setCity("����")
							.setStreet("������")
							.setBuilding("111")
							.setFlat("22")
							.setPostcode("79000")
							)
					.setPassport(Passport.get()
							.setSeria("��")
							.setNumber("444444")
							.setPublished("����")
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
	
}
