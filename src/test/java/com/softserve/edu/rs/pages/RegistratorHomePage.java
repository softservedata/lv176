package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.Link;
import com.softserve.edu.atqc.data.apps.PageObserveLoad;
import com.softserve.edu.rs.pages.CommonPage;
import com.softserve.edu.rs.pages.LoginPage;

public class RegistratorHomePage extends CommonPage {

	private class RegistratorHomePageUIMap {
		public final ILink resourceSearch;
		public final ILink addNewResource;

		public RegistratorHomePageUIMap() {
			this.resourceSearch = Link.get().getByCssSelector("a[href*='resource/searchOnMap']");
			this.addNewResource = Link.get().getByCssSelector("a[href*='resource/new']");
		}
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Elements
	private RegistratorHomePageUIMap controls;

	public RegistratorHomePage() {
		// super();
		PageObserveLoad.get().deleteLoadCompleteEvents();
		this.controls = new RegistratorHomePageUIMap();
	}
	
    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Get Elements
	
	public ILink getResourceSearche(){
		return this.controls.resourceSearch;
	}
	
	public ILink getAddNewResource(){
		return this.controls.addNewResource;
	}

	
	// Set Data

	public void clickResourceSearch() {
		getResourceSearche().click();
	}
	
	public void clickAddNewResource() {
		getAddNewResource().click();
	}
	
	// Business Logic
	// Functional

	public RegistratorHomePage changeLanguage(ChangeLanguageFields language) {
		setChangeLanguage(language);
		return new RegistratorHomePage();
	}
	
	
	public LoginPage logout() {
		clickLogout();
		return new LoginPage();
	}

	
	public ResourceSearchPage gotoResourceSearchPage() {
		clickResourceSearch();
		return new ResourceSearchPage();
	}
	
	
	public AddNewResourceHomePage gotoAddNewResource() {
		clickAddNewResource();
		return new AddNewResourceHomePage();
	}

}
