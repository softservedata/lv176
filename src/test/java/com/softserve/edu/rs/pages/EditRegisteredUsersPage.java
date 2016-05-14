package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;

public class EditRegisteredUsersPage extends AdminHomePage {

	private class EditRegisteredUsersPageUIMap {
		public final IButton editUsers;

		public EditRegisteredUsersPageUIMap() {
			this.editUsers = Button.get().getById("edit");

		}
	}

	// Elements
	private EditRegisteredUsersPageUIMap controls;

	public EditRegisteredUsersPage() {
		controls = new EditRegisteredUsersPageUIMap();
	}

	// PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	public IButton getEditUsers() {
		return this.controls.editUsers;
	}

	// Set

	public void clickEditUsers() {
		getEditUsers().click();
	}

	public EditNewuserPage goToEditNewuserPage() {
		clickEditUsers();
		return new EditNewuserPage();
	}

}
