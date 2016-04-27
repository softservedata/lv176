package com.softserve.edu.rs.tests;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.testdata.SearchDataRepository;
import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.UserSearch.ItemsPerPage;
import com.softserve.edu.rs.pages.admin.ActiveUserSearchPage;
import com.softserve.edu.rs.pages.Application;
import com.softserve.edu.rs.testutils.TestDataPreparator;
import com.softserve.edu.rs.testutils.VerifyInfo;

public class TestSearchFields {
	private Application app;
	private IUser admin;
	private ActiveUserSearchPage activeUserSearchPage;
	
	@BeforeClass
	public void beforeSuit(){
		app = new Application(ApplicationSourcesRepository.get().getLocalHostByFirefox());
		admin = UserRepository.get().getAdmin();
	}

	@AfterClass
	public void afterSuit(){
		app.quitAll();
	}
	
	@BeforeMethod
	public void beforeMeth(){
		activeUserSearchPage = app.load().successAdminLogin(admin).clickActiveUsers();
	}
	
	@AfterMethod
	public void afterMeth(){
		app.logout();
	}
	
	@DataProvider
	public Object[][] loginData() {
		return TestDataPreparator
				.convertToMultidimensionalArray(SearchDataRepository.getDataForLoginField());
	}
	
	@Test(dataProvider = "loginData", enabled = false)
	public void loginSearchTest(String input) {
		activeUserSearchPage.setUserSearch(activeUserSearchPage.getUserSearch().typeInLoginField(input).clickSearchButton());
		boolean result = VerifyInfo
							.compareSearchResults(activeUserSearchPage.getUserSearch().getLoginsFromSearchTable(),input);
		Assert.assertTrue(result, "Search result doesn't contains input data");
	}
	
	@DataProvider
	public Object[][] rolesData() {
		return TestDataPreparator
				.convertToMultidimensionalArray(SearchDataRepository.getDataForRoleField());
	}

	@Test (dataProvider = "rolesData", enabled = false)
	public void roleSearchTest(String input){
		activeUserSearchPage.setUserSearch(
				activeUserSearchPage.getUserSearch()
									.setAnotherRole(input)
									.clickSearchButton());		
		boolean result = VerifyInfo
							.compareSearchResults(activeUserSearchPage.getUserSearch().getRolesFromSearchTable(), 
										activeUserSearchPage.getUserSearch().getChangeRoleFieldSelectedText());
		Assert.assertTrue(result, "Search result doesn't contains input data");
		
	}
	
	@DataProvider
	public Object[][] emailTestData() {
		return TestDataPreparator
				.convertToMultidimensionalArray(SearchDataRepository.getDataForEmailField());
	}

	@Test (dataProvider = "emailTestData", enabled = false)
	public void emailSearchTest(String input) {
		activeUserSearchPage.setUserSearch(activeUserSearchPage.getUserSearch().typeInEmailField(input).clickSearchButton());	
		boolean result = VerifyInfo
							.compareSearchResults(activeUserSearchPage.getUserSearch().getEmailsFromSearchTable(),input);
		Assert.assertTrue(result, "Search result doesn't contains input data");
	}
	
	@DataProvider
	public Object[][] itemsPerPageTestData() {
		return new Object[][]{
				{ItemsPerPage.TEN},
				{ItemsPerPage.TWENTYFIVE},
				{ItemsPerPage.FIFTY},
				{ItemsPerPage.HUNDRED}
		};
	}

	@Test(dataProvider = "itemsPerPageTestData", enabled = false)
	public void verifyItemsPerPageTest(ItemsPerPage items){
		activeUserSearchPage.setUserSearch(activeUserSearchPage.getUserSearch().setItemsPerPage(items));
		Assert.assertEquals(activeUserSearchPage.getUserSearch().getItemsQuantityPerPage(), 
				activeUserSearchPage.getUserSearch().getItemsPerPageSelectedText(), "Vrong amount of item on page");
	}
	
	
	
	
	
	

}
