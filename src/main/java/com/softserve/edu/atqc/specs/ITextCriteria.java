package com.softserve.edu.atqc.specs;

public interface ITextCriteria {

	ITextCriteriaNext valueMatch(String expectedResult);

	ITextCriteriaNext valueMatch(Integer expectedResult);

	ITextCriteriaNext valueStartsWith(String expectedResult);

	ITextCriteriaNext valueByPartialText(String expectedResult);

}
