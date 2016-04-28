package com.softserve.edu.atqc.tools;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.data.ApplicationSources;
import com.softserve.edu.atqc.data.ApplicationSourcesRepository;

public class SmokeTest {

    @AfterClass
    public void oneTimeTearDown() throws InterruptedException {
    	System.out.println("@AfterClass STATR");
    	Thread.sleep(1000);
    	BrowserUtils.quitAll();
    }

    @DataProvider//(parallel = true)
    public Object[][] getApplicationSources() {
        return new Object[][] {
                //{ ApplicationSourcesRepository.get().getLocalHostByDefaultBrowser() },
                //{ ApplicationSourcesRepository.get().getLocalHostByIETemporary() },
                { ApplicationSourcesRepository.get().getLocalHostByChromeTemporary() },
                };
    }

	@Test(dataProvider = "getApplicationSources")
	public void adminLogin(ApplicationSources applicationSources) throws Exception {
		BrowserUtils.get(applicationSources).getBrowser().getWebDriver()
			.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		BrowserUtils.get().getBrowser().getWebDriver()
			.get(applicationSources.getLoginUrl());
		Thread.sleep(2000);
		//driver.get("http://java.training.local:8080/registrator/login");
		//driver.get("http://registrator.herokuapp.com/login");
		//
		BrowserUtils.get().getBrowser().getWebDriver()
			.findElement(By.id("login")).sendKeys("+++admin+++");
		BrowserUtils.get().getBrowser().getWebDriver()
			.findElement(By.id("password")).sendKeys("+++admin+++");
		Thread.sleep(2000);
		//
		BrowserUtils.get(ApplicationSourcesRepository.get().getLocalHostByFirefoxTemporary())
			.getBrowser().getWebDriver()
			.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		BrowserUtils.get().getBrowser().getWebDriver()
			.get(applicationSources.getLoginUrl());
		//
		BrowserUtils.get().getBrowser().getWebDriver()
				.findElement(By.id("login")).clear();
		BrowserUtils.get().getBrowser().getWebDriver()
			.findElement(By.id("login")).sendKeys("admin");
		//
		BrowserUtils.get().getBrowser().getWebDriver()
			.findElement(By.id("password")).clear();
		BrowserUtils.get().getBrowser().getWebDriver()
			.findElement(By.id("password")).sendKeys("admin");
		Thread.sleep(2000);
		//
		BrowserUtils.get().getBrowser().getWebDriver()
			.findElement(By.cssSelector("button.btn.btn-primary")).click();
		// driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		//
		// WebElement userLogin = driver.findElement(By.cssSelector("label"));
		WebElement userLogin = BrowserUtils.get().getBrowser().getWebDriver()
				.findElement(By.cssSelector(".col-md-7 label"));
		Assert.assertEquals(userLogin.getText(), "admin");
		Thread.sleep(2000);
		// Assert.assertEquals(driver.findElement(By.cssSelector("label")).getText(),"admin");
		//
		// driver.findElement(By.linkText("Вихід")).click();
		// driver.findElement(By.linkText("Sign out")).click();
		BrowserUtils.get().getBrowser().getWebDriver()
			.findElement(By.cssSelector("a.btn.btn-primary.btn-sm")).click();
		//
		WebElement startLogo = BrowserUtils.get().getBrowser().getWebDriver()
				.findElement(By.xpath("//div[@id='body']/div/img"));
		String nameLogoPath = startLogo.getAttribute("src");
		String nameLogo = nameLogoPath.substring(nameLogoPath.lastIndexOf('/') + 1);
		System.out.println("\t+++ nameLogo = " + nameLogo);
		// Assert.assertEquals(driver.findElement(By.cssSelector("button.btn.btn-primary")).getText(),"Увійти");
		Assert.assertEquals(nameLogo, "ukraine_logo.gif");
		Thread.sleep(1000);
		BrowserUtils.get().quitBrowser();
		System.out.println("Test DONE");
	}

}
