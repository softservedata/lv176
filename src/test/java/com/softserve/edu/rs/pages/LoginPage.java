package com.softserve.edu.rs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.softserve.edu.entity.IUser;

public class LoginPage extends BasePage {
	@FindBy(id = "login")
	private WebElement login;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signIn;

	public LoginPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	public WebElement getLogin() {
		return this.login;
	}

	public WebElement getPassword() {
		return this.password;
	}

	public WebElement getSignIn() {
		return this.signIn;
	}

	public String getLoginText() {
		return getLogin().getText();
	}

	public String getPasswordText() {
		return getPassword().getText();
	}

	public void setLogin(String login) {
		getLogin().sendKeys(login);
	}

	public void setPassword(String password) {
		getPassword().sendKeys(password);
	}

	public void clearLogin() {
		getLogin().clear();
	}

	public void clearPassword() {
		getPassword().clear();
	}

	public void clickLogin() {
		getLogin().click();
	}

	public void clickPassword() {
		getPassword().click();
	}

	public void clickSignIn() {
		getSignIn().click();
	}

	public LoginPage changeLanguage(ChangeLanguageFields language) {
		setChangeLanguage(language);
		return new LoginPage(webDriver);
	}

	private void setLoginData(IUser user) {
		clickLogin();
		clearLogin();
		setLogin(user.getAccount().getLogin());
		clickPassword();
		clearPassword();
		setPassword(user.getAccount().getPassword());
		clickSignIn();
	}

	public HomeUserPage successUserLogin(IUser user) {
		setLoginData(user);
		return new HomeUserPage(webDriver);
	}

	public CommonAdminCommissionerHomePage successAdminCommissionerLogin(IUser admin) {
		setLoginData(admin);
		return new CommonAdminCommissionerHomePage(webDriver);
	}

	public LoginValidatorPage unsuccessfulLogin(IUser invalidUser) {
		setLoginData(invalidUser);
		return new LoginValidatorPage(webDriver);
	}

}
