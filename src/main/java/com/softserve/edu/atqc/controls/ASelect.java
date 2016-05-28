package com.softserve.edu.atqc.controls;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.atqc.tools.ControlLocation;
import com.softserve.edu.atqc.tools.ControlWrapper;
import com.softserve.edu.atqc.tools.SelectWrapper;

abstract class ASelect<TComponent> extends ALabelClickable<TComponent> implements ISelect {
	private SelectWrapper selectWrapper;

	// implements constructor
	protected ASelect() {
	}

    // Search Visible Elements

	@Override
    TComponent get(ControlLocation controlLocation) {
		TComponent tComponent = super.get(controlLocation);
        this.selectWrapper =  SelectWrapper.getVisibleSelectWebElement(getControlWrapper());
        return tComponent;
    }

    // implements getters and setters
	
	SelectWrapper getSelectWrapper() {
        return this.selectWrapper;
    }

	// implements interface

	public void submit() {
		getControlWrapper().submit();
	}

	public List<ILabelClickable> getAllOptions() {
		List<ILabelClickable> selectLabels = new ArrayList<ILabelClickable>();
		for (ControlWrapper controlWrapper : getSelectWrapper().getSelectWebElements()) {
			selectLabels.add(LabelClickable.get()
					.getByControl(controlWrapper, ControlLocation
							.getByXPath("//option[text()='" + controlWrapper.getText() + "']")));
		}
		return selectLabels;
	}

	public ILabelClickable getFirstSelectedOption() {
		return LabelClickable.get().getByControl(
				getSelectWrapper().getFirstSelectedOption(),
					ControlLocation.getByXPath("//option[text()='"
						+ getSelectWrapper().getFirstSelectedOption() + "']"));
	}

	public void selectByIndex(int index) {
		getSelectWrapper().selectByIndex(index);
	}

	public void selectByValue(String value) {
		getSelectWrapper().selectByValue(value);
	}

	public void selectByVisibleText(String text) {
		getSelectWrapper().selectByVisibleText(text);
	}

	public void selectByPartialText(String partialText) {
		getSelectWrapper().selectByPartialText(partialText);
	}

}
