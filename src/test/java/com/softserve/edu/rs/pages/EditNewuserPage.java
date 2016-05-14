package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ISelect;
import com.softserve.edu.atqc.controls.SelectField;

public class EditNewuserPage extends AdminHomePage {

	private class EditNewuserPageUIMap {

		public final ISelect userStatus;
		public final IButton confirmUser;

		public EditNewuserPageUIMap() {

			this.userStatus = SelectField.get().getById("userStatusId");
			this.confirmUser = Button.get().getById("ok");

		}
	}

	// Elements
	private EditNewuserPageUIMap controls;

	public EditNewuserPage() {
		controls = new EditNewuserPageUIMap();
	}

	// PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public IButton getConfirmUser() {
		return this.controls.confirmUser;
	}

	public ISelect getChangeUserStatus() {
		return this.controls.userStatus;
	}

	// Set

	public void clickConfirmUsers() {
		getConfirmUser().click();
	}

	public void clickChangeUserStatus() {
		getChangeUserStatus().selectByVisibleText("Активний");

	}

	public void changeStatus() {
		clickChangeUserStatus();
		clickConfirmUsers();

	}

}
