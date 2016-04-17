package com.softserveinc.edu.ita;

import org.openqa.selenium.support.FindBy;
import com.codeborne.selenide.SelenideElement;

public class RegistratorMenu extends UseersCommonPage {
	@FindBy(xpath = ".//*[@id='bs-example-navbar-collapse-1']/ul/li[1]/a")
	private SelenideElement registratorHomeLnk;

	@FindBy(xpath = ".//*[@id='bs-example-navbar-collapse-1']/ul/li[2]/a")
	private SelenideElement resourceSearchLnk;

	@FindBy(xpath = ".//*[@id='bs-example-navbar-collapse-1']/ul/li[3]/a")
	private SelenideElement subclassesOfResourcesLnk;

	@FindBy(xpath = ".//*[@id='bs-example-navbar-collapse-1']/ul/li[4]")
	private SelenideElement procurationsLnk;

	@FindBy(xpath = ".//*[@id='bs-example-navbar-collapse-1']/ul/li[4]/ul/li[1]/a")
	private SelenideElement enteringData;

	@FindBy(xpath = ".//*[@id='bs-example-navbar-collapse-1']/ul/li[4]/ul/li[2]/a")
	private SelenideElement extractFromRegisterLnk;

	@FindBy(xpath = ".//*[@id='bs-example-navbar-collapse-1']/ul/li[5]/a")
	private SelenideElement addNewResourceLnk;

	public SelenideElement getRegistratorHomeLnk() {
		return registratorHomeLnk;
	}

	public SelenideElement getResourceSearchLnk() {
		return resourceSearchLnk;
	}

	public SelenideElement getSubclassesOfResourcesLnk() {
		return subclassesOfResourcesLnk;
	}

	public SelenideElement getProcurationsLnk() {
		return procurationsLnk;
	}

	public SelenideElement getEnteringData() {
		return enteringData;
	}

	public SelenideElement getExtractFromRegisterLnk() {
		return extractFromRegisterLnk;
	}

	public SelenideElement getAddNewResourceLnk() {
		return addNewResourceLnk;
	}

	// ----registrator user menu-----\\

	public void registaGoHome() {
		registratorHomeLnk.click();
	}

	public void resourceSearch() {
		resourceSearchLnk.click();
	}

	public void showEnteringData() {
		procurationsLnk.click();
		enteringData.click();
	}

	public void extractFromRegister() {
		procurationsLnk.click();
		extractFromRegisterLnk.click();
	}

	public void addNewResource() {
		addNewResourceLnk.click();
	}

	// -----registrator user menu get text for internationalization test----\\
	public SelenideElement getregistratorHomeLnkText() {
		return registratorHomeLnk;
	}

	public SelenideElement getResourceSearchLnkText() {
		return resourceSearchLnk;
	}

	public SelenideElement getSubclassesOfResourcesLnkText() {
		return subclassesOfResourcesLnk;
	}

	public SelenideElement getProcurationsLnkText() {
		return procurationsLnk;
	}

	public SelenideElement getEnteringDataText() {
		procurationsLnk.click();
		return enteringData;
	}

	public SelenideElement getExtractFromRegisterLnkText() {
		procurationsLnk.click();
		return extractFromRegisterLnk;
	}

	public SelenideElement getAddNewResourceLnkText() {
		return addNewResourceLnk;
	}

}
