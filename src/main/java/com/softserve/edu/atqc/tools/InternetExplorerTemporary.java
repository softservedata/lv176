package com.softserve.edu.atqc.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.softserve.edu.atqc.data.ApplicationSources;

public class InternetExplorerTemporary extends ABrowser {

	public static class InternetExplorerFactory implements IBrowserFactory {
		public ABrowser getInstance(ApplicationSources applicationSources) {
			String browserName = ((applicationSources != null) && (applicationSources.getBrowserName() != null)
					&& (!applicationSources.getBrowserName().isEmpty())) ? applicationSources.getBrowserName()
							: IE_TEMPORARY;
			if ((applicationSources != null) && (applicationSources.getDriverPath() != null)
					&& (!applicationSources.getDriverPath().isEmpty())) {
				return InternetExplorerTemporary.get(applicationSources.getDriverPath(), browserName);
			}
			return InternetExplorerTemporary.get(browserName);
		}

		public String getInstanceName() {
			return InternetExplorerTemporary.IE_TEMPORARY;
		}
	}

	private static final String IE_TEMPORARY = "Internet Explorer temporary profile by ignoring security domains";
	private static final String IE_PROPERTY = "webdriver.ie.driver";
	private static final String IE_DRIVER = "C:\\Program Files\\Internet Explorer\\IEDriverServer.exe";

	private InternetExplorerTemporary(WebDriver driver, String browserName) {
		super(driver, browserName);
	}

	static InternetExplorerTemporary get() {
		return get(IE_DRIVER, IE_TEMPORARY);
	}

	static InternetExplorerTemporary get(String browserName) {
		return get(IE_DRIVER, browserName);
	}

	static InternetExplorerTemporary get(String ieDriverPath, String browserName) {
		System.setProperty(IE_PROPERTY, ieDriverPath);
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		return new InternetExplorerTemporary(new InternetExplorerDriver(capabilities), browserName);
	}

}
