package com.softserve.edu.atqc.tools;

import java.util.List;

import org.openqa.selenium.WebElement;

abstract class ASearchContext {
	static final long ONE_SECOND = 1000L;
	//static final String ELEMENT_NOT_CLICKABLE = "Element is not clickable %s";
	static final String ERROR_DURING_SEARCHING = "Error was found during searching";
	static final String ERROR_WEBELEMENT_NOT_FOUND = "WebElement(s) was not found %s";
	static final String ERROR_WEBELEMENT_STILL_VISIBLE = "WebElement is still visible %s";
	static final String ERROR_TITLE_INVISIBLE = "Title invisible %s";

	abstract void setWaitTimeout(long waitTimeout);
	
	abstract WebElement getVisibleWebElement(ControlLocation controlLocation);

	abstract List<WebElement> getVisibleWebElements(ControlLocation controlLocation);

	abstract WebElement getPresentWebElement(ControlLocation controlLocation);

	abstract boolean isClickableWebElement(ControlLocation controlLocation);

	abstract boolean isInvisibleWebElement(ControlLocation controlLocation);

	abstract boolean isInvisibleWebElementWithText(ControlLocation controlLocation, String text);

	abstract boolean isStatelessOfWebElement(ControlWrapper controlWrapper);

	abstract boolean isVisibleTitle(String partialTitle);

}
