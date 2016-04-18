package com.softserve.edu.rs.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShowAllCommn extends CommonPage {

	@FindBy(xpath = "//td[contains(text(),'122:22:22:222:22222')]/following-sibling::td[1]/descendant::div[2]/a[@id ='deletecommunity']")
	private WebElement DeleteButton;

	@FindBy(xpath = ".//*[@id='body']/p/a")
	private WebElement AddNewCommunitySecond;

	@FindBy(xpath = "")
	private List<WebElement> ElementsOfTable;

	@FindBy(xpath = "//td[contains(text(),'Черкаська')]/following-sibling::td[2]/descendant::div[1]/a[@id ='editcommunity']")
	private WebElement EditButton;

	@FindBy(xpath = ".//*[@id='body']/div/h4")
	private WebElement NameOfTable;

	@FindBy(xpath = "//td[contains(text(),'Тернопільська')]/following-sibling::td[2]/descendant::div[2]/a[@id ='deletecommunity']")
	private WebElement DeleteTempEditCommn;

	@FindBy(xpath = "//td[contains(text(),'12345')]/following-sibling::td[2]/descendant::div[2]/a[@id ='deletecommunity']")
	private WebElement DeleteTempNumericalCommn;

	@FindBy(xpath = "//td[contains(text(),'Poltava')]/following-sibling::td[2]/descendant::div[2]/a[@id ='deletecommunity']")
	private WebElement DeleteTempAlhabeticalCommn;

	@FindBy(xpath = "//td[contains(text(),'Винники')]/following-sibling::td[2]/descendant::div[2]/a[@id ='deletecommunity']")
	private WebElement DeleteTempCyrillicCommn;

	public ShowAllCommn(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public WebElement getDeleteTempEditCommn() {
		return this.DeleteTempEditCommn;
	}

	public WebElement getDeleteTempNumericalCommn() {
		return this.DeleteTempNumericalCommn;
	}

	public WebElement getDeleteTempAlhabeticalCommn() {
		return this.DeleteTempAlhabeticalCommn;
	}

	public WebElement getDeleteTempCyrillicCommn() {
		return this.DeleteTempCyrillicCommn;
	}

	public WebElement getNameOfTable() {
		return this.NameOfTable;
	}

	public WebElement getEditButton() {
		return this.EditButton;
	}

	public WebElement getDeleteButton() {
		return this.DeleteButton;
	}

	public WebElement getAddNewCommunitySecond() {
		return this.AddNewCommunitySecond;
	}

	public List<WebElement> getElementsOfTable() {
		return this.ElementsOfTable;
	}

	public void clickDeleteTempEditCommn() {
		getDeleteTempEditCommn().click();
		;
	}

	public void clickDeleteTempNumericalCommn() {
		getDeleteTempNumericalCommn().click();
		;
	}

	public void clickDeleteTempAlhabeticalCommn() {
		getDeleteTempAlhabeticalCommn().click();
	}

	public void clickDeleteTempCyrillicCommn() {
		getDeleteTempCyrillicCommn().click();
	}

	public void clickDeleteButton() {
		getDeleteButton().click();
	}

	public void clickAddNewCommunity() {
		getAddNewCommunitySecond().click();
	}

	public void clickEditButton() {
		getEditButton().click();
	}

	public EditCommunityPage gotoEditCommunityPage() {
		clickEditButton();
		return new EditCommunityPage(driver);
	}

	public AddNewCommunityPage gotoAddNewCommunityPageSecond() {
		clickAddNewCommunity();
		return new AddNewCommunityPage(driver);
	}

	public ConfirmDecisionPage gotoConfirmDecisionPage() {
		clickDeleteButton();
		return new ConfirmDecisionPage(driver);
	}

	public ConfirmDecisionPage gotoConfirmDecisionPageTempCommnEdit() {
		clickDeleteTempEditCommn();

		return new ConfirmDecisionPage(driver);
	}

	public ConfirmDecisionPage gotoConfirmDecisionPageTempCommnNumerical() {

		clickDeleteTempNumericalCommn();

		return new ConfirmDecisionPage(driver);
	}

	public ConfirmDecisionPage gotoConfirmDecisionPageTempCommnAlhabetical() {
		clickDeleteTempAlhabeticalCommn();
		return new ConfirmDecisionPage(driver);
	}

	public ConfirmDecisionPage gotoConfirmDecisionPageTempCommnCyrillicl() {
		clickDeleteTempCyrillicCommn();
		return new ConfirmDecisionPage(driver);
	}

}
