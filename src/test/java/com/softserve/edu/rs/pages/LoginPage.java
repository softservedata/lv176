package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.Label;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.entity.IUser;

public class LoginPage {
	public final String VALIDATOR_MESSAGE = "You have entered wrong login or password.";
	
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
	
	private class LoginValidatorPageUIMap {
		public final ILabel validator;

		public LoginValidatorPageUIMap() {
			this.validator = Label.get().getByXpath("//div[@style='color: red;']");
		}
	}
	
	private LoginPageUIMap loginControls;
	private LoginValidatorPageUIMap validatorControls;
	
	public LoginPage() {
		loginControls = new LoginPageUIMap();
	}
	
	public ITextField getLogin() {
		return this.loginControls.login;
	}

	public ITextField getPassword() {
		return this.loginControls.password;
	}

	public IButton getSignin() {
		return this.loginControls.signin;
	}

	public String getLoginText() {
		return getLogin().getText();
	}

	public String getPasswordText() {
		return getPassword().getText();
	}
	
	public ILabel getValidator() {
		return this.validatorControls.validator;
	}

	public String getValidatorText() {
		return getValidator().getText();
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

	public LoginPage unsuccessfulLogin(IUser invalidUser) {
		setLoginData(invalidUser);
		loginControls = new LoginPageUIMap();
		validatorControls = new LoginValidatorPageUIMap();
		return this;
	}

}
