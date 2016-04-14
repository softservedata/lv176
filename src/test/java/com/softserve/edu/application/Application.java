package com.softserve.edu.application;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import com.softserve.edu.rs.pages.LoginPage;

public class Application {
	ApplicationSources applicationSources;
	WebDriver webDriver;

	public Application(ApplicationSources applicationSources) {
		this.applicationSources = applicationSources;
	}

	private void initBrowser() {
		if (webDriver == null) {
			webDriver = new FirefoxDriver(new ProfilesIni().getProfile("default"));
			webDriver.manage().timeouts().implicitlyWait(applicationSources.getImplicitTimeOut(), TimeUnit.SECONDS);
		}
	}

	public LoginPage load() {
		initBrowser();
		webDriver.get(applicationSources.getLoginUrl());
		return new LoginPage(webDriver);
	}

	public LoginPage login() {
		if (webDriver == null) {
			return load();
		}
		webDriver.get(applicationSources.getLoginUrl());
		return new LoginPage(webDriver);
	}

	public LoginPage logout() {
		if (webDriver == null) {
			return load();
		}
		webDriver.get(applicationSources.getLogoutUrl());
		return new LoginPage(webDriver);
	}

	public void quit() {
		if (webDriver != null) {
			webDriver.quit();
		}
	}
}
