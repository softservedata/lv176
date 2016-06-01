package com.softserve.edu.rs.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.softserve.edu.DeleteFromDB;
import com.softserve.edu.atqc.specs.FlexAssert;
import com.softserve.edu.rs.data.apps.Application;
import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.AdminHomePage;
import com.softserve.edu.rs.pages.AfterRegistrationPage;
import com.softserve.edu.rs.pages.CommissionerPage;
import com.softserve.edu.rs.pages.SettingPage;
import com.softserve.edu.rs.pages.UserHomePage;
import com.softserve.edu.rs.pages.UserRegistrationPage;

public class TestForDemo4 {
	private AdminHomePage adminHomePage;
	private Application application;
	private SettingPage settingPage;
	private CommissionerPage commissioner;

	@BeforeClass
	public void oneTimeSetUp() {
		application = Application.get(ApplicationSourcesRepository.get().getLocalHostByFirefoxDefault());
		settingPage = application.load().successAdminLogin(UserRepository.get().getAdmin()).goToSetting();
		settingPage.clickMixedRegister();
		settingPage.clickConfirmChanges();
		application.logout();
	}

	@AfterClass
	public void oneTimeTearDown() {
		application.quit();
	}

	@AfterMethod
	public void tearDown() {
		application.logout();
		FlexAssert.get().check();
	}

	@Test
	public void mixedRegistration() {
		FlexAssert.get().forElement(application.logout().getRegisterButton()).isVisible();
		commissioner = application.load().successCommissionerLogin(UserRepository.get().getCommissioner());
		FlexAssert.get().forElement(UserRepository.get().getCommissioner().getAccount().getLogin())
				.valueMatch(commissioner.getLoginAccountText()).next().forElement(commissioner.getRegisteredUsers())
				.isVisible();
	}

	@Test
	public void userPersonalRegistration() {
		IUser randomUser = UserRepository.get().getRandomUser();
		UserRegistrationPage registerNewUser = application.load().registerUser();
		registerNewUser.setLoginDatas(randomUser);
		AfterRegistrationPage afterRegistrationPage = registerNewUser.confirmRegistration();
		afterRegistrationPage.clickReturnToLoginPage();
		adminHomePage = application.load().successAdminLogin(UserRepository.get().getAdmin());
		FlexAssert.get().forElement(UserRepository.get().getAdmin().getAccount().getLogin())
				.valueMatch(adminHomePage.getLoginAccountText());
		adminHomePage.goToNonConfirmedUsers().editNonConfirmeduser(randomUser).goToEditRegisteredUserPage()
				.goToEditNewuserPage().changeStatus();
		application.logout();
		UserHomePage userPage = application.load().successUserHomeLogin(randomUser);
		FlexAssert.get().forElement(randomUser.getAccount().getLogin()).valueMatch(userPage.getLoginAccountText());
		DeleteFromDB.deleteUser(randomUser);
	}

	@Test
	public void userRegistrationByCommissioner() {
		commissioner = application.load().successCommissionerLogin(UserRepository.get().getCommissioner());
		FlexAssert.get().forElement(UserRepository.get().getCommissioner().getAccount().getLogin())
				.valueMatch(commissioner.getLoginAccountText());
		IUser randomUser = UserRepository.get().getRandomUser();
		UserRegistrationPage usersData = commissioner.goToUserRegistrationPage();
		usersData.setLoginDatas(randomUser);
		usersData.goToNonConfirmedPage().editNonConfirmeduser(randomUser).goToEditRegisteredUserPage()
				.goToEditNewuserPage().changeStatus();
		application.logout();
		UserHomePage userPage = application.load().successUserHomeLogin(randomUser);
		FlexAssert.get().forElement(randomUser.getAccount().getLogin()).valueMatch(userPage.getLoginAccountText());
		DeleteFromDB.deleteUser(randomUser);
	}

}
