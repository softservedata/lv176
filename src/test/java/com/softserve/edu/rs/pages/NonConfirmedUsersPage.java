package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.entity.IUser;

public class NonConfirmedUsersPage extends CommonAdminCommissionerHomePage {
	@FindBy(xpath = "//h4")
	private WebElement title;
	@FindBy(id = "inputIndex3")
	private WebElement inputLogin;
	@FindBy(id = "bth-search")
	private WebElement buttonSearch;

	public NonConfirmedUsersPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}

	public WebElement getInputLogin() {
		return this.inputLogin;
	}

	public WebElement getButtonSearch() {
		return this.buttonSearch;
	}

	public void clickInputLogin() {
		getInputLogin().click();
	}

	public void clearInputLogin() {
		getInputLogin().clear();
	}

	public void setInputLogin(String login) {
		getInputLogin().sendKeys(login);
	}

	public WebElement getXpathForProfilButton(String login) {
		return webDriver.findElement(By.xpath("//tbody/tr[td[text()='" + login + "']]/td/button[@id ='edit']"));
	}

	public NonConfirmedUsersPage searchByLogin(IUser user) {
		clickInputLogin();
		clearInputLogin();
		setInputLogin(user.getAccount().getLogin());
		WebElement firstRowOfTable = webDriver.findElement(By.xpath("//tbody/tr[1]"));
		getButtonSearch().click();
		(new WebDriverWait(webDriver, 2)).until(ExpectedConditions.stalenessOf(firstRowOfTable));
		return new NonConfirmedUsersPage(webDriver);
	}

	public void clickProfilButton(IUser user) {
		getXpathForProfilButton(user.getAccount().getLogin()).click();
	}

	public ProfilUserPage gotoProfilUser(IUser user) {
		searchByLogin(user);
		clickProfilButton(user);
		return new ProfilUserPage(webDriver);
	}
}
