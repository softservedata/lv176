package com.softserve.edu.atqc.specs;

import com.softserve.edu.atqc.controls.ITextField;

public final class TextFieldCriteria extends ABaseCriteria implements ITextFieldCriteriaNext {
    private final String DOES_NOT_MATCH = "Values doesn't match. Expected Result %s ActualResult %s";
    private final String IT_IS_NOT_VISIBLE = "TextInput it's not visible";
    private ITextField textField;

    private TextFieldCriteria(ITextField textField) {
        this.textField = textField;
    }

    public static ITextFieldCriteria get(ITextField textField) {
        return new TextFieldCriteria(textField);
    }

    public ITextFieldCriteriaNext attributeMatch(String attribute, String expectedResult) {
        FlexAssert.get().verify(textField.getAttribute(attribute).equals(expectedResult),
                String.format(DOES_NOT_MATCH, expectedResult, textField.getAttribute(attribute)));
        return this;
    }

    public ITextFieldCriteriaNext valueMatch(String expectedResult) {
        FlexAssert.get().verify(textField.getText().equals(expectedResult),
                String.format(DOES_NOT_MATCH, expectedResult, textField.getText()));
        return this;
    }

    public ITextFieldCriteriaNext valueStartsWith(String expectedResult) {
        FlexAssert.get().verify(textField.getText().startsWith(expectedResult),
                String.format(DOES_NOT_MATCH, expectedResult, textField.getText()));
        return this;
    }

    public ITextFieldCriteriaNext valueByPartialText(String expectedResult) {
        FlexAssert.get().verify(textField.getText().contains(expectedResult),
                String.format(DOES_NOT_MATCH, expectedResult, textField.getText()));
        return this;
    }
    
    public ITextFieldCriteriaNext valueBySeparator(String separator, String expectedResult) {
    	String actualRezult = textField.getAttribute("value").split(separator)[0];
    	FlexAssert.get().verify(actualRezult.equals(expectedResult),
    			String.format(DOES_NOT_MATCH, expectedResult, actualRezult));
		return this;
    }

    public ITextFieldCriteriaNext isVisible() {
        FlexAssert.get().verify(textField.isDisplayed(), IT_IS_NOT_VISIBLE);
        return this;
    }

}
