package com.softserve.edu.atqc.tools;

public class CheckResult {
	private boolean result = true;
	
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
