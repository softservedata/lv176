package com.softserve.edu.rs.data.apps;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class VerifyEnabledOfCommunity {

	/*
	 * public static boolean VerifyOfCommunity(List<WebElement> searchResult,
	 * String expected) {
	 * 
	 * boolean result = true; 
	 * for (WebElement element : searchResult)
	 *  { if (element.getText().contains(expected) == false) {
	 * 
	 * return false; } } return result;
	 * 
	 * } }
	 */
	

	public static  boolean VerifyOfCommunity(String exp) {

		List<WebElement> arrayCom = new ArrayList<WebElement>();
		for (WebElement dd : arrayCom) {
			{if (dd.getText().contains(exp)  == true) {
				return false; } }

				
		
	}
		return true;
}

}