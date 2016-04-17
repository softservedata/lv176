package com.softserveinc.edu.ita;
import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.SelenideElement;

public class UseersCommonPage {
	@FindBy(css = "#.btn.btn-primary.btn-sm")
	private SelenideElement userButton;

	@FindBy(xpath = ".//*[@id='header']/div[2]/div[1]/div/button[2]")
	private SelenideElement userDropDownMenuButton;

	@FindBy(xpath = ".//*[@id='header']/div[2]/div[1]/div/ul/li[1]")
	private SelenideElement changePasswordButton;

	@FindBy(xpath = ".//*[@id='header']/div[2]/div[1]/div/ul/li[2]")
	private SelenideElement resetPasswordButon;

	@FindBy(id = "changeLanguage")
	private SelenideElement changeLanguageDropMenu;

	@FindBy(xpath = ".//*[@id='header']/div[2]/div[1]/div/ul/li[4]/a")
	private SelenideElement signoutButton;
	
	@FindBy (css = "#footer>div>p>span")
	private SelenideElement commonPafeFooter;
	
	

	// --actions user with account--\\
	
	public SelenideElement getCommonPafeFooter() {
		
		return commonPafeFooter;
	}

	public SelenideElement getUserButton() {
		return userButton;
	}

	public SelenideElement getUserDropDownMenuButton() {
		return userDropDownMenuButton;
	}

	public SelenideElement getChangePasswordButton() {
		if (changePasswordButton.isDisplayed()) {
			return changePasswordButton;
		} else {
			openUserDropDown();
			return changePasswordButton;
		}
	}

	public SelenideElement getResetPasswordButon() {
		if (resetPasswordButon.isDisplayed()) {
			return resetPasswordButon;
		} else {
			openUserDropDown();
			return resetPasswordButon;
		}
	}

	public SelenideElement getChangeLanguageDropMenu() {
		return changeLanguageDropMenu;
	}

	public SelenideElement getSignoutButton() {
		if (signoutButton.isDisplayed()) {
			return signoutButton;
		} else {
			openUserDropDown();
			return signoutButton;
		}
	}

	public void changeUserPassw() {// --change user passw--\\
		openUserDropDown();
		changePasswordButton.click();
	}

	public void resetUserPassword() {// --reset user passw--\\
		openUserDropDown();
		resetPasswordButon.click();
	}

	public void userSignOut() {// --sign out from application--\\
		openUserDropDown();
		signoutButton.click();
	}

	public void changeLanguage(String value) {// --change page language--\\
		changeLanguageDropMenu.selectOptionByValue(value);
	}

	public void openUserDropDown() {
		userDropDownMenuButton.click();

	}
}
