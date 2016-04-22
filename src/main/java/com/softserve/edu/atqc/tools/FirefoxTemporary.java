package com.softserve.edu.atqc.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

final class FirefoxTemporary extends ABrowser {
	private static final String FIREFOX_TEMPORARY = "Firefox temporary profile";

	private FirefoxTemporary(WebDriver driver, String browserName) {
		super(driver, browserName);
	}

	static FirefoxTemporary get() {
		return new FirefoxTemporary(new FirefoxDriver(), FIREFOX_TEMPORARY);
	}

}
