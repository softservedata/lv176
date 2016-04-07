package com.softserve.edu.rs.tests;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.AdminHomePage2;
import com.softserve.edu.rs.pages.Application2;
import com.softserve.edu.rs.pages.LoginPage2;
import com.softserve.edu.rs.pages.LoginPage2.LoginPageEng;
import com.softserve.edu.rs.pages.LoginPage2.LoginPageUkr;
import com.softserve.edu.rs.pages.TopPage2.ChangeLanguageFields2;

public class SmokeAppSuiteTest2 {
	private SoftAssert softAssert;

    @BeforeClass
    public void oneTimeSetUp() {
        softAssert = new SoftAssert();
    }
    
    @DataProvider//(parallel = true)
    public Object[][] adminUsers(ITestContext context) {
        Application2 application = new Application2(ApplicationSourcesRepository.get().getLocalHostByFirefox());
        return new Object[][] {
                { application, UserRepository.get().getAdmin() },
                //{ application, UserRepository.get().getCommissioner() },
                //{ application, UserRepository.get().getAdmin() },
                };
    }
 
	@Test(dataProvider = "adminUsers")
	public void adminLogin1(Application2 application, IUser admin) throws Exception {
		// Preconditions.
		//LoginPage2 loginPage = PageFactory.initElements(driver, LoginPage2.class); 
		// Test Steps.
//		AdminHomePage2 adminHomePage = application.load()
//				.successAdminLogin(admin);
		LoginPage2 loginPage = application.load();
		loginPage.setChangeLanguage(ChangeLanguageFields2.ENGLISH);
		// Checking.
		Thread.sleep(1000);
		softAssert.assertEquals(loginPage.getLoginLabelText(),
				LoginPageEng.LOGINLABEL.toString());
		softAssert.assertEquals(loginPage.getPasswordLabelText(),
				LoginPageEng.PASSWORDLABEL.toString());
		//
		// Test Steps.
		loginPage.setChangeLanguage(ChangeLanguageFields2.UKRAINIAN);
		// Checking.
		Thread.sleep(1000);
		softAssert.assertEquals(loginPage.getLoginLabelText(),
				LoginPageUkr.LOGINLABEL.toString());
		softAssert.assertEquals(loginPage.getPasswordLabelText(),
				LoginPageUkr.PASSWORDLABEL.toString());
		//
		// Test Steps.
		loginPage.setLogin("hahaha");
		loginPage.setPassword("hahaha");
		Thread.sleep(1000);
		application.reload();
		Thread.sleep(1000);
		AdminHomePage2 adminHomePage = loginPage.successAdminLogin(admin);
		// Checking.
		Thread.sleep(2000);
		softAssert.assertEquals(admin.getAccount().getLogin(),
				adminHomePage.getLoginAccountText());
		//
		// Test Steps.
		loginPage.setChangeLanguage(ChangeLanguageFields2.UKRAINIAN);
		// Checking.
		Thread.sleep(1000);
		softAssert.assertEquals(adminHomePage.getLogoutText(),
				"Вихід");
		//
		// Test Steps.
		loginPage.setChangeLanguage(ChangeLanguageFields2.ENGLISH);
		// Checking.
		Thread.sleep(1000);
		softAssert.assertEquals(adminHomePage.getLogoutText(),
				"Sign out");
		//
		// Test Steps.
		// Return to previous state.
		loginPage.setChangeLanguage(ChangeLanguageFields2.UKRAINIAN);
		adminHomePage.logout();
		//
		Thread.sleep(2000);
		application.quit();
        // Final Check
        softAssert.assertAll();
	}

}
