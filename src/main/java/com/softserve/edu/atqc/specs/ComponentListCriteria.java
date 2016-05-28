package com.softserve.edu.atqc.specs;

import java.util.List;

import com.softserve.edu.atqc.controls.IComponentsList;


public class ComponentListCriteria extends ABaseCriteria implements IComponentListCriteriaNext {
//	private final String VRONG_LIST_SIZE = "Values doesn't match. Expected Result %s ActualResult %s";
	private final String DOES_NOT_MATCH = "Values doesn't match. Expected Result %s ActualResult %s";
//	private final String IT_IS_NOT_VISIBLE = "List it's not visible";
	private IComponentsList list;
	
	private ComponentListCriteria(IComponentsList link) {
		this.list = link;
	}
	
	public static IComponentListCriteria get(IComponentsList list) {
		return new ComponentListCriteria(list);
	}
	
	public IComponentListCriteriaNext containsText(String expectedResult){
		FlexAssert.get().verify(compareValues(list.getListStrings(), expectedResult),
				String.format(DOES_NOT_MATCH, expectedResult, list.getListStrings()));
		return this;
	}
	
	public IComponentListCriteriaNext equalInt(int expectedResult){
		FlexAssert.get().verify(list.labeleListSize()==expectedResult,
				String.format(DOES_NOT_MATCH, expectedResult, list.getListStrings()));
		return this;
	}
	
	private boolean compareValues(List<String> list, String expected){
		boolean result = true;
		for (String str : list){
			if(!str.toLowerCase().contains(expected.toLowerCase())){
				result = false;
			}
		}
		return result;
	}
}
