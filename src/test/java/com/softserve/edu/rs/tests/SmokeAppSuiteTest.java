package com.softserve.edu.rs.tests;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.rs.data.apps.ApplicationSources;
import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.AdminHomePage;
import com.softserve.edu.rs.pages.Application;

public class SmokeAppSuiteTest {

    @DataProvider//(parallel = true)
    public Object[][] adminUsers(ITestContext context) {
        System.out.println("@DataProvider adminUsers, Thread Id = "
                + Thread.currentThread().getId());
        ApplicationSources applicationSources = ApplicationSourcesRepository.get().getLocalHostByFirefox();
        //
        // Print all parameters
        HashMap<String, String> hashMap = new HashMap<String, String>(context.getCurrentXmlTest().getSuite().getParameters()); 
        for (String key : hashMap.keySet()) {
        	System.out.println("Suite parameter: key=" + key + " value=" + hashMap.get(key));
        }
        //
        if (context.getCurrentXmlTest().getSuite().getParameter("loginurl") != null) {
            System.out.println("New loginurl: "
                    + context.getCurrentXmlTest().getSuite().getParameter("loginurl"));
            applicationSources.setLoginUrl(context.getCurrentXmlTest().getSuite().getParameter("loginurl"));
        }
        if (context.getCurrentXmlTest().getSuite().getParameter("logouturl") != null) {
            System.out.println("New loginurl: "
                    + context.getCurrentXmlTest().getSuite().getParameter("logouturl"));
            applicationSources.setLogoutUrl(context.getCurrentXmlTest().getSuite().getParameter("logouturl"));
        }
        //
        Application application = new Application(applicationSources);
        return new Object[][] {
                { application, UserRepository.get().getAdmin() },
                //{ application, UserRepository.get().getCommissioner() },
                //{ application, UserRepository.get().getAdmin() },
                };
    }
 
	@Test(dataProvider = "adminUsers")
	public void adminLogin1(Application application, IUser admin) throws Exception {
        System.out.println("@Test adminLogin1, Thread Id = "
                + Thread.currentThread().getId());
		// Preconditions.
		// Test Steps.
		AdminHomePage adminHomePage = application.load()
				.successAdminLogin(admin); 
		// Checking.
		Thread.sleep(2000);
		Assert.assertEquals(admin.getAccount().getLogin(),
				adminHomePage.getLoginAccountText());
		// Return to previous state.
		adminHomePage.logout();
		//
		Thread.sleep(2000);
		application.quit();
	}

}
