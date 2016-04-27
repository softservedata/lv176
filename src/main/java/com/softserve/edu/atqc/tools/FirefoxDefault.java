package com.softserve.edu.atqc.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import com.softserve.edu.atqc.data.ApplicationSources;

final class FirefoxDefault extends ABrowser {

	public static class FirefoxDefaultFactory implements IBrowserFactory {
		public ABrowser getInstance(ApplicationSources applicationSources) {
			String browserName = ((applicationSources != null)
					&& (applicationSources.getBrowserName() != null)
					&& (!applicationSources.getBrowserName().isEmpty()))
				? applicationSources.getBrowserName() : FIREFOX_DEFAULT;
			if ((applicationSources != null)
					&& (applicationSources.getDefaulProfile() != null)
					&& (!applicationSources.getDefaulProfile().isEmpty())) {
				return FirefoxDefault.get(applicationSources.getDefaulProfile(), browserName);
			}
			return FirefoxDefault.get(browserName);
		}

		public String getInstanceName() {
			return FirefoxDefault.FIREFOX_DEFAULT;
		}
	}

	private static final String FIREFOX_DEFAULT = "Firefox default profile";
	private static final String PROFILE_DEFAULT = "default";

	private FirefoxDefault() {
		super(new FirefoxDriver(), FIREFOX_DEFAULT);
	}

	FirefoxDefault(WebDriver driver, String browserName) {
		super(driver, browserName);
	}

	static FirefoxDefault get() {
		return get(PROFILE_DEFAULT, FIREFOX_DEFAULT);
	}

	static FirefoxDefault get(String browserName) {
		return get(PROFILE_DEFAULT, browserName);
	}

	static FirefoxDefault get(String defaultProfileName, String browserName) {
		ProfilesIni profileIni = new ProfilesIni();
		FirefoxProfile profile = profileIni.getProfile(defaultProfileName);
		profile.setAcceptUntrustedCertificates(true);
		return new FirefoxDefault(new FirefoxDriver(profile), browserName);
	}

}
