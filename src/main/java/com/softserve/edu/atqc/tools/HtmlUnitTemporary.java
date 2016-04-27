package com.softserve.edu.atqc.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.softserve.edu.atqc.data.ApplicationSources;

final class HtmlUnitTemporary extends ABrowser {
	
	public static class HtmlUnitTemporaryFactory implements IBrowserFactory {
		public ABrowser getInstance(ApplicationSources applicationSources) {
			if ((applicationSources != null)
					&& (applicationSources.getBrowserName() != null)
					&& (!applicationSources.getBrowserName().isEmpty())) {
				return HtmlUnitTemporary.get(applicationSources.getBrowserName());
			}
			return HtmlUnitTemporary.get();
		}

		public String getInstanceName() {
			return HtmlUnitTemporary.HTMLUNIT_TEMPORARY;
		}
	}

	private static final String HTMLUNIT_TEMPORARY = "HtmlUnit temporary profile";

	private HtmlUnitTemporary(WebDriver driver, String browserName) {
		super(driver, browserName);
	}

	static HtmlUnitTemporary get() {
		return get(HTMLUNIT_TEMPORARY);
	}
	
	static HtmlUnitTemporary get(String browserName) {
		WebDriver driver = new HtmlUnitDriver(true);
        ((HtmlUnitDriver) driver).setJavascriptEnabled(true);
		return new HtmlUnitTemporary(driver, browserName);
	}

}
