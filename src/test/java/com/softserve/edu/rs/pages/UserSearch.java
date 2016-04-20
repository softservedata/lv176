package com.softserve.edu.rs.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UserSearch extends AbstractAppPage {

	public static enum ItemsPerPage {
		TEN("10"), TWENTYFIVE("25"), FIFTY("50"), HUNDRED("100");

		private String field;

		private ItemsPerPage(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}

	private WebElement searchButton;
	private WebElement firstNameSearchField;
	private WebElement lastNameSearchField;
	private WebElement loginSearchField;
	private WebElement communitySearchField;
	private WebElement emailSearchField;
	private WebElement roleDropDownBox;
	private WebElement itemsPerPage;
	private List<WebElement> firstNamesFromSearchTable;
	private List<WebElement> lastNamesFromSearchTable;
	private List<WebElement> loginsFromSearchTable;
	private List<WebElement> communitiesFromSearchTable;
	private List<WebElement> emailsFromSearchTable;
	private List<WebElement> rolesFromSearchTable;

	public UserSearch(WebDriver driver) {
		super(driver);
		this.searchButton = findById("bth-search");
		this.firstNameSearchField = findById("inputIndex1");
		this.lastNameSearchField = findById("inputIndex2");
		this.loginSearchField = findById("inputIndex3");
		this.communitySearchField = findById("inputIndex4");
		this.emailSearchField = findById("inputIndex5");
		this.roleDropDownBox = findById("inputIndex6");
		this.firstNamesFromSearchTable = findCollectionByCss("td.firstName");
		this.lastNamesFromSearchTable = findCollectionByCss("td.lastName");
		this.loginsFromSearchTable = findCollectionByCss("td.login.sorting_1");
		this.communitiesFromSearchTable = findCollectionByCss("td.territorialCommunity_name");
		this.emailsFromSearchTable = findCollectionByCss("td.email");
		this.rolesFromSearchTable = findCollectionByCss("td.role_type");
		this.itemsPerPage = findByXpath("//select[@name='example_length']");
	}

	// -----getters

	public WebElement getSearchButton() {
		return this.searchButton;
	}
	public WebElement getFirstName() {
		return this.firstNameSearchField;
	}
	public WebElement getLastName() {
		return this.lastNameSearchField;
	}
	public WebElement getLogin() {
		return this.loginSearchField;
	}
	public WebElement getCommunity() {
		return this.communitySearchField;
	}
	public WebElement getEmail() {
		return this.emailSearchField;
	}
	public Select getRoleDropDownBox() {
		return new Select(roleDropDownBox);
	}
	public Select getItemsPerPage() {
		return new Select(itemsPerPage);
	}
	public String getItemsPerPageSelectedText() {
		return getItemsPerPage().getFirstSelectedOption().getText();
	}
	public String getChangeRoleFieldSelectedText() {
		return getRoleDropDownBox().getFirstSelectedOption().getText();
	}
	public List<WebElement> getFirstNamesFromSearchTable() {
		return this.firstNamesFromSearchTable;
	}
	public List<WebElement> getLastNamesFromSearchTable() {
		return this.lastNamesFromSearchTable;
	}
	public List<WebElement> getLoginsFromSearchTable() {
		return this.loginsFromSearchTable;
	}
	public List<WebElement> getCommunitiesFromSearchTable() {
		return this.communitiesFromSearchTable;
	}
	public List<WebElement> getEmailsFromSearchTable() {
		return this.emailsFromSearchTable;
	}
	public List<WebElement> getRolesFromSearchTable() {
		return this.rolesFromSearchTable;
	}
	

	// ---- Set data

	public void setFirstName(String data) {
		getFirstName().sendKeys(data);
	}
	public void setLastName(String data) {
		getLastName().sendKeys(data);
	}
	public void setLogin(String data) {
		getLogin().sendKeys(data);
	}
	public void setCommunity(String data) {
		getCommunity().sendKeys(data);
	}
	public void setEmail(String data) {
		getEmail().sendKeys(data);
	}
	public void clickFirsName() {
		getFirstName().click();
	}
	public void clearFirsName() {
		getFirstName().clear();
	}
	public void clickLastName() {
		getLastName().click();
	}
	public void clearLastName() {
		getLastName().clear();
	}
	public void clickLogin() {
		getLogin().click();
	}
	public void clearLogin() {
		getLogin().clear();
	}
	public void clickCommunity() {
		getCommunity().click();
	}
	public void clearCommunity() {
		getCommunity().clear();
	}
	public void clickEmail() {
		getEmail().click();
	}
	public void clearEmail() {
		getEmail().clear();
	}
	public void setAnotherRole(String role) {
		getRoleDropDownBox().selectByValue(role);
	}
	public UserSearch setItemsPerPage(ItemsPerPage items) {
		getItemsPerPage().selectByValue(items.toString());
		return new UserSearch(driver);
	}
	public UserSearch searchByFirstName(String data) {
		clickFirsName();
		clearFirsName();
		setFirstName(data);
		clickSearchButton();
		return new UserSearch(driver);
	}
	public UserSearch searchByLastName(String data) {
		clickLastName();
		clearLastName();
		setLastName(data);
		clickSearchButton();
		return new UserSearch(driver);
	}
	public UserSearch searchByLogin(String data) {
		clickLogin();
		clearLogin();
		setLogin(data);
		clickSearchButton();
		return new UserSearch(driver);
	}
	public UserSearch searchByCommunity(String data) {
		clickCommunity();
		clearCommunity();
		setCommunity(data);
		clickSearchButton();
		return new UserSearch(driver);
	}
	public UserSearch searchByEmail(String data) {
		clickEmail();
		clearEmail();
		setEmail(data);
		clickSearchButton();
		return new UserSearch(driver);
	}
	public UserSearch searchByRole(String role) {
		setAnotherRole(role);
		clickSearchButton();
		return new UserSearch(driver);
	}

	// ----Business logic

	public void clickSearchButton() {
		getSearchButton().click();
	}
	
	public String getItemsQuantityPerPage(){
		String result;
		result = String.valueOf(getLoginsFromSearchTable().size());
		return result;
	}
	
	
	
	

}
