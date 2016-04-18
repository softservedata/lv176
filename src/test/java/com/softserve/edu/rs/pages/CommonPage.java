package com.softserve.edu.rs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class CommonPage extends TopPage {

	private WebElement loginAccount;
	private WebElement logout;	
	private WebElement loginMenu;	
	private WebElement changePasswordButton;	
	private WebElement resetPasswordButton;

	public CommonPage(WebDriver driver) {
		super(driver);
		this.loginAccount = findByCss(".btn.btn-primary.btn-sm:first-child");
		this.logout = findByXpath("//a[contains(@href,'/logout')]");
		this.loginMenu = findByCss(".btn.btn-primary.btn-sm.dropdown-toggle");
		this.loginMenu = findByCss(".change-password");
		this.loginMenu = findByCss(".reset-my-password");
	}

	// Get Elements
	
	public WebElement getResetPasswordButton(){
		return this.resetPasswordButton;
	}
	
	public WebElement getLoginMenu() {
		return this.loginMenu;
	}
	
	public WebElement getChangePasswordButton() {
		return this.changePasswordButton;
	}
	
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

	// Bissines logic
	
	public void clickLoginMenu() {
		getLoginMenu().click();
	}
	
	public LoginPage logOutFromApp(){
		clickLoginMenu();
		getLogout().click();
		return new LoginPage(driver);
	}
	
	public ChangePasswordPage clickChangePasswordButton(){
		getChangePasswordButton().click();
		return new ChangePasswordPage(driver);
	}

}
