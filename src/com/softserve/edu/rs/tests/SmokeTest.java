package com.softserve.edu.rs.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.rs.pages.AdminHomePage;
import com.softserve.edu.rs.pages.LoginPage;


public class SmokeTest {
	//private WebDriver driver;
	
	//@Test
	public void adminLogin0() throws Exception {
		// Preconditions.
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/resources/login");
		// Test Steps.
		LoginPage loginPage = new LoginPage(driver);
		AdminHomePage adminHomePage = loginPage
				.successAdminLogin(UserRepository.get().getAdmin()); 
		// Checking.
		Thread.sleep(2000);
		Assert.assertEquals(UserRepository.get().getAdmin().getAccount().getLogin(),
				adminHomePage.getLoginAccountText());
		// Return to previous state.
		adminHomePage.logout();
		//
		Thread.sleep(2000);
		driver.quit();
	}

    @DataProvider//(parallel = true)
    public Object[][] adminUsers() {
        return new Object[][] {
                { UserRepository.get().getAdmin() },
                //{ UserRepository.get().getCommissioner() },
                //{ UserRepository.get().getAdmin() },
                };
    }
 
	@Test(dataProvider = "adminUsers")
	public void adminLogin1(IUser admin) throws Exception {
		// Preconditions.
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/resources/login");
		// Test Steps.
		AdminHomePage adminHomePage = new LoginPage(driver)
				.successAdminLogin(admin); 
		// Checking.
		Thread.sleep(2000);
		Assert.assertEquals(admin.getAccount().getLogin(),
				adminHomePage.getLoginAccountText());
		// Return to previous state.
		adminHomePage.logout();
		//
		Thread.sleep(2000);
		driver.quit();
	}

}
