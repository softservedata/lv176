package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.rs.data.users.AddNewCommunity;

public class AddNewCommunityPage extends CommonPage {

	private WebElement newCommunityName;
	private WebElement registerNumberCommunity;
	private WebElement saveButtonCommunity;
	private WebElement cleanButton;
	private WebElement HeadPageAddNewCommunity;
	private WebElement VerifyFieldForEmpty;

	public AddNewCommunityPage(WebDriver driver) {
		super(driver);
		//this.newCommunityName = driver.findElement(By.xpath(".//*[@id='newCommunity']/div[1]/div/input"));
		this.newCommunityName = driver.findElement(By.cssSelector(".col-sm-3 .form-control[required]"));
		//this.registerNumberCommunity = driver.findElement(By.xpath(".//*[@id='newCommunity']/div[2]/div/input"));
		this.registerNumberCommunity = driver.findElement(By.cssSelector(".col-sm-3  .form-control[name='registrationNumber']"));
		this.saveButtonCommunity = driver.findElement(By.cssSelector(".btn.btn-success"));
		this.cleanButton = driver.findElement(By.cssSelector(".btn.btn-default"));
		
		this.HeadPageAddNewCommunity = driver.findElement(By.cssSelector("div#body h2"));
		this.VerifyFieldForEmpty = driver.findElement(By.cssSelector("[placeholder='¬вед≥ть']"));

	}




	public WebElement getregisterNumber() {
		return this.registerNumberCommunity;
	}

	public WebElement getsaveButton() {
		return this.saveButtonCommunity;
	}

	public WebElement getcleanButton() {
		return this.cleanButton;
	}
	
	public  WebElement getnewCommunity() {
		return this.newCommunityName;
	}
	
	public WebElement getHeadPageAddNewCommunity(){
		return this.HeadPageAddNewCommunity;
	}

	// Set Data

	public void setnewCommunity(String newCommunity) {
		getnewCommunity().sendKeys(newCommunity);
	}

	public void setregisterNumber(String registerNumber) {
		getregisterNumber().sendKeys(registerNumber);
	}

	public void clearnewCommunity() {
		getnewCommunity().clear();
	}

	public void clearregisterNumber() {
		getregisterNumber().clear();
	}

	public void clicknewCommunity() {
		getnewCommunity().click();
	}

	public void clickregisterNumber() {
		getregisterNumber().click();
	}

	public void clicksaveButton() {
		getsaveButton().click();
	}

	public void clickcleanButton() {
		getcleanButton().click();
	}

	

	// Business Logic
	// Functional

	private void setLoginData(AddNewCommunity newData) {
		clicknewCommunity();
		clearnewCommunity();
		setnewCommunity(newData.getnameCommunity());
		clickregisterNumber();
		clearregisterNumber();
		setregisterNumber(newData.getregisterNumber());

	}

	public AddNewCommunityPage successInputData(AddNewCommunity newData) {
		setLoginData(newData);
		return new AddNewCommunityPage(driver);
	}

	public ShowAllCommn gotoShowAllCommunitiesPageSaveSecond() {
		clicksaveButton();
		return new ShowAllCommn(driver);
	}
	

	/*public TotalAddedCommunitiPage gotoShowAllCommunitiesPageSave() {
		clicksaveButton();
		return new TotalAddedCommunitiPage(driver);
	}*/


	
	public void gotoCleanButton() {
		clickcleanButton();
	}

	/*
	 * public DeleteCommunityPage gotoShowAllCommunitiesPageSave() {
	 * clicksaveButton(); return new DeleteCommunityPage(driver); /* }
	 * 
	 * /* public LoginValidatorPage unsuccessfulLogin(IUser invalidUser) {
	 * setLoginData(invalidUser); return new LoginValidatorPage(driver); //
	 * return this; }
	 */

}
