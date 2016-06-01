package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.Link;

public class CommissionerPage extends CommonPage {

	private class CommissionerPageUIMap {
		public final ILink registeredUsers;

		public CommissionerPageUIMap() {
			this.registeredUsers = Link.get().getByXpath("//a [contains(@href,'manualregistration')]");
		}
	}

	// Elements
	private CommissionerPageUIMap controls;

	public CommissionerPage() {
		controls = new CommissionerPageUIMap();
	}
	// Get Elements

	public ILink getRegisteredUsers() {
		return this.controls.registeredUsers;
	}

	// Set Data

	public void clickRegisteredUsers() {
		getRegisteredUsers().click();
	}

	// Business Logic
	// Functional

	public UserRegistrationPage goToUserRegistrationPage() {
		clickRegisteredUsers();
		return new UserRegistrationPage();
	}

}
