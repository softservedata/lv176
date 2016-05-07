package com.softserve.edu.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.softserve.edu.application.Application;
import com.softserve.edu.application.ApplicationSourcesRepository;
import com.softserve.edu.atqc.tools.CsvReaderData;
import com.softserve.edu.db.OperationWithDB;
import com.softserve.edu.entity.UserRepository;
import com.softserve.edu.listener.TestListener;
import com.softserve.edu.rs.pages.EditProfilUserPage;
@Listeners(TestListener.class)

public class EditUserTest {
	private Application application;
	private EditProfilUserPage editProfilUserPage;

	@BeforeClass
	public void beforeClass() {
		application = Application.get(ApplicationSourcesRepository.get().getLocalHostByFirefoxTemporary());

		// create new user
		application.load()
				.successAdminCommissionerLogin(UserRepository.getInstance().getAdmin()).gotoCreateNewUserPage()
				.successCreateUser(UserRepository.getInstance().getUser());
	}
	
	@BeforeMethod
	public void beforeMethod(){
		editProfilUserPage = application.gotoEditPage(UserRepository.getInstance().getUser().getAccount().getLogin()).clickButtonEdit();
	}

	@AfterClass
	public void afterClass() {
		OperationWithDB.deleteNonConfirmedUser(UserRepository.getInstance().getUser());
		application.quit();
	}
	
	@DataProvider(name = "DataForFirstName")
	public Object[][] dataForFirstNameField() {
		return CsvReaderData.readDataForFirstName();
	}
	
	@DataProvider(name = "DataForLastName")
	public Object[][] dataForLastNameField() {
		return CsvReaderData.readDataForLastName();
	}
	
	@DataProvider(name = "DataForEmail")
	public Object[][] dataForEmailField() {
		return CsvReaderData.readDataForEmail();
	}

	@Test(dataProvider = "DataForFirstName")
	public void testUnsuccessfulEditFirstName(String forType, String warning) {
		editProfilUserPage.typeInputForFirstName(forType);
		editProfilUserPage.clickButtonOk();
		Assert.assertEquals(editProfilUserPage.getWarningText(warning), warning);
	}
	
	@Test(dataProvider = "DataForLastName")
	public void testUnsuccessfulEditLasttName(String forType, String warning) {
		editProfilUserPage.typeInputForLastName(forType);
		editProfilUserPage.clickButtonOk();
		Assert.assertEquals(editProfilUserPage.getWarningText(warning), warning);
	}
	
	@Test(dataProvider = "DataForEmail")
	public void testUnsuccessfulEditEmail(String forType, String warning) {
		editProfilUserPage.typeInputForEmail(forType);
		editProfilUserPage.clickButtonOk();
		Assert.assertEquals(editProfilUserPage.getWarningText(warning), warning);
	}
}
