package com.softserve.edu.atqc.tools;

import java.util.HashMap;

import com.softserve.edu.atqc.data.apps.ApplicationSources;
import com.softserve.edu.atqc.tools.BrowserRepository.BrowserList;

public final class BrowserUtils {
	private static volatile BrowserUtils instance = null;
	private final HashMap<Long, ABrowser> browsers;

	private BrowserUtils() {
		this.browsers = new HashMap<Long, ABrowser>();
	}

	public static BrowserUtils get() {
		return get(null); 
	}
	
	public static BrowserUtils get(ApplicationSources applicationSources) {
		if (instance == null) {
			synchronized (BrowserUtils.class) {
				if (instance == null) {
					instance = new BrowserUtils();
				}
			}
		}
		instance.checkStatus(applicationSources);
		return instance;
	}

	public static void quitAll() {
		if (instance != null) {
			for (Long threadId : instance.browsers.keySet()) {
			//for (ABrowser browser : instance.browsers.values()) {
				//browser.quit();
				if (instance.browsers.get(threadId) != null) {
					instance.browsers.get(threadId).close();
					instance.browsers.put(threadId, null);
				}
			}
		}
	}

	public ABrowser getBrowser() {
		return this.browsers.get(Thread.currentThread().getId());
	}

	public void quitBrowser() {
		getBrowser().close();
		this.browsers.put(Thread.currentThread().getId(), null);
	}

	private void checkStatus(ApplicationSources applicationSources) {
		/*-
			AS.name		browser		Action
				+		+			name != browser (+) quit new
		*		+		-			new
		**		-		+			-
		*		- 		-			new
				+/-		+(-)		new
		*/		
		if ((getBrowser() == null)
				|| (!getBrowser().isEnabled())) {
			startBrowser(getBrowserList(applicationSources), applicationSources);
		} else if ((applicationSources != null)
				&& (applicationSources.getBrowserName() != null)
				&& (!applicationSources.getBrowserName().isEmpty())
				&& (!applicationSources.getBrowserName().equals(getBrowser().getBrowserName()))) {
			getBrowser().close();
			startBrowser(getBrowserList(applicationSources), applicationSources);
		}
	}

	private BrowserList getBrowserList(ApplicationSources applicationSources) {
		BrowserList browserList = BrowserList.BROWSER_DEFAULT;
		if ((applicationSources != null)
				&& (applicationSources.getBrowserName() != null)
				&& (!applicationSources.getBrowserName().isEmpty())) {
			for (BrowserList browser : BrowserList.values()) {
				if (browser.toString().toLowerCase()
						.equals(applicationSources.getBrowserName().toLowerCase())) {
					browserList = browser;
					break;
				}
			}
			if (browserList == BrowserList.BROWSER_DEFAULT) {
				for (BrowserList browser : BrowserList.values()) {
					if (browser.toString().toLowerCase()
							.contains(applicationSources.getBrowserName().toLowerCase())) {
						browserList = browser;
						break;
					}
				}
			}
		}
		return browserList;
	}

	private void startBrowser(BrowserList browserList, ApplicationSources applicationSources) {
		this.browsers.put(Thread.currentThread().getId(), browserList.getInstance(applicationSources));
	}

}
