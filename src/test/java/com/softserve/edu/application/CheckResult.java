package com.softserve.edu.application;

public class CheckResult {
	boolean result = true;
	
	public CheckResult add(boolean expect, boolean actual) {
		result = result && (expect == actual);
		return this;
	}
	
	public CheckResult add(String expect, String actual) {
		result = result && (expect.equals(actual));
		return this;
	}
	
	public boolean check() {
		return result;
	}
}
