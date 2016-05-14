package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.IRadioButton;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.RadioButton;
import com.softserve.edu.atqc.controls.TextField;

public class SettingPage extends AdminHomePage {

	private class SettingPageUIMap {
		public final IRadioButton personalRegistr;
		public final IRadioButton mixedRegister;
		public final IRadioButton commissionerRegister;
		public final ITextField timeZone;
		public final IButton confirmChanges;

		public SettingPageUIMap() {
			this.personalRegistr = RadioButton.get().getByXpath("//input[@value = 'PERSONAL']");
			this.mixedRegister = RadioButton.get().getByXpath("//input[@value = 'MIXED']");
			this.commissionerRegister = RadioButton.get().getByXpath("//input[@value ='MANUAL']");
			this.timeZone = TextField.get().getByXpath("//input[@class='form-control col-md-4']");
			this.confirmChanges = Button.get().getById("confirmRegistrationMethod");

		}
	}

	// Elements
	private SettingPageUIMap controls;

	public SettingPage() {

		controls = new SettingPageUIMap();
	}

	// Get Elements
	public IButton getPersonalRegister() {
		return this.controls.personalRegistr;
	}

	public IButton getMixedRegister() {
		return this.controls.mixedRegister;
	}

	public IButton getCommissionerRegister() {
		return this.controls.commissionerRegister;
	}

	public ITextField getTimeZone() {
		return this.controls.timeZone;
	}

	public IButton getConfirmChanges() {
		return this.controls.confirmChanges;
	}

	// Set Data
	public void clickPersonalRegister() {
		getPersonalRegister().click();
	}

	public void clickMixedRegister() {
		getMixedRegister().click();
	}

	public void clickCommissionerRegister() {
		getCommissionerRegister().click();

	}

	public void clickTimeZone() {
		getTimeZone().click();

	}

	public void clickConfirmChanges() {
		getConfirmChanges().click();

	}

	public void setTimeZone(String timeZone) {
		getTimeZone().sendKeys(timeZone);
	}
	
	public void clearTimeZone() {
		getTimeZone().clear();
	}

	// Functional

	public SettingPage confirm() {
		clickConfirmChanges();
		return this;

	}
}
