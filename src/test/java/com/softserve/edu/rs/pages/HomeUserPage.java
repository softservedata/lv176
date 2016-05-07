package com.softserve.edu.rs.pages;


import org.testng.Assert;
import com.softserve.edu.entity.IUser;


public final class HomeUserPage extends CommonPage {
	
    public void verifyUserIsEntered(IUser user){
		Assert.assertEquals(getLoginAccountText(), user.getAccount().getLogin());
	}

}
