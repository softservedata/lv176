package com.softserve.edu.rs.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.resources.SubclassRepository;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.Application;
import com.softserve.edu.rs.pages.ShowSubclassPage;

public class DeleteSubclassTest {
	private Application application;
	private ShowSubclassPage showSubclassPage;

	@BeforeClass
	public void oneTimeSetUp() {
		application = new Application(ApplicationSourcesRepository.get().getLocalHostByFirefox());
	}
	
	@BeforeMethod
	public void setUp() {
		showSubclassPage = application.load()
				.successRegistratorLogin(UserRepository.get().getRegistrator())
				.gotoSubclassPage()
				.gotoAddSubclassPage()
				.showParameter()
				.addNewSubclass(SubclassRepository.get().getOneLetterSubclassName());
	}

	@Test
	public void delSubclassTest() {
		showSubclassPage.deleteSubclass(SubclassRepository.get().getOneLetterSubclassName());
		Assert.assertFalse(showSubclassPage.findPresentSubclass(SubclassRepository.get().getOneLetterSubclassName()));
	}
	
	@AfterMethod
	public void tearDown() {
		application.logout();
	}

	@AfterClass
	public void oneTimeTearDown() {
		application.quitAll();
	}

	
}
