package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hello World! from Lv-176.ATQC");
		//
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.seleniumhq.org/download/");
		//
		WebElement seleniumIDE =driver.findElement(By.name("selenium_ide"));
		//WebElement seleniumIDE =driver.findElement(By.partialLinkText("plugin tutorial page"));
		//WebElement seleniumIDE =driver.findElement(By.partialLinkText("see the wiki page"));
		new Actions(driver).moveToElement(seleniumIDE).perform();
		seleniumIDE.sendKeys(new String());
		//new Actions(driver).sendKeys(Keys.ENTER);
		//new Actions(driver).sendKeys(Keys.TAB);
		Thread.sleep(2000);
	}

}
