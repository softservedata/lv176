package com.softserve.edu.rs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginValidatorPage2 extends LoginPage2 {
	public static final String START_VALIDATOR_MESSAGE = "You have entered wrong login or password.";
	//
	@FindBy(xpath = "//div[@style='color: red;']")
	private WebElement validator;

	public LoginValidatorPage2(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// Get Elements

	public WebElement getValidator() {
		return this.validator;
	}

	public String getValidatorText() {
		return getValidator().getText();
	}

	public String getStartValidatorText() {
		return getValidatorText().substring(0, START_VALIDATOR_MESSAGE.length());
	}

}
