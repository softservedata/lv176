package com.softserve.edu.atqc.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

final class FirefoxDefault extends ABrowser {
	private static final String FIREFOX_DEFAULT = "Firefox default profile";
	private static final String PROFILE_DEFAULT = "default";

	private FirefoxDefault() {
		super(new FirefoxDriver(), FIREFOX_DEFAULT);
	}

	FirefoxDefault(WebDriver driver, String browserName) {
		super(driver, browserName);
	}

	static FirefoxDefault get() {
		return get(PROFILE_DEFAULT);
	}

	static FirefoxDefault get(String defaultProfileName) {
		ProfilesIni profileIni = new ProfilesIni();
		FirefoxProfile profile = profileIni.getProfile(defaultProfileName);
		profile.setAcceptUntrustedCertificates(true);
		return new FirefoxDefault(new FirefoxDriver(profile), FIREFOX_DEFAULT);
	}

}
