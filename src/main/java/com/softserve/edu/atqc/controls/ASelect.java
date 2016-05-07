package com.softserve.edu.atqc.controls;

import java.util.List;

import com.softserve.edu.atqc.tools.SelectWrapper;

public abstract class ASelect<TComponent> extends ALabelClickable<TComponent> implements ISelect{

	// implements constructor
    protected ASelect() {
	}

	public List<ILabelClickable> getAllOptions() {
		return null;
	}

	public ILabelClickable getFirstSelectedOption() {
		return null;//SelectWrapper.getPresentSelectWebElement(getControlWrapper()).getFirstSelectedOption();
	}

	public void selectByIndex(int index) {
		SelectWrapper.getVisibleSelectWebElement(getControlWrapper()).selectByIndex(index);
	}

	public void selectByVisibleText(String text) {
		SelectWrapper.getVisibleSelectWebElement(getControlWrapper()).selectByVisibleText(text);
	}

	public void selectByPartialText(String partialText) {
		SelectWrapper.getVisibleSelectWebElement(getControlWrapper()).selectByPartialText(partialText);
	}

	public void selectByValue(String value) {
		SelectWrapper.getVisibleSelectWebElement(getControlWrapper()).selectByValue(value);
	}
}
