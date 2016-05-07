package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.entity.IUser;

public class LoginPage extends BasePage {
	
	private class LoginPageUIMap {
		public final ITextField login;
		public final ITextField password;
		public final IButton signin;

		public LoginPageUIMap() {
			this.login = TextField.get().getById("login");
			this.password = TextField.get().getById("password");
			this.signin = Button.get().getByXpath("//button[@type='submit']");
		}
	}
	
	private LoginPageUIMap controls;
	
	public LoginPage() {
		//super();
		controls = new LoginPageUIMap();
	}
	
	public ITextField getLogin() {
		return this.controls.login;
	}

	public ITextField getPassword() {
		return this.controls.password;
	}

	public IButton getSignin() {
		return this.controls.signin;
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

	public void setLoginClear(String login) {
		getLogin().sendKeysClear(login);
	}

	public void setPassword(String password) {
		getPassword().sendKeys(password);
	}

	public void setPasswordClear(String password) {
		getPassword().sendKeysClear(password);
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

	public LoginPage changeLanguage(ChangeLanguageFields language) {
		setChangeLanguage(language);
		return new LoginPage();
	}

	private void setLoginData(IUser user) {
		setLoginClear(user.getAccount().getLogin());
		setPasswordClear(user.getAccount().getPassword());
		clickSignin();
	}
	    
	public CommonAdminCommissionerHomePage successAdminCommissionerLogin(IUser admin) {
		setLoginData(admin);
		return new CommonAdminCommissionerHomePage();
	}


	public HomeUserPage successUserLogin(IUser user) {
		setLoginData(user);
		return new HomeUserPage();
	}

	public LoginValidatorPage unsuccessfulLogin(IUser invalidUser) {
		setLoginData(invalidUser);
		return new LoginValidatorPage();
	}

}
