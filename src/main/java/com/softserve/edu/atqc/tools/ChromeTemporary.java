package com.softserve.edu.atqc.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.softserve.edu.atqc.data.apps.ApplicationSources;


final class ChromeTemporary extends ABrowser {

	static enum ChromeSettings {
		NO_PROXY_SERVER("--no-proxy-server"),
		IGNORE_CERTIFICATE_ERRORS("--ignore-certificate-errors");
		//
		private String field;

		private ChromeSettings(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}

	public static class ChromeTemporaryFactory implements IBrowserFactory {
		public ABrowser getInstance(ApplicationSources applicationSources) {
			String browserName = ((applicationSources != null)
					&& (applicationSources.getBrowserName() != null)
					&& (!applicationSources.getBrowserName().isEmpty()))
				? applicationSources.getBrowserName() : CHROME_TEMPORARY;
			if ((applicationSources != null)
					&& (applicationSources.getDriverPath() != null)
					&& (!applicationSources.getDriverPath().isEmpty())) {
				return ChromeTemporary.get(applicationSources.getDriverPath(), browserName);
			}
			return ChromeTemporary.get(browserName);
		}

		public String getInstanceName() {
			return ChromeTemporary.CHROME_TEMPORARY;
		}
	}

	private static final String CHROME_TEMPORARY = "Chrome temporary profile";
	private static final String CHROME_PROPERTY = "webdriver.chrome.driver";
	private static final String CHROME_DRIVER = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe";

	private ChromeTemporary(WebDriver driver, String browserName) {
		super(driver, browserName);
	}

	static ChromeTemporary get() {
		return get(CHROME_DRIVER, CHROME_TEMPORARY);
	}

	static ChromeTemporary get(String browserName) {
		return get(CHROME_DRIVER, browserName);
	}

	static ChromeTemporary get(String chromeDriverPath, String browserName) {
		System.setProperty(CHROME_PROPERTY, chromeDriverPath);
		ChromeOptions options = new ChromeOptions();
		for (ChromeSettings chromeSettings : ChromeSettings.values()) {
			options.addArguments(chromeSettings.toString());
		}
		// options.addArguments(ChromeSettings.NO_PROXY_SERVER.toString());
		// options.addArguments(ChromeSettings.IGNORE_CERTIFICATE_ERRORS.toString());
		return new ChromeTemporary(new ChromeDriver(options), browserName);
	}

}
