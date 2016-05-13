package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.Link;

public class CommissionerHomePage extends CommonPage {
	private class CommissionerPageUIMap {
		public final ILink home;
		public final ILink users;
		public final ILink newUser;

    	public CommissionerPageUIMap() {
    		this.home = Link.get().getByCssSelector("a.glyphicon.glyphicon-home");
    		this.users = Link.get().getByXpath("//li[@class='dropdown']");
    		this.newUser = Link.get().getByXpath("//a[contains(@href,'/manualregistration')]");
    	}
    	
    }
	
	private CommissionerPageUIMap controls;
	
	public CommissionerHomePage() {
		this.controls = new CommissionerPageUIMap();
	}
	
	public ILink getHome() {
		return this.controls.home;
	}

	public ILink getUsers() {
		return this.controls.users;
	}
	
	public ILink getNewUser() {
		return this.controls.newUser;
	}
	
	
	
	
	
	
	
}
