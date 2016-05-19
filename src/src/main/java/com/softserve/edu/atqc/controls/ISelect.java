package com.softserve.edu.atqc.controls;

import java.util.List;

public interface ISelect extends ILabelClickable {

	List<ILabelClickable> getAllOptions();

	ILabelClickable getFirstSelectedOption();

	void selectByIndex(int index);

	void selectByValue(String value);

	void selectByVisibleText(String text);

	void selectByPartialText(String partialText);

}
