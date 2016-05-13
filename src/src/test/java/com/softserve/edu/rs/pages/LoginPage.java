package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.rs.data.users.IUser;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private class LoginPageUIMap {
		public final ITextField login;
		public final ITextField password;
		public final IButton signin;
    	
    	public LoginPageUIMap() {
    		this.login = TextField.get().getById("login");
    		this.password = TextField.get().getById("password");
    		this.signin = Button.get().getByCssSelector("button.btn.btn-primary");
    	}
    }

    private LoginPageUIMap controls;

	public LoginPage() {
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

    private void setLoginData(IUser user) {
		setLoginClear(user.getAccount().getLogin());
		setPasswordClear(user.getAccount().getPassword());
		clickSignin();
	}

    public AdminHomePage successAdminLogin(IUser admin) {
		setLoginData(admin);
		return new AdminHomePage();
	}

}
