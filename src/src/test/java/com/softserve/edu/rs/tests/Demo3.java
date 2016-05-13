package com.softserve.edu.rs.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.data.apps.ApplicationSources;
import com.softserve.edu.rs.data.apps.Application;
import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.users.AddNewCommunity;
import com.softserve.edu.rs.data.users.AddNewCommunityRepository;
import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.AddNewCommunityPage;
import com.softserve.edu.rs.pages.AdminHomePage;
import com.softserve.edu.rs.pages.ShowAllCommunitiesPage;

public class Demo3 {

	AdminHomePage adminHomePage;
	ShowAllCommunitiesPage showAllCommunitiesPage;
	Application application;
	
	private static final String CommunityForCheckEditOption = "Черкаська територіальна громада";
	private static final String EditedCommunity = "Тернопільська територіальна громада";
	private static final String CommunityForCheckDeleteOption = "Хмельницька територіальна громада";

	private static final String CommunityWithAlphabeticalSymbols = "USA Community";
	private static final String CommunityWithCyrillicSymbols = "Зборівська територіальна громада";
	private static final String CommunityWithOnlyNumberSymbols = "0123456789";
	private static final String IdShowAllCommn = "Показати всі громади";
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
			Assert.assertTrue(showAllCommunitiesPage.getNameOfTableText().contains( IdShowAllCommn)) ;
		}
		
	@DataProvider
	public Object[][] AddCommunityForCheckDeleteOption() {
		return new Object[][] { { AddNewCommunityRepository.get().getCommunityForDelete(), } };
	}

	@Test(dataProvider = "AddCommunityForCheckDeleteOption")
	public void AddCommunityForDelete(AddNewCommunity DataForCheckDeleteCommunityOption) {
		showAllCommunitiesPage = adminHomePage.gotoShowAllCommunitiesPage().gotoAddNewCommunityPage()
				.successInputData(DataForCheckDeleteCommunityOption).saveCommunityButton();
		
		boolean result = showAllCommunitiesPage.verifyEnabledOfCommunity(CommunityForCheckDeleteOption).isEnabled();
		Assert.assertTrue(result);
	}

	@Test
	public void CheckDeleteOption() throws InterruptedException {
		showAllCommunitiesPage = adminHomePage.gotoShowAllCommunitiesPage();
		showAllCommunitiesPage.clickDeleteButton(CommunityForCheckDeleteOption).clickConfirmButtonOk();	
	}

	@DataProvider
	public Object[][] AddCommunityForCheckEditOption() {
		return new Object[][] { { AddNewCommunityRepository.get().getCreateCommunityForEdit() } };
	}

	@Test(dataProvider = "AddCommunityForCheckEditOption")
	public void AddCommunityForEdit(AddNewCommunity DataForChecEditCommunityOption) {
		 showAllCommunitiesPage = adminHomePage.gotoShowAllCommunitiesPage()
				.gotoAddNewCommunityPage().successInputData(DataForChecEditCommunityOption).saveCommunityButton();

		 boolean result = showAllCommunitiesPage.verifyEnabledOfCommunity(CommunityForCheckEditOption).isDisplayed();
			Assert.assertTrue(result);
	}

	@DataProvider
	public Object[][] CheckEditOption() {
		return new Object[][] { { AddNewCommunityRepository.get().getCreateCommunityForCheckEditOption(), } };
	}

	@Test(dataProvider = "CheckEditOption")
	public void CheckEditOption(AddNewCommunity CheckEditCommunityOption) {
		ShowAllCommunitiesPage showAllCommunitiesPage = adminHomePage.gotoShowAllCommunitiesPage()
				.gotoEditCommunityPage(CommunityForCheckEditOption).successInputData(CheckEditCommunityOption);
		 boolean result = showAllCommunitiesPage.verifyEnabledOfCommunity(EditedCommunity).isDisplayed();
			Assert.assertTrue(result);

	}

	
	@DataProvider
	public Object[][] clearCommunityField() {
		return new Object[][] { { AddNewCommunityRepository.get().getCommunityForClear(), } };
	}

	 @Test(dataProvider = "clearCommunityField")
	public void ClearCommunity(AddNewCommunity CommunityForClear) {
		AddNewCommunityPage addNewCommunityPage = adminHomePage.gotoShowAllCommunitiesPage().gotoAddNewCommunityPage()
				.successInputData(CommunityForClear).clickClearButton();
		boolean resultCommunityField = addNewCommunityPage.getNewCommunityFieldText().isEmpty();
		Assert.assertTrue(resultCommunityField, "Add community field is not empty");
		boolean resultRegisteredField = addNewCommunityPage.getNewRegisterNumberFieldText().isEmpty();
		Assert.assertTrue(resultRegisteredField, "Add registered number is not empty");
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
			ShowAllCommunitiesPage showAllCommunitiesPage = adminHomePage.gotoShowAllCommunitiesPage()
					.gotoAddNewCommunityPage().successInputData(dataForAlphabeticalCommunity).saveCommunityButton()
					.gotoAddNewCommunityPage().successInputData(dataForCyrillicCommunity).saveCommunityButton()
					.gotoAddNewCommunityPage().successInputData(dataForNumericalCommunity).saveCommunityButton();

			boolean resultAlphabetical = showAllCommunitiesPage.verifyEnabledOfCommunity(CommunityWithAlphabeticalSymbols).isDisplayed();
			Assert.assertTrue(resultAlphabetical);
		
			boolean resultCyrillic = showAllCommunitiesPage.verifyEnabledOfCommunity(CommunityWithCyrillicSymbols).isDisplayed();
			Assert.assertTrue(resultCyrillic);
			
			boolean resultOnlyNumberSymbols = showAllCommunitiesPage.verifyEnabledOfCommunity(CommunityWithOnlyNumberSymbols).isDisplayed();
			Assert.assertTrue(resultOnlyNumberSymbols);

		}
		 
			@Test
			public void DeleteAllChanges() {
			 showAllCommunitiesPage = adminHomePage.gotoShowAllCommunitiesPage()
						.clickDeleteButton( CommunityWithAlphabeticalSymbols).clickConfirmButtonOk().
						 clickDeleteButton(CommunityWithCyrillicSymbols).clickConfirmButtonOk().
						 clickDeleteButton( CommunityWithOnlyNumberSymbols ).clickConfirmButtonOk().
						 clickDeleteButton( EditedCommunity).clickConfirmButtonOk();
						
			}

			
		
}
