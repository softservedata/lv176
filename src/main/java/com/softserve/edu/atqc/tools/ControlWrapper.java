package com.softserve.edu.atqc.tools;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.softserve.edu.atqc.exceptions.GeneralCustomException;
import com.softserve.edu.atqc.exceptions.ScreenCapturingCustomException;

public final class ControlWrapper {
	private final String ELEMENT_NOT_CLICKABLE = "Element is not clickable %s";
	private final String ERROR_ON_CLICK = "Error on click";
	private final String INVALID_TAG = "Invalid Tag. Must be <a>";
	private final String TAG_A = "a";
	private final String ATTRIBUTE_HREF = "href";
	private final String ATTRIBUTE_NAME = "name";
	private WebElement webElement;

	private ControlWrapper(WebElement webElement) {
		this.webElement = webElement;
	}
	
	static ControlWrapper get(WebElement webElement) {
		return new ControlWrapper(webElement);
	}

	public static ControlWrapper getVisibleWebElement(ControlLocation controlLocation) {
		return new ControlWrapper(ControlSearch.get().getVisibleWebElement(controlLocation));
	}

	public static ControlWrapper getPresentWebElement(ControlLocation controlLocation) {
		return new ControlWrapper(ControlSearch.get().getPresentWebElement(controlLocation));
	}

	WebElement getWebElement() {
		return webElement;
	}

	// For Implements Interface

	public String getAttribute(String attribute) {
		return getWebElement().getAttribute(attribute);
	}

	public String getAttributeName() {
		return getWebElement().getAttribute(ATTRIBUTE_NAME);
	}

	public String getContent() {
		return getWebElement().getText();
	}

	public String getTagName() {
		return getWebElement().getTagName();
	}

	public String getText() {
		return getWebElement().getText();
	}

	public String getUrl() {
		if (getTagName().toLowerCase().equals(TAG_A)) {
			return getWebElement().getAttribute(ATTRIBUTE_HREF);
		} else {
			throw new GeneralCustomException(INVALID_TAG);
		}
	}

	public void clear() {
		click();
		getWebElement().clear();
	}

	public void click() {
		boolean clickDone = false;
		long waitSeconds = SearchImplicit.get().getImplicitlyWaitTimeout()
						> SearchExplicit.get().getExplicitlyWaitTimeout()
						? SearchImplicit.get().getImplicitlyWaitTimeout()
						: SearchExplicit.get().getExplicitlyWaitTimeout();
		long beginTime = System.currentTimeMillis();
		while ((System.currentTimeMillis() - beginTime < ASearchContext.ONE_SECOND * waitSeconds)
				&& (!clickDone)) {
			try {
				getWebElement().click();
				clickDone = true;
				break;
			} catch (WebDriverException e) {
				try {
					Thread.sleep(ASearchContext.ONE_SECOND / 2);
				} catch (InterruptedException e1) {
					throw new ScreenCapturingCustomException(
							String.format(ELEMENT_NOT_CLICKABLE,
									getWebElement().getTagName()));
				}
			} catch (Exception e) {
				throw new ScreenCapturingCustomException(
						String.format(ELEMENT_NOT_CLICKABLE,
								getWebElement().getTagName()));
			}
		}
		if (clickDone) {
			return;
		}
		try {
			getWebElement().click();
		} catch (WebDriverException e) {
			throw new ScreenCapturingCustomException(
					String.format(ELEMENT_NOT_CLICKABLE,
							getWebElement().getTagName()));
		} catch (Exception e) {
			throw new ScreenCapturingCustomException(ERROR_ON_CLICK, e);
		}
	}

	public boolean isDisplayed() {
		return getWebElement().isDisplayed();
	}

	public boolean isEnabled() {
		return getWebElement().isEnabled();
	}

	public boolean isSelected() {
		return getWebElement().isSelected();
	}

	public void sendKeys(String text) {
		getWebElement().sendKeys(text);
	}

	public void sendKeysClear(String text) {
		clear();
		getWebElement().sendKeys(text);
	}

	public void setFocus() {
		new Actions(BrowserUtils.get().getBrowser().getWebDriver())
			.moveToElement(getWebElement()).perform();
		sendKeys(new String());
	}

	public void submit() {
		getWebElement().submit();
	}

}
