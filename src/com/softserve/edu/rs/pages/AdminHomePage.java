package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;;

public class AdminHomePage extends CommonPage {

	private WebElement ShowAllComm;

	public AdminHomePage(WebDriver driver) {
		super(driver);

		//this.ShowAllComm = driver.findElement(By.xpath(".//*[@id='menubaradmin']/div/div/ul/li[4]/a"));
		this.ShowAllComm = driver.findElement(By.cssSelector(".nav.navbar-nav li:nth-of-type(4)"));
	}

	public WebElement getAllCommunities() {
		return this.ShowAllComm;
	}

	public void clickShowAllCommunities() {
		getAllCommunities().click();
	}

	// Business Logic
	// Functional

	public AdminHomePage changeLanguage(ChangeLanguageFields language) {
		setChangeLanguage(language);
		// Return a new page object representing the destination.
		return new AdminHomePage(driver);
	}

	public ShowAllCommn gotoAllCommunitiesSecond() {
		clickShowAllCommunities();
		return new ShowAllCommn(driver);
	}

}
