package com.softserve.edu.atqc.tools;

import com.softserve.edu.atqc.data.apps.ApplicationSources;
import com.softserve.edu.atqc.tools.ChromeTemporary.ChromeTemporaryFactory;
import com.softserve.edu.atqc.tools.FirefoxDefault.FirefoxDefaultFactory;
import com.softserve.edu.atqc.tools.FirefoxTemporary.FirefoxTemporaryFactory;
import com.softserve.edu.atqc.tools.HtmlUnitTemporary.HtmlUnitTemporaryFactory;
import com.softserve.edu.atqc.tools.InternetExplorerTemporary.InternetExplorerFactory;

final class BrowserRepository {

	static enum BrowserList {
		BROWSER_FIREFOX_TEMPORARY(new FirefoxTemporaryFactory()),
		BROWSER_FIREFOX_DEFAULT(new FirefoxDefaultFactory()),
		BROWSER_CHROME_TEMPORARY(new ChromeTemporaryFactory()),
		BROWSER_IE_TEMPORARY(new InternetExplorerFactory()),
		BROWSER_HTMLUNIT_TEMPORARY(new HtmlUnitTemporaryFactory()),
		BROWSER_DEFAULT(new FirefoxTemporaryFactory());
        //
        private IBrowserFactory browserFactory;

        private BrowserList(IBrowserFactory browserFactory) {
            this.browserFactory = browserFactory;
        }

        public ABrowser getInstance(ApplicationSources applicationSources) {
        	return this.browserFactory.getInstance(applicationSources);
        }
        
        @Override
        public String toString() {
            return this.browserFactory.getInstanceName();
        }
    }

	private BrowserRepository() {
    }
	
}
