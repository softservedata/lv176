package com.softserve.edu.rs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.entity.IUser;

public class EditProfilUserPage extends CommonPage {
	@FindBy(id = "userStatusId")
	private WebElement selectStatus;
	@FindBy(id = "ok")
	private WebElement buttonOK;

	public EditProfilUserPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}
	
	public WebElement getSelectStatus() {
		return this.selectStatus;
	}
	
	public WebElement getButtonOk() {
		return this.buttonOK;
	}
	
	public void clickButtonOk() {
		getButtonOk().click();
	}
	
	public void setStatus(IUser user) {
		new Select(getSelectStatus()).selectByValue(user.getAccount().getStatus());
	}
	
	public EditProfilUserPage changeStatus(IUser user) {
		setStatus(user);
		return this;
	}
}
