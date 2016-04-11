package com.softserve.edu.rs.pages;

import org.openqa.selenium.WebDriver;

public final class HomePage2 extends CommonPage2 {
	//
	public HomePage2(WebDriver driver) {
		super(driver);
	}

	// Business Logic
	// Functional
	
    public HomePage2 changeLanguage(ChangeLanguageFields2 language) {
    	setChangeLanguage(language);
        // Return a new page object representing the destination.
        return new HomePage2(driver);
    }

}
