package com.softserve.edu.rs.pages;

import org.openqa.selenium.WebDriver;

public class RegistratorHomePage2 extends CommonPage2 {

	public RegistratorHomePage2(WebDriver driver) {
		super(driver);
	}

	// Business Logic
	// Functional
	
    public RegistratorHomePage2 changeLanguage(ChangeLanguageFields2 language) {
    	setChangeLanguage(language);
        // Return a new page object representing the destination.
        return new RegistratorHomePage2(driver);
    }

}
