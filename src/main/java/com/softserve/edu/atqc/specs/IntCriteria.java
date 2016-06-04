package com.softserve.edu.atqc.specs;

public class IntCriteria extends ABaseCriteria implements IIntCriteriaNext {

	private final String DOES_NOT_MATCH = "Values do not match. Expected Result: %s ActualResult: %s";
	private int num;

	private IntCriteria(int num) {
		this.num = num;
	}

	public static IIntCriteria get(int num) {
		return new IntCriteria(num);
	}

	public IIntCriteriaNext valueMatch(int expectedResult) {
		FlexAssert.get().verify((num == expectedResult), String.format(DOES_NOT_MATCH, expectedResult, num));
		return this;
	}

	@Override
	public IIntCriteriaNext valueMatch(Integer expectedResult) {
		FlexAssert.get().verify((num == expectedResult), String.format(DOES_NOT_MATCH, expectedResult, num));
		return this;
	}

}
