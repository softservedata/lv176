package com.softserve.edu.rs.pages;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.softserve.edu.atqc.controls.Component;
import com.softserve.edu.atqc.controls.IComponent;
import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.ILabelClickable;
import com.softserve.edu.atqc.controls.Label;

public interface ISearchResultsTable {
	
	public IComponent getTableOfResults() ;

	public ILabel getDataTextInfo() ;

	public ILabel getPaginateInfo() ;
	
	public List<WebElement> getSearchResultValues() ;

	public List<String> getSearchResultTextValues() ;

	public List<String> getSearchResultIdValues() ;

	public List<WebElement> getSearchResultRows() ;

	public void setNumberResultsByPageByPartialText(String partialText);

	public ILabelClickable getBtnPaginateNext();

	public void setBtnPaginateNext(ILabelClickable btnPaginateNext);

	public ILabelClickable getBtnPaginatePrevious();
		

	public void setBtnPaginatePrevious(ILabelClickable btnPaginatePrevious);

	public ILabelClickable getTableColumnDate();

	public List<Date> getSearchResultDateValues() throws ParseException;

	public ILabelClickable getTableColumnId(); 
}
