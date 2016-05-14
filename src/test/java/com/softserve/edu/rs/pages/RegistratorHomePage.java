package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.softserve.edu.atqc.controls.LabelClickable;
import com.softserve.edu.rs.pages.TopPage.ChangeLanguageFields;

public class RegistratorHomePage extends RegistratorCommonPage {
	public RegistratorHomePage() {
	}

	// Business Logic
	// Functional
	public ResourceSearchPage gotoResourcesSearchPage(){
	LabelClickable.get().getByCssSelector("a[href$='/searchOnMap']").click();
		return new ResourceSearchPage();
	}
	
    public RegistratorHomePage changeLanguage(ChangeLanguageFields language) {
    	setChangeLanguage(language);
        // Return a new page object representing the destination.
        return new RegistratorHomePage();
    }
}
