package com.softserve.edu.test;

import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.softserve.edu.application.Application;
import com.softserve.edu.application.ApplicationSourcesRepository;
import com.softserve.edu.entity.IUser;
import com.softserve.edu.entity.UserRepository;
import com.softserve.edu.rs.pages.CreateNewUserPage;
import com.softserve.edu.rs.pages.EditProfilUserPage;
import com.softserve.edu.rs.pages.HomeUserPage;
import com.softserve.edu.rs.pages.LoginPage;
import com.softserve.edu.rs.pages.LoginValidatorPage;

public class CreateNewUserTest {
	Application application;

	@BeforeTest
	public void beforeTest() {
		application = new Application(ApplicationSourcesRepository.get().getLocalHostByFirefox());
	}

	@AfterTest
	public void afterTest() {
		application.quit();
	}
	
	@AfterMethod
	public void afterMethod() {
		application.logout();
	}

	@DataProvider(name = "Type of user")
	public Object[][] parameterUser() {
		return new Object[][] { 
			{ UserRepository.getInstance().getAdmin() },
			{ UserRepository.getInstance().getCommissioner() } };
	}

	@Test(dataProvider = "Type of user")
	public void testPageLoadsCorectly(IUser user) {
		CreateNewUserPage createNewUserPage =  application.load().successAdminCommissionerLogin(user).gotoCreateNewUserPage();
		Assert.assertTrue(createNewUserPage.verifyPageForCreateUserIsLoadedCorrectly());
		Assert.assertEquals(createNewUserPage.getFieldForDateOfAccessionValue(),(new SimpleDateFormat("dd.MM.yyy")).format((new Date())));
	}

	@Test(dataProvider = "Type of user")
	public void testButtonClearWorksCorectly(IUser user) {
		CreateNewUserPage createNewUserPage = application.load().successAdminCommissionerLogin(user)
				.gotoCreateNewUserPage()
				.typeAllFields(UserRepository.getInstance().getUser())
				.clearFormForCreateNewUser();
		Assert.assertTrue(createNewUserPage.verifyPageForCreateUserIsLoadedCorrectly());
	}

	@Test(dataProvider = "Type of user")
	public void testCreateNewUser(IUser adminOrCommissioner) {
		IUser newUser = UserRepository.getInstance().getUser();
		
		//create new user
		LoginPage loginPage = application.load().successAdminCommissionerLogin(adminOrCommissioner)
				.gotoCreateNewUserPage().successCreateUser(newUser).logout();
		
		//verify that not confirmed user can not login 
		LoginValidatorPage loginValidatorPage = loginPage.unsuccessfulLogin(newUser);
		Assert.assertEquals(loginValidatorPage.getValidatorText(), LoginValidatorPage.VALIDATOR_MESSAGE);
		
		//activate new user
		EditProfilUserPage editProfilUserPage = loginValidatorPage.successAdminCommissionerLogin(UserRepository.getInstance().getAdmin())
				.gotoNonConfirmedUsersPage()
				.gotoProfilUser(newUser).clickButtonEdit()
				.changeStatus(newUser);
		editProfilUserPage.clickButtonOk();
		
		//verify that confirmed user can login
		HomeUserPage homePage = editProfilUserPage.logout().successUserLogin(newUser);
		Assert.assertEquals(homePage.getLoginAccountText(), newUser.getAccount().getLogin());
	}

}
