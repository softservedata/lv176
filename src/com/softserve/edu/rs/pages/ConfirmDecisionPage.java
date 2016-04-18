package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmDecisionPage extends CommonPage {

	private WebElement ConfirmButtonOk;

	public ConfirmDecisionPage(WebDriver driver) {
		super(driver);
		this.ConfirmButtonOk = driver.findElement(By.cssSelector("button[data-bb-handler$='confirm"));
	}
	
	public WebElement getConfirmButtonOk() {
		return this.ConfirmButtonOk;
	}
	
	public ShowAllCommn clickConfirmButtonOk() {
		getConfirmButtonOk().click();
		return new  ShowAllCommn(driver);
	}
	

}
