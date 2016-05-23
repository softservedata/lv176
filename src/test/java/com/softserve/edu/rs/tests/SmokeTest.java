package com.softserve.edu.rs.tests;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.data.ListUtils;
import com.softserve.edu.atqc.data.apps.ApplicationSources;
import com.softserve.edu.atqc.specs.FlexAssert;
import com.softserve.edu.atqc.test.ParameterUtils;
import com.softserve.edu.rs.data.apps.Application;
import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.AdminHomePage;
import com.softserve.edu.rs.pages.LoginPage;

public class SmokeTest {
	
	@AfterClass
	public void oneTimeTearDown() {
		System.out.println("@AfterClass - oneTimeTearDown");
		Application.quitAll();
	}

    @DataProvider//(parallel = true)
    public Object[][] getApplicationSources(ITestContext context) {
    	return ListUtils.get().toMultiArrayNumberParams(
    			ParameterUtils.get().updateAllApplicationSources(
    				ApplicationSourcesRepository.get()
    					.getHerokuByFirefoxTemporary(), context),
    			UserRepository.get().getExistUsersExcel());
//        return new Object[][] {
//                //{ ApplicationSourcesRepository.get().getJavaTrainingLocalByFirefoxTemporary(), UserRepository.get().getAdmin() },
//                //{ ApplicationSourcesRepository.get().getHerokuByFirefoxTemporary(), UserRepository.get().getAdmin() },
//            	//{ ApplicationSourcesRepository.get().getJavaTrainingLocalByChromeTemporary(), UserRepository.get().getAdmin() },
//                { ParameterUtils.get().updateAllApplicationSources(ApplicationSourcesRepository.get().getHerokuByFirefoxTemporary(), context),
//                		UserRepository.get().getAdmin() },
//                };
    }

	@Test(dataProvider = "getApplicationSources")
	public void adminLoginAdv(ApplicationSources applicationSources, IUser admin) throws Exception {
		// Preconditions.
		Application application = Application.get(applicationSources);
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
		// Check
		FlexAssert.get()
			.check();
	}

}
