package com.softserve.edu.atqc.specs;

import com.softserve.edu.atqc.controls.ILabel;

public final class LabelCriteria extends ABaseCriteria implements ILabelCriteriaNext {
	private final String DOES_NOT_MATCH = "Values doesn't match. Expected Result %s ActualResult %s";
	private final String IT_IS_NOT_VISIBLE = "Label it's not visible";
	private ILabel label;

	private LabelCriteria(ILabel label) {
		this.label = label;
	}

	public static ILabelCriteria get(ILabel label) {
		return new LabelCriteria(label);
	}

	public ILabelCriteriaNext valueMatch(String expectedResult) {
	    FlexAssert.get().verify(label.getText().equals(expectedResult),
				String.format(DOES_NOT_MATCH, expectedResult, label.getText()));
		return this;
	}

	public ILabelCriteriaNext valueStartsWith(String expectedResult) {
	    FlexAssert.get().verify(label.getText().startsWith(expectedResult),
				String.format(DOES_NOT_MATCH, expectedResult, label.getText()));
		return this;
	}

	public ILabelCriteriaNext valueByPartialText(String expectedResult) {
	    FlexAssert.get().verify(label.getText().contains(expectedResult),
				String.format(DOES_NOT_MATCH, expectedResult, label.getText()));
		return this;
	}
	
    public ILabelCriteriaNext valueBySeparator(String separator, String expectedResult) {
    	//String actualRezult = label.getText().split(separator)[0];
    	String actualRezult = label.getText().substring(0, label.getText().indexOf('.'));
    	FlexAssert.get().verify(actualRezult.equals(expectedResult),
    			String.format(DOES_NOT_MATCH, expectedResult, actualRezult));
		return this;
    }

	public ILabelCriteriaNext isVisible() {
	    FlexAssert.get().verify(label.isDisplayed(), IT_IS_NOT_VISIBLE);
		return this;
	}

}
