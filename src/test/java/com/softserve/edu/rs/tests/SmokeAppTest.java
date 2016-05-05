package com.softserve.edu.rs.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.data.apps.ApplicationSources;
import com.softserve.edu.rs.data.apps.Application;
import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.AdminHomePage;

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
		Application application = Application.get(applicationSources);
		// Test Steps.
		AdminHomePage adminHomePage = application.load().successAdminLogin(admin); 
		// Checking.
		Thread.sleep(2000);
		Assert.assertEquals(admin.getAccount().getLogin(),
				adminHomePage.getLoginAccountText());
		// Return to previous state.
		adminHomePage.logout();
		//
		Thread.sleep(2000);
		//application.quit();
		application.quit();
	}

}
