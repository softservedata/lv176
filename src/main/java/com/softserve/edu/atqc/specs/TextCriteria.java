package com.softserve.edu.atqc.specs;

public final class TextCriteria extends ABaseCriteria implements ITextCriteriaNext {
    private final String DOES_NOT_MATCH = "Values do not match. Expected Result: %s ActualResult: %s";
    private String text;

    private TextCriteria(String text) {
        this.text = text;
    }

    public static ITextCriteria get(String text) {
        return new TextCriteria(text);
    }

    public ITextCriteriaNext valueMatch(String expectedResult) {
        FlexAssert.get().verify(text.equals(expectedResult),
                String.format(DOES_NOT_MATCH, expectedResult, text));
        return this;
    }

    public ITextCriteriaNext valueMatch(Integer expectedResult) {
        FlexAssert.get().verify(text.equals(expectedResult.toString()),
                String.format(DOES_NOT_MATCH, expectedResult, text));
        return this;
    }

    public ITextCriteriaNext valueStartsWith(String expectedResult) {
        FlexAssert.get().verify(text.startsWith(expectedResult),
                String.format(DOES_NOT_MATCH, expectedResult, text));
        return this;
    }

    public ITextCriteriaNext valueByPartialText(String expectedResult) {
        FlexAssert.get().verify(text.contains(expectedResult),
                String.format(DOES_NOT_MATCH, expectedResult, text));
        return this;
    }

}
