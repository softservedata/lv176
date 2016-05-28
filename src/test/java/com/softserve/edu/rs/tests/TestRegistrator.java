package com.softserve.edu.rs.tests;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.data.ListUtils;
import com.softserve.edu.atqc.specs.FlexAssert;
import com.softserve.edu.atqc.test.ParameterUtils;
import com.softserve.edu.rs.data.apps.Application;
import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.testdata.CoordinatesData;
import com.softserve.edu.rs.data.testdata.CoordinatesDataRepository;
import com.softserve.edu.rs.data.testdata.ResourceData;
import com.softserve.edu.rs.data.testdata.ResourceDataRepository;
import com.softserve.edu.rs.data.testdata.TestData;
import com.softserve.edu.rs.data.testdata.TestDataRepository;
import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.AddNewResourceHomePage;
import com.softserve.edu.rs.pages.AddNewResourceValidatorPage;
import com.softserve.edu.rs.pages.MapPage;
import com.softserve.edu.rs.pages.PointsPage;
import com.softserve.edu.rs.pages.ResourcePage;


public class TestRegistrator {
	
	private Application application;
	private AddNewResourceHomePage addNewResourceHomePage;

	@BeforeClass
	public void oneTimeSetUp(ITestContext context) {
		
		application = Application.get(
		ParameterUtils.get().updateAllApplicationSources(
				ApplicationSourcesRepository.get()
					.getLocalHostByFirefoxTemporary(), context));

	}

	@AfterClass
	public void oneTimeTearDown() {
		application.quit();
	}
	
	@BeforeMethod 
    public void setUp() {
		addNewResourceHomePage = application.load()
		                        .successRegistratorLogin(UserRepository.get().getRegistrator())
		                        .gotoAddNewResource();
    }
	
	@AfterMethod
	public void tearDown() {
		FlexAssert.get().check();
	    application.logout();
	    	
	}

	@DataProvider
    public Object[][] testData() {
          return new Object[][] {
                {TestDataRepository.get().getTestData()},
                };
    }
	
	
	@DataProvider
    public Object[][] dataResource() {
		return ListUtils.get()
				.toMultiArrayNumberParams(ResourceDataRepository.get().getResourcesCsv(), CoordinatesDataRepository.get().getCoordinatesCsv(),
						UserRepository.get().getCoOwnerExcel(), UserRepository.get().getRegistratorExcel());
    }
	
	
	@DataProvider
    public Object[][] invalidDataResource() {
		return ListUtils.get()
				.toMultiArrayNumberParams(ResourceDataRepository.get().getResourcesNegativCsv(), CoordinatesDataRepository.get().getCoordinatesCsv(),
						UserRepository.get().getCoOwnerExcel(), UserRepository.get().getRegistratorExcel());

    }
 
	// Test Methods 

	// SMOKE TEST
	@Test(dataProvider = "testData") 
	public void registratorLogin(TestData testData){
		
		PointsPage pointsPage = addNewResourceHomePage.gotoPointsPage();
		
		FlexAssert.get()
		     .forElement(pointsPage.getDelAllter())
		         .valueMatch(testData.getDeleteTeritories());

	}
	
	
	// verify one click on PROCURATION
	@Test(dataProvider = "testData") 
	public void procurationOneClick(TestData testData){
		addNewResourceHomePage.clickProcurations();
		FlexAssert.get()
		     .forElement(addNewResourceHomePage.getTextarea())
		           .valueBySeparator(";", testData.getProcuration());

	}
	
	// verify two click on PROCURATION
	@Test(dataProvider = "testData")  
	public void procurationTwoClick(TestData testData){
		addNewResourceHomePage.clickProcurations();
		
		FlexAssert.get()
	     .forElement(addNewResourceHomePage.getTextarea())
	           .valueBySeparator(";", testData.getProcuration());
		
		addNewResourceHomePage.clickProcurations();
		
		FlexAssert.get()
	     .forElement(addNewResourceHomePage.getTextarea())
	           .valueMatch(testData.getEmptyField());

	}
	
	// verify click MAPINSTRUCTION
	@Test(dataProvider = "testData")  
	public void mapInstructionVerify(TestData testData){
		

		MapPage mapPage = addNewResourceHomePage.gotoMapPage();
		mapPage.clicInstrUsingMapButt();
		FlexAssert.get()
	     .forElement(mapPage.getInstrUsingMap())
	          .valueBySeparator(".", testData.getMapInstruction());

	}
	 
	
	// verify adding new resource
	@Test(dataProvider = "dataResource") 
    public void addNewResource(ResourceData resources, CoordinatesData coordinates,
    		  IUser user, IUser registrator){

		ResourcePage resourcePage = addNewResourceHomePage.successGotoResource(user, registrator, resources, coordinates);
		
		FlexAssert.get()
	     .forElement(resourcePage.getResorceNumber())
	          .valueMatch(registrator.getAccount().getRegistratorNumber()+resources.getResourceNumber());

		resourcePage.clickOk();
	}
	
	
	// verify adding invalid registrator number 
	@Test(dataProvider = "invalidDataResource") 
    public void invalidRegistratorNumber(ResourceData invalidresources, CoordinatesData coordinates,
    		     IUser user, IUser registrator){
		   
		AddNewResourceValidatorPage addNewResourceValidatorPage = 
				addNewResourceHomePage.unsuccessRegistratorNumber(user, registrator, invalidresources, coordinates);
		
		FlexAssert.get()
	     .forElement(addNewResourceValidatorPage.getValidator())
	          .valueMatch(AddNewResourceValidatorPage.START_VALIDATOR_MESSAGE);
		
	}
	
	
}

