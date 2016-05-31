package com.softserve.edu.atqc.specs;

public interface ILinkCriteria {

    ILinkCriteriaNext urlMatch(String expectedResult);

    ILinkCriteriaNext valueMatch(String expectedResult);

    ILinkCriteriaNext valueStartsWith(String expectedResult);

    ILinkCriteriaNext valueByPartialText(String expectedResult);

    ILinkCriteriaNext isVisible();

    ILinkCriteriaNext isInvisible();
}
