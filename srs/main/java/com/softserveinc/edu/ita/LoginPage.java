package com.softserveinc.edu.ita;
import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.SelenideElement;

public class LoginPage {
	@FindBy(xpath = ".//*[@id='login']")
	private SelenideElement userNameField;
	@FindBy(xpath = ".//*[@id='password']")
	private SelenideElement userPasswField;
	@FindBy(xpath = ".//*[@id='loginForm']/div[5]/button")
	private SelenideElement enterButton;

	public void enterUsername(String username) {
		this.userNameField.sendKeys(username);
	}

	public void enterUserPassw(String passw) {
		this.userPasswField.sendKeys(passw);
	}

	public void clickEnter() {
		this.enterButton.click();
	}
	
	public SelenideElement getSignInButton() {
		return enterButton;
		
	}

}
