package com.softserve.edu.rs.testutils;

import java.util.List;
import org.openqa.selenium.WebElement;



public class VerifyInfo {
	
	public static boolean compareSearchResults(List<WebElement> searchResult, String expected) {
		boolean result = true;
		for (WebElement element : searchResult) {
			if (element.getText().contains(expected) == false) {
				result = false;
			}
		}
		return result;
	}
}
