package com.softserve.edu.rs.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShowAllCommn extends CommonPage {
	
	private  String Verify = "Lviv";
	//private  final String sss = "TTTT";

	@FindBy(xpath = "//td[contains(text(),'Житомирська')]/following-sibling::td[2]/descendant::div[2]/a[@id ='deletecommunity']")
	private WebElement DeleteButton;

	//@FindBy(xpath = ".//*[@id='body']/p/a")
	@FindBy(css = ".btn.btn-success[href='addCommunity']")
	private WebElement AddNewCommunitySecond;

	//@FindBy(xpath = "//td[1]")
	@FindBy(css = "td:nth-of-type(1)")
	private List<WebElement> ElementsOfTable;

	@FindBy(xpath = "//td[contains(text(),'Черкаська')]/following-sibling::td[2]/descendant::div[1]/a[@id ='editcommunity']")
	private WebElement EditButton;

	//@FindBy(xpath = ".//*[@id='body']/div/h4")
	@FindBy(css = "div[style='text-align: center;'] h4")
	private WebElement NameOfTable;



	public ShowAllCommn(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	public String getVer(){
		return this.Verify;
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

	public static boolean NewCheckComm(List<WebElement> searchResult, String expected) {
		boolean result = true;
		for (WebElement element : searchResult) {
			if (element.getText().contains(expected) == false) {
				result = false;
			}
		}
		return result;
	}

}
