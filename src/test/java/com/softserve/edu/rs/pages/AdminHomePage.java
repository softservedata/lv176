package com.softserve.edu.rs.pages;

import org.openqa.selenium.WebDriver;

public class AdminHomePage extends CommonAdminCommissionerHomePage {

	public AdminHomePage(WebDriver webDriver) {
		super(webDriver);
	}
	
	public AdminHomePage changeLanguage(ChangeLanguageFields language) {
		setChangeLanguage(language);
		return new AdminHomePage(webDriver);
	}
}
