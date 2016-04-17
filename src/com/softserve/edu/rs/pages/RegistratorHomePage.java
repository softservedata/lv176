package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistratorHomePage extends CommonPage {

	private WebElement subclassObject;

	public RegistratorHomePage(WebDriver driver) {
		super(driver);
		this.subclassObject = driver
				.findElement(By.cssSelector("#bs-example-navbar-collapse-1 > ul > li:nth-child(3) > a"));
	}

	// get--------------------------

	private WebElement getSubclassObject() {
		return this.subclassObject;
	}

	// set-------------------------

	private void clickSubclassObject() {
		getSubclassObject().click();
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

	public ShowSubclassPage gotoSubclassPage() {
		clickSubclassObject();
		return new ShowSubclassPage(driver);
	}

}
