package com.softserve.edu.atqc.tools;

final class BrowserRepository {

	static enum BrowserList {
		BROWSER_FIREFOX_TEMPORARY(""),
		BROWSER_FIREFOX_DEFAULT(""),
		BROWSER_CHROME_TEMPORARY(""),
		BROWSER_HTMLUNIT_TEMPORARY(""),
		BROWSER_DEFAULT("");
        //
        private String field;

        private BrowserList(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }

	private BrowserRepository() {
    }
	
}
