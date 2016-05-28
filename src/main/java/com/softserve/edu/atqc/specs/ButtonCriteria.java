package com.softserve.edu.atqc.specs;

import com.softserve.edu.atqc.controls.IButton;

public final class ButtonCriteria extends ABaseCriteria implements IButtonCriteriaNext {
	private final String DOES_NOT_MATCH = "Values doesn't match. Expected Result %s ActualResult %s";
	private final String IT_IS_NOT_VISIBLE = "Link it's not visible";
	private IButton button;

	private ButtonCriteria(IButton button) {
		this.button = button;
	}

	public static IButtonCriteria get(IButton button) {
		return new ButtonCriteria(button);
	}

	public IButtonCriteriaNext valueMatch(String expectedResult) {
	    FlexAssert.get().verify(button.getText().equals(expectedResult),
				String.format(DOES_NOT_MATCH, expectedResult, button.getText()));
		return this;
	}

	public IButtonCriteriaNext valueStartsWith(String expectedResult) {
	    FlexAssert.get().verify(button.getText().startsWith(expectedResult),
				String.format(DOES_NOT_MATCH, expectedResult, button.getText()));
		return this;
	}

	public IButtonCriteriaNext valueByPartialText(String expectedResult) {
	    FlexAssert.get().verify(button.getText().contains(expectedResult),
				String.format(DOES_NOT_MATCH, expectedResult, button.getText()));
		return this;
	}

	public IButtonCriteriaNext  isVisible() {
	    FlexAssert.get().verify(button.isDisplayed(), IT_IS_NOT_VISIBLE);
		return this;
	}

}
