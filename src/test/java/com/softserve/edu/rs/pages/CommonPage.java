package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.ILabelClickable;
import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.LabelClickable;
import com.softserve.edu.atqc.controls.Link;

public abstract class CommonPage {
	
	private class CommonPageUIMap {
    	public final ILabelClickable labelUserLogin;
    	public final ILabelClickable dropdownButton;
    	
    	public CommonPageUIMap() {
    		this.labelUserLogin = LabelClickable.get().getByXpath("//button[@class='btn btn-primary btn-sm']");
    		this.dropdownButton = LabelClickable.get().getByXpath("//button[@data-toggle='dropdown']");
    	}
    }
	
	private class MenuPageUIMap {
    	public final ILink changePassword;
    	public final ILink resetPassword;
    	public final ILink logout;
    	
    	public MenuPageUIMap() {
    		this.changePassword = Link.get().getByCssSelector("a.change-password");
    		this.resetPassword = Link.get().getByCssSelector("a.reset-my-password");
    		this.logout = Link.get().getByXpath("//a[contains(@href,'/logout')]");
    	}
    }
	
	private CommonPageUIMap controls;
    private MenuPageUIMap menuControls;
    
    public CommonPage() {
		this.controls = new CommonPageUIMap();
	}
    
    public ILabelClickable getLoginAccount() {
		return this.controls.labelUserLogin;
	}
	
	public String getLoginAccountText() {
		return getLoginAccount().getText();
	}

	public ILabelClickable getMenuAccount() {
		return this.controls.dropdownButton;
	}
	
	public ILink getChangePassword() {
		clickMenuAccount();
		return this.menuControls.changePassword;
	}

	public String getChangePasswordText() {
		return getChangePassword().getText();
	}
	
	public ILink getResetPassword() {
		clickMenuAccount();
		return this.menuControls.resetPassword;
	}

	public String getResetPasswordText() {
		return getResetPassword().getText();
	}

	public ILink getLogout() {
		clickMenuAccount();
		return this.menuControls.logout;
	}

	public String getLogoutText() {
		return getLogout().getText();
	}

	// Set Data

	public void clickLoginAccount() {
		getLoginAccount().click();
	}

	public void clickMenuAccount() {
		clickLoginAccount();
		getMenuAccount().click();
		this.menuControls = new MenuPageUIMap();
	}

	public void clickChangePassword() {
		getChangePassword().click();
	}

	public void clickResetPassword() {
		getResetPassword().click();
	}

	public LoginPage clickLogout() {
		getLogout().click();
		return new LoginPage();
	}
}
