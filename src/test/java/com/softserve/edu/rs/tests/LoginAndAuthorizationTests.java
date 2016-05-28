package com.softserve.edu.rs.tests;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.specs.FlexAssert;
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

	@BeforeClass
	public void setUpApp() {
		application = Application.get(ApplicationSourcesRepository.get()
				.getLocalHostByFirefoxTemporary());
	}

	@BeforeMethod
	public void loginApp() {
	}

	@AfterMethod
	public void logOutApp() {
		application.logout();
	}

	@AfterClass
	public void shotDownApp() {
		application.quit();
	}
	
	@DataProvider
    public Object[][] getAllRolesUsers(ITestContext context) {
		return new Object[][] { 
				{ UserRepository.get().getAdmin() },
				{ UserRepository.get().getCommissioner() },
				{ UserRepository.get().getCoOwner() },
				{ UserRepository.get().getRegistrator() }
		};
    }

	@DataProvider
	public Object[][] getAdmin() {
		return new Object[][] { { UserRepository.get().getAdmin() } };
	}

//	@Test(dataProvider = "getAdmin")
	public void smokeLoginTest(IUser user) {
		HomePage homePage = application.load().successAdminLogin(user);
		FlexAssert.get()
		.forElement(homePage.getLoginAccount())
			.isVisible()
			.valueMatch(user.getAccount().getLogin());
		FlexAssert.get().check();
	}
	
	@Test(dataProvider = "getAllRolesUsers")
	public void menuAccountTest(IUser user) {
		HomePage homePage = application.load().successUserLogin(user);
		FlexAssert.get()
		.forElement(homePage.getChangePassword())
			.isVisible()
			.next()
		.forElement(homePage.getResetPassword())
			.isVisible()
			.next()
		.forElement(homePage.getLogout())
			.isVisible();
		FlexAssert.get().check();
	}

//	@Test(dependsOnMethods = { "smokeLoginTest" }, dataProvider = "getAdmin")
	public void adminAuthorizationTest(IUser user) {
		AdminHomePage adminHomePage = application.load().successAdminLogin(user);
		FlexAssert.get()
			.forElement(adminHomePage.getUsers())
				.isVisible()
				.next()
			.forElement(adminHomePage.getSettings())
				.isVisible()
				.next()
			.forElement(adminHomePage.getCommunities())
				.isVisible()
				.next()
			.forElement(adminHomePage.getNewUser())
				.isVisible()
				.next()
			.forElement(adminHomePage.getUnblockAll())
				.isVisible();
			FlexAssert.get().check();
	}
	
	@DataProvider
	public Object[][] getComissioner() {
		return new Object[][] { { UserRepository.get().getCommissioner() } };
	}

//	@Test(dependsOnMethods = { "smokeLoginTest" }, dataProvider = "getComissioner")
	public void comissionerAuthorizationTest(IUser user) {
		CommissionerHomePage commissionerHomePage = application.load()
				.successCommissionerLogin(user);
		FlexAssert.get()
			.forElement(commissionerHomePage.getLoginAccount())
					.isVisible()
					.valueMatch(user.getAccount().getLogin())
					.next()
			.forElement(commissionerHomePage.getUsers())
					.isVisible()
					.next()
			.forElement(commissionerHomePage.getNewUser())
					.isVisible();
		FlexAssert.get().check();
	}
	
	@DataProvider
	public Object[][] getRegistrator() {
		return new Object[][] { { UserRepository.get().getRegistrator() } };
	}

//	@Test(dependsOnMethods = { "smokeLoginTest" }, dataProvider = "getRegistrator")
	public void registratorAuthorizationTest(IUser user) {
		RegistratorHomePage registratorHomePage = application.load()
				.successRegistratorLogin(user);
		FlexAssert.get()
			.forElement(registratorHomePage.getLoginAccount())
				.isVisible()
				.valueMatch(user.getAccount().getLogin())
				.next()
			.forElement(registratorHomePage.getResourceSearch())
				.isVisible()
				.next()
			.forElement(registratorHomePage.getSubclasses())
				.isVisible()
				.next()
			.forElement(registratorHomePage.getProcurations())
				.isVisible()
				.next()
			.forElement(registratorHomePage.getAddNewResource())
				.isVisible();
		FlexAssert.get().check();
	}
	
	@DataProvider
	public Object[][] getUser() {
		return new Object[][] { { UserRepository.get().getCoOwner() } };
	}

//	@Test(dependsOnMethods = { "smokeLoginTest" }, dataProvider = "getUser")
	public void userAuthorizationTest(IUser user) {
		UserHomePage userHomePage = application.load()
				.successUserPageLogin(user);
		FlexAssert.get()
			.forElement(userHomePage.getLoginAccount())
				.isVisible()
				.valueMatch(user.getAccount().getLogin())
				.next()
			.forElement(userHomePage.getResourceSearch())
				.isVisible()
				.next()
			.forElement(userHomePage.getProcurations())
				.isVisible();
		FlexAssert.get().check();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
