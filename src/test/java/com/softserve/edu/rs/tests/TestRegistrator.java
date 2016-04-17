package com.softserve.edu.rs.tests;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.testdata.CoordinatesData;
import com.softserve.edu.rs.data.testdata.CoordinatesDataRepository;
import com.softserve.edu.rs.data.testdata.ResourceData;
import com.softserve.edu.rs.data.testdata.ResourceDataRepository;
import com.softserve.edu.rs.data.testdata.TestData;
import com.softserve.edu.rs.data.testdata.TestDataRepository;
import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.Application;
import com.softserve.edu.rs.pages.regist.AddNewResourceHomePage;
import com.softserve.edu.rs.pages.regist.SquarePerimetrPage;
import com.softserve.edu.rs.pages.regist.MapPage;
import com.softserve.edu.rs.pages.regist.PointsPage;
import com.softserve.edu.rs.pages.regist.AddNewResourceHomePage.ChangeObjectSubclas;

public class TestRegistrator {

	private Application application;
	private SoftAssert softAssert;
	private AddNewResourceHomePage addNewResourceHomePage;

	@BeforeClass
	public void oneTimeSetUp() {
		application = new Application(ApplicationSourcesRepository.get()
				.getLocalHostByFirefox());
		softAssert = new SoftAssert();
	}

	@AfterClass
	public void oneTimeTearDown() {
		application.quitAll();
		
	}
	
	@BeforeMethod 
    public void setUp() {
		addNewResourceHomePage = application.load()
				.successRegistratorLogin(UserRepository.get().getRegistrator())
				.gotoAddNewResource();
		
    }
    
    @AfterMethod
    public void tearDown() {
    	addNewResourceHomePage.logout();
    	
    }
	
	@DataProvider
    public Object[][] testData() {
          return new Object[][] {
                { TestDataRepository.get().getTestData()},
                };
    }
	
	@DataProvider
    public Object[][] dataResource() {
          return new Object[][] {
                {UserRepository.get().getCoOwner(), UserRepository.get().getRegistrator(),
                ResourceDataRepository.get().getResourceData(),	CoordinatesDataRepository.get().getCoordinatesData()},
                };
    }
 
	// Test Methods 
	
	
	@Test(dataProvider = "testData")  // SMOKE TEST
	public void registratorLogin(TestData testData){
				
		PointsPage pointsPage = addNewResourceHomePage.gotoPointsPage();
	
		Assert.assertEquals(pointsPage.getDellAllTerText(),
				testData.getDeleteTeritories());
				
		
	}
	
	@Test(dataProvider = "testData")  // verify one click on PROCURATION
	public void procurationOneClick(TestData testData){

		Assert.assertEquals(addNewResourceHomePage.oneClicProcurations(),
				testData.getProcuration());

	}
	
	@Test(dataProvider = "testData")  // verify two click on PROCURATION
	public void procurationTwoClick(TestData testData){

		softAssert.assertEquals(addNewResourceHomePage.oneClicProcurations(),
				testData.getProcuration());
		
		softAssert.assertEquals(addNewResourceHomePage.twoClicProcurations(),
				testData.getEmptyField());
		
		softAssert.assertAll();
	
	}
	
	@Test(dataProvider = "testData")  // verify one click on PASSPORT
	public void passportoneClick(TestData testData){

		softAssert.assertEquals(addNewResourceHomePage.oneClicPassport(),
				testData.getPassport());
		softAssert.assertAll();

	}
	
	@Test(dataProvider = "testData")  // verify click MAPINSTRUCTION
	public void mapInstructionVerify(TestData testData){
	
		MapPage mapPage = addNewResourceHomePage.gotoMapPage();
				
		Assert.assertEquals(mapPage.verifyInstrUsingMap(),
						testData.getMapInstruction());

	}
		
	@Test(dataProvider = "dataResource")  // verify adding new resource
    public void addNewResource(IUser user, IUser registrator,
    		 ResourceData resources, CoordinatesData coordinates){

		PointsPage pointsPage = addNewResourceHomePage.setDataGoPointPage(user, registrator, resources);
		
		pointsPage.enterPoints(coordinates);
		
		String square = pointsPage.gotoMapPage().getSquareTerrText();
		String perimetr = pointsPage.gotoMapPage().getPerimetrTerrText();
		
		SquarePerimetrPage squarePerimetrPage =(SquarePerimetrPage) pointsPage
				.selectObjectSubclas(ChangeObjectSubclas.LANDED);
		
		squarePerimetrPage.setDataPerSq(square, perimetr);
		
		Assert.assertEquals(squarePerimetrPage.gotoResource().getResorceNameText(),
				registrator.getAccount().getRegistratorNumber()+resources.getResourceNumber());
		
	}
	
}

