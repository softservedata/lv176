package com.softserve.edu.rs.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.AdminHomePage;
import com.softserve.edu.rs.pages.Application;

public class SmokeAppTest {
	private Application application;

    @BeforeClass
    public void oneTimeSetUp() {
    	application = new Application(ApplicationSourcesRepository.get()
    			.getLocalHostByFirefox());
        System.out.println("@BeforeClass oneTimeSetUp, Thread Id = "
                + Thread.currentThread().getId());
    }

    @AfterClass
    public void oneTimeTearDown() {
    	application.quitAll();
        System.out.println("@AfterClass oneTimeTearDown, Thread Id = "
                + Thread.currentThread().getId());
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("@BeforeMethod setUp, Thread Id = "
                + Thread.currentThread().getId());
    }
    
    @AfterMethod
    public void tearDown() {
    	//application.logout();
        System.out.println("@AfterMethod setUp, Thread Id = "
                + Thread.currentThread().getId());
    }
	
    @DataProvider//(parallel = true)
    public Object[][] adminUsers() {
        System.out.println("@DataProvider adminUsers, Thread Id = "
                + Thread.currentThread().getId());
        return new Object[][] {
                { UserRepository.get().getAdmin() },
                //{ UserRepository.get().getCommissioner() },
                //{ UserRepository.get().getAdmin() },
                };
    }
 
	@Test(dataProvider = "adminUsers")
	public void adminLogin1(IUser admin) throws Exception {
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
