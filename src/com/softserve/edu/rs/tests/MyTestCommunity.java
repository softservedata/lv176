package com.softserve.edu.rs.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.apps.VerifyEnabledOfCommunity;
import com.softserve.edu.rs.data.users.AddNewCommunity;
import com.softserve.edu.rs.data.users.AddNewCommunityRepository;
import com.softserve.edu.rs.data.users.EditCommunity;
import com.softserve.edu.rs.data.users.EditCommunityRepository;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.AddNewCommunityPage;
import com.softserve.edu.rs.pages.AdminHomePage;
import com.softserve.edu.rs.pages.Application;
import com.softserve.edu.rs.pages.ShowAllCommn;

public class MyTestCommunity {
	private Application application;
	private AdminHomePage adminHomePage;
	private static final String VerifyValueForCommunityCyrillic = "Винники";
	private static final String VerifyValueForCommunityDelete = "Житомирська";
	private static final String VerifyValuesForCommunityNumeric = "12345";
	private static final String VerifyValuesForCommunityAlphabetical = "Poltava";

	private static final String VerifyValuesCreateCommunityForEdit = "Черкаська";
	private static final String VerifyEditedrCommunity = "Тернопільська";
	private ShowAllCommn showAllCommunity;
	private AddNewCommunityPage addNewCommunityPage;

	@BeforeClass
	public void oneTimeSetUp() {
		application = new Application(ApplicationSourcesRepository.get().getLocalHostByFirefox());
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

	@Test(priority = 1)
	public void GeneralAdminSmokeTest() {
		Assert.assertEquals(adminHomePage.getAllCommunities().isEnabled(), true);
	}

	@Test(priority = 2)
	public void SmokeShowAll() {

		showAllCommunity = adminHomePage.gotoAllCommunitiesSecond();
		Assert.assertEquals(showAllCommunity.getNameOfTable().isEnabled(), true);

	}

	@Test(priority = 3)
	public void SmokeShowAddCommunityPage() {
		addNewCommunityPage = adminHomePage.gotoAllCommunitiesSecond().gotoAddNewCommunityPageSecond();
		Assert.assertEquals(addNewCommunityPage.getHeadPageAddNewCommunity().isDisplayed(), true);
		Assert.assertEquals(addNewCommunityPage.getnewCommunity().isDisplayed(), true);
		Assert.assertEquals(addNewCommunityPage.getregisterNumber().isDisplayed(), true);

	}

	@DataProvider
	public Object[][] AddCommunityForDelete() {
		return new Object[][] { { AddNewCommunityRepository.get().getNewCommunityForDelete(), } };
	}
	
	
	@Test(dataProvider = "AddCommunityForDelete", priority = 4)
	public void AddLastCommunity(AddNewCommunity DataForDeleteCommunity) {
		adminHomePage.gotoAllCommunitiesSecond().gotoAddNewCommunityPageSecond()
				.successInputData(DataForDeleteCommunity).gotoShowAllCommunitiesPageSaveSecond();
		boolean result = VerifyEnabledOfCommunity.VerifyOfCommunity(VerifyValueForCommunityDelete);
		Assert.assertEquals(result, true);
	}

	@Test(priority = 5)
	public void DeleteLastCommunity() {
		showAllCommunity = adminHomePage.gotoAllCommunitiesSecond().gotoConfirmDecisionPage().clickConfirmButtonOk();
		 Assert.assertTrue(showAllCommunity.getDeleteButton().isDisplayed());
	}

	@DataProvider
	public Object[][] clearCommunityField() {

		return new Object[][] { { AddNewCommunityRepository.get().getNewCommunityForClear(), } };
	}

	@Test(dataProvider = "clearCommunityField", priority = 6)
	public void ClearCommunity(AddNewCommunity CommunityForClear) {
		AddNewCommunityPage addNewCommunityPage = adminHomePage.gotoAllCommunitiesSecond()
				.gotoAddNewCommunityPageSecond().successInputData(CommunityForClear);

		Assert.assertEquals(addNewCommunityPage.getcleanButton().isEnabled(), true);

		addNewCommunityPage.clickcleanButton();

		boolean resultCommunityField = addNewCommunityPage.getnewCommunity().getText().isEmpty();
		Assert.assertEquals(resultCommunityField, true);
		boolean resultRegisteredField = addNewCommunityPage.getregisterNumber().getText().isEmpty();
		Assert.assertEquals(resultRegisteredField, true);
	}

	
	@DataProvider
	public Object[][] createCommunityForEdit() {
		return new Object[][] { { AddNewCommunityRepository.get().getCreateNewCommunityForEdit(), }

		};
	}

	@Test(dataProvider = "createCommunityForEdit", groups = "VerifyEditOfCommunity", priority = 7)
	public void CreateForEditCommunity(AddNewCommunity dataCreateForEdit) {
		adminHomePage.gotoAllCommunitiesSecond().gotoAddNewCommunityPageSecond().successInputData(dataCreateForEdit)
				.gotoShowAllCommunitiesPageSaveSecond();
		boolean result = VerifyEnabledOfCommunity.VerifyOfCommunity(VerifyValuesCreateCommunityForEdit);
		Assert.assertEquals(result, true);

	}

	@DataProvider
	public Object[][] editCommunity() {
		return new Object[][] { { EditCommunityRepository.get().getNewCommunityForEdit(), }

		};
	}

	@Test(dataProvider = "editCommunity", groups = "VerifyEditOfCommunity", priority = 8)
	public void EditCreatedCommunity(EditCommunity dataEditCommunity) {
		adminHomePage.gotoAllCommunitiesSecond().gotoEditCommunityPage().successInputData(dataEditCommunity)
				.gotoShowAllCommunitiesPageSaveEditSecond();
		boolean result = VerifyEnabledOfCommunity.VerifyOfCommunity(VerifyEditedrCommunity);
		Assert.assertEquals(result, true);
	}

	@DataProvider
	public Object[][] addDifferentSymbolsTypeCommunity() {
		return new Object[][] { { AddNewCommunityRepository.get().getNewCommunityAlphabetical(),
				AddNewCommunityRepository.get().getNewCommunityCyrillic(),
				AddNewCommunityRepository.get().getNewCommunityNumber(), } };
	}

	@Test(dataProvider = "addDifferentSymbolsTypeCommunity", priority = 9)
	public void AddCommunities(AddNewCommunity dataForCyrillicCommunity, AddNewCommunity dataForAlphabeticalCommunity,
			AddNewCommunity dataForNumericalCommunity) {

		adminHomePage.gotoAllCommunitiesSecond().gotoAddNewCommunityPageSecond()
				.successInputData(dataForCyrillicCommunity).gotoShowAllCommunitiesPageSaveSecond()
				.gotoAddNewCommunityPageSecond().successInputData(dataForAlphabeticalCommunity)
				.gotoShowAllCommunitiesPageSaveSecond().gotoAddNewCommunityPageSecond()
				.successInputData(dataForNumericalCommunity).gotoShowAllCommunitiesPageSaveSecond();
		boolean resultCommunityCyrillic = VerifyEnabledOfCommunity.VerifyOfCommunity(VerifyValueForCommunityCyrillic);
		Assert.assertEquals(resultCommunityCyrillic, true);
		boolean resultCommunityAlphabetical = VerifyEnabledOfCommunity
				.VerifyOfCommunity(VerifyValuesForCommunityAlphabetical);
		Assert.assertEquals(resultCommunityAlphabetical, true);
		boolean resultCommunityNumeric = VerifyEnabledOfCommunity.VerifyOfCommunity(VerifyValuesForCommunityNumeric);
		Assert.assertEquals(resultCommunityNumeric, true);
	
	}


}
