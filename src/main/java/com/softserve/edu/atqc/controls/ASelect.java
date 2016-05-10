package com.softserve.edu.atqc.controls;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.atqc.tools.ControlWrapper;
import com.softserve.edu.atqc.tools.SelectWrapper;

public abstract class ASelect<TComponent> extends ALabelClickable<TComponent> implements ISelect {
	// implements constructor

    protected ASelect() {
	}
    
	// implements interface

    public List<ILabelClickable> getAllOptions() {
		List<ILabelClickable> iLabelClickablelist = new ArrayList<ILabelClickable>();
		List<ControlWrapper> controlwrapperlist = SelectWrapper.
				getVisibleSelectWebElement(getControlWrapper()).getSelectWebElements();
		for (ControlWrapper control:controlwrapperlist){
			iLabelClickablelist.add(LabelClickable.get().getByControlWrapper(control));
		}
		return iLabelClickablelist;
	}

	public ILabelClickable getFirstSelectedOption() {
		ILabelClickable iLabelClickable = LabelClickable.get().
				getByControlWrapper(SelectWrapper.getVisibleSelectWebElement(getControlWrapper()).getFirstSelectedOption());
		return iLabelClickable;
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
