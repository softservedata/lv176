package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;

public class AfterRegistrationPage extends TopPage {

	private class AfterRegistrationPageUIMap {
		public final IButton returnToLoginPage;

		public AfterRegistrationPageUIMap() {
			this.returnToLoginPage = Button.get().getByXpath("//a [contains(@href,'resources/login')]");

		}
	}

	// Elements
	private AfterRegistrationPageUIMap controls;

	public AfterRegistrationPage() {

		controls = new AfterRegistrationPageUIMap();
	}

	// Get
	public IButton getReturnToLoginPage() {
		return this.controls.returnToLoginPage;
	}

	// Set
	public void clickReturnToLoginPage() {
		getReturnToLoginPage().click();
	}

}