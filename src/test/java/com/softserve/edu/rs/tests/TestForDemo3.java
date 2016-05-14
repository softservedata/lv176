package com.softserve.edu.rs.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import com.softserve.edu.rs.data.apps.Application;
import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.*;

public class TestForDemo3 {
	private AdminHomePage adminHomePage;
	private Application application;
	private SettingPage settingPage;

	@BeforeClass
	public void oneTimeSetUp() {
		application = new Application(ApplicationSourcesRepository.get().getLocalHostByFirefoxDefault());

	}

	@BeforeMethod
	public void setUp() {
		settingPage = application.load().successAdminLogin(UserRepository.get().getAdmin()).goToSetting();
	}

	@AfterClass
	public void oneTimeTearDown() {
		application.quit();
	}

	@AfterMethod
	public void tearDown() {
		application.logout();
	}

	@Test
	public void settingsPage() {
		Assert.assertTrue(settingPage.getTimeZone().isEnabled());
		Assert.assertTrue(settingPage.getConfirmChanges().isEnabled());
	}

	@Test
	public void mixedRegistration() {
		settingPage.clickMixedRegister();
		settingPage.clickConfirmChanges();
		application.logout();
		Assert.assertTrue(application.logout().getRegisterButton().isEnabled());
		CommissionerPage commissioner = application.load()
				.successCommissionerLogin(UserRepository.get().getCommissioner());
		Assert.assertEquals(UserRepository.get().getCommissioner().getAccount().getLogin(),
				commissioner.getLoginAccountText());
		Assert.assertTrue(commissioner.getRegisteredUsers().isEnabled());

	}

	@Test
	public void userPersonalRegistration() {
		IUser randomUser = UserRepository.get().getRandomUser();
		settingPage.clickPersonalRegister();
		settingPage.clickConfirmChanges();
		application.logout();
		UserRegistrationPage registerNewUser = application.load().registerUser();
		registerNewUser.setLoginDatas(randomUser);
		AfterRegistrationPage afterRegistrationPage = registerNewUser.confirmRegistration();
		afterRegistrationPage.clickReturnToLoginPage();
		adminHomePage = application.load().successAdminLogin(UserRepository.get().getAdmin());
		Assert.assertEquals(UserRepository.get().getAdmin().getAccount().getLogin(),
				adminHomePage.getLoginAccountText());
		adminHomePage.goToNonConfirmedUsers().editNonConfirmeduser(randomUser).goToEditRegisteredUserPage()
				.goToEditNewuserPage().changeStatus();
		application.logout();
		UserHomePage userPage = application.load().successUserHomeLogin(randomUser);
		Assert.assertEquals(randomUser.getAccount().getLogin(), userPage.getLoginAccountText());

	}
}
