package com.softserve.edu.rs.pages.regist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ResourcePage extends AddNewResourceHomePage {

	@FindBy(id = "resourceIdentifier")
	private WebElement resourceNumber;

	public ResourcePage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
	}

	// Get Elements

	public WebElement getResorceName() {
		return this.resourceNumber;
	}
	
	public String getResorceNameText(){
		return getResorceName().getText();
	}
	
	

}
