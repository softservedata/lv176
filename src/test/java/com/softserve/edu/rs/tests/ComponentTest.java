package com.softserve.edu.rs.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.specs.FlexAssert;
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
		Assert.assertTrue(addSubclassPage.getConteinerWithParameters().isDisplayed());
		FlexAssert.get()
		.forElement(addSubclassPage.getConteinerWithParameters())
		.isVisible()
		.next();
		FlexAssert.get()
		.check();
	}

	@Test
	public void hideParametersTest() {
		addSubclassPage.showParameter().hideParameter();
		FlexAssert.get()
		.forElement(addSubclassPage.getConteinerWithParameters())
		.isInvisible()
		.next();
		FlexAssert.get()
		.check();
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
		addSubclassPage.fillSubParamUnitField(SubclassRepository.get().getRiverSubclass(),1).clearSubParamUnitField();
		FlexAssert.get()
			.forElement(addSubclassPage.getSubclassField())
				.attributeMatch("value", "")
				.next()
			.forElement(addSubclassPage.getDescriptionParametrField())
				.attributeMatch("value", "")
				.next()
			.forElement(addSubclassPage.getUnitOfMeasurementField())
				.attributeMatch("value", "")
				.next();
		FlexAssert.get()
			.check();
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
