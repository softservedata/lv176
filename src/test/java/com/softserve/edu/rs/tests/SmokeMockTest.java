package com.softserve.edu.rs.tests;

import org.mockito.Mockito;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.data.apps.ApplicationSources;
import com.softserve.edu.atqc.specs.FlexAssert;
import com.softserve.edu.atqc.test.ParameterUtils;
import com.softserve.edu.rs.data.apps.Application;
import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.LoginPage;

public class SmokeMockTest {
	
	@AfterClass
	public void oneTimeTearDown() {
		System.out.println("@AfterClass - oneTimeTearDown");
		Application.quitAll();
	}

    @DataProvider//(parallel = true)
    public Object[][] getApplicationSources(ITestContext context) {
//    	return ListUtils.get().toMultiArrayNumberParams(
//    			ParameterUtils.get().updateAllApplicationSources(
//    				ApplicationSourcesRepository.get()
//    					.getHerokuByFirefoxTemporary(), context),
//    			UserRepository.get().getExistUsersExcel());
        return new Object[][] {
                //{ ApplicationSourcesRepository.get().getJavaTrainingLocalByFirefoxTemporary(), UserRepository.get().getAdmin() },
                //{ ApplicationSourcesRepository.get().getHerokuByFirefoxTemporary(), UserRepository.get().getAdmin() },
            	//{ ApplicationSourcesRepository.get().getJavaTrainingLocalByChromeTemporary(), UserRepository.get().getAdmin() },
                { ParameterUtils.get().updateAllApplicationSources(ApplicationSourcesRepository.get().getHerokuByFirefoxTemporary(), context),
                		UserRepository.get().getAdmin() },
                };
    }

	@Test(dataProvider = "getApplicationSources")
	public void adminLogin(ApplicationSources applicationSources, IUser admin) throws Exception {
		// Preconditions.
		Application application = Application.get(applicationSources);
		// Test Steps.
		application.load();
//		LoginPage loginPage = Mockito.spy(application.load());
		//
//		ITextField textFieldMock = Mockito.spy(TextField.get().getById("password"));
//		Mockito.when(textFieldMock.getAttribute("name")).thenReturn("login");
//		Mockito.when(textFieldMock.getAttribute("id")).thenReturn("login");
//		Mockito.when(textFieldMock.getAttribute("hahaha")).thenReturn("non");
//		Mockito.when(loginPage.getLogin()).thenReturn(textFieldMock);
		//
		LoginPage loginPage = Mockito.mock(LoginPage.class);
		ITextField textFieldMock = Mockito.mock(ITextField.class);
		Mockito.when(textFieldMock.getAttribute("name")).thenReturn("login");
		Mockito.when(textFieldMock.getAttribute("id")).thenReturn("login");
		Mockito.when(textFieldMock.getAttribute("hahaha")).thenReturn("non");
		Mockito.when(loginPage.getLogin()).thenReturn(textFieldMock);
		//
		// Checking.
		Thread.sleep(2000);
		FlexAssert.get()
			.forElement(loginPage.getLogin())
				.attributeMatch("name", "login")
				.attributeMatch("id", "login")
				.attributeMatch("hahaha", "non");
		//
		//application.quit();
		// Check
		FlexAssert.get()
			.check();
	}



}
