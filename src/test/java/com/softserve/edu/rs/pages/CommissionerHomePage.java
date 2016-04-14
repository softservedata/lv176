package com.softserve.edu.rs.pages;

import org.openqa.selenium.WebDriver;

public class CommissionerHomePage extends CommonPage {

	public CommissionerHomePage(WebDriver webDriver) {
		super(webDriver);
	}

    public CommissionerHomePage changeLanguage(ChangeLanguageFields language) {
    	setChangeLanguage(language);
        return new CommissionerHomePage(webDriver);
    }

}
