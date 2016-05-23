package com.softserve.edu.rs.pages;

import java.util.HashMap;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.Component;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.Label;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.atqc.data.apps.IObserveLoad;
import com.softserve.edu.atqc.data.apps.PageObserveLoad;
import com.softserve.edu.rs.data.users.IUser;

public class LoginPage extends TopPage {

	public static enum LoginPageText {
        LOGIN_LABEL("Логін","Логин","Login"),
        PASSWORD_LABEL("Пароль","Пароль","Password"),
		SUBMIT_BUTTON("Увійти","Войти","Sign in");
        //
        private HashMap<ChangeLanguageFields, String> field;

        private LoginPageText(String... localization) {
        	this.field = new HashMap<ChangeLanguageFields, String>();
        	int i = 0;
        	for (ChangeLanguageFields language : ChangeLanguageFields.values()) {
        		this.field.put(language, localization[i]);
        		i++;
        	}
        }

        public String getLocalization(ChangeLanguageFields language) {
            return this.field.get(language).trim();
        }
    }

	private class LoginPageUIMap {
		public final ITextField login;
		public final ITextField password;
		public final IButton signin;
		//
		public final ILabel loginLabel;
		public final ILabel passwordLabel;
    	
    	public LoginPageUIMap() {
    		this.login = TextField.get().getById("login");
    		this.password = TextField.get().getById("password");
    		this.signin = Button.get().getByCssSelector("button.btn.btn-primary");
    		//
    		loginLabel = Label.get().getByXpath("//label[contains(@for,'inputEmail')]");
    		passwordLabel = Label.get().getByXpath("//label[contains(@for,'inputPassword')]");
    	}
    	
    	public void showAlert(String message) {
    		Component.get().runJavaScript(String.format("alert('Hello %s')", message));
    	}
    }

	private class LoginPageLoaded implements IObserveLoad {
		public boolean loadComplete() {
			return (Boolean)Component.get().runJavaScript("return $('#baseurl')[0].style.opacity  == '';");
		}
	}
	
	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
    // Elements
    private LoginPageUIMap controls;

	public LoginPage() {
		//super();
		// TODO Add Observe
		PageObserveLoad.get().refreshLoadCompleteEvent(new LoginPageLoaded());
		controls = new LoginPageUIMap();
	}

    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Get Elements

	public ITextField getLogin() {
		return this.controls.login;
	}

	public ITextField getPassword() {
		return this.controls.password;
	}

	public IButton getSignin() {
		return this.controls.signin;
	}

	public ILabel getLoginLabel() {
		return this.controls.loginLabel;
	}

	public ILabel getPasswordLabel() {
		return this.controls.passwordLabel;
	}

	public String getLoginText() {
		return getLogin().getText();
	}

	public String getPasswordText() {
		return getPassword().getText();
	}

	public String getSigninText() {
		return getSignin().getText().trim();
	}

	public String getLoginLabelText() {
		return getLoginLabel().getText().trim();
	}

	public String getPasswordLabelText() {
		return getPasswordLabel().getText().trim();
	}

	// Set Data

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

    // business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public void showAlert(String message) {
		this.controls.showAlert(message);
	}
	
	// Functional
	
    public LoginPage changeLanguage(ChangeLanguageFields language) {
    	setChangeLanguage(language);
        // Return a new page object representing the destination.
        return new LoginPage();
    }

    private void setLoginData(IUser user) {
		setLoginClear(user.getAccount().getLogin());
		setPasswordClear(user.getAccount().getPassword());
		clickSignin();
	}

//    public HomePage successUserLogin(IUser user) {
//        setLoginData(user);
//        // Return a new page object representing the destination.
//        return new HomePage();
//    }

    public AdminHomePage successAdminLogin(IUser admin) {
		setLoginData(admin);
		// Return a new page object representing the destination.
		return new AdminHomePage();
	}

//	public RegistratorHomePage successRegistratorLogin(IUser registrator) {
//		setLoginData(registrator);
//		// Return a new page object representing the destination.
//		return new RegistratorHomePage();
//	}
//
//	public LoginValidatorPage unsuccessfulLogin(IUser invalidUser) {
//		setLoginData(invalidUser);
//		return new LoginValidatorPage(); // return this;
//	}

}
