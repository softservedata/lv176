package com.softserve.edu.rs.tests;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
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
	public void oneTimeSetUp() {
		
		application = Application.get
				(ApplicationSourcesRepository.get().getLocalHostByFirefoxTemporary());

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
          return new Object[][] {
                {UserRepository.get().getCoOwner(), UserRepository.get().getRegistrator(),
                ResourceDataRepository.get().getResourceData(),	CoordinatesDataRepository.get().getCoordinatesData()},
                };
    }
	
	@DataProvider
    public Object[][] invalidDataResource() {
          return new Object[][] {
                {UserRepository.get().getCoOwner(), UserRepository.get().getRegistrator(),
                ResourceDataRepository.get().getUnseccesData(),	CoordinatesDataRepository.get().getCoordinatesData()},
                };
    }
 
	// Test Methods 
	
	
	// SMOKE TEST
	@Test(dataProvider = "testData") 
	public void registratorLogin(TestData testData){
		
		PointsPage pointsPage = addNewResourceHomePage.gotoPointsPage();
	
		Assert.assertEquals(pointsPage.getDellAllTerText(),
				testData.getDeleteTeritories());
	
	}
	
	
	// verify one click on PROCURATION
	@Test(dataProvider = "testData") 
	public void procurationOneClick(TestData testData){

		Assert.assertEquals(addNewResourceHomePage.oneClicProcurations(),
				testData.getProcuration());

	}
	
	// verify two click on PROCURATION
	@Test(dataProvider = "testData")  
	public void procurationTwoClick(TestData testData){

		Assert.assertEquals(addNewResourceHomePage.oneClicProcurations(),
				testData.getProcuration());
		
		Assert.assertEquals(addNewResourceHomePage.twoClicProcurations(),
				testData.getEmptyField());

	}
	
	// verify click MAPINSTRUCTION
	@Test(dataProvider = "testData")  
	public void mapInstructionVerify(TestData testData){

		MapPage mapPage = addNewResourceHomePage.gotoMapPage();
				
		Assert.assertEquals(mapPage.verifyInstrUsingMap(),
						testData.getMapInstruction());

	}
	 
	
	// verify adding new resource
	@Test(dataProvider = "dataResource") 
    public void addNewResource(IUser user, IUser registrator,
    		 ResourceData resources, CoordinatesData coordinates){
		
		ResourcePage resourcePage = addNewResourceHomePage.successGotoResource(user, registrator, resources, coordinates);
		
		Assert.assertEquals(resourcePage.getResorceNumberText(),
				registrator.getAccount().getRegistratorNumber()+resources.getResourceNumber());

		resourcePage.clickOk();
	}
	
	
	// verify adding invalid registrator number 
	@Test(dataProvider = "invalidDataResource") 
    public void invalidRegistratorNumber(IUser user, IUser registrator,
    		 ResourceData invalidresources, CoordinatesData coordinates){
		
		AddNewResourceValidatorPage addNewResourceValidatorPage = 
				addNewResourceHomePage.unsuccessRegistratorNumber(user, registrator, invalidresources, coordinates);
		
		Assert.assertEquals(addNewResourceValidatorPage.getStartValidatorText(), 
				AddNewResourceValidatorPage.START_VALIDATOR_MESSAGE);

	}
	
	
}

