package com.softserve.edu.rs.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.rs.data.apps.Application;
import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.users.AddNewCommunity;
import com.softserve.edu.rs.data.users.AddNewCommunityRepository;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.AddNewCommunityPage;
import com.softserve.edu.rs.pages.AdminHomePage;
import com.softserve.edu.rs.pages.ShowAllCommunitiesPage;

public class Demo3 {

	private AdminHomePage adminHomePage;
	private ShowAllCommunitiesPage showAllCommunitiesPage;
	private Application application;
	private AddNewCommunityPage addNewCommunityPage;

	private static final String COMMUNITY_FOR_CHECK_EDIT_OPTION = "Черкаська територіальна громада";
	private static final String EDITED_COMMUNITY = "Тернопільська територіальна громада";
	private static final String COMMUNITY_FOR_CHECK_DELETE_OPTION = "Хмельницька територіальна громада";
	private static final String COMMUNITY_WITH_ALHABETICAL_SYMBOLS = "USA Community";
	private static final String COMMUNITY_WITH_CYRILLIC_SYMBOLS = "Зборівська територіальна громада";
	private static final String COMMUNITY_WITH_ONLY_NUMBER_SYMBOLS = "0123456789";
	private static final String TITLE_SHOW_ALL_COMMNUNITY_PAGE = "Показати всі громади";

	@BeforeClass
	public void oneTimeSetUp() {
		application = new Application(ApplicationSourcesRepository.get().getLocalHostByFirefoxTemporary());
	}

	@AfterClass
	public void oneTimeTearDown() {
		application.close();
	}

	@BeforeMethod()
	public void setUp() {
		adminHomePage = application.load().successAdminLogin(UserRepository.get().getAdmin());
	}

	@AfterMethod
	public void tearDown() {
		application.logout();
	}

	@Test
	public void ShowAllCommunitiesPageSmokeTest() {
		showAllCommunitiesPage = adminHomePage.gotoShowAllCommunitiesPage();
		Assert.assertTrue(showAllCommunitiesPage.getNameOfTableText().contains(TITLE_SHOW_ALL_COMMNUNITY_PAGE));
	}

	@DataProvider
	public Object[][] AddCommunityForCheckDeleteOption() {
		return new Object[][] { { AddNewCommunityRepository.get().getCommunityForDelete(), } };
	}

	@Test(dataProvider = "AddCommunityForCheckDeleteOption")
	public void AddCommunityForDelete(AddNewCommunity DataForCheckDeleteCommunityOption) {
		showAllCommunitiesPage = adminHomePage.gotoShowAllCommunitiesPage().gotoAddNewCommunityPage()
				.successInputData(DataForCheckDeleteCommunityOption).saveCommunityButton();
		Assert.assertTrue(showAllCommunitiesPage.VerifyDisplayedOfCommunity(COMMUNITY_FOR_CHECK_DELETE_OPTION),
				"Error! Community is not present in the list.");
	}

	@Test
	public void CheckDeleteOption() {
		showAllCommunitiesPage = adminHomePage.gotoShowAllCommunitiesPage()
				.clickDeleteButton(COMMUNITY_FOR_CHECK_DELETE_OPTION).clickConfirmButtonOk();

		Assert.assertTrue(showAllCommunitiesPage.VerifyDisplayedOfCommunity(COMMUNITY_FOR_CHECK_DELETE_OPTION),
				"Error! Community is present in the list.");
	}

	@DataProvider
	public Object[][] AddCommunityForCheckEditOption() {
		return new Object[][] { { AddNewCommunityRepository.get().getCreateCommunityForEdit() } };
	}

	@Test(dataProvider = "AddCommunityForCheckEditOption")
	public void AddCommunityForEdit(AddNewCommunity DataForChecEditCommunityOption) {
		showAllCommunitiesPage = adminHomePage.gotoShowAllCommunitiesPage().gotoAddNewCommunityPage()
				.successInputData(DataForChecEditCommunityOption).saveCommunityButton();

		Assert.assertTrue(showAllCommunitiesPage.VerifyDisplayedOfCommunity(COMMUNITY_FOR_CHECK_EDIT_OPTION),
				"Error! Community is not present in the list.");
	}

	@DataProvider
	public Object[][] CheckEditOption() {
		return new Object[][] { { AddNewCommunityRepository.get().getCreateCommunityForCheckEditOption(), } };
	}

	@Test(dataProvider = "CheckEditOption")
	public void CheckEditOption(AddNewCommunity CheckEditCommunityOption) {
		showAllCommunitiesPage = adminHomePage.gotoShowAllCommunitiesPage()
				.gotoEditCommunityPage(COMMUNITY_FOR_CHECK_EDIT_OPTION).successInputData(CheckEditCommunityOption);

		Assert.assertTrue(showAllCommunitiesPage.VerifyDisplayedOfCommunity(EDITED_COMMUNITY));
		Assert.assertFalse(showAllCommunitiesPage.VerifyDisplayedOfCommunity(COMMUNITY_FOR_CHECK_EDIT_OPTION));
	}

	@DataProvider
	public Object[][] clearCommunityField() {
		return new Object[][] { { AddNewCommunityRepository.get().getCommunityForClear(), } };
	}

	@Test(dataProvider = "clearCommunityField")
	public void ClearCommunity(AddNewCommunity CommunityForClear) {
		addNewCommunityPage = adminHomePage.gotoShowAllCommunitiesPage().gotoAddNewCommunityPage()
				.successInputData(CommunityForClear).clickClearButton();
		Assert.assertTrue(addNewCommunityPage.getNewCommunityFieldText().isEmpty(), "Add community field is not empty");
		Assert.assertTrue(addNewCommunityPage.getNewRegisterNumberFieldText().isEmpty(),
				"Add registered number is not empty");
	}

	@DataProvider
	public Object[][] addDifferentSymbolsTypeCommunity() {
		return new Object[][] { { AddNewCommunityRepository.get().getCommunityWithAlphabeticalSymbols(),
				AddNewCommunityRepository.get().getCommunityWithCyrillicSymbols(),
				AddNewCommunityRepository.get().getCommunityWithOnlyNumberSymbols(), } };

	}

	@Test(dataProvider = "addDifferentSymbolsTypeCommunity")
	public void AddCommunities(AddNewCommunity dataForAlphabeticalCommunity, AddNewCommunity dataForCyrillicCommunity,
			AddNewCommunity dataForNumericalCommunity) {
		showAllCommunitiesPage = adminHomePage.gotoShowAllCommunitiesPage().gotoAddNewCommunityPage()
				.successInputData(dataForAlphabeticalCommunity).saveCommunityButton().gotoAddNewCommunityPage()
				.successInputData(dataForCyrillicCommunity).saveCommunityButton().gotoAddNewCommunityPage()
				.successInputData(dataForNumericalCommunity).saveCommunityButton();
		Assert.assertTrue(showAllCommunitiesPage.VerifyDisplayedOfCommunity(COMMUNITY_WITH_ALHABETICAL_SYMBOLS));
		Assert.assertTrue(showAllCommunitiesPage.VerifyDisplayedOfCommunity(COMMUNITY_WITH_CYRILLIC_SYMBOLS));
		Assert.assertTrue(showAllCommunitiesPage.VerifyDisplayedOfCommunity(COMMUNITY_WITH_ONLY_NUMBER_SYMBOLS));

	}

	@Test
	public void DeleteAllChanges() {
		showAllCommunitiesPage = adminHomePage.gotoShowAllCommunitiesPage()
				.clickDeleteButton(COMMUNITY_WITH_ALHABETICAL_SYMBOLS).clickConfirmButtonOk()
				.clickDeleteButton(COMMUNITY_WITH_CYRILLIC_SYMBOLS).clickConfirmButtonOk()
				.clickDeleteButton(COMMUNITY_WITH_ONLY_NUMBER_SYMBOLS).clickConfirmButtonOk()
				.clickDeleteButton(EDITED_COMMUNITY).clickConfirmButtonOk();
		Assert.assertFalse(showAllCommunitiesPage.VerifyDisplayedOfCommunity(COMMUNITY_WITH_ALHABETICAL_SYMBOLS));
		Assert.assertFalse(showAllCommunitiesPage.VerifyDisplayedOfCommunity(COMMUNITY_WITH_CYRILLIC_SYMBOLS));
		Assert.assertFalse(showAllCommunitiesPage.VerifyDisplayedOfCommunity(COMMUNITY_WITH_ONLY_NUMBER_SYMBOLS));

	}

}
