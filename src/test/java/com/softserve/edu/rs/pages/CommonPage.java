package com.softserve.edu.rs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class CommonPage extends TopPage {
	//protected WebDriver driver;
	//
	
	@FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
	private WebElement loginAccount;
	@FindBy(xpath = "//button[@data-toggle='dropdown']")
	private WebElement menulogout;
	@FindBy(xpath = "//a[contains(@href,'/logout')]")
	private WebElement logout;

	public CommonPage(WebDriver driver) {
		super(driver);
		//this.driver = driver;
		//
		/*
		this.loginAccount=driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm']"));
		this.menulogout = driver.findElement(By.xpath("//button[@data-toggle='dropdown']"));
		this.logout=driver.findElement(By.xpath("//a[contains(@href,'/logout')]")); */
		
		PageFactory.initElements(driver, this);
		
	}

	// Get Elements
	
	public WebElement getLoginAccount() {
		return this.loginAccount;
	}
	
	public WebElement getMenuLogout() {
		return this.menulogout;
	}
	
	
	public WebElement getLogout() {
		return this.logout;
	}

	public String getLoginAccountText() {
		return this.loginAccount.getText();
	}
	
	// Set Data
	
	public void clickMenuLogout() {
		getMenuLogout().click();
	}
	
	public void clickLogout(){
		clickMenuLogout();
		getLogout().click();
	}

}
