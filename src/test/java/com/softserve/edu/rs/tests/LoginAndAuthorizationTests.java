package com.softserve.edu.rs.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.softserve.edu.rs.data.apps.Application;
import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.AdminHomePage;
import com.softserve.edu.rs.pages.CommissionerHomePage;
import com.softserve.edu.rs.pages.HomePage;
import com.softserve.edu.rs.pages.RegistratorHomePage;
import com.softserve.edu.rs.pages.UserHomePage;

public class LoginAndAuthorizationTests {

	Application application;
	SoftAssert s_assert;

	@BeforeClass
	public void setUpApp() {
		application = Application.get(ApplicationSourcesRepository.get()
				.getLocalHostByFirefoxTemporary());
	}

	@BeforeMethod
	public void loginApp() {
		s_assert = new SoftAssert();
	}

	@AfterMethod
	public void logOutApp() {
		s_assert = null;
		application.logout();
	}

	@AfterClass
	public void shotDownApp() {
		application.quit();
	}

	@DataProvider
	public Object[][] getAdmin() {
		return new Object[][] { { UserRepository.get().getAdmin() } };
	}

	@Test(dataProvider = "getAdmin")
	public void smokeLoginTest(IUser user) {
		HomePage homePage = application.load().successAdminLogin(user);
		Assert.assertEquals(user.getAccount().getLogin(),
				homePage.getLoginAccountText());
	}

	@Test(dependsOnMethods = { "smokeLoginTest" }, dataProvider = "getAdmin")
	public void adminAuthorizationTest(IUser user) {
		AdminHomePage adminHomePage = application.load()
				.successAdminLogin(user);
		s_assert.assertTrue(adminHomePage.getUsers().isEnabled());
		s_assert.assertTrue(adminHomePage.getSettings().isEnabled());
		s_assert.assertTrue(adminHomePage.getCommunities().isEnabled());
		s_assert.assertTrue(adminHomePage.getNewUser().isEnabled());
		s_assert.assertTrue(adminHomePage.getUnblockAll().isClickable());
		s_assert.assertAll();
	}
	
	@DataProvider
	public Object[][] getComissioner() {
		return new Object[][] { { UserRepository.get().getCommissioner() } };
	}

	@Test(dependsOnMethods = { "smokeLoginTest" }, dataProvider = "getComissioner")
	public void comissionerAuthorizationTest(IUser user) {
		CommissionerHomePage commissionerHomePage = application.load()
				.successCommissionerLogin(user);
		s_assert.assertEquals(commissionerHomePage.getLoginAccountText(), user.getAccount().getLogin());
		s_assert.assertTrue(commissionerHomePage.getUsers().isEnabled());
		s_assert.assertTrue(commissionerHomePage.getNewUser().isEnabled());
		s_assert.assertAll();
	}
	
	@DataProvider
	public Object[][] getRegistrator() {
		return new Object[][] { { UserRepository.get().getRegistrator() } };
	}

	@Test(dependsOnMethods = { "smokeLoginTest" }, dataProvider = "getRegistrator")
	public void registratorAuthorizationTest(IUser user) {
		RegistratorHomePage registratorHomePage = application.load()
				.successRegistratorLogin(user);
		s_assert.assertEquals(registratorHomePage.getLoginAccountText(), user.getAccount().getLogin());
		s_assert.assertTrue(registratorHomePage.getResourceSearch().isEnabled());
		s_assert.assertTrue(registratorHomePage.getSubclasses().isEnabled());
		s_assert.assertTrue(registratorHomePage.getProcurations().isEnabled());
		s_assert.assertTrue(registratorHomePage.getAddNewResource().isEnabled());
		s_assert.assertAll();
	}
	
	@DataProvider
	public Object[][] getUser() {
		return new Object[][] { { UserRepository.get().getCoOwner() } };
	}

	@Test(dependsOnMethods = { "smokeLoginTest" }, dataProvider = "getUser")
	public void userAuthorizationTest(IUser user) {
		UserHomePage userHomePage = application.load()
				.successUserPageLogin(user);
		s_assert.assertEquals(userHomePage.getLoginAccountText(), user.getAccount().getLogin());
		s_assert.assertTrue(userHomePage.getResourceSearch().isEnabled());
		s_assert.assertTrue(userHomePage.getProcurations().isEnabled());
		s_assert.assertAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
