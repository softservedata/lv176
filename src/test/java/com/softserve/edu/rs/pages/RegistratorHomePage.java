package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.Link;

public class RegistratorHomePage extends CommonPage {

	private class RegistratorHomePageUIMap {
		public final ILink home;
		public final ILink resources;
		public final ILink subclassesObjects;
		public final ILink procurations;
		public final ILink newResource;

		public RegistratorHomePageUIMap() {
			this.home = Link.get().getByCssSelector("a.glyphicon.glyphicon-home");
			this.resources = Link.get().getByXpath("//a[contains(@href,'/searchOnMap')]");
			this.subclassesObjects = Link.get().getByXpath("//a[contains(@href,'/show-res-types')]");
			this.procurations = Link.get().getByCssSelector("a.not-active");
			this.newResource = Link.get().getByXpath("//a[contains(@href,'/new')]");
		}
	}

	// ---------------------------------------------------------------------------------

	private class ProcurationsMenuUIMap {
		public final ILink enteringData;
		public final ILink extractData;

		public ProcurationsMenuUIMap() {
			this.enteringData = Link.get().getByXpath("//a[contains(@href,'/add/listInquiryUserInput')]");
			this.extractData = Link.get().getByXpath("//a[contains(@href,'/add/listInqUserOut')]");
		}
	}

	// ---------------------------------------------------------------------------------

	private RegistratorHomePageUIMap controls;
	private ProcurationsMenuUIMap procurationsMenuControls;

	public RegistratorHomePage() {
		controls = new RegistratorHomePageUIMap();
	}

	// PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Get Elements

	public ILink getHome() {
		return this.controls.home;
	}

	public ILink getResources() {
		return this.controls.resources;
	}

	public ILink getSubclassesObjects() {
		return this.controls.subclassesObjects;
	}

	public ILink getProcurations() {
		return this.controls.procurations;
	}

	public ILink getNewResource() {
		return this.controls.newResource;
	}

	public String getHomeText() {
		return getHome().getText();
	}

	public String getResourcesText() {
		return getResources().getText();
	}

	public String getSubclassesObjectsText() {
		return getSubclassesObjects().getText();
	}

	public String getProcurationsText() {
		return getProcurations().getText();
	}

	public String getNewResourceText() {
		return getNewResource().getText();
	}

	// ---------------------------------------------------------------------------------

	public ILink getEnteringData() {
		clickProcurations();
		return this.procurationsMenuControls.enteringData;
	}

	public ILink getExtractData() {
		clickProcurations();
		return this.procurationsMenuControls.extractData;
	}

	// Set Data

	public void setFocusProcurations() {
		getProcurations().setFocus();
	}

	public void clickHome() {
		getHome().click();
	}

	public void clickResources() {
		getResources().click();
	}

	public void clickSubclassesObjects() {
		getSubclassesObjects().click();
	}

	public void clickProcurations() {
		setFocusProcurations();
		getProcurations().click();
		procurationsMenuControls = new ProcurationsMenuUIMap();
	}

	public void clickNewResource() {
		getNewResource().click();
	}

	// ---------------------------------------------------------------------------------

	public void clickEnteringData() {
		getEnteringData().click();
	}

	public void clickExtractData() {
		getExtractData().click();
	}

	// business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Functional

	public RegistratorHomePage changeLanguage(ChangeLanguageFields language) {
		setChangeLanguage(language);
		return new RegistratorHomePage();
	}

	public LoginPage logout() {
		clickLogout();
		return new LoginPage();
	}

	public SubclassesOfObjectsPage gotoSubclassPage() {
		    clickSubclassesObjects();
			return new SubclassesOfObjectsPage();
		}
}