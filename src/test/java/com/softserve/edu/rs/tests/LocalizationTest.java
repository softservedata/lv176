package com.softserve.edu.rs.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.data.apps.ReadDataFromFile;
import com.softserve.edu.rs.data.apps.Application;
import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.EnteringData;
import com.softserve.edu.rs.pages.ProcurationPage;
import com.softserve.edu.rs.pages.RegistratorHomePage;
import com.softserve.edu.rs.pages.TopPage.ChangeLanguageFields;

public class LocalizationTest {

	Application application;
	RegistratorHomePage registratorHomePage;

	@BeforeClass
	public void setUpApp() {
		application = Application.get(ApplicationSourcesRepository.get().getJavaTrainingLocalByFirefoxTemporary());
	}

	@AfterClass
	public void shutDown() {
		application.quitAll();
	}

	@BeforeMethod
	public void logInAsRegistar() {
		registratorHomePage = application.load().successRegistratorLogin(UserRepository.get().getRegistrator());
	}

	@AfterMethod
	public void closeAll() {
		application.logout();
	}

	@DataProvider
	public Object[][] columnInFiles() {
		return new Object[][] { { ChangeLanguageFields.ENGLISH, 4 }, { ChangeLanguageFields.RUSSIAN, 3 },
				{ ChangeLanguageFields.UKRAINIAN, 2 }, };
	}

	@Test(priority = 10)
	public void registarFunctioonalSmokeTest() {

		EnteringData enteringData = registratorHomePage.enteringDataClick();
		registratorHomePage = enteringData.registratorGoHomeClick();
	}

	@Test(priority = 31)
	public void procurationExtracting() {

		EnteringData enteringData = registratorHomePage.enteringDataClick();
		ProcurationPage procuration = enteringData.getProcurations();
		Assert.assertTrue(procuration.getpdfViewer());

	}

	@Test(priority = 10)
	public void registarEnterindDataFunctioonalSmokeTest() {

		RegistratorHomePage extractFromRegister = registratorHomePage.extractFromRegisterClick();
		registratorHomePage = extractFromRegister.registratorGoHomeClick();
	}

	@Test(dataProvider = "columnInFiles", priority = 20)
	public void changecolumnInFile(ChangeLanguageFields lang, Integer columnInFile) throws Exception {
		registratorHomePage = registratorHomePage.changeLanguage(lang);
		EnteringData enteringData = registratorHomePage.enteringDataClick();
		ReadDataFromFile.setLocalizationDataTableFile();

		Assert.assertEquals(enteringData.getChangeLanguageSelectedText(),
				ReadDataFromFile.getCellData(4, columnInFile));
		Assert.assertEquals(enteringData.getChangePasswordText(), ReadDataFromFile.getCellData(2, columnInFile));
		Assert.assertEquals(enteringData.getResetPasswordText(), ReadDataFromFile.getCellData(3, columnInFile));
		Assert.assertEquals(enteringData.getLogoutText(), ReadDataFromFile.getCellData(5, columnInFile));
		Assert.assertEquals(enteringData.resourceSearchGetTExt(), ReadDataFromFile.getCellData(6, columnInFile));
		Assert.assertEquals(enteringData.subclassesObjectsGetText(), ReadDataFromFile.getCellData(7, columnInFile));
		Assert.assertEquals(enteringData.ProcurationsMenuGetTExt(), ReadDataFromFile.getCellData(8, columnInFile));
		Assert.assertEquals(enteringData.enteringDataGetText(), ReadDataFromFile.getCellData(9, columnInFile));
		Assert.assertEquals(enteringData.extractFromRgisterGetText(), ReadDataFromFile.getCellData(10, columnInFile));
		Assert.assertEquals(enteringData.addNewResourceGetText(), ReadDataFromFile.getCellData(11, columnInFile));
		Assert.assertEquals(enteringData.localPageNameGetTExt(), ReadDataFromFile.getCellData(12, columnInFile));
		Assert.assertEquals(enteringData.procurationDateGetTExt(), ReadDataFromFile.getCellData(13, columnInFile));
		Assert.assertEquals(enteringData.partOwnerGetTExt(), ReadDataFromFile.getCellData(14, columnInFile));
		Assert.assertEquals(enteringData.registarGetText(), ReadDataFromFile.getCellData(15, columnInFile));
		Assert.assertEquals(enteringData.objectRegNumbGetText(), ReadDataFromFile.getCellData(16, columnInFile));
		Assert.assertEquals(enteringData.resourcesStatusGetTExt(), ReadDataFromFile.getCellData(17, columnInFile));
		Assert.assertEquals(enteringData.actionsGetTExt(), ReadDataFromFile.getCellData(18, columnInFile));
	}

}
