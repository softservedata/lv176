package com.softserve.edu.rs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class CommonPage2 extends TopPage2 {
	//
	@FindBy(css = ".col-md-7 label")
	private WebElement loginAccount;
	//
	@FindBy(xpath = "//a[contains(@href,'/logout')]")
	private WebElement logout;

	public CommonPage2(WebDriver driver) {
		super(driver);
		//this.driver = driver;
		//
		PageFactory.initElements(driver, this);
	}

	// Get Elements
	
	public WebElement getLoginAccount() {
		return this.loginAccount;
	}
	
	public WebElement getLogout() {
		return this.logout;
	}

	public String getLoginAccountText() {
		return getLoginAccount().getText();
	}
	
	public String getLogoutText() {
		return getLogout().getText();
	}

	// Set Data
	
	public void clickLogout() {
		getLogout().click();
	}

}
