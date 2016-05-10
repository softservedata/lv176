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
import com.softserve.edu.rs.pages.SubclassesOfObjectsPage;

public class DeleteSubclassTest {
	private Application application;
	private SubclassesOfObjectsPage subclassesOfObjectsPage;

	@BeforeClass
	public void oneTimeSetUp() {
		application = Application.get(ApplicationSourcesRepository.get().getLocalHostByFirefoxTemporary());
	}
	
	@BeforeMethod
	public void setUp() {
		subclassesOfObjectsPage = application.load()
				.successRegistratorLogin(UserRepository.get().getRegistrator())
				.gotoSubclassPage()
				.gotoAddSubclassPage()
				.showParameter()
				.addNewSubclass(SubclassRepository.get().getOneLetterSubclassName());
	}

	@Test
	public void delSubclassTest() {
		subclassesOfObjectsPage.deleteSubclass(SubclassRepository.get().getOneLetterSubclassName());
		Assert.assertFalse(subclassesOfObjectsPage.visibleDeleteSubclass(SubclassRepository.get().getOneLetterSubclassName()));
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
