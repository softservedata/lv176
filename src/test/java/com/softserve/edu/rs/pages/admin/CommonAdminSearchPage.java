package com.softserve.edu.rs.pages.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.rs.pages.UserSearch;

public class CommonAdminSearchPage extends AdminHomePage {
	
	private UserSearch searchTable;	
	private WebElement searchTypeName;
	
	public CommonAdminSearchPage(WebDriver driver){
		super(driver);
		searchTable = new UserSearch(driver);
		this.searchTypeName = findByCss(".container>div>h4");
	}

	
	public WebElement getSearchTypeName(){
		return this.searchTypeName;
	}
	
	public String getTextFromSearchTypeName(){
		return getSearchTypeName().getText();
	}
	
	public UserSearch getUserSearch(){
		return this.searchTable;
	}
	
	public void setUserSearch(UserSearch searchTable){
		this.searchTable = searchTable;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
