package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class CommonPage extends TopPage {
	private WebElement loginAccount;
	private WebElement PreLogoutButtn;
	private WebElement logout;
	

	public CommonPage(WebDriver driver) {
		super(driver);
		this.loginAccount=driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm"));
		this.PreLogoutButtn = driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle"));
		this.logout = driver.findElement(By.xpath(".//*[@id='header']/div[2]/div[1]/div/ul/li[4]/a"));
		
	}

	// Get Elements
	
	public WebElement getLoginAccount() {
		return this.loginAccount;
	}
	
	public WebElement getPreLogoutButton(){
		return this.PreLogoutButtn;
	}
	
	public WebElement getLogout() {
		return this.logout;
	}

	
	public String getLoginAccountText() {
		return this.loginAccount.getText();
	}
	
	// Set Data
	
	public void clickPreLogoutButton(){
		getPreLogoutButton().click();
	}
	
	public void clickLogout() throws Exception {
		clickPreLogoutButton();
		Thread.sleep(2000);
		getLogout().click();
	}

}
