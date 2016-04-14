package com.softserve.edu.rs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProfilUserPage extends CommonPage {
	@FindBy(xpath = "//button[@id='edit']")
	private WebElement buttonEdit;

	public ProfilUserPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	public WebElement getButtonEdit() {
		return this.buttonEdit;
	}

	public EditProfilUserPage clickButtonEdit() {
		getButtonEdit().click();
		return new EditProfilUserPage(webDriver);
	}
}
