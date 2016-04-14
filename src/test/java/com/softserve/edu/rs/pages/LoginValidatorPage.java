package com.softserve.edu.rs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginValidatorPage extends LoginPage {
	public static final String VALIDATOR_MESSAGE = "You have entered wrong login or password.";
	@FindBy(xpath = "//div[@style='color: red;']")
	private WebElement validator;
	
	public LoginValidatorPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	public WebElement getValidator() {
		return this.validator;
	}

	public String getValidatorText() {
		return getValidator().getText();
	}
}
