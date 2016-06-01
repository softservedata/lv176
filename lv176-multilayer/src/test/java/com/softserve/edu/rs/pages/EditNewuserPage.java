package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ISelect;
import com.softserve.edu.atqc.controls.Select;


public class EditNewuserPage extends CommonPage {

	private class EditNewuserPageUIMap {

		public final ISelect userStatus;
		public final IButton confirmUser;

		public EditNewuserPageUIMap() {

			this.userStatus = Select.get().getById("userStatusId");
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
