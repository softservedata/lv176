package com.softserve.edu.rs.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.data.apps.ApplicationSources;
import com.softserve.edu.atqc.specs.FlexAssert;
import com.softserve.edu.rs.data.apps.Application;
import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.LoginPage;
import com.softserve.edu.rs.pages.RegistratorHomePage;

public class SmokeLoginTest {
    
    @DataProvider (parallel = true)
    public Object[][] getApplicationSources() {
        	return new Object[][] {
                { ApplicationSourcesRepository.get().getLocalHostByFirefoxTemporary(), UserRepository.get().getRegistrator() },
                { ApplicationSourcesRepository.get().getLocalHostByChromeTemporary(), UserRepository.get().getRegistrator() },
                };
    }
 
	@Test(dataProvider = "getApplicationSources")
	public void registratorLogin(ApplicationSources applicationSources, IUser registrator) {
		Application application = Application.get(ApplicationSourcesRepository.get().getLocalHostByFirefoxTemporary());
		RegistratorHomePage registratorHomePage = application.load()
				.successRegistratorLogin(registrator); 		
		FlexAssert.get()
		.forElement(registratorHomePage.getLoginAccount())
		.valueMatch(registrator.getAccount().getLogin())
		.next();
		FlexAssert.get()
		.check();
		registratorHomePage.logout();
	}
	
	@Test(dataProvider = "getApplicationSources")
	public void registratorLogout(ApplicationSources applicationSources, IUser registrator) {
		Application application = Application.get(applicationSources);
		RegistratorHomePage registratorHomePage = application.load()
				.successRegistratorLogin(registrator); 		
		FlexAssert.get()
			.forElement(registratorHomePage.getLoginAccount())
				.valueMatch(registrator.getAccount().getLogin())
				.next();
		FlexAssert.get()
			.check();	
		LoginPage loginPage = registratorHomePage.logout();		
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
		FlexAssert.get()
		.check();
	}

	@AfterClass
	public void oneTimeTearDown() {
		Application.quitAll();
	}
}
