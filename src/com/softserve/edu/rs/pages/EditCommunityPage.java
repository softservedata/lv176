package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.rs.data.users.EditCommunity;

public class EditCommunityPage extends CommonPage {

	private WebElement newCommunityNameEdit;
	private WebElement registerNumberCommunityEdit;
	private WebElement saveButtonCommunityEdit;

	public EditCommunityPage(WebDriver driver) {
		super(driver);
		this.newCommunityNameEdit = driver.findElement(By.xpath(".//*[@id='communityDTO']/div[1]/div/input[1]"));
		this.registerNumberCommunityEdit = driver.findElement(By.xpath(".//*[@id='communityDTO']/div[2]/div/input"));
		this.saveButtonCommunityEdit = driver.findElement(By.cssSelector(".btn.btn-success"));

	}

	public WebElement getregisterNumberEdit() {
		return this.registerNumberCommunityEdit;
	}

	public WebElement getsaveButtonEdit() {
		return this.saveButtonCommunityEdit;
	}

	public WebElement getnewCommunityEdit() {
		return this.newCommunityNameEdit;
	}

	public void setnewCommunityEdit(String nameCommunityEdit) {
		getnewCommunityEdit().sendKeys(nameCommunityEdit);
	}

	public void setregisterNumberEdit(String registerNumberEdit) {
		getregisterNumberEdit().sendKeys(registerNumberEdit);
	}

	public void clearnewCommunityEdit() {
		getnewCommunityEdit().clear();
	}

	public void clearregisterNumberEdit() {
		getregisterNumberEdit().clear();
	}

	public void clicknewCommunityEdit() {
		getnewCommunityEdit().click();
	}

	public void clickregisterNumberEdit() {
		getregisterNumberEdit().click();
	}

	public void clicksaveButtonEdit() {
		getsaveButtonEdit().click();
	}

	private void setEditData(EditCommunity newData) {
		clicknewCommunityEdit();
		clearnewCommunityEdit();
		setnewCommunityEdit(newData.getnameCommunityEdit());
		clickregisterNumberEdit();
		clearregisterNumberEdit();
		setregisterNumberEdit(newData.getregisterNumberEdit());

	}

	public EditCommunityPage successInputData(EditCommunity newData) {
		setEditData(newData);
		return new EditCommunityPage(driver);
	}

	public ShowAllCommn gotoShowAllCommunitiesPageSaveEditSecond() {
		clicksaveButtonEdit();
		return new ShowAllCommn(driver);
	}

}
