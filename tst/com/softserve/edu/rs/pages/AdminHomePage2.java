package com.softserve.edu.rs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage2 extends CommonPage2 {
    //
	@FindBy(css = "a.not-active")
    private WebElement listAllusers;
	//
	@FindBy(xpath = "//a[contains(@href,'/get-all-users')]")
    private WebElement registeredUsers;

    public AdminHomePage2(WebDriver driver) {
        super(driver);
        //
        PageFactory.initElements(driver, this);
    }

    // Get Elements
    
    public WebElement getListAllusers() {
        return this.listAllusers;
    }

    public WebElement getRegisteredUsers() {
        return this.registeredUsers;
    }

    // Set Data
    
    public void clickListAllusers() {
    	getListAllusers().click();
    }
    
    public void clickRegisteredUsers() {
    	clickListAllusers();
    	getRegisteredUsers().click();
    }

    // Business Logic
	// Functional
	
    public AdminHomePage2 changeLanguage(ChangeLanguageFields2 language) {
    	setChangeLanguage(language);
        // Return a new page object representing the destination.
        return new AdminHomePage2(driver);
    }

    public LoginPage2 logout() {
    	clickLogout();
        // Return a new page object representing the destination.
        return new LoginPage2(driver);
    }
    
    public RegisteredUsersHomePage2 gotoRegisteredUsers() {
    	clickRegisteredUsers();
        return new RegisteredUsersHomePage2(driver);
    }

}
