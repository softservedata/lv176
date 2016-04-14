package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class CommonPage extends BasePage {
	@FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
	private WebElement labelUserLogin;
	@FindBy(xpath = "//button[@data-toggle='dropdown']")
	private WebElement dropdownButton;
	@FindBy(xpath = "//a[contains(@href,'/logout')]")
	private WebElement logout;

	public CommonPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	public WebElement getLabelUserLogin() {
		return this.labelUserLogin;
	}
	
	public WebElement getButtonDropdown() {
		return this.dropdownButton;
	}
	
	public WebElement getLogout() {
		return this.logout;
	}

	public String getLoginAccountText() {
		return this.labelUserLogin.getText();
	}
	
	public void clickDropdown() {
		getButtonDropdown().click();
	}
	
	public LoginPage logout() {
		clickDropdown();
		getLogout().click();
		(new WebDriverWait(webDriver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		return new LoginPage(webDriver);
	}

}
