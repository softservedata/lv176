package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.atqc.controls.ILabelClickable;
import com.softserve.edu.atqc.controls.LabelClickable;

public abstract class RegistratorCommonPage extends CommonPage {
	public RegistratorCommonPage() {
		 registratorHome=LabelClickable.get().getByCssSelector(".glyphicon.glyphicon-home");
		 resourcesSearch=LabelClickable.get().getByCssSelector("a[href$='/searchOnMap']");
		 objectSubclasses=LabelClickable.get().getByCssSelector("a[href$='/show-res-types']");
	//	 procurations=LabelClickable.get().getByCssSelector("a[href$='/#']");
		 addNewResource=LabelClickable.get().getByCssSelector("a[href$='/new']");
	}
	private ILabelClickable registratorHome;
	private ILabelClickable resourcesSearch;
	private ILabelClickable objectSubclasses;
	private ILabelClickable procurations;
	private ILabelClickable addNewResource;
	
	public ILabelClickable getResourcesSearch() {
		return resourcesSearch;
	}

	public ILabelClickable getObjectSubclasses() {
		return objectSubclasses;
	}


	public ILabelClickable getRegistratorHome() {
		return registratorHome;
	}

	public ILabelClickable getProcurations() {
		return procurations;
	}

	public ILabelClickable getAddNewResource() {
		return addNewResource;
	}
	
	public void clickHomeItem(){
		getRegistratorHome().click();
	}
	
	public RegistratorCommonPage clickResourceSearchItem(){
		getResourcesSearch().click();
	    return this;
	}
	
	public void clickObjectSubclassesItem(){
		getObjectSubclasses().click();
	}
	
	public void clickProcurationsItem(){
		getProcurations().click();
	}
	
	public void clickAddNewResourceItem(){
		getAddNewResource().click();
	}
	
}
