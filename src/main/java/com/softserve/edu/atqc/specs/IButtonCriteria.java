package com.softserve.edu.atqc.specs;

public interface IButtonCriteria {

    IButtonCriteriaNext valueMatch(String expectedResult);

    IButtonCriteriaNext valueStartsWith(String expectedResult);

    IButtonCriteriaNext valueByPartialText(String expectedResult);

    IButtonCriteriaNext isVisible();

}
