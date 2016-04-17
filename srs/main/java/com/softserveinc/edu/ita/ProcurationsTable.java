package com.softserveinc.edu.ita;

import org.openqa.selenium.support.FindBy;
import java.util.List;
import com.codeborne.selenide.SelenideElement;

public class ProcurationsTable extends RegistratorMenu {
	@FindBy(css = "#body>div>h4")
	private SelenideElement actualPageName;

	@FindBy(css = "#datatable_length>label>select")
	private SelenideElement entriesQuantityCoiceButton;

	@FindBy(css = "#datatable_filter>label>input")
	private SelenideElement searchField;

	@FindBy(xpath = ".//*[@id='datatable_filter']/label")
	private SelenideElement searchFieldLable;

	@FindBy(xpath = ".//*[@id='datatable']/thead/tr/th[2]")
	private SelenideElement dataSortButton;

	@FindBy(xpath = ".//*[@id='datatable']/thead/tr/th[3]")
	private SelenideElement coownerSortButton;

	@FindBy(xpath = ".//*[@id='datatable']/thead/tr/th[4]")
	private SelenideElement registratorNameSortButton;

	@FindBy(xpath = ".//*[@id='datatable']/thead/tr/th[6]")
	private SelenideElement resorceRegistrationNumberSortButton;

	@FindBy(xpath = ".//*[@id='datatable']/thead/tr/th[7]")
	private SelenideElement resourceStatusSortButton;

	@FindBy(xpath = ".//*[@id='datatable']/thead/tr/th[8]")
	private SelenideElement actionWithProcurationSortButton;

	@FindBy(css = "#datatable tbody tr") // ---------?????????????
	private List<ProcurationInfo> procurationInfoList;

	// --sort data in procuration table--\\

	public void sortByDate() {
		this.dataSortButton.click();
	}

	public void sortByCoowner() {
		this.coownerSortButton.click();
	}

	public void sortByRegistratorName() {
		this.registratorNameSortButton.click();
	}

	public void sortByResourceNumber() {
		this.resorceRegistrationNumberSortButton.click();
	}

	public void sortByResourceStatus() {
		this.resourceStatusSortButton.click();
	}

	public void sortByAction() {
		this.actionWithProcurationSortButton.click();
	}

	// ----------search field fill----------\\

	public void searchFieadFill(String rowValue) {
		searchField.sendKeys(rowValue);
	}

	// ---------choice entries quantity-------\\
	public void choiceEntriesQuantity(String entriesQuantity) {
		entriesQuantityCoiceButton.selectOptionByValue(entriesQuantity);
	}

	// --web elements get text for internationalization test--\\

	public SelenideElement getActualPageName() {
		return actualPageName;
	}

	public SelenideElement gerEntriesQuantity() {
		return entriesQuantityCoiceButton;
	}

	public SelenideElement getSearchFieldLableText() {
		return searchFieldLable;
	}

	public SelenideElement dataSortButtonGetText() {
		return dataSortButton;
	}

	public SelenideElement coownerSortButtonGetText() {
		return coownerSortButton;
	}

	public SelenideElement registratorNameSortButtonGetText() {
		return registratorNameSortButton;

	}

	public SelenideElement resorceRegistrationNumberSortButtonGetText() {
		return resorceRegistrationNumberSortButton;
	}

	public SelenideElement resourceStatusSortButtonGetText() {
		return resourceStatusSortButton;
	}
	
	public SelenideElement actionWithProcurationSortButtonGetTExt() {
		return actionWithProcurationSortButton;
	}
}
