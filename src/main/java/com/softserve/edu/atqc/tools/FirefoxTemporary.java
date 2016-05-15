package com.softserve.edu.atqc.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.softserve.edu.atqc.data.apps.ApplicationSources;

final class FirefoxTemporary extends ABrowser {

	public static class FirefoxTemporaryFactory implements IBrowserFactory {
		public ABrowser getInstance(ApplicationSources applicationSources) {
			if ((applicationSources != null)
					&& (applicationSources.getBrowserName() != null)
					&& (!applicationSources.getBrowserName().isEmpty())) {
				return FirefoxTemporary.get(applicationSources.getBrowserName());
			}
			return FirefoxTemporary.get();
		}

		public String getInstanceName() {
			return FirefoxTemporary.FIREFOX_TEMPORARY;
		}
	}

	private static final String FIREFOX_TEMPORARY = "Firefox temporary profile";

	private FirefoxTemporary(WebDriver driver, String browserName) {
		super(driver, browserName);
	}

	static FirefoxTemporary get() {
		return get(FIREFOX_TEMPORARY);
		//return new FirefoxTemporary(new FirefoxDriver(), FIREFOX_TEMPORARY);
	}

	static FirefoxTemporary get(String browserName) {
		return new FirefoxTemporary(new FirefoxDriver(), browserName);
	}

}
