package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.Link;


public class ResourceSearchPage extends RegistratorHomePage {
	
	private class ResourceSearchPageUIMap {
		public final ILink searchByCoordinate;
		public final ILink searchByArea;
		public final ILink searchByParameters;
		
		
		public ResourceSearchPageUIMap() {
			this.searchByCoordinate = Link.get().getById("searchByPointButton");
			this.searchByArea = Link.get().getById("searchByAreaButton");
			this.searchByParameters = Link.get().getById("searchByParameterButton");
		}
		
	}
	
	private ResourceSearchPageUIMap controls;

	public ResourceSearchPage() {
		
		this.controls = new ResourceSearchPageUIMap();
	}
	
	
	
	public ILink getSearchByCoordinate(){
		return this.controls.searchByCoordinate;
	}
	
	public ILink getSearchByArea(){
		return this.controls.searchByArea;
	}
	
	public ILink getSearchByParameters(){
		return this.controls.searchByParameters;
	}
	
	public void clickSearchByArea() {
		getSearchByCoordinate().click();
	}
	
	public void clickSearchByCoordinate() {
		getSearchByArea().click();
	}
	
	public void clickSearchByParameters() {
		getSearchByParameters().click();
	}
	
	

}
