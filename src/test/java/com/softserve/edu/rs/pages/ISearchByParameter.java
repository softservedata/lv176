package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.ILabelClickable;
import com.softserve.edu.atqc.controls.ISelect;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.rs.pages.ResourceSearchPage.ObjectSubclasses;

public interface ISearchByParameter {
	ITextField  getInputPerimeter();
	ITextField  getInputArea();
	ILabelClickable getBtnShowAll();
	ISelect getListObjectSubclasses();
	ILabelClickable getListObjectSubclassesSelected();
	String getListObjectSubclassesSelectedText();
	void setListObjectSubclasses(ObjectSubclasses subclass);
	void setListObjectSubclassesByPartialText(String partialText);
	public void setInputPerimeter(ITextField inputPerimeter) ;

	public void setInputArea(ITextField inputArea) ;
	
}
