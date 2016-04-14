package com.softserve.edu.rs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonAdminCommissionerHomePage extends CommonPage {
	@FindBy(xpath = "//a[contains(@href,'/manualregistration')]")
	private WebElement createNewUser;
	@FindBy(xpath = "//li[a[text()='Користувачі']]")
	private WebElement notComfirmedUsers;
	@FindBy(xpath = "//a[contains(@href,'/administrator/users/get-all-users?statusType=notcomfirmed')]")
	private WebElement nonConfirmedUsers;

	public CommonAdminCommissionerHomePage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	public WebElement getCreateNewUser() {
		return this.createNewUser;
	}

	public void clickCreateNewUser() {
		getCreateNewUser().click();
	}

	public WebElement getListAllUsers() {
		return this.notComfirmedUsers;
	}

	public void clickListAllUsers() {
		getListAllUsers().click();
	}

	public WebElement getNonConfirmedUsers() {
		return this.nonConfirmedUsers;
	}

	public void clickNonConfirmedUsers() {
		getNonConfirmedUsers().click();
	}

	public CreateNewUserPage gotoCreateNewUserPage() {
		clickCreateNewUser();
		return new CreateNewUserPage(webDriver);
	}
	
	public NonConfirmedUsersPage gotoNonConfirmedUsersPage() {
		clickListAllUsers();
		clickNonConfirmedUsers();
		return new NonConfirmedUsersPage(webDriver);
	}
}
