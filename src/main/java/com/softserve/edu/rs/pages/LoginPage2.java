package com.softserve.edu.rs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.softserve.edu.rs.data.users.IUser;

public class LoginPage2 extends TopPage2 {
	
	public static enum LoginPageEng {
		LOGINLABEL("Login"),
        PASSWORDLABEL("Password");
        //
        private String field;

        private LoginPageEng(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }

	public static enum LoginPageUkr {
		LOGINLABEL("Ћог≥н"),
        PASSWORDLABEL("ѕароль");
        //
        private String field;

        private LoginPageUkr(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }
	
	//private WebDriver driver;
	//
	@FindBy(id = "login")
	private WebElement login;
	//
	@FindBy(id = "password")
	//@CacheLookup
	private WebElement password;
	//
	@FindBy(css = "button.btn.btn-primary")
	private WebElement signin;
	//
	@FindBy(xpath = "//label[@for = 'inputEmail']")
	private WebElement loginLabel;
	//
	@FindBy(xpath = "//label[@for = 'inputPassword']")
	private WebElement passwordLabel;

	public LoginPage2(WebDriver driver) {
		super(driver);
		//this.driver = driver;
		//
		PageFactory.initElements(driver, this);
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
	
    public LoginPage2 changeLanguage(ChangeLanguageFields2 language) {
    	setChangeLanguage(language);
        // Return a new page object representing the destination.
        return new LoginPage2(driver);
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

    public HomePage2 successUserLogin(IUser user) {
        setLoginData(user);
        // Return a new page object representing the destination.
        return new HomePage2(driver);
    }

    public AdminHomePage2 successAdminLogin(IUser admin) {
		setLoginData(admin);
		// Return a new page object representing the destination.
		return new AdminHomePage2(driver);
	}

	public RegistratorHomePage2 successRegistratorLogin(IUser registrator) {
		setLoginData(registrator);
		// Return a new page object representing the destination.
		return new RegistratorHomePage2(driver);
	}

	public LoginValidatorPage2 unsuccessfulLogin(IUser invalidUser) {
		setLoginData(invalidUser);
		return new LoginValidatorPage2(driver); // return this;
	}

}
