package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.data.apps.PageObserveLoad;

public class ProfilUserPage extends CommonPage {
	
	private class ProfilUserPageUIMap {
		public final IButton buttonEdit;
		
		public ProfilUserPageUIMap() {
			this.buttonEdit = Button.get().getById("edit");
		}
	}
	
	private ProfilUserPageUIMap controls;
	
	public ProfilUserPage() {
		PageObserveLoad.get().deleteLoadCompleteEvents();
		controls = new ProfilUserPageUIMap();
	}

	public IButton getButtonEdit() {
		return this.controls.buttonEdit;
	}

	public EditProfilUserPage clickButtonEdit() {
		getButtonEdit().click();
		return new EditProfilUserPage();
	}
}