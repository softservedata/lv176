package com.softserve.edu.atqc.specs;

public interface IComponentListCriteria {
	IComponentListCriteriaNext containsText(String expectedResult);
	IComponentListCriteriaNext equalInt(int expectedResult);
}
