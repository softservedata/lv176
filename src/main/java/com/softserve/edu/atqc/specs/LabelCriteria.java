package com.softserve.edu.atqc.specs;

import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.Label;

public final class LabelCriteria extends ABaseCriteria implements ILabelCriteriaNext {
	private final String DOES_NOT_MATCH = "Values doesn't match. Expected Result %s ActualResult %s";
	private final String IT_IS_NOT_VISIBLE = "Label it's not visible";
	//TODO
	private final String IT_IS_VISIBLE = "Label is  visible";
	private ILabel label;
	
	//TODO
    

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

	public ILabelCriteriaNext isVisible() {
	    FlexAssert.get().verify(label.isDisplayed(), IT_IS_NOT_VISIBLE);
		return this;
	}
	
	public void isNotVisibleLable() {
		System.out.println("we are here");
	    FlexAssert.get().verify(label.equals(" "), IT_IS_NOT_VISIBLE);
	    System.out.println("we are here");
	    System.out.println(IT_IS_VISIBLE);
	
	}

	public static ILabelCriteria get(boolean bb) {
		// TODO Auto-generated method stub
             return null;
	}
	
}
