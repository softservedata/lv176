package com.softserve.edu.rs.pages.regist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.softserve.edu.rs.pages.CommonPage;
import com.softserve.edu.rs.pages.LoginPage;


public class RegistratorHomePage extends CommonPage {
	
	@FindBy(css = "a[href*='resource/new']")
	private WebElement addNewResource;
	

	public RegistratorHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
    // Get Elements
    
    public WebElement getaddNewResource() {
        return this.addNewResource;
    }

    // Set Data
    
    public void clickaddNewResource() {
    	getaddNewResource().click();
    }
    
   
	// Business Logic
	// Functional
	
    public RegistratorHomePage changeLanguage(ChangeLanguageFields language) {
    	setChangeLanguage(language);
     
        return new RegistratorHomePage(driver);
    }
    
    public LoginPage logout() {
    	clickLogout();
        
        return new LoginPage(driver);
    }
    
    public AddNewResourceHomePage gotoAddNewResource() {
    	clickaddNewResource();
        return new AddNewResourceHomePage(driver);
    }
    
    
    

}
