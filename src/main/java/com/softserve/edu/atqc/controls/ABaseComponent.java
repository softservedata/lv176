package com.softserve.edu.atqc.controls;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.atqc.tools.BrowserUtils;
import com.softserve.edu.atqc.tools.ControlLocation;
import com.softserve.edu.atqc.tools.ControlSearch;
import com.softserve.edu.atqc.tools.ControlWrapper;

public abstract class ABaseComponent<TComponent> {
    private ControlLocation controlLocation;
    private ControlWrapper controlWrapper;
    private TComponent tComponent;

    protected ABaseComponent() {
        // TODO Create tComponent using Reflection API
        // tComponent = this;
    	 
    }
  
    // Search Visible Elements
    
    public TComponent getById(String id) {
        return get(ControlLocation.getById(id));
    }

    public TComponent getByName(String name) {
        return get(ControlLocation.getByName(name));
    }

    public TComponent getByXpath(String xpath) {
        return get(ControlLocation.getByXPath(xpath));
    }

    public TComponent getByPartialLinkText(String partialLinkText) {
        return get(ControlLocation.getByPartialLinkText(partialLinkText));
    }

    public TComponent getByCssSelector(String cssSelector) {
        return get(ControlLocation.getByCssSelector(cssSelector));
    }

    public TComponent getByTagName(String tagName) {
        return get(ControlLocation.getByTagName(tagName));
    }

    TComponent getByControl(ControlWrapper controlWrapper, ControlLocation controlLocation) {
        this.controlLocation = controlLocation;
        // TODO Set strategy for Searching Elements
        this.controlWrapper = controlWrapper;
        return tComponent;
    }

    TComponent get(ControlLocation controlLocation) {
        this.controlLocation = controlLocation;
        // TODO Set strategy for Searching Elements
        this.controlWrapper = ControlWrapper.getVisibleWebElement(controlLocation);
        return tComponent;
    }

    // TODO Search Present Elements
    
    public TComponent getPresentById(String id) {
        return getPresent(ControlLocation.getById(id));
    }

    public TComponent getPresentByName(String name) {
        return getPresent(ControlLocation.getByName(name));
    }

    private TComponent getPresent(ControlLocation controlLocation) {
        this.controlLocation = controlLocation;
        // TODO Set strategy for Searching Elements
        this.controlWrapper = ControlWrapper.getPresentWebElement(controlLocation);
        return tComponent;
    }

    // TODO Change strategy Implicit/Explicit and Visible/Present

    // implements getters and setters

    ControlWrapper getControlWrapper() {
        return this.controlWrapper;
    }

    ControlLocation getControlLocation() {
        return this.controlLocation;
    }

    protected void setTComponent(TComponent tComponent) {
        this.tComponent = tComponent;
    }

    // implements common methods

    public boolean isInvisibleWebElementById(String id) {
        return ControlSearch.get().isInvisibleWebElementById(id);
    }

    public boolean isInvisibleWebElementByPartialLinkText(String partialLinkText) {
        return ControlSearch.get().isInvisibleWebElementByPartialLinkText(partialLinkText);
    }
    
    //Temporary methods for getting Lists of WebElements
    public List<WebElement> getElementsById(String id) {
    	return  BrowserUtils.get().getBrowser().getWebDriver().findElements(By.id(id));
       
    }

    public List<WebElement> getElementsByName(String name) {
    	return  BrowserUtils.get().getBrowser().getWebDriver().findElements(By.name(name));
    }

    public List<WebElement> getElementsByXpath(String xpath) {
    	return  BrowserUtils.get().getBrowser().getWebDriver().findElements(By.xpath(xpath));
    }

    public List<WebElement> getElementsByPartialLinkText(String partialLinkText) {
       return  BrowserUtils.get().getBrowser().getWebDriver().findElements(By.partialLinkText(partialLinkText));
    }

    public List<WebElement>  getElementsByCssSelector(String cssSelector) {
    	  return  BrowserUtils.get().getBrowser().getWebDriver().findElements(By.cssSelector(cssSelector));
    }

    public TComponent getElementsByTagName(String tagName) {
        return get(ControlLocation.getByTagName(tagName));
    }
    public Object runJavaScript(String script) {
		return BrowserUtils.get().getBrowser().runJavaScript(script);
	}

}
