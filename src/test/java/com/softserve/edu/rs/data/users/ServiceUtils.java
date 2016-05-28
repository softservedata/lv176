package com.softserve.edu.rs.data.users;
// TODO Move to com.softserve.edu.rs.services
//package com.softserve.edu.rs.services;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.softserve.edu.rs.data.users.Account;
import com.softserve.edu.rs.data.users.Address;
import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.Passport;
import com.softserve.edu.rs.data.users.Person;
import com.softserve.edu.rs.data.users.User;
import com.softserve.edu.rs.entity.UserDB;

public class ServiceUtils {
	private final String TIME_TEMPLATE = "yyyy-MM-dd HH:mm:ss";
	//
	private static volatile ServiceUtils instance = null;

    private ServiceUtils() {
    }

    public static ServiceUtils get() {
        if (instance == null) {
            synchronized (ServiceUtils.class) {
                if (instance == null) {
                    instance = new ServiceUtils();
                }
            }
        }
        return instance;
    }

    // TODO Use RegionDao
    //public IUser userDB2IUser(UserDB userDB, String roleName) {
    public IUser userDB2IUser(UserDB userDB) {
		return User.get()
				.setPerson(Person.get()
								.setFirstname(userDB.getFirstname())
								.setLastname(userDB.getLastname())
								.setEmail(userDB.getEmail())
								.build()
								.setMiddlename(userDB.getMiddlename())
								.setPhonenumber(userDB.getPhonenumber())
						)
				.setAccount(Account.get()
								.setLogin(userDB.getLogin())
								.setPassword(userDB.getPassword())
								// TODO Use ReoleService
								.setRole("ADMIN")
								.setStatus(userDB.getStatus())
								// TODO Use CommunityService
								.setCommunity("Україна")
								.build()
								.setData(userDB.getDateOfAccession().toString())
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

    // TODO
    public UserDB user2UserDB(IUser user) {
    	return new UserDB(0L, // userId,
    			1L,
    			1L,
    			0L,
    			1L,
    			Date.valueOf(user.getAccount().getData()),
    			user.getPerson().getEmail(),
    			1L,
    			user.getPerson().getFirstname(),
    			// TODO
    			Date.valueOf(new SimpleDateFormat(TIME_TEMPLATE).format(new java.util.Date())),
    			user.getPerson().getLastname(),
    			user.getAccount().getLogin(),
    			user.getPerson().getMiddlename(),
    			user.getAccount().getPassword(),
    			user.getPerson().getPhonenumber(),
    			user.getAccount().getStatus(),
    			// TODO
    			1L,
    			1L);
    }

}