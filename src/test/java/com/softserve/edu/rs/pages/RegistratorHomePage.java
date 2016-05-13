package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.Link;

public class RegistratorHomePage extends CommonPage {
	private class RegistratorHomePageUIMap{
		public final ILink home;
		public final ILink resourceSearch;
		public final ILink subclasses;
		public final ILink procurations;
		public final ILink addNewResource;
		
		private RegistratorHomePageUIMap(){
			this.home = Link.get().getByCssSelector(".glyphicon.glyphicon-home");
			this.resourceSearch = Link.get().getByXpath("//a[@href='/resources/registrator/resource/searchOnMap']");
			this.subclasses = Link.get().getByXpath(".//a[@href='/resources/registrator/resourcetypes/show-res-types']");
			this.procurations = Link.get().getByCssSelector(".not-active");
			this.addNewResource = Link.get().getByXpath(".//a[@href='/resources/registrator/resource/new']");
		}
	}
	
	private RegistratorHomePageUIMap controls;
	
	public RegistratorHomePage(){
		this.controls = new RegistratorHomePageUIMap();
	}
	
	public ILink getHome() {
		return this.controls.home;
	}
	
	public ILink getResourceSearch() {
		return this.controls.resourceSearch;
	}
	
	public ILink getSubclasses() {
		return this.controls.subclasses;
	}
	
	public ILink getProcurations() {
		return this.controls.procurations;
	}
	
	public ILink getAddNewResource() {
		return this.controls.addNewResource;
	}
	
	
	
	
	
	
	
	
	
	
	
}
