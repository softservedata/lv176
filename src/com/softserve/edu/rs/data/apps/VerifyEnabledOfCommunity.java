package com.softserve.edu.rs.data.apps;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class VerifyEnabledOfCommunity {


	
	  public static boolean VerifyOfCommunity(List<WebElement> searchResult,
	  String expected) {
	  
	  boolean result = true; for (WebElement element : searchResult) { if
	  (element.getText().contains(expected) == false) {
	  
	  return false; } } return result;
	  
	  } 
	 

	public static boolean CheckComm(List<WebElement> searchResult, String expected) {
	 boolean result = false;

		//List<WebElement> searchResult = new ArrayList<WebElement>();
		
		for (WebElement element : searchResult) {
			if (element.getText().contains(expected) == true) {
				result = true;
			}
		}
		return result;
	}
	
	  public static boolean VerifyOfCleaning(WebElement searchResult,String expected) {
			  
			  boolean result = false;
			   
			  if(searchResult.getText().contains(expected) == true) {
			  
			  result = true;
			  }  
			  return result;
			  
			  }

}