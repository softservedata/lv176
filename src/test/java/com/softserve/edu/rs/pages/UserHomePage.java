package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.Link;

public class UserHomePage extends CommonPage {
	private class UserHomePageUIMap{
		public final ILink home;
		public final ILink resourceSearch;
		public final ILink procurations;
		
		private UserHomePageUIMap(){
			this.home = Link.get().getByCssSelector(".glyphicon.glyphicon-home");
			this.resourceSearch = Link.get().getByXpath("//a[@href='/resources/registrator/resource/searchOnMap']");
			this.procurations = Link.get().getByCssSelector(".not-active");
		}
	}
	
	private UserHomePageUIMap controls;
	
	public UserHomePage(){
		this.controls = new UserHomePageUIMap();
	}
	
	public ILink getHome() {
		return this.controls.home;
	}
	
	public ILink getResourceSearch() {
		return this.controls.resourceSearch;
	}
	
	public ILink getProcurations() {
		return this.controls.procurations;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
