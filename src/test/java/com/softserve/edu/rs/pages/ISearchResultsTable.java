package com.softserve.edu.rs.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.softserve.edu.atqc.controls.Component;
import com.softserve.edu.atqc.controls.IComponent;
import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.Label;

public interface ISearchResultsTable {
	
	public IComponent getTableOfResults() ;

	public ILabel getDataTextInfo() ;

	public ILabel getPaginateInfo() ;
	
	public List<WebElement> getSearchResultValues() ;

	public List<String> getSearchResultTextValues() ;

	public List<String> getSearchResultIdValues() ;

	public List<WebElement> getSearchResultRows() ;
}
