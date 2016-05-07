package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.Label;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.entity.IUser;

public class NonConfirmedUsersPage extends CommonAdminCommissionerHomePage {
	
	private class NonConfirmedUsersPageUIMap {
		public final ILabel title;
		public final ITextField inputLogin;
		public final IButton buttonSearch;
		
		public NonConfirmedUsersPageUIMap() {
			this.title = Label.get().getByXpath("//h4");
			this.inputLogin = TextField.get().getById("inputIndex3");
			this.buttonSearch = Button.get().getById("bth-search");
		}
		
		public IButton getXpathForProfilButton(String login) {
			return Button.get().getByXpath("//tbody/tr[td[text()='" + login + "']]/td/button[@id ='edit']");
		}
	}
	
	private class EmptyTableUIMap {
		public final ILabel labelEmptyTable;
		
		public EmptyTableUIMap() {
			this.labelEmptyTable = Label.get().getByXpath("//td[@class='dataTables_empty']");
		}
	}
	
	private NonConfirmedUsersPageUIMap nonConfirmedPageControls;
	private EmptyTableUIMap emptyTableControls;
	
	public NonConfirmedUsersPage() {
		nonConfirmedPageControls = new NonConfirmedUsersPageUIMap();
	}
	
	public ILabel getTitle() {
		return this.nonConfirmedPageControls.title;
	}
	
	public ITextField getInputLogin() {
		return this.nonConfirmedPageControls.inputLogin;
	}

	public IButton getButtonSearch() {
		return this.nonConfirmedPageControls.buttonSearch;
	}
	
	public ILabel getLabelEmptyTable() {
		emptyTableControls = new EmptyTableUIMap();
		return this.emptyTableControls.labelEmptyTable;
	}

	public void clickInputLogin() {
		getInputLogin().click();
	}

	public void setInputLogin(String login) {
		getInputLogin().sendKeys(login);
	}
	
	public void setInputLoginClear(String login) {
		getInputLogin().sendKeysClear(login);
	}
	
	public void clearInputLogin() {
		getInputLogin().clear();
	}

	public NonConfirmedUsersPage searchByLogin(IUser user) {
		clickInputLogin();
		setInputLoginClear(user.getAccount().getLogin());
		getButtonSearch().click();
		return new NonConfirmedUsersPage();
	}

	public void clickProfilButton(IUser user) {
		nonConfirmedPageControls.getXpathForProfilButton(user.getAccount().getLogin()).click();
	}

	public ProfilUserPage gotoProfilUser(IUser user) {
		searchByLogin(user);
		clickProfilButton(user);
		return new ProfilUserPage();
	}
}
