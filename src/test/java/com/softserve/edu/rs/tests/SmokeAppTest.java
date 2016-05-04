package com.softserve.edu.rs.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.data.apps.ApplicationSources;
import com.softserve.edu.atqc.tools.BrowserUtils;
import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.AdminHomePage;
import com.softserve.edu.rs.pages.LoginPage;

public class SmokeAppTest {

    @DataProvider//(parallel = true)
    public Object[][] getApplicationSources() {
        return new Object[][] {
                { ApplicationSourcesRepository.get().getJavaTrainingLocalByFirefoxTemporary(), UserRepository.get().getAdmin() },
                };
    }
 
	@Test(dataProvider = "getApplicationSources")
	public void adminLogin(ApplicationSources applicationSources, IUser admin) throws Exception {
		// Preconditions.
		BrowserUtils.get(applicationSources).getBrowser().loadPage(applicationSources.getLoginUrl());;
		// Test Steps.
		AdminHomePage adminHomePage = new LoginPage().successAdminLogin(admin); 
		// Checking.
		Thread.sleep(2000);
		Assert.assertEquals(admin.getAccount().getLogin(),
				adminHomePage.getLoginAccountText());
		// Return to previous state.
		adminHomePage.logout();
		//
		Thread.sleep(2000);
		//application.quit();
		BrowserUtils.get().quitBrowser();
	}

}
