package com.softserve.edu.rs.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.data.apps.ApplicationSources;
import com.softserve.edu.rs.data.apps.Application;
import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.LoginPage;
import com.softserve.edu.rs.pages.RegistratorHomePage;

public class SmokeLoginTest {
    
    @DataProvider
    public Object[][] getApplicationSources() {
        	return new Object[][] {
                { ApplicationSourcesRepository.get().getLocalHostByFirefoxTemporary(), UserRepository.get().getRegistrator() },
                { ApplicationSourcesRepository.get().getHerokuByFirefoxTemporary(), UserRepository.get().getRegistrator() },
                };
    }
 
	@Test(dataProvider = "getApplicationSources")
	public void registratorLogin(ApplicationSources applicationSources, IUser registrator) {
		Application application = Application.get(ApplicationSourcesRepository.get().getLocalHostByFirefoxTemporary());
		RegistratorHomePage registratorHomePage = application.load()
				.successRegistratorLogin(registrator); 		
		Assert.assertEquals(registrator.getAccount().getLogin(),
				registratorHomePage.getLoginAccountText());		
		registratorHomePage.logout();
		application.quit();
	}
	
	@Test(dataProvider = "getApplicationSources")
	public void registratorLogout(ApplicationSources applicationSources, IUser registrator) {
		Application application = Application.get(applicationSources);
		RegistratorHomePage registratorHomePage = application.load()
				.successRegistratorLogin(registrator); 		
		Assert.assertEquals(registrator.getAccount().getLogin(),
				registratorHomePage.getLoginAccountText());		
		LoginPage loginPage = registratorHomePage.logout();		
		Assert.assertEquals(LoginPage.TITLE, loginPage.getTitle());
		application.quit();
	}
	
}
