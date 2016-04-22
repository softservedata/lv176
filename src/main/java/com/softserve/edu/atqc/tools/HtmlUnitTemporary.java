package com.softserve.edu.atqc.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

final class HtmlUnitTemporary extends ABrowser {
	private static final String HTMLUNIT_TEMPORARY = "HtmlUnit temporary profile";

	private HtmlUnitTemporary(WebDriver driver, String browserName) {
		super(driver, browserName);
	}

	static HtmlUnitTemporary get() {
		WebDriver driver = new HtmlUnitDriver(true);
        ((HtmlUnitDriver) driver).setJavascriptEnabled(true);
		return new HtmlUnitTemporary(driver, HTMLUNIT_TEMPORARY);
	}

}
