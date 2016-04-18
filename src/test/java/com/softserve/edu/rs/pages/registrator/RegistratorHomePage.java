package com.softserve.edu.rs.pages.registrator;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.rs.pages.CommonPage;


public class RegistratorHomePage extends CommonPage {

	public RegistratorHomePage(WebDriver driver) {
		super(driver);
	}

	// Business Logic
	// Functional
	
    public RegistratorHomePage changeLanguage(ChangeLanguageFields language) {
    	setChangeLanguage(language);
        return new RegistratorHomePage(driver);
    }

}
