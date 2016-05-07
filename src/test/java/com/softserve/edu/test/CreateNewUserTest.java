package com.softserve.edu.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.softserve.edu.application.Application;
import com.softserve.edu.application.ApplicationSourcesRepository;
import com.softserve.edu.db.OperationWithDB;
import com.softserve.edu.entity.IUser;
import com.softserve.edu.entity.UserRepository;
import com.softserve.edu.listener.TestListener;
import com.softserve.edu.rs.pages.CreateNewUserPage;
import com.softserve.edu.rs.pages.EditProfilUserPage;
import com.softserve.edu.rs.pages.HomeUserPage;
import com.softserve.edu.rs.pages.LoginPage;
import com.softserve.edu.rs.pages.NonConfirmedUsersPage;
@Listeners(TestListener.class)

public class CreateNewUserTest {
	private Application application;

	@BeforeClass
	public void beforeClass() {
		application = Application.get(ApplicationSourcesRepository.get().getLocalHostByFirefoxTemporary());
	}

	@AfterClass
	public void afterClass() {
		application.quit();
	}
	
	@AfterMethod
	public void afterMethod() {
		OperationWithDB.deleteActiveUser(UserRepository.getInstance().getUser());
		application.logout();
	}

	@DataProvider(name = "TypeOfUser")
	public Object[][] parameterUser() {
		return new Object[][] { 
			{ UserRepository.getInstance().getAdmin() }, 
			{ UserRepository.getInstance().getCommissioner() } };
	}

	@Test(dataProvider = "TypeOfUser")
	public void testPageLoadsCorectly(IUser adminOrCommissioner) {
		CreateNewUserPage createNewUserPage =  application.load()
				.successAdminCommissionerLogin(adminOrCommissioner)
				.gotoCreateNewUserPage();
		Assert.assertTrue(createNewUserPage.verifyPageForCreateUserIsLoadedCorrectly());
		Assert.assertEquals(createNewUserPage.getValueFromDateOfAccession(),
				(new SimpleDateFormat("dd.MM.yyy")).format((new Date())));
	}

	@Test(dataProvider = "TypeOfUser")
	public void testButtonClearWorksCorectly(IUser adminOrCommissioner) {
		CreateNewUserPage createNewUserPage = application.load().successAdminCommissionerLogin(adminOrCommissioner)
				.gotoCreateNewUserPage()
				.typeAllFields(UserRepository.getInstance().getUser())
				.clearFormForCreateNewUser();
		Assert.assertTrue(createNewUserPage.verifyPageForCreateUserIsLoadedCorrectly());
	}
	
	@Test(dataProvider = "TypeOfUser")
	public void testButtonCancelWorksCorectly(IUser adminOrCommissioner) {
		application.load().successAdminCommissionerLogin(adminOrCommissioner)
				.gotoCreateNewUserPage()
				.typeAllFields(UserRepository.getInstance().getUser())
				.clickButtonCancel();
		NonConfirmedUsersPage nonConfirmedUsersPage = application.loadNonConfirmedUsersPage()
				.searchByLogin(UserRepository.getInstance().getUser());
		Assert.assertTrue(nonConfirmedUsersPage.getLabelEmptyTable().isDisplayed());
	}

	@Test(dataProvider = "TypeOfUser")
	public void testCreateNewUser(IUser adminOrCommissioner) {
		//create new user
		LoginPage loginPage = application.load().successAdminCommissionerLogin(adminOrCommissioner)
				.gotoCreateNewUserPage().successCreateUser(UserRepository.getInstance().getUser())
				.clickLogout().unsuccessfulLogin(UserRepository.getInstance().getUser());
		
		//verify that not confirmed user can not login 
		Assert.assertEquals(loginPage.getValidatorText(), loginPage.VALIDATOR_MESSAGE);
		
		//activate new user
		EditProfilUserPage editProfilUserPage = loginPage.successAdminCommissionerLogin(UserRepository.getInstance().getAdmin())
				.gotoNonConfirmedUsersPage()
				.gotoProfilUser(UserRepository.getInstance().getUser())
				.clickButtonEdit()
				.changeStatusToActive(UserRepository.getInstance().getUser());
		editProfilUserPage.clickButtonOk();
		
		//verify that confirmed user can login
		HomeUserPage homePage = application.logout().successUserLogin(UserRepository.getInstance().getUser());
		Assert.assertEquals(homePage.getLoginAccountText(), UserRepository.getInstance().getUser().getAccount().getLogin());
	}

}
