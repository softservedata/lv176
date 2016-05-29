package com.softserve.edu.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.softserve.edu.apps.Application;
import com.softserve.edu.apps.ApplicationSourcesRepository;
import com.softserve.edu.atqc.data.CSVUtils;
import com.softserve.edu.atqc.data.ListUtils;
import com.softserve.edu.atqc.specs.FlexAssert;
import com.softserve.edu.db.OperationWithDB;
import com.softserve.edu.listener.TestListener;
import com.softserve.edu.rs.pages.EditProfilUserPage;
import com.softserve.edu.users.UserRepository;
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
	public void beforeMethod() {
		editProfilUserPage = application.gotoEditPage(UserRepository.getInstance().getUser().getAccount().getLogin()).clickButtonEdit();
	}

	@AfterClass
	public void afterClass() {
		OperationWithDB.deleteNonConfirmedUser(UserRepository.getInstance().getUser());
		application.quit();
	}
	
	@DataProvider(name = "DataForFirstName")
	public Object[][] dataForFirstNameField() {
		return ListUtils.get().toMultiArrayNumber(new CSVUtils().readDataForFirstName());
	}
	
	@DataProvider(name = "DataForLastName")
	public Object[][] dataForLastNameField() {
		return ListUtils.get().toMultiArrayNumber(new CSVUtils().readDataForLastName());
	}
	
	@DataProvider(name = "DataForEmail")
	public Object[][] dataForEmailField() {
		return ListUtils.get().toMultiArrayNumber(new CSVUtils().readDataForEmail());
	}
	
	@Test(dataProvider = "DataForFirstName")
	public void testUnsuccessfulEditFirstName(String forType, String warning) {
		editProfilUserPage.typeInputForFirstName(forType);
		checkWarningAppears(warning);
	}
	
	@Test(dataProvider = "DataForLastName")
	public void testUnsuccessfulEditLasttName(String forType, String warning) {
		editProfilUserPage.typeInputForLastName(forType);
		checkWarningAppears(warning);
	}
	
	@Test(dataProvider = "DataForEmail")
	public void testUnsuccessfulEditEmail(String forType, String warning) {
		editProfilUserPage.typeInputForEmail(forType);
		checkWarningAppears(warning);
	}
	
	public void checkWarningAppears(String warning) {
		editProfilUserPage.clickButtonOk();
		FlexAssert.get().forElement(editProfilUserPage.getWarningText(warning)).valueMatch(warning);
		FlexAssert.get().check();
	}
}
