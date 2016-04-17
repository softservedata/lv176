package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class CommonPage extends TopPage {

	private WebElement labelUserLogin;
	private WebElement dropdownButton;
	private WebElement logout;

	public CommonPage(WebDriver driver) {
		super(driver);
		this.labelUserLogin = driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm']"));
		this.dropdownButton = driver.findElement(By.xpath("//button[@data-toggle='dropdown']"));
		this.logout = driver.findElement(By.xpath("//a[contains(@href,'/logout')]"));
	}

	// Get Elements
	public WebElement getLoginAccount() {
		return this.labelUserLogin;
	}
	
	public WebElement getdropdownButton() {
		return this.dropdownButton;
	}
	
	public WebElement getLogout() {
		return this.logout;
	}
	
	public String getLoginAccountText() {
		return this.labelUserLogin.getText();
	}
	
	// Set Data
	
	public void clickLogout() {
		this.dropdownButton.click();
		this.logout.click();
	}
	
}
