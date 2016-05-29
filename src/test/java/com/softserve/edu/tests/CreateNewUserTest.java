package com.softserve.edu.tests;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.softserve.edu.apps.Application;
import com.softserve.edu.apps.ApplicationSourcesRepository;
import com.softserve.edu.atqc.specs.FlexAssert;
import com.softserve.edu.db.OperationWithDB;
import com.softserve.edu.listener.TestListener;
import com.softserve.edu.rs.pages.CreateNewUserPage;
import com.softserve.edu.rs.pages.EditProfilUserPage;
import com.softserve.edu.rs.pages.HomeUserPage;
import com.softserve.edu.rs.pages.LoginPage;
import com.softserve.edu.rs.pages.NonConfirmedUsersPage;
import com.softserve.edu.users.IUser;
import com.softserve.edu.users.UserRepository;
@Listeners(TestListener.class)

public class CreateNewUserTest {
	private Application application;
	private IUser newUser = UserRepository.getInstance().getUser();

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
		application.logout();
		FlexAssert.get().check();
	}

	@DataProvider(name = "TypeOfUser")
	public Object[][] parameterUser() {
		return new Object[][] { 
			{ UserRepository.getInstance().getAdmin() }, 
			{ UserRepository.getInstance().getCommissioner() } };
	}

	@Test(dataProvider = "TypeOfUser")
	public void testPageLoadsCorectly(IUser adminOrCommissioner) {
		CreateNewUserPage createNewUserPage = application.load()
				.successAdminCommissionerLogin(adminOrCommissioner)
				.gotoCreateNewUserPage();
		createNewUserPage.verifyPageForCreateUserIsLoadedCorrectly();
		FlexAssert.get().forElement(createNewUserPage.getValueFromDateOfAccession())
				.valueMatch((new SimpleDateFormat("dd.MM.yyy")).format((new Date())));	
	}

	@Test(dataProvider = "TypeOfUser")
	public void testButtonClearWorksCorectly(IUser adminOrCommissioner) {
		application.load().successAdminCommissionerLogin(adminOrCommissioner)
				.gotoCreateNewUserPage()
				.typeAllFields(UserRepository.getInstance().getUser())
				.clearFormForCreateNewUser().verifyPageForCreateUserIsLoadedCorrectly();
	}
	
	@Test(dataProvider = "TypeOfUser")
	public void testButtonCancelWorksCorectly(IUser adminOrCommissioner) {
		application.load().successAdminCommissionerLogin(adminOrCommissioner)
				.gotoCreateNewUserPage()
				.typeAllFields(newUser)
				.clickButtonCancel();
		NonConfirmedUsersPage nonConfirmedUsersPage = application.loadNonConfirmedUsersPage()
				.searchByLogin(newUser);
		FlexAssert.get().forElement(nonConfirmedUsersPage.getLabelEmptyTable()).isVisible();
	}

	@Test(dataProvider = "TypeOfUser")
	public void testCreateNewUser(IUser adminOrCommissioner) {
		//create new user
		LoginPage loginPage = application.load().successAdminCommissionerLogin(adminOrCommissioner)
				.gotoCreateNewUserPage().successCreateUser(newUser)
				.clickLogout().unsuccessfulLogin(newUser);
		
		//verify that not confirmed user can not login 
		FlexAssert.get().forElement(loginPage.getValidator()).isVisible();
		
		//activate new user
		EditProfilUserPage editProfilUserPage = loginPage.successAdminCommissionerLogin(UserRepository.getInstance().getAdmin())
				.gotoNonConfirmedUsersPage()
				.gotoProfilUser(newUser)
				.clickButtonEdit()
				.changeStatusToActive(newUser);
		editProfilUserPage.clickButtonOk();
		
		//verify that confirmed user can login
		HomeUserPage homePage = application.logout().successUserLogin(UserRepository.getInstance().getUser());
		FlexAssert.get().forElement(homePage.getLoginAccountText())
				.valueMatch(newUser.getAccount().getLogin());
		OperationWithDB.deleteActiveUser(UserRepository.getInstance().getUser());
	}

}
