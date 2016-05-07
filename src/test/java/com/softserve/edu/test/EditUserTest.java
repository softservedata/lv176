package com.softserve.edu.test;

import java.util.HashMap;
import java.util.Map.Entry;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.CsvReaderData;
import com.softserve.edu.application.Application;
import com.softserve.edu.application.ApplicationSourcesRepository;
import com.softserve.edu.entity.IUser;
import com.softserve.edu.entity.UserRepository;
import com.softserve.edu.rs.pages.EditProfilUserPage;

public class EditUserTest {
	private Application application;
	private EditProfilUserPage editProfilUserPage;
	private IUser newUser = UserRepository.getInstance().getUser();

	@BeforeClass
	public void beforeClass() {
		application = new Application(ApplicationSourcesRepository.get().getLocalHostByFirefox());
		//IUser newUser = UserRepository.getInstance().getUser();

		// create new user
		application.load()
				.successAdminCommissionerLogin(UserRepository.getInstance().getAdmin()).gotoCreateNewUserPage()
				.successCreateUser(newUser);//.logout();
	}

	@AfterClass
	public void afterClass() {
		application.quit();
	}
	
	@BeforeMethod
	public void beforeMethod(){
		editProfilUserPage = application.gotoEditPage(newUser.getAccount().getLogin()).clickButtonEdit();
//				successAdminCommissionerLogin(UserRepository.getInstance().getAdmin())
//				.gotoNonConfirmedUsersPage().gotoProfilUser(newUser).clickButtonEdit();
	}
	
	@AfterMethod
	public void afterMethod() {
		//application.logout();
	}

	@DataProvider(name = "Data for last and first name")
	public Object[][] dataForFirstNameField() {
		
		
		return CsvReaderData.convertHashMapToObjectArray(CsvReaderData.read());
//			{ "", EditProfilUserPage.EMPTY_FIELD_WARNING },
//			{ "123", EditProfilUserPage.INCORRECT_FIELD_WARNING },
//			{ "!sf", EditProfilUserPage.INCORRECT_FIELD_WARNING },
//			{ "@", EditProfilUserPage.INCORRECT_FIELD_WARNING },
//			{ "#", EditProfilUserPage.INCORRECT_FIELD_WARNING },
//			{ "%", EditProfilUserPage.INCORRECT_FIELD_WARNING },
//			{ "(", EditProfilUserPage.INCORRECT_FIELD_WARNING },
//			{ ")", EditProfilUserPage.INCORRECT_FIELD_WARNING },
//			{ "{", EditProfilUserPage.INCORRECT_FIELD_WARNING },
//			{ "}", EditProfilUserPage.INCORRECT_FIELD_WARNING },
//			{ "sdf3", EditProfilUserPage.INCORRECT_FIELD_WARNING },
//			{ "s!f", EditProfilUserPage.INCORRECT_FIELD_WARNING },
//			{ "^", EditProfilUserPage.INCORRECT_FIELD_WARNING },
//			{ "?", EditProfilUserPage.INCORRECT_FIELD_WARNING },
//			{ "/", EditProfilUserPage.INCORRECT_FIELD_WARNING },
//			{ "[", EditProfilUserPage.INCORRECT_FIELD_WARNING },
//			{ "]", EditProfilUserPage.INCORRECT_FIELD_WARNING },
//			{ "aaaaabbbbbcccccdddddeeeeefffffg", EditProfilUserPage.NO_ALLOWED_SIZE_FOR_FIRST_NAME }
			//};
	}
	
	@DataProvider(name = "Data for last and last name")
	public Object[][] dataForLastNameField() {
		return new Object[][] { 
			{ "", EditProfilUserPage.EMPTY_FIELD_WARNING },
			{ "123", EditProfilUserPage.INCORRECT_FIELD_WARNING },
			{ "!sf", EditProfilUserPage.INCORRECT_FIELD_WARNING },
			{ "@", EditProfilUserPage.INCORRECT_FIELD_WARNING },
			{ "#", EditProfilUserPage.INCORRECT_FIELD_WARNING },
			{ "%", EditProfilUserPage.INCORRECT_FIELD_WARNING },
			{ "(", EditProfilUserPage.INCORRECT_FIELD_WARNING },
			{ ")", EditProfilUserPage.INCORRECT_FIELD_WARNING },
			{ "{", EditProfilUserPage.INCORRECT_FIELD_WARNING },
			{ "}", EditProfilUserPage.INCORRECT_FIELD_WARNING },
			{ "sdf3", EditProfilUserPage.INCORRECT_FIELD_WARNING },
			{ "s!f", EditProfilUserPage.INCORRECT_FIELD_WARNING },
			{ "^", EditProfilUserPage.INCORRECT_FIELD_WARNING },
			{ "?", EditProfilUserPage.INCORRECT_FIELD_WARNING },
			{ "/", EditProfilUserPage.INCORRECT_FIELD_WARNING },
			{ "[", EditProfilUserPage.INCORRECT_FIELD_WARNING },
			{ "]", EditProfilUserPage.INCORRECT_FIELD_WARNING },
			{ "aaaaabbbbbcccccdddddeeeeefffffg", EditProfilUserPage.NO_ALLOWED_SIZE_FOR_LAST_NAME }
			};
	}
	
	@DataProvider(name = "Data for email")
	public Object[][] dataForEmailField() {
		return new Object[][] { 
			{ "", EditProfilUserPage.EMPTY_FIELD_WARNING },
			{ "@gmail.com", EditProfilUserPage.INCORRECT_WARNING_FOR_EMAIL },
			{ "test@@gmail.com", EditProfilUserPage.INCORRECT_WARNING_FOR_EMAIL },	
			};
	}
	
	@DataProvider(name = "Data for passport seria")
	public Object[][] dataForPassportSeria() {
		return new Object[][] { 
			{ "123", EditProfilUserPage.INCORRECT_WARNING_FOR_PASSPORT_SERIA },
			{ "a", EditProfilUserPage.INCORRECT_WARNING_FOR_PASSPORT_SERIA },
			{ "sd", EditProfilUserPage.INCORRECT_WARNING_FOR_PASSPORT_SERIA },
			{ "DF", EditProfilUserPage.INCORRECT_WARNING_FOR_PASSPORT_SERIA },
			{ "DFG", EditProfilUserPage.INCORRECT_WARNING_FOR_PASSPORT_SERIA },
			{ "@", EditProfilUserPage.INCORRECT_WARNING_FOR_PASSPORT_SERIA },
			{ "#", EditProfilUserPage.INCORRECT_WARNING_FOR_PASSPORT_SERIA },
			{ "№", EditProfilUserPage.INCORRECT_WARNING_FOR_PASSPORT_SERIA },
			};
	}
	
	@DataProvider(name = "Data for passport number")
	public Object[][] dataForPassportNumber() {
		return new Object[][] { 
			{ "0", EditProfilUserPage.INCORRECT_WARNING_FOR_PASSPORT_SERIA },
			{ "1", EditProfilUserPage.INCORRECT_WARNING_FOR_PASSPORT_SERIA },
			{ "12345", EditProfilUserPage.INCORRECT_WARNING_FOR_PASSPORT_SERIA },
			{ "1234567", EditProfilUserPage.INCORRECT_WARNING_FOR_PASSPORT_SERIA },
			};
	}

	@Test(dataProvider = "Data for last and first name")
	public void testUnsuccessfulEditFirstName(String forType, String warning) throws InterruptedException {
//		HashMap<String, String> testData = CsvReaderData.read();		
//		for (Entry<String, String> entry : testData.entrySet()) {
			//Thread.sleep(1000);
			editProfilUserPage.clearInputForFirstName().typeInputForFirstName(forType);
			//System.out.println("=> " + forType);
			Thread.sleep(3000);
			editProfilUserPage.clickButtonOk();
			//Thread.sleep(3000);
			Assert.assertEquals(editProfilUserPage.getWarningText(warning), warning);
//			
//		}
	}
	
	@Test(dataProvider = "Data for last and last name")
	public void testUnsuccessfulEditLasttName(String forType, String warning) {
		editProfilUserPage.clearInputForLastName().typeInputForLastName(forType);
		editProfilUserPage.clickButtonOk();
		Assert.assertEquals(editProfilUserPage.getWarningText(warning), warning, "Not found warning " + warning);
	}
	
	@Test(dataProvider = "Data for email")
	public void testUnsuccessfulEditEmail(String forType, String warning) {
		editProfilUserPage.clearInputForEmail().typeInputForEmail(forType);
		editProfilUserPage.clickButtonOk();
		Assert.assertEquals(editProfilUserPage.getWarningText(warning), warning, "Not found warning " + warning);
	}
	
	@Test(dataProvider = "Data for passport seria")
	public void testUnsuccessfulEditPassportSeria(String forType, String warning) {
		editProfilUserPage.clearInputForPassportSeria().typeInputForPassportSeria(forType);
		editProfilUserPage.clickButtonOk();
		Assert.assertEquals(editProfilUserPage.getWarningText(warning), warning, "Not found warning " + warning);
	}
	
	@Test(dataProvider = "Data for passport number")
	public void testUnsuccessfulEditPassportNumber(String forType, String warning) {
		editProfilUserPage.clearInputForPassportNumber().typeInputForPassportNumber(forType);
		editProfilUserPage.clickButtonOk();
		Assert.assertEquals(editProfilUserPage.getWarningText(warning), warning, "Not found warning " + warning);
	}
}
