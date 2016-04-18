package com.softserve.edu.rs.pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.softserve.edu.rs.pages.CommonPage;


public class AdminHomePage extends CommonPage {
	
	private Actions action;	
    private WebElement listAllusers;	
    private WebElement activeUsers;	
    private WebElement blockedUsers;	
    private WebElement notVerifyedUsers;

    public AdminHomePage(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
        this.listAllusers = findByCss(".dropdown");
        this.activeUsers = findByCss(".dropdown>ul>li:first-child>a");
        this.blockedUsers = findByXpath("//a[contains(@href,'block')]");
        this.notVerifyedUsers = findByXpath("//a[contains(@href,'notcomfirmed')]");
    }

    // Get Elements
    
    public Actions getAction(){
    	return this.action;
    }
    
    public WebElement getNotVerifyedUsers(){
    	return this.notVerifyedUsers;
    }
    
    public WebElement getBlockedusers() {
        return this.blockedUsers;
    }

    public WebElement getActiveUsers() {
        return this.activeUsers;
    }
    
    public WebElement getListAllusers() {
        return this.listAllusers;
    }

    // Set Data
    
    public void clickListAllusers() {
    	getAction().moveToElement(getListAllusers()).build().perform();
    }  

    // Business Logic
	// Functional
	
    public AdminHomePage changeLanguage(ChangeLanguageFields language) {
    	setChangeLanguage(language);
        return new AdminHomePage(driver);
    }
    
    public ActiveUserSearchPage clickActiveUsers() {
    	clickListAllusers();
    	getActiveUsers().click();
    	return new ActiveUserSearchPage(driver);
    }
    
    public BlockedUserSearchPage clickBlockedUsers() {
    	clickListAllusers();
    	getBlockedusers();
        return new BlockedUserSearchPage(driver);
    }

    public NotVerifyedUserSearchPage clickNotVerifyedUsers() {
    	clickListAllusers();
    	getNotVerifyedUsers();
        return new NotVerifyedUserSearchPage(driver);
    }
    
    
    
    
    
    
    
    
}
