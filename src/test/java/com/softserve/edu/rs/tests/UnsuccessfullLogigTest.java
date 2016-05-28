package com.softserve.edu.rs.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.specs.FlexAssert;
import com.softserve.edu.rs.data.apps.Application;
import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.LoginPage;
import com.softserve.edu.rs.pages.LoginValidatorPage;

public class UnsuccessfullLogigTest {
	
	Application application;
	LoginPage loginPage;
	
	@BeforeClass
	public void setUpApp(){
		application = Application.get(ApplicationSourcesRepository.get().getLocalHostByFirefoxTemporary());
	}
	
	@BeforeMethod
	public void setUp(){
		loginPage = application.load();
	}
	
	@AfterClass
	public void shotDownApp(){
		application.quit();
		Application.quitAll();
	}

    @DataProvider
    public Object[][] getUsers() {
        return new Object[][] {
                { UserRepository.get().getEmpty() }
                };
    }
 
	@Test (dataProvider = "getUsers")
	public void adminLogin(IUser user){
		LoginValidatorPage lVPage = application.load().unsuccessUserLogin(user); 
		FlexAssert.get()
			.forElement(lVPage.getValidator())
				.isVisible()
				.valueMatch(LoginValidatorPage.START_VALIDATOR_MESSAGE)
				.next().check();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
