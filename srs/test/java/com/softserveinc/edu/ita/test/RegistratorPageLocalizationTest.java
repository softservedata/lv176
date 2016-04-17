package com.softserveinc.edu.ita.test;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.WebDriverRunner.*;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.codeborne.selenide.Selenide;
import com.softserveinc.edu.ita.LoginPage;
import com.softserveinc.edu.ita.ProcurationsTable;
import com.softserveinc.edu.ita.utils.Constants;
import com.softserveinc.edu.ita.utils.LocalizationCheck;
import com.softserveinc.edu.ita.utils.TableUtils;

public class RegistratorPageLocalizationTest {

	@BeforeMethod
	public void setUp() throws Exception {
		TableUtils.setUsersTableFile();
		LoginPage loginPage = Selenide.open(Constants.URL, LoginPage.class);
		loginPage.enterUsername(TableUtils.getCellData(2, 1));
		loginPage.enterUserPassw(TableUtils.getCellData(2, 2));
		loginPage.clickEnter();
	}

	@AfterMethod
	public void logOut() {
		closeWebDriver();
	}

	@Test(priority = 0)
	public void registarUserSignInSmokeTest() throws Exception {

		ProcurationsTable procurationsTable = page(ProcurationsTable.class);
		procurationsTable.getRegistratorHomeLnk().shouldBe(Condition.visible);
		procurationsTable.userSignOut();
		LoginPage loginPage = page(LoginPage.class);
		loginPage.getSignInButton().shouldBe(Condition.visible);
	}

	@Test(priority = 2)
	public void registarUserFunctioonalSmokeTest() throws Exception {

		ProcurationsTable procurationsTable = page(ProcurationsTable.class);
		procurationsTable.getRegistratorHomeLnk().shouldBe(Condition.visible);
		procurationsTable.getSubclassesOfResourcesLnk().should(Condition.visible);
		procurationsTable.getProcurationsLnk().should(Condition.visible);
		procurationsTable.getAddNewResourceLnk().should(Condition.visible);
	}
	
	@Test(priority = 2)
	public void registarEnteringDataTableTest() throws Exception {

		ProcurationsTable procurationsTable = page(ProcurationsTable.class);
		procurationsTable.showEnteringData();
		procurationsTable.dataSortButtonGetText().shouldBe(Condition.exist);

	}
	
	@Test(priority = 2)
	public void registarUserExstractTableTest() throws Exception {

		ProcurationsTable procurationsTable = page(ProcurationsTable.class);
		procurationsTable.extractFromRegister();
		procurationsTable.dataSortButtonGetText().shouldBe(Condition.exist);

	}

	@Test(priority = 3)
	public void registarPageUALocalizationTest() throws Exception {
		LocalizationCheck.registratorPageLocalizationTest(2, "ua");
	}

	@Test(priority = 3)
	public void registarPageRULocalizationTest() throws Exception {

		LocalizationCheck.registratorPageLocalizationTest(3, "ru");
	}

	@Test(priority = 3)
	public void registarPageENLocalizationTest() throws Exception {
		LocalizationCheck.registratorPageLocalizationTest(4, "en");
	}

}
