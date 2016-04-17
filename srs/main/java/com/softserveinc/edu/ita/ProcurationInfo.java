package com.softserveinc.edu.ita;

import org.openqa.selenium.support.FindBy;
import com.codeborne.selenide.SelenideElement;

public class ProcurationInfo extends ProcurationsTable{
	@FindBy(xpath = ".//*[@id='datatable']/tbody/tr[1]/td[2]")
	private SelenideElement procurationData;

	@FindBy(xpath = ".//*[@id='datatable']/tbody/tr[1]/td[3]")
	private SelenideElement partOwner;

	@FindBy(xpath = ".//*[@id='datatable']/tbody/tr[1]/td[4]")
	private SelenideElement registar;

	@FindBy(xpath = ".//*[@id='datatable']/tbody/tr[1]/td[6]/a")
	private SelenideElement resourRegistrNumb;

	@FindBy(xpath = ".//*[@id='datatable']/tbody/tr[1]/td[7]")
	private SelenideElement resourceStatus;

	@FindBy(xpath = ".//*[@id='datatable']/tbody/tr[1]/td[8]/div/a")
	private SelenideElement saveProcuration;

	// -------web elements get text for internationalization test-----////

	public String getProcurationData() {
		return this.procurationData.getText();
	}

	public String getPartOwner() {
		return this.partOwner.getText();
	}

	public String getRegistar() {
		return this.registar.getText();

	}

	public String getResourceStatus() {
		return this.resourceStatus.getText();
		
	}
	
	//////--------registrator user actions with procurations -----\\\\

	public void getResource() { 
		this.resourRegistrNumb.click();//-- show resource on the map---\\
	}

	public void saveProcuration() {
		this.saveProcuration.click();//-- save procuration on PC--\\
	}
}
