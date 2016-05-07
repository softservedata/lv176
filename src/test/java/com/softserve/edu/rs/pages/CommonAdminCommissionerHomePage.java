package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.Link;

public class CommonAdminCommissionerHomePage extends CommonPage {
	
	private class CommonAdminCommissionerHomePageUIMap {
		public final ILink createNewUser;
		public final ILink users;
		
		public CommonAdminCommissionerHomePageUIMap() {
			this.createNewUser = Link.get().getByXpath("//a[contains(@href,'/manualregistration')]");
			this.users = Link.get().getByXpath("//li[@class='dropdown']");
		}
	}
	
	private class StatusUsersPageUIMap {
		public final ILink active;
		public final ILink inactive;
		public final ILink nonConfirmed;
		public final ILink blocked;
		
		public StatusUsersPageUIMap() {
			this.active = Link.get().getByXpath("//a[contains(@href,'/users/get-all-users')]");
			this.inactive = Link.get().getByXpath("//a[contains(@href,'/users/get-all-users?statusType=inactive')]");
			this.nonConfirmed = Link.get().getByXpath("//a[contains(@href,'/users/get-all-users?statusType=notcomfirmed')]");
			this.blocked = Link.get().getByXpath("//a[contains(@href,'/users/get-all-users?statusType=block')]");
		}
	}
	
	private CommonAdminCommissionerHomePageUIMap controls;
	private StatusUsersPageUIMap statusUsersControls;
	
	public CommonAdminCommissionerHomePage() {
		controls = new CommonAdminCommissionerHomePageUIMap();
	}
	
	public ILink getCreateNewUser() {
		return this.controls.createNewUser;
	}
	
	public ILink getUsers() {
		return this.controls.users;
	}
	
	public String getCreateNewUserText() {
		return getCreateNewUser().getText();
	}
	
	public String getUsersText() {
		return getUsers().getText();
	}
	
	public ILink getActive() {
		clickUsers();
		return this.statusUsersControls.active;
	}
	
	public ILink getInactive() {
		clickUsers();
		return this.statusUsersControls.inactive;
	}
	
	public ILink getNonConfirmed() {
		clickUsers();
		return this.statusUsersControls.nonConfirmed;
	}
	
	
	public ILink getBlocked() {
		clickUsers();
		return this.statusUsersControls.blocked;
	}
	
	public void setFocusUsers() {
		getUsers().setFocus();
	}

	public void clickUsers() {
		setFocusUsers();
		getUsers().click();
		statusUsersControls = new StatusUsersPageUIMap();
	}
	
	public void clickCreateNewUser() {
		getCreateNewUser().click();
	}
	
	public void clickActive() {
		getActive().click();
	}
	
	public void clickInactive() {
		getInactive().click();
	}
	
	public void clickNonConfirmed() {
		getNonConfirmed().click();
	}
	
	public void clickBlocked() {
		getBlocked().click();
	}
	
	public CreateNewUserPage gotoCreateNewUserPage() {
		clickCreateNewUser();
		return new CreateNewUserPage();
	}

	public NonConfirmedUsersPage gotoNonConfirmedUsersPage() {
		clickUsers();
		clickNonConfirmed();
		return new NonConfirmedUsersPage();
	}
}
