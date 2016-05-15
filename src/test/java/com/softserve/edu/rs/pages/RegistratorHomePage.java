package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.Link;

public class RegistratorHomePage extends CommonPage {

	private class RegistratorHomePageUIMap {
		

		public final ILink registatorGoHome;
		public final ILink resourcesSearch;
		public final ILink subclassesObjects;
		public final ILink procurationsMenu;
		public final ILink addNewResource;

		public RegistratorHomePageUIMap() {
			this.registatorGoHome = Link.get().getByXpath(".//*[@id='navigationbar']/ul/li[1]/a");
			this.resourcesSearch = Link.get().getByXpath(".//*[@id='navigationbar']/ul/li[2]/a");
			this.subclassesObjects = Link.get().getByXpath(".//*[@id='navigationbar']/ul/li[3]/a");
			this.procurationsMenu = Link.get().getByXpath(".//*[@id='navigationbar']/ul/li[4]/a");
			this.addNewResource = Link.get().getByXpath(".//*[@id='navigationbar']/ul/li[5]/a");

		}
	}

	private class ProcurationMenu {
		public final ILink enteringData;
		public final ILink extractFromRegister;

		public ProcurationMenu() {
			this.enteringData = Link.get().getByXpath("//ul/li[4]/ul/li[1]/a");
			this.extractFromRegister = Link.get().getByXpath("//body/div[1]/div[3]");
		}
	}

	// ---------------------------------------

	private RegistratorHomePageUIMap controls;
	private ProcurationMenu procurationMenuControls;

	public RegistratorHomePage() {
		this.controls = new RegistratorHomePageUIMap();
	}

	// getElements--------

	public ILink getRegistratorHomePage() {
		return this.controls.registatorGoHome;
	}

	public ILink getResourceSearch() {
		return this.controls.resourcesSearch;
	}

	public String resourceSearchGetTExt() {
		return getResourceSearch().getText();
	}

	public ILink getSubclassesObjects() {
		return this.controls.subclassesObjects;
	}

	public String subclassesObjectsGetText() {
		return getSubclassesObjects().getText();
	}

	public ILink getProcurationsMenu() {
		return this.controls.procurationsMenu;
	}

	public String ProcurationsMenuGetTExt() {
		return getProcurationsMenu().getText();
	}

	public ILink getEnteringData() {
		procurationsMenuClick();
		return this.procurationMenuControls.enteringData;
	}

	public String enteringDataGetText() {
		return getEnteringData().getText();
	}

	public ILink getExtractFromRegister() {
		procurationsMenuClick();
		return this.procurationMenuControls.extractFromRegister;
	}

	public String extractFromRgisterGetText() {
		return this.getExtractFromRegister().getText();
	}

	public ILink getAddNewResource() {
		return this.controls.addNewResource;
	}
	
	public String addNewResourceGetText(){
		return getAddNewResource().getText();
	}
	
	// setters

	public RegistratorHomePage registratorGoHomeClick() {
		getRegistratorHomePage().click();
		return new RegistratorHomePage();
	}

	public void resourcesSearchClick() {
		getResourceSearch().click();
	}

	public void subclassesObjectsClick() {
		getSubclassesObjects().click();
	}

	public void procurationsMenuClick() {
		getProcurationsMenu().click();
		this.procurationMenuControls = new ProcurationMenu();
	}
	
	public EnteringData enteringDataClick(){
		getEnteringData().click();
		return new EnteringData();
	}
	//todo
	public RegistratorHomePage extractFromRegisterClick(){
		getExtractFromRegister().click();
		return new RegistratorHomePage();
	}
	
	 public RegistratorHomePage changeLanguage(ChangeLanguageFields language) {
	    	setChangeLanguage(language);
	        return new RegistratorHomePage();
	    }
}
