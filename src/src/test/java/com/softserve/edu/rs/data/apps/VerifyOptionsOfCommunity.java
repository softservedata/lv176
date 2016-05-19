package com.softserve.edu.rs.data.apps;

import java.util.List;

import org.openqa.selenium.WebElement;

public class VerifyOptionsOfCommunity {
	public static boolean CheckComm(List<WebElement> searchResult, String expected) {
		boolean result = false;
		// List<WebElement> searchResult = new ArrayList<WebElement>();
		for (WebElement element : searchResult) {
			if (element.getText().contains(expected) == true) {
				result = true;
			}
		}
		return result;
	}

}
