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
	private static final String expectedCyrillicCommunity = "Винники";
	private static final String expectedCommunityForDelete = "Житомирська";
	private static final String expectedNumericCommunity = "12345";
	private static final String expectedAlphabeticalCommunity = "Poltava";
	private static final String expectedCommunityForCleaning = "Ланівецька";
	private static final String expectedCommunityForEdit = "Черкаська";
	private static final String expectedCommunityAfterEdit = "Тернопільська";
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

	 @Test
	public void GeneralAdminSmokeTest() {
		Assert.assertEquals(adminHomePage.getAllCommunities().isEnabled(), true);
	}

	@Test
	public void SmokeShowAll() {
		showAllCommunity = adminHomePage.gotoAllCommunitiesSecond();
		//Assert.assertEquals(showAllCommunity.getNameOfTable().isEnabled(), true);

	}

	 @Test
	public void SmokeShowAddCommunityPage() {
		addNewCommunityPage = adminHomePage.gotoAllCommunitiesSecond().gotoAddNewCommunityPageSecond();
		Assert.assertEquals(addNewCommunityPage.getHeadPageAddNewCommunity().isDisplayed(), true);
		Assert.assertEquals(addNewCommunityPage.getnewCommunity().isDisplayed(), true);
		Assert.assertEquals(addNewCommunityPage.getregisterNumber().isDisplayed(), true);

	}

	/*@DataProvider
	public Object[][] AddCommunityForDelete() {
		return new Object[][] { { AddNewCommunityRepository.get().getNewCommunityForDelete(), } };
	}

	 @Test
	public void AddLastCommunity(AddNewCommunity DataForDeleteCommunity) {
		showAllCommunity = adminHomePage.gotoAllCommunitiesSecond().gotoAddNewCommunityPageSecond()
				.successInputData(DataForDeleteCommunity).gotoShowAllCommunitiesPageSaveSecond();
		boolean CheckTestResult = VerifyEnabledOfCommunity.CheckComm(showAllCommunity.getElementsOfTable(),
				expectedCommunityForDelete);
		Assert.assertTrue(CheckTestResult, "Community for delete is not present");
	}

	 @Test
	public void DeleteLastCommunity() throws InterruptedException {
		showAllCommunity = adminHomePage.gotoAllCommunitiesSecond().gotoConfirmDecisionPage().clickConfirmButtonOk();
		Thread.sleep(2000);
		boolean CheckTestResult = VerifyEnabledOfCommunity.CheckComm(showAllCommunity.getElementsOfTable(),
				expectedCommunityForDelete);
		Assert.assertTrue(CheckTestResult, "Community for delete is not present");
	}

	@DataProvider
	public Object[][] clearCommunityField() {

		return new Object[][] { { AddNewCommunityRepository.get().getNewCommunityForClear(), } };
	}

	 @Test(dataProvider = "clearCommunityField", priority = 6)
	public void ClearCommunity(AddNewCommunity CommunityForClear) {
		AddNewCommunityPage addNewCommunityPage = adminHomePage.gotoAllCommunitiesSecond()
				.gotoAddNewCommunityPageSecond().successInputData(CommunityForClear);
		Assert.assertTrue(addNewCommunityPage.getcleanButton().isEnabled(), "Button for cleaning is disenabled");
		addNewCommunityPage.clickcleanButton();
		boolean resultCommunityField = addNewCommunityPage.getnewCommunity().getText().isEmpty();
		Assert.assertTrue(resultCommunityField, "Add community field is not empty");
		boolean resultRegisteredField = addNewCommunityPage.getregisterNumber().getText().isEmpty();
		Assert.assertTrue(resultRegisteredField, "Add registered number is not empty");
	}

	@DataProvider
	public Object[][] createCommunityForEdit() {
		return new Object[][] { { AddNewCommunityRepository.get().getCreateNewCommunityForEdit(), }

		};
	}

	 @Test(dataProvider = "createCommunityForEdit")
	public void CreateForEditCommunity(AddNewCommunity dataCreateForEdit) {
		showAllCommunity = adminHomePage.gotoAllCommunitiesSecond().gotoAddNewCommunityPageSecond()
				.successInputData(dataCreateForEdit).gotoShowAllCommunitiesPageSaveSecond();

		boolean CheckTestResultEdit = VerifyEnabledOfCommunity.CheckComm(showAllCommunity.getElementsOfTable(),
				expectedCommunityForEdit);
		Assert.assertTrue(CheckTestResultEdit, "Community for edit is not present in the list");

	}

	@DataProvider
	public Object[][] editCommunity() {
		return new Object[][] { { EditCommunityRepository.get().getNewCommunityForEdit(), }

		};
	}

	 @Test(dataProvider = "editCommunity")
	public void EditCreatedCommunity(EditCommunity dataEditCommunity) {
		showAllCommunity = adminHomePage.gotoAllCommunitiesSecond().gotoEditCommunityPage()
				.successInputData(dataEditCommunity).gotoShowAllCommunitiesPageSaveEditSecond();
		boolean CheckTestResultChange = VerifyEnabledOfCommunity.CheckComm(showAllCommunity.getElementsOfTable(),
				expectedCommunityForEdit);
		Assert.assertFalse(CheckTestResultChange, "Community for edit is not present in the list");

		boolean CheckTestResult = VerifyEnabledOfCommunity.CheckComm(showAllCommunity.getElementsOfTable(),
				expectedCommunityAfterEdit);
		Assert.assertTrue(CheckTestResult, "Edited community is not present in the list");

	}

	@DataProvider
	public Object[][] addDifferentSymbolsTypeCommunity() {
		return new Object[][] { { AddNewCommunityRepository.get().getNewCommunityAlphabetical(),
				AddNewCommunityRepository.get().getNewCommunityCyrillic(),
				AddNewCommunityRepository.get().getNewCommunityNumber(), } };
	}

	@Test(dataProvider = "addDifferentSymbolsTypeCommunity")
	public void AddCommunities(AddNewCommunity dataForCyrillicCommunity, AddNewCommunity dataForAlphabeticalCommunity,
			AddNewCommunity dataForNumericalCommunity) {
		showAllCommunity = adminHomePage.gotoAllCommunitiesSecond().gotoAddNewCommunityPageSecond()
				.successInputData(dataForCyrillicCommunity).gotoShowAllCommunitiesPageSaveSecond()
				.gotoAddNewCommunityPageSecond().successInputData(dataForAlphabeticalCommunity)
				.gotoShowAllCommunitiesPageSaveSecond().gotoAddNewCommunityPageSecond()
				.successInputData(dataForNumericalCommunity).gotoShowAllCommunitiesPageSaveSecond();

		boolean CheckTestResultCyrillicCommunity = VerifyEnabledOfCommunity
				.CheckComm(showAllCommunity.getElementsOfTable(), expectedCyrillicCommunity);
		Assert.assertTrue(CheckTestResultCyrillicCommunity, "Cyrillic community is not present in the list");

		boolean CheckTestResultAlphabeticalCommunity = VerifyEnabledOfCommunity
				.CheckComm(showAllCommunity.getElementsOfTable(), expectedAlphabeticalCommunity);
		Assert.assertTrue(CheckTestResultAlphabeticalCommunity, "Alphabetical community is not present in the list");

		boolean CheckTestResultNumericCommunity = VerifyEnabledOfCommunity
				.CheckComm(showAllCommunity.getElementsOfTable(), expectedNumericCommunity);
		Assert.assertTrue(CheckTestResultNumericCommunity, "Numeric community is not present in the list");

	}*/

}
