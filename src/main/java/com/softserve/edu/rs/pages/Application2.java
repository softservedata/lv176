package com.softserve.edu.rs.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.softserve.edu.rs.data.apps.ApplicationSources;

public class Application2 {
    //private final String START_PAGE_UNDEFINED = "ApplicationSources Undefined.";
    //
    ApplicationSources applicationSources;
    WebDriver driver;
    
    public Application2(ApplicationSources applicationSources) {
    	this.applicationSources= applicationSources;
    	System.out.println("\t*** Application Sources");
    	System.out.println("\t" + applicationSources.getLoginUrl());
    	System.out.println("\t" + applicationSources.getLogoutUrl());
    	System.out.println("\t" + applicationSources.getBrowserName());
    }

    private void initBrowser() {
    	// TODO Read applicationSources.getBrowserName()
    	if (driver == null){
	    	driver = new FirefoxDriver();
	    	driver.manage().timeouts()
	    		.implicitlyWait(applicationSources.getImplicitTimeOut(), TimeUnit.SECONDS);
    	}
    }
    
    public LoginPage2 load() {
    	initBrowser();
    	driver.get(applicationSources.getLoginUrl());
        return new LoginPage2(driver);
    }

    public LoginPage2 login() {
    	if (driver == null){
    		return load();
    	}
    	driver.get(applicationSources.getLogoutUrl());
        driver.get(applicationSources.getLoginUrl());
        return new LoginPage2(driver);
    }

    public LoginPage2 logout() {
    	if (driver == null){
    		return load();
    	}
    	driver.get(applicationSources.getLogoutUrl());
        return new LoginPage2(driver);
    }
    
    public void quit() {
    	if (driver != null){
    		driver.quit();
    	}
    }
    
    public void quitAll() {
    	if (driver != null){
    		driver.quit();
    	}
    }
    
    public void reload() {
    	if (driver != null){
    		driver.navigate().refresh();
    	}
    }

}
