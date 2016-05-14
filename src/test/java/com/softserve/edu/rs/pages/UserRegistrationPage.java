package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ISelect;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.SelectField;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.rs.data.users.IUser;

public class UserRegistrationPage extends TopPage {

	private class UserRegistrationPageUIMap {
		public final ITextField name;
		public final ITextField lastName;
		public final ITextField email;
		public final ITextField login;
		public final ITextField password;
		public final ITextField confirmPassword;
		public final ISelect community;
		public final IButton confirms;

		public UserRegistrationPageUIMap() {
			this.name = TextField.get().getById("firstName");
			this.lastName = TextField.get().getById("lastName");
			this.email = TextField.get().getById("email");
			this.login = TextField.get().getById("login");
			this.password = TextField.get().getById("password");
			this.confirmPassword = TextField.get().getById("confirmPassword");
			this.community = SelectField.get().getById("territorial_Community");
			this.confirms = Button.get().getById("submit");

		}
	}

	private UserRegistrationPageUIMap controls;

	public UserRegistrationPage() {
		controls = new UserRegistrationPageUIMap();
	}

	// Get Elements

	public ITextField getName() {
		return this.controls.name;
	}

	public ITextField getlastName() {
		return this.controls.lastName;
	}

	public ITextField getEmail() {
		return this.controls.email;
	}

	public ITextField getLogin() {
		return this.controls.login;
	}

	public ITextField getPassword() {
		return this.controls.password;
	}

	public IButton getConfirm() {
		return this.controls.confirms;
	}

	public ISelect getCommunity() {
		return this.controls.community;
	}

	public ITextField getConfirmPassword() {
		return this.controls.confirmPassword;
	}

	// Set Data

	public void setLogin(String login) {
		getLogin().sendKeys(login);
	}

	public void setName(String name) {
		getName().sendKeys(name);
	}

	public void setLastName(String lastName) {
		getlastName().sendKeys(lastName);
	}

	public void setEmail(String email) {
		getEmail().sendKeys(email);
	}

	public void setPasword(String password) {
		getPassword().sendKeys(password);
	}

	public void setConfirmPassword(String password) {
		getConfirmPassword().sendKeys(password);
	}

	public void setSelectCommunity(String community) {
		getCommunity().selectByVisibleText(community);
	}

	public void clearLogin() {
		getLogin().clear();
	}

	public void clearEmail() {
		getEmail().clear();
	}

	public void clearPassword() {
		getPassword().clear();
	}

	public void clickConfirm() {
		getConfirm().click();
	}
	// Business Logic
	// Functional

	public void setLoginDatas(IUser user) {
		setName(user.getPerson().getFirstname());
		setLastName(user.getPerson().getLastname());
		clearEmail();
		setEmail(user.getPerson().getEmail());
		clearLogin();
		setLogin(user.getAccount().getLogin());
		clearPassword();
		setPasword(user.getAccount().getPassword());
		setConfirmPassword(user.getAccount().getPassword());
		setSelectCommunity(user.getAccount().getCommunity());

	}

	public NonConfirmedPage goToNonConfirmedPage() {
		clickConfirm();
		return new NonConfirmedPage();
	}

	public AfterRegistrationPage confirmRegistration() {
		clickConfirm();
		return new AfterRegistrationPage();
	}
}