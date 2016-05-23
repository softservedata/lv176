package com.softserve.edu.rs.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.data.apps.ApplicationSources;
import com.softserve.edu.atqc.specs.FlexAssert;
import com.softserve.edu.rs.data.apps.Application;
import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.AdminHomePage;
import com.softserve.edu.rs.pages.LoginPage;

public class SmokeAppTest {
	private Application application;
	private boolean isFailed;
	
	@AfterClass
	public void oneTimeTearDown() {
		System.out.println("@AfterClass - oneTimeTearDown");
		Application.quitAll();
	}

	@BeforeMethod(groups = "method1")
	public void setUp() {
		System.out.println("@BeforeMethod - setUp");
		isFailed = true;
	}

	@AfterMethod(groups = "method1")
	public void tearDown() {
		System.out.println("@AfterMethod - tearDown");
		if (application != null) {
			if (isFailed) {
				FlexAssert.get().verify(false, "Test Failed");
			}
			application.quit();
		}
		// Check
		FlexAssert.get().check();
	}

    @DataProvider//(parallel = true)
    public Object[][] getApplicationSources() {
        return new Object[][] {
                //{ ApplicationSourcesRepository.get().getJavaTrainingLocalByFirefoxTemporary(), UserRepository.get().getAdmin() },
                { ApplicationSourcesRepository.get().getHerokuByFirefoxTemporary(), UserRepository.get().getAdmin() },
                };
    }
 
	//@Test(dataProvider = "getApplicationSources")
	public void adminLogin(ApplicationSources applicationSources, IUser admin) throws Exception {
		// Preconditions.
		Application application = Application.get(applicationSources);
		// Test Steps.
		AdminHomePage adminHomePage = application.load().successAdminLogin(admin); 
		// Checking.
		Thread.sleep(2000);
		Assert.assertEquals(admin.getAccount().getLogin(),
				adminHomePage.getLoginAccountText());
		// Test Steps.
		//adminHomePage.setFocusUsers();
		adminHomePage.clickUsers(); 
		Thread.sleep(2000);
		// Return to previous state.
		adminHomePage.logout();
		//
		Thread.sleep(2000);
		//application.quit();
		application.quit();
	}

	@Test(dataProvider = "getApplicationSources")
	public void adminLoginAdv(ApplicationSources applicationSources, IUser admin) throws Exception {
		// Preconditions.
		application = Application.get(applicationSources);
		// Test Steps.
		AdminHomePage adminHomePage = application.load().successAdminLogin(admin); 
		// Checking.
		Thread.sleep(2000);
		FlexAssert.get()
			.forElement(adminHomePage.getLoginAccountText())
				.valueMatch(admin.getAccount().getLogin())
				.next()
			.forElement(adminHomePage.getLoginAccount())
				.valueMatch(admin.getAccount().getLogin());
//		Assert.assertEquals(admin.getAccount().getLogin(),
//				adminHomePage.getLoginAccountText());
		// Test Steps.
		//adminHomePage.setFocusUsers();
		adminHomePage.clickUsers(); 
		Thread.sleep(2000);
		// Return to previous state.
		LoginPage loginPage = adminHomePage.logout();
		Thread.sleep(2000);
		FlexAssert.get()
			.forElement(loginPage.getLogin())
				.attributeMatch("name", "login")
				.attributeMatch("id", "login")
				.isVisible()
				.next()
			.forElement(loginPage.getPassword())
				.attributeMatch("name", "password")
				.attributeMatch("id", "password")
				.isVisible();
		//
		//application.quit();
		int i=5;
		if (i<2) {
			throw new RuntimeException("Ha-Ha-Ha");
		}
		// Check
//		FlexAssert.get()
//			.check();
		isFailed = false;
	}

	//@Test(dataProvider = "getApplicationSources")
	public void adminLoginHello(ApplicationSources applicationSources, IUser admin) throws Exception {
		// Preconditions.
		Application application = Application.get(applicationSources);
		// Test Steps.
		application.load().showAlert("ADMIN");
		//
		Thread.sleep(2000);
		//application.quit();
		application.quit();
	}

	//@Test
	public void one() throws Exception {
		System.out.println("one()");
		isFailed = false;
	}

}
