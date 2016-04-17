package com.softserve.edu.rs.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.resources.ISubclass;
import com.softserve.edu.rs.data.resources.SubclassRepository;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.AddSubclassPage;
import com.softserve.edu.rs.pages.Application;
import com.softserve.edu.rs.pages.ShowSubclassPage;

public class CreateNewSubclassTest {
	private Application application;
	private AddSubclassPage addSubclassPage;

	@BeforeClass
	public void oneTimeSetUp() {
		application = new Application(ApplicationSourcesRepository.get().getLocalHostByFirefox());
	}

	@BeforeMethod
	public void setUp() {
		addSubclassPage = application.load()
				.successRegistratorLogin(UserRepository.get().getRegistrator())
				.gotoSubclassPage()
				.gotoAddSubclassPage();
	}
	
	@DataProvider
    public Object[][] SubclassParametr() {
        return new Object[][] {
                { SubclassRepository.get().getOneLetterSubclassName() },
                { SubclassRepository.get().getLettersSubclassName() },
                { SubclassRepository.get().getOneNumberSubclassName() },
                { SubclassRepository.get().getNumbersSubclassName() },
                { SubclassRepository.get().getResCharsSubclass() },
                { SubclassRepository.get().getRandomSubclassNoParams() },
                { SubclassRepository.get().getRandomSubclassNoParamsMaxLength() },
                };
    }
	
	@Test(dataProvider = "SubclassParametr")
	public void addNewSubclassTest(ISubclass subclass) {
		ShowSubclassPage showSubclassPage = addSubclassPage.showParameter().addNewSubclass(subclass);
		Assert.assertTrue(showSubclassPage.findPresentSubclass(subclass));
		showSubclassPage.deleteSubclass(subclass);
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
