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
		CsvReaderData.convertHashMapToObjectArray(CsvReaderData.read());
	}

}
