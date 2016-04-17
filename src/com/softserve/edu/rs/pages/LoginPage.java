package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.rs.data.users.IUser;

public class LoginPage extends TopPage {

	private WebElement login;
	private WebElement password;
	private WebElement signin;
	public static final String TITLE = "Login";

	public LoginPage(WebDriver driver) {
		super(driver);
		this.login = driver.findElement(By.id("login"));
		this.password = driver.findElement(By.id("password"));
		this.signin = driver.findElement(By.cssSelector("button.btn.btn-primary"));
	}

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

	public String getLoginText() {
		return this.login.getText();
	}

	public String getPasswordText() {
		return this.password.getText();
	}

	public String getTitle() {
		return this.driver.getTitle();
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

	public RegistratorHomePage successRegistratorLogin(IUser registrator) {
		setLoginData(registrator);
		return new RegistratorHomePage(driver);
	}

	public LoginValidatorPage unsuccessfulLogin(IUser invalidUser) {
		setLoginData(invalidUser);
		return new LoginValidatorPage(driver);
	}

}
