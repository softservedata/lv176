package com.softserve.edu.rs.tests;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.data.ListUtils;
import com.softserve.edu.atqc.data.apps.ApplicationSources;
import com.softserve.edu.atqc.specs.FlexAssert;
import com.softserve.edu.atqc.test.ParameterUtils;
import com.softserve.edu.rs.data.apps.Application;
import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.input.SearchDataRepository;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.ActiveAdminSearchPage;

public class SearchByNameTest {
	Application application;
	ActiveAdminSearchPage aasp;
	
	@BeforeClass
	public void setUpApp(){
		application = Application.get(ApplicationSourcesRepository.get().getLocalHostByFirefoxTemporary());
		aasp = application.load().successAdminLogin(UserRepository.get().getAdmin()).gotoActiveUsers();
	}
	
	@AfterClass
	public void shotDownApp(){
		application.quit();
	}
	
	@DataProvider
    public Object[][] getNames(ITestContext context) {
		return ListUtils.get().toMultiArrayNumberParams(
    			ParameterUtils.get().updateAllApplicationSources(
        				ApplicationSourcesRepository.get()
        					.getLocalHostByFirefoxTemporary(), context),
        					SearchDataRepository.get().getNamesFromCVS());
    }
	
	@Test (dataProvider = "getNames")
	public void searchByNameTest(ApplicationSources app, String str){
		aasp = aasp.searhByName(str);
		FlexAssert.get()
			.forElement(aasp.getNamesTableList())
				.containsText(str)
		.next().check();
	}
}
