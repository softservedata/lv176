package com.softserve.edu.atqc.specs;

import com.softserve.edu.atqc.controls.ILink;

public final class LinkCriteria extends ABaseCriteria implements ILinkCriteriaNext {
	private final String DOES_NOT_MATCH = "Values doesn't match. Expected Result %s ActualResult %s";
	private final String IT_IS_NOT_VISIBLE = "Link it's not visible";
	private final String IT_IS_VISIBLE = "Link it's visible";
	private ILink link;

	private LinkCriteria(ILink link) {
		this.link = link;
	}

	public static ILinkCriteria get(ILink link) {
		return new LinkCriteria(link);
	}

	public ILinkCriteriaNext urlMatch(String expectedResult) {
	    FlexAssert.get().verify(link.getUrl().equals(expectedResult),
				String.format(DOES_NOT_MATCH, expectedResult, link.getUrl()));
		return this;
	}

	public ILinkCriteriaNext valueMatch(String expectedResult) {
	    FlexAssert.get().verify(link.getText().equals(expectedResult),
				String.format(DOES_NOT_MATCH, expectedResult, link.getText()));
		return this;
	}

	public ILinkCriteriaNext valueStartsWith(String expectedResult) {
	    FlexAssert.get().verify(link.getText().startsWith(expectedResult),
				String.format(DOES_NOT_MATCH, expectedResult, link.getText()));
		return this;
	}

	public ILinkCriteriaNext valueByPartialText(String expectedResult) {
	    FlexAssert.get().verify(link.getText().contains(expectedResult),
				String.format(DOES_NOT_MATCH, expectedResult, link.getText()));
		return this;
	}

	public ILinkCriteriaNext  isVisible() {
	    FlexAssert.get().verify(link.isDisplayed(), IT_IS_NOT_VISIBLE);
		return this;
	}

	public ILinkCriteriaNext  isInvisible() {
	    FlexAssert.get().verify(link.isInvisible(), IT_IS_VISIBLE);
		return this;
	}
}
