package com.softserve.edu.atqc.tools;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.softserve.edu.atqc.data.apps.ApplicationSources;

interface IBrowserFactory {
	ABrowser getInstance(ApplicationSources applicationSources);
	String getInstanceName();
}

public abstract class ABrowser {
	private final String BROWSER_CLOSED = "Browser not found.";
	private String browserName; 
	private WebDriver driver;

	// TODO Delete Code
	// ABrowser() {
	// }

	ABrowser(WebDriver driver, String browserName) {
		this.driver = driver;
		this.browserName = browserName;
	}

	// TODO +++ Set Package Access
	public WebDriver getWebDriver() {
		if (driver != null) {
			return driver;
		} else {
			// TODO Create class Exception + log + report.
			throw new RuntimeException(BROWSER_CLOSED);
		}
	}

	// TODO Delete Code
	// void setWebDriver(WebDriver driver) {
	// this.driver = driver;
	// }

	String getBrowserName() {
		return browserName;
	}

	boolean isEnabled() {
		return driver != null;
	}

	public void loadPage(String url) {
		getWebDriver().get(url);
	}

	public Object runJavaScript(String script) {
		return ((JavascriptExecutor) getWebDriver()).executeScript(script);
	}

	public void refreshPage() {
		getWebDriver().navigate().refresh();
	}

	public void forwardPage() {
		// TODO Use try
		getWebDriver().navigate().forward();
	}

	public void previousPage() {
		// TODO Use try
		getWebDriver().navigate().back();
	}

	public String getCurrentUrl() {
		return getWebDriver().getCurrentUrl();
	}

	public void close() {
		getWebDriver().close();
		driver = null;
	}

	public void quit() {
		getWebDriver().quit();
		driver = null;
	}

}
