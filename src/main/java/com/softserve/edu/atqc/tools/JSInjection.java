package com.softserve.edu.atqc.tools;

import org.openqa.selenium.JavascriptExecutor;

public class JSInjection {
	private JavascriptExecutor jsExecutor;
	
	public JSInjection() {
		this.jsExecutor = (JavascriptExecutor) BrowserUtils.get().getBrowser().getWebDriver();
	}
	
	public JavascriptExecutor getJsExecutor() {
		return this.jsExecutor;
	}
	
	public Object runScript(String script) {
		return getJsExecutor().executeScript(script);
	}
}
