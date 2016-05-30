package com.softserve.edu.rs.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.softserve.edu.atqc.specs.FlexAssert;
import com.softserve.edu.rs.data.apps.Application;
import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.users.AddNewCommunity;
import com.softserve.edu.rs.data.users.AddNewCommunityRepository;
import com.softserve.edu.rs.data.users.EditCommunity;
import com.softserve.edu.rs.data.users.EditCommunityRepository;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.AddNewCommunityPage;
import com.softserve.edu.rs.pages.AdminHomePage;
import com.softserve.edu.rs.pages.ShowAllCommunitiesPage;
import com.softserve.edu.rs.pages.UnsuccessDeleteAtemptPage;

public class Demo4 {

	private AdminHomePage adminHomePage;
	private ShowAllCommunitiesPage showAllCommunitiesPage;
	private Application application;
	private AddNewCommunityPage addNewCommunityPage;
	private UnsuccessDeleteAtemptPage unsuccessDeleteAtemptPage;
	private static final String UNSUCCESS_ATEMPT = "Lviv";
	private static final String EDITED_COMMUNITY = "Полтавська територіальна громада";
	private static final String COMMUNITY_FOR_CHECK_EDIT_OPTION = "Черкаська територіальна громада";
	private static final String COMMUNITY_WITH_ALHABETICAL_SYMBOLS = "USA Community";
	private static final String COMMUNITY_WITH_CYRILLIC_SYMBOLS = "Зборівська територіальна громада";
	private static final String COMMUNITY_WITH_ONLY_NUMBER_SYMBOLS = "0123456789";
	private static final String COMMUNITY_FOR_CHECK_DELETE_OPTION = "Сумська територіальна громада";
	private static final String VALIDATOR_MESSAGE_FOR_COMMUNITY = "Підклас з вказаним іменем вже існує";
	private static final String VALIDATOR_MESSAGE_FOR_REG_NUMBER = "Невірний формат";
	public static final String START = "";
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
		FlexAssert.get().check();
		application.logout();
	}

	@Test
	public void ShowAllCommunitiesPageSmokeTest() {
		showAllCommunitiesPage = adminHomePage.gotoShowAllCommunitiesPage();
		FlexAssert.get().forElement(showAllCommunitiesPage.getNameOfTableText())
				.valueMatch(TITLE_SHOW_ALL_COMMNUNITY_PAGE);
	}

	@DataProvider
	public Object[][] AddCommunityForCheckDeleteOption() {
		return new Object[][] { { AddNewCommunityRepository.get().getCommunityForDelete(), } };
	}

	@Test(dataProvider = "AddCommunityForCheckDeleteOption")
	public void AddCommunityForDelete(AddNewCommunity DataForCheckDeleteCommunityOption) {
		showAllCommunitiesPage = adminHomePage.gotoShowAllCommunitiesPage().gotoAddNewCommunityPage()
				.successInputData(DataForCheckDeleteCommunityOption).saveCommunityButton();
		FlexAssert.get().forElement(showAllCommunitiesPage.getCommunityName(COMMUNITY_FOR_CHECK_DELETE_OPTION)).isVisible()
				.next().forElement(showAllCommunitiesPage.getCommunityNameText(COMMUNITY_FOR_CHECK_DELETE_OPTION))
				.valueMatch(COMMUNITY_FOR_CHECK_DELETE_OPTION);
	}

	@Test
	public void CheckDeleteOption() {
		showAllCommunitiesPage = adminHomePage.gotoShowAllCommunitiesPage()
				.clickDeleteButton(COMMUNITY_FOR_CHECK_DELETE_OPTION).clickConfirmButtonOk();
		FlexAssert.get()
				.forElement(showAllCommunitiesPage.VerifyDisplayedOfCommunity(COMMUNITY_FOR_CHECK_DELETE_OPTION));
		FlexAssert.get().check();
	}

	@DataProvider
	public Object[][] AddCommunityForCheckEditOption() {
		return new Object[][] { { AddNewCommunityRepository.get().getCreateCommunityForEdit() } };
	}

	@Test(dataProvider = "AddCommunityForCheckEditOption")
	public void AddCommunityForEdit(AddNewCommunity DataForChecEditCommunityOption) {
		showAllCommunitiesPage = adminHomePage.gotoShowAllCommunitiesPage().gotoAddNewCommunityPage()
				.successInputData(DataForChecEditCommunityOption).saveCommunityButton();
		FlexAssert.get().forElement(showAllCommunitiesPage.getCommunityNameText(COMMUNITY_FOR_CHECK_EDIT_OPTION))
				.valueMatch(COMMUNITY_FOR_CHECK_EDIT_OPTION);
	}

	@DataProvider
	public Object[][] CheckEditOption() {
		return new Object[][] { { EditCommunityRepository.get().getNewCommunityForEdit(), } };
	}

	@Test(dataProvider = "CheckEditOption")
	public void CheckEditOption(EditCommunity CheckEditCommunityOption) {
		showAllCommunitiesPage = adminHomePage.gotoShowAllCommunitiesPage()
				.gotoEditCommunityPage(COMMUNITY_FOR_CHECK_EDIT_OPTION).successInputData(CheckEditCommunityOption);
		FlexAssert.get().forElement(showAllCommunitiesPage.getCommunityNameText(EDITED_COMMUNITY)).valueMatch(EDITED_COMMUNITY);
	}

	@DataProvider
	public Object[][] clearCommunityField() {
		return new Object[][] { { AddNewCommunityRepository.get().getCommunityForClear(), } };
	}

	@Test(dataProvider = "clearCommunityField")
	public void ClearCommunity(AddNewCommunity CommunityForClear) {
		addNewCommunityPage = adminHomePage.gotoShowAllCommunitiesPage().gotoAddNewCommunityPage()
				.successInputData(CommunityForClear).clickClearButton();
		FlexAssert.get().forElement(addNewCommunityPage.getNewCommunityFieldText()).valueMatch("").next()
				.forElement(addNewCommunityPage.getNewRegisterNumberFieldText()).valueMatch("");
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
		FlexAssert.get().forElement(showAllCommunitiesPage.getCommunityNameText(COMMUNITY_WITH_ALHABETICAL_SYMBOLS))
				.valueMatch(COMMUNITY_WITH_ALHABETICAL_SYMBOLS).next()
				.forElement(showAllCommunitiesPage.getCommunityNameText(COMMUNITY_WITH_CYRILLIC_SYMBOLS))
				.valueMatch(COMMUNITY_WITH_CYRILLIC_SYMBOLS).next()
				.forElement(showAllCommunitiesPage.getCommunityNameText(COMMUNITY_WITH_ONLY_NUMBER_SYMBOLS))
				.valueMatch(COMMUNITY_WITH_ONLY_NUMBER_SYMBOLS);
	}

	@DataProvider
	public Object[][] DataForVerifyCommunity() {
		return new Object[][] { { AddNewCommunityRepository.get().getCommunityForVerifyUnique(), } };
	}

	@Test(dataProvider = "DataForVerifyCommunity")
	public void VerifyUnique(AddNewCommunity dataForVerify) {
		addNewCommunityPage = adminHomePage.gotoShowAllCommunitiesPage().gotoAddNewCommunityPage()
				.unsuccessInputCommunityData(dataForVerify);
		FlexAssert.get().forElement(addNewCommunityPage.getValidatorCommunityText())
				.valueMatch(VALIDATOR_MESSAGE_FOR_COMMUNITY).next()
				.forElement(addNewCommunityPage.getNewCommunityFieldText()).valueMatch(START).next()
				.forElement(addNewCommunityPage.getNewRegisterNumberFieldText()).valueMatch(START);
	}

	@DataProvider
	public Object[][] DataForVerifyCorrectFormat() {
		return new Object[][] { { AddNewCommunityRepository.get().getVerifyCorrectFormat(), } };
	}

	@Test(dataProvider = "DataForVerifyCorrectFormat")
	public void VerifyCorrectFormat(AddNewCommunity dataForVerify) {
		addNewCommunityPage = adminHomePage.gotoShowAllCommunitiesPage().gotoAddNewCommunityPage()
				.unsuccessInputRegNumberData(dataForVerify);
		FlexAssert.get().forElement(addNewCommunityPage.getValidatorRegNumberText())
				.valueMatch(VALIDATOR_MESSAGE_FOR_REG_NUMBER).next()
				.forElement(addNewCommunityPage.getNewCommunityFieldText()).valueMatch(START).next()
				.forElement(addNewCommunityPage.getNewRegisterNumberFieldText()).valueMatch(START);
	}

	@Test
	public void VerifyCorrectDelete() {
		unsuccessDeleteAtemptPage = adminHomePage.gotoShowAllCommunitiesPage().clickDeleteButton(UNSUCCESS_ATEMPT)
				.clickConfirmUnsuccessAtempt();
		FlexAssert.get().forElement(unsuccessDeleteAtemptPage.getValidatorMessageText())
				.valueMatch(unsuccessDeleteAtemptPage.VALIDATOR_MESSAGE);
		unsuccessDeleteAtemptPage.confirmOkButtom();
	}

	@Test
	public void DeleteAllChanges() {
		showAllCommunitiesPage = adminHomePage.gotoShowAllCommunitiesPage()
				.clickDeleteButton(COMMUNITY_WITH_ALHABETICAL_SYMBOLS).clickConfirmButtonOk()
				.clickDeleteButton(COMMUNITY_WITH_CYRILLIC_SYMBOLS).clickConfirmButtonOk()
				.clickDeleteButton(COMMUNITY_WITH_ONLY_NUMBER_SYMBOLS).clickConfirmButtonOk()
				.clickDeleteButton(EDITED_COMMUNITY).clickConfirmButtonOk();
	}

}
