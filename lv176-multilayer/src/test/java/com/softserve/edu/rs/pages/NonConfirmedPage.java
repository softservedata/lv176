package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.rs.data.users.IUser;

public class NonConfirmedPage extends CommonPage {

	private class NonConfirmedPageUIMap {
		public final ITextField logins;
		public final IButton searchs;
		public final IButton edits;
		public final ITextField emails;

		public NonConfirmedPageUIMap() {
			this.logins = TextField.get().getById("inputIndex3");
			this.searchs = Button.get().getById("bth-search");
			this.edits = Button.get().getById("edit");
			this.emails = TextField.get().getById("inputIndex5");

		}
	}

	// Elements
	private NonConfirmedPageUIMap controls;

	public NonConfirmedPage() {
		controls = new NonConfirmedPageUIMap();
	}

	// PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Get Elements

	public ITextField getLogins() {
		return this.controls.logins;
	}

	public IButton getSearch() {
		return this.controls.searchs;
	}

	public IButton getEdit() {
		return this.controls.edits;
	}

	public ITextField getEmail() {
		return this.controls.emails;
	}

	// Set Data

	public void clickLogins() {
		getLogins().click();
	}

	public void clickSearch() {
		getSearch().click();
	}

	public void clickEdit() {
		getEdit().click();
	}

	public void clickEmail() {
		getEmail().click();
	}

	// Set Data
	public void setLogins(String loggin) {
		getLogins().sendKeys(loggin);
	}

	public void setEmails(String email) {
		getEmail().sendKeys(email);
	}

	// Functional

	public NonConfirmedPage editNonConfirmeduser(IUser user) {
		setLogins(user.getAccount().getLogin());
		setEmails(user.getPerson().getEmail());
		clickSearch();
		return new NonConfirmedPage();
	}

	public EditRegisteredUsersPage goToEditRegisteredUserPage() {
		clickEdit();
		return new EditRegisteredUsersPage();
	}

}
