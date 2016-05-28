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
import com.softserve.edu.rs.data.resources.ISubclass;
import com.softserve.edu.rs.data.resources.SubclassRepository;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.AddSubclassPage;
import com.softserve.edu.rs.pages.SubclassesOfObjectsPage;

public class CreateNewSubclassTest {
	private Application application;
	private AddSubclassPage addSubclassPage;

	@BeforeClass
	public void oneTimeSetUp() {
		application = Application.get(ApplicationSourcesRepository.get().getLocalHostByFirefoxTemporary());
	}

	@BeforeMethod
	public void setUp() {
		addSubclassPage = application.load()
				.successRegistratorLogin(UserRepository.get().getRegistrator())
				.gotoSubclassPage()
				.gotoAddSubclassPage();
	}
	
	@DataProvider (parallel = true)
    public Object[][] SubclassParametr() {
        return new Object[][] {
                { SubclassRepository.get().getOneLetterSubclassName() },
                { SubclassRepository.get().getLettersSubclassName() },
                { SubclassRepository.get().getOneNumberSubclassName() },
                { SubclassRepository.get().getNumbersSubclassName() },
                { SubclassRepository.get().getResCharsSubclass() },
                
                { SubclassRepository.get().getEqualCharsSubclass() },
                { SubclassRepository.get().getSlashCharsSubclass() },
                { SubclassRepository.get().getSeparatorCharsSubclass() },
                { SubclassRepository.get().getBackSlashCharsSubclass() },
                { SubclassRepository.get().getSnowflakeCharsSubclass() },
                { SubclassRepository.get().getLeftEarCharsSubclass() },
                { SubclassRepository.get().getRightEarCharsSubclass() },
                { SubclassRepository.get().getDashCharsSubclass() },
                { SubclassRepository.get().getColonCharsSubclass() },
                { SubclassRepository.get().getSemicolonCharsSubclass() },
                { SubclassRepository.get().getSharpCharsSubclass() },
                { SubclassRepository.get().getPercentCharsSubclass() },
                { SubclassRepository.get().getCircumflexCharsSubclass() },
                { SubclassRepository.get().getQuestionMarkCharsSubclass() },
                { SubclassRepository.get().getLeftBracketCharsSubclass() },
                { SubclassRepository.get().getRightBracketCharsSubclass() },
                
                { SubclassRepository.get().getRandomSubclassNoParams() },
                
                };
    }
	
	@Test(dataProvider = "SubclassParametr")
	public void addNewSubclassTest(ISubclass subclass) {
		SubclassesOfObjectsPage subclassesOfObjectsPage = addSubclassPage.showParameter().addNewSubclass(subclass);
		Assert.assertTrue(subclassesOfObjectsPage.visibleDeleteSubclass(subclass));
		subclassesOfObjectsPage.deleteSubclass(subclass);
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
