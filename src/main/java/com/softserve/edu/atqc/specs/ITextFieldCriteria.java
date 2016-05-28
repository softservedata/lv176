package com.softserve.edu.atqc.specs;

public interface ITextFieldCriteria {

    ITextFieldCriteriaNext attributeMatch(String attribute, String expectedResult);

    ITextFieldCriteriaNext valueMatch(String expectedResult);

    ITextFieldCriteriaNext valueStartsWith(String expectedResult);

    ITextFieldCriteriaNext valueByPartialText(String expectedResult);
    
    ITextFieldCriteriaNext valueBySeparator(String separator, String expectedResult);

    ITextFieldCriteriaNext isVisible();

}
