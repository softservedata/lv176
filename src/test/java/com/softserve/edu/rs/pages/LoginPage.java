package com.softserve.edu.rs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.pages.admin.AdminHomePage;
import com.softserve.edu.rs.pages.registrator.RegistratorHomePage;

public class LoginPage extends TopPage {	

	private WebElement login;
	private WebElement password;
	private WebElement signin;
	private WebElement loginLabel;
	private WebElement passwordLabel;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.login = findById("login");
		this.password = findById("password");
		this.signin = findByCss("button.btn.btn-primary");
		this.loginLabel = findByXpath("//label[@for = 'inputEmail']");
		this.passwordLabel = findByXpath("//label[@for = 'inputPassword']");
	}

	// Page Object - - - - - - - - - -
	// Get Elements

	public WebElement getLogin() {
		return this.login;
	}

	public WebElement getPassword() {
		return this.password;
	}

	public WebElement getSignin() {
		return this.signin;
	}

	public WebElement getLoginLabel() {
		return this.loginLabel;
	}

	public WebElement getPasswordLabel() {
		return this.passwordLabel;
	}

	public String getLoginText() {
		return getLogin().getText();
	}

	public String getPasswordText() {
		return getPassword().getText();
	}

	public String getLoginLabelText() {
		return getLoginLabel().getText();
	}

	public String getPasswordLabelText() {
		return getPasswordLabel().getText();
	}

	// Set Data

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

	public void clickSignin() {
		getSignin().click();
	}

	// Business Logic
	// Functional
	
    public LoginPage changeLanguage(ChangeLanguageFields language) {
    	setChangeLanguage(language);
        return new LoginPage(driver);
    }

    private void setLoginData(IUser user) {
		clickLogin();
		clearLogin();
		setLogin(user.getAccount().getLogin());
		clickPassword();
		clearPassword();
		setPassword(user.getAccount().getPassword());
		clickSignin();
	}

    public HomePage successUserLogin(IUser user) {
        setLoginData(user);
        return new HomePage(driver);
    }

    public AdminHomePage successAdminLogin(IUser admin) {
		setLoginData(admin);
		return new AdminHomePage(driver);
	}

	public RegistratorHomePage successRegistratorLogin(IUser registrator) {
		setLoginData(registrator);
		return new RegistratorHomePage(driver);
	}

	public LoginValidatorPage unsuccessfulLogin(IUser invalidUser) {
		setLoginData(invalidUser);
		return new LoginValidatorPage(driver);
	}

}
