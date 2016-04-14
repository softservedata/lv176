package com.softserve.edu.rs.pages;

import org.openqa.selenium.WebDriver;


public final class HomeUserPage extends CommonPage {

	public HomeUserPage(WebDriver webDriver) {
		super(webDriver);
	}
	
    public HomeUserPage changeLanguage(ChangeLanguageFields language) {
    	setChangeLanguage(language);
        return new HomeUserPage(webDriver);
    }
    
//    public void verifyUserIsEntered(IUser user){
//		Assert.assertEquals(getLoginAccountText(), user.getAccount().getLogin());
//	}

}
