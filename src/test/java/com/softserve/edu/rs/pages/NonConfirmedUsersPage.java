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
		//public final ILabel labelEmptyTable;
		//public final ILabel firstRow;
		
		public NonConfirmedUsersPageUIMap() {
			this.title = Label.get().getByXpath("//h4");
			this.inputLogin = TextField.get().getById("inputIndex3");
			this.buttonSearch = Button.get().getById("bth-search");
			//this.labelEmptyTable = Label.get().getByXpath("//td[@class='dataTables_empty']");
			
			//this.firstRow = Label.get().getByXpath("//tbody/tr[1]");
			//this.buttonEdit = Button.get().getByXpath(xpath)
		}
		
		public IButton getXpathForProfilButton(String login) {
			return Button.get().getByXpath("//tbody/tr[td[text()='" + login + "']]/td/button[@id ='edit']");
		}
	}
	
	private class InvisibleElementUIMap {
		public final ILabel labelEmptyTable;
		
		public InvisibleElementUIMap() {
			this.labelEmptyTable = Label.get().getByXpath("//td[@class='dataTables_empty']");
		}
	}
	
	private NonConfirmedUsersPageUIMap controls;
	private InvisibleElementUIMap in;
	
	public NonConfirmedUsersPage() {
		controls = new NonConfirmedUsersPageUIMap();
	}
	
	public ILabel getTitle() {
		return this.controls.title;
	}
	
	public ITextField getInputLogin() {
		return this.controls.inputLogin;
	}

	public IButton getButtonSearch() {
		return this.controls.buttonSearch;
	}
	
	public ILabel getLabelEmptyTable() {
		in = new InvisibleElementUIMap();
		return this.in.labelEmptyTable;
	}
	
//	public ILabel getFirstRow() {
//		return this.controls.firstRow;
//	}

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
		//in = new InvisibleElementUIMap();
		//getLabelEmptyTable();
		//ControlSearch.get().isStatelessOfWebElement(getFirstRow().);
		//(new WebDriverWait(webDriver, 2)).until(ExpectedConditions.stalenessOf(firstRowOfTable));
		return new NonConfirmedUsersPage();
	}

	public void clickProfilButton(IUser user) {
		controls.getXpathForProfilButton(user.getAccount().getLogin()).click();
	}

	public ProfilUserPage gotoProfilUser(IUser user) {
		searchByLogin(user);
		clickProfilButton(user);
		return new ProfilUserPage();
	}
}
