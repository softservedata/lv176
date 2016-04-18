package com.softserve.edu.rs.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractAppPage {
	protected WebDriver driver;
	
	public AbstractAppPage(WebDriver driver){
		this.driver = driver;
	}
	
	protected WebElement findById(String value) {
		return driver.findElement(By.id(value));
	}
	
	protected WebElement findByCss(String value) {
		return driver.findElement(By.cssSelector(value));
	}
	
	protected WebElement findByXpath(String value) {
		return driver.findElement(By.xpath(value));
	}
	
	protected WebElement findByPartialLinkText(String value) {
		return driver.findElement(By.partialLinkText(value));
	}
	
	protected List<WebElement> findCollectionById(String value) {
		return driver.findElements(By.id(value));
	}
	
	protected List<WebElement> findCollectionByCss(String value) {
		return driver.findElements(By.cssSelector(value));
	}
	
	protected List<WebElement> findCollectionByXpath(String value) {
		return driver.findElements(By.xpath(value));
	}
	
	protected List<WebElement> findCollectionByPartialLinkText(String value) {
		return driver.findElements(By.partialLinkText(value));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
