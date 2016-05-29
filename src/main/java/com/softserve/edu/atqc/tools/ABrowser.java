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


	ABrowser(WebDriver driver, String browserName) {
		this.driver = driver;
		this.browserName = browserName;
	}

	WebDriver getWebDriver() {
		if (driver != null) {
			return driver;
		} else {
			throw new RuntimeException(BROWSER_CLOSED);
		}
	}

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
		getWebDriver().navigate().forward();
	}

	public void previousPage() {
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
