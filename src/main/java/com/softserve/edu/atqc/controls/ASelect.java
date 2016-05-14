package com.softserve.edu.atqc.controls;

import java.util.List;

import com.softserve.edu.atqc.tools.SelectWrapper;

abstract class ASelect<TComponent> extends ALabelClickable<TComponent> implements ISelect {
	// implements constructor

    protected ASelect() {
	}
    
	// implements interface

	@Override
	public List<ILabelClickable> getAllOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	public ILabelClickable getFirstSelectedOption() {
		// TODO Auto-generated method stub
		return null;
	}

	public void selectByIndex(int index) {
		SelectWrapper.getVisibleSelectWebElement(getControlWrapper()).selectByIndex(index);
	}

	public void selectByValue(String value) {
		SelectWrapper.getVisibleSelectWebElement(getControlWrapper()).selectByValue(value);
	}

	public void selectByVisibleText(String text) {
		SelectWrapper.getVisibleSelectWebElement(getControlWrapper()).selectByVisibleText(text);
	}

	public void selectByPartialText(String partialText) {
		SelectWrapper.getVisibleSelectWebElement(getControlWrapper()).selectByPartialText(partialText);
	}
        

    

    
    
}
