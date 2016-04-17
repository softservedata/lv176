package com.softserve.edu.rs.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.Application;
import com.softserve.edu.rs.pages.LoginPage;
import com.softserve.edu.rs.pages.RegistratorHomePage;

public class SmokeLoginTest {
	private Application application;
	
    @BeforeClass
    public void oneTimeSetUp() {
    	application = new Application(ApplicationSourcesRepository.get()
    			.getLocalHostByFirefox());
    }
    
    @DataProvider
    public Object[][] Users() {
        return new Object[][] {
                { UserRepository.get().getRegistrator() },
                };
    }
 
	@Test(dataProvider = "Users")
	public void registratorLogin(IUser registrator) {
		
		RegistratorHomePage registratorHomePage = application.load()
				.successRegistratorLogin(registrator); 
		
		Assert.assertEquals(registrator.getAccount().getLogin(),
				registratorHomePage.getLoginAccountText());
		
		registratorHomePage.logout();
	}
	
	@Test(dataProvider = "Users")
	public void registratorLogout(IUser registrator) {
		
		RegistratorHomePage registratorHomePage = application.load()
				.successRegistratorLogin(registrator); 
		
		Assert.assertEquals(registrator.getAccount().getLogin(),
				registratorHomePage.getLoginAccountText());
		
		LoginPage loginPage = registratorHomePage.logout();
		
		Assert.assertEquals(LoginPage.TITLE, loginPage.getTitle());
	}
	
	 @AfterClass
	    public void oneTimeTearDown() {
	    	application.quitAll();
	    }
	
}
