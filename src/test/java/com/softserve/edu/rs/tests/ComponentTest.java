package com.softserve.edu.rs.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.softserve.edu.rs.data.apps.Application;
import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.resources.SubclassRepository;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.AddSubclassPage;

public class ComponentTest {
	private Application application;
	private AddSubclassPage addSubclassPage;

	@BeforeClass
	public void oneTimeSetUp() {
		application = Application.get(ApplicationSourcesRepository.get().getLocalHostByFirefoxTemporary());
	}

	@BeforeMethod
	public void setUp() {
		addSubclassPage = application.load().successRegistratorLogin(UserRepository.get().getRegistrator())
				.gotoSubclassPage().gotoAddSubclassPage();
	}

	@Test
	public void showParametersTest() {
		addSubclassPage.showParameter();
		//Assert.assertEquals(addSubclassPage.visibleParametrsBlockVisible(), "block");
		Assert.assertTrue(addSubclassPage.getOptionsTable().isDisplayed());
	}

	@Test
	public void hideParametersTest() {
		addSubclassPage.showParameter().hideParameter();
		Assert.assertFalse(addSubclassPage.getOptionsTable().isDisplayed());
	}

	@Test
	public void addParametersTest() {
		addSubclassPage.showParameter();
		int elementsCount = addSubclassPage.getElementCount();
		int elementsCountAfterAdd = addSubclassPage.addParameter().getElementCount();
		Assert.assertEquals(elementsCountAfterAdd - 1, elementsCount);
	}

	@Test
	public void delParametersTest() {
		addSubclassPage.showParameter().addParameter();
		int elementsCount = addSubclassPage.getElementCount();
		int elementsCountAfterAdd = addSubclassPage.delParameter().getElementCount();
		Assert.assertEquals(elementsCountAfterAdd + 1, elementsCount);
	}

	@Test
	public void clearFormTest() {
		addSubclassPage.showParameter();
		String textSubclassField = addSubclassPage.readSubclassField();
		String textDescriptionParametrField = addSubclassPage.readDescriptionParametrField();
		String textUnitOfMeasurementField = addSubclassPage.readUnitOfMeasurementField();
		addSubclassPage.fillClearSubParamUnitField(SubclassRepository.get().getRiverSubclass());
		String textSubclassFieldAfter = addSubclassPage.readSubclassField();
		String textDescriptionParametrFieldAfter = addSubclassPage.readDescriptionParametrField();
		String textUnitOfMeasurementFieldAfter = addSubclassPage.readUnitOfMeasurementField();
		Assert.assertEquals(textSubclassFieldAfter, textSubclassField);
		Assert.assertEquals(textDescriptionParametrFieldAfter, textDescriptionParametrField);
		Assert.assertEquals(textUnitOfMeasurementFieldAfter, textUnitOfMeasurementField);

	}

	@AfterMethod
	public void tearDown() {
		application.logout();
	}

	@AfterClass
	public void oneTimeTearDown() {
		application.quit();
	}

}
