package com.softserve.edu.atqc.data.apps;

import com.softserve.edu.atqc.loggers.LoggerUtils;
import com.softserve.edu.atqc.tools.BrowserUtils;
import com.softserve.edu.atqc.tools.ControlSearch;

public abstract class ABaseApplication<TApplication> {
	private ApplicationSources applicationSources;

	protected ABaseApplication(ApplicationSources applicationSources) {
		this.applicationSources = applicationSources;
		BrowserUtils.get(applicationSources);
		// TODO Set strategy, etc.
	}

	protected abstract TApplication getStartPage();

	public ApplicationSources getApplicationSources() {
		return this.applicationSources;
	}

	protected void setSearchStrategy() {
		ControlSearch.get(getApplicationSources());
	}

	protected void setLoggerStrategy() {
		LoggerUtils.get(getApplicationSources());
	}

	public TApplication load() {
		if (BrowserUtils.get().getBrowser().getCurrentUrl().contains(getApplicationSources().getServerUrl())
				&& (!BrowserUtils.get().getBrowser().getCurrentUrl().contains(getApplicationSources().getLoginUrl()))) {
			logout();
		}
		BrowserUtils.get().getBrowser().loadPage(getApplicationSources().getLoginUrl());
		setSearchStrategy();
		setLoggerStrategy();
		return getStartPage();
	}

	public TApplication logout() {
		BrowserUtils.get().getBrowser().loadPage(getApplicationSources().getLogoutUrl());
		return getStartPage();
	}

	public void quit() {
		BrowserUtils.get().quitBrowser();
	}

	public static void quitAll() {
		BrowserUtils.quitAll();
	}

//	public void addEventsPageLoadComplete() {
//		PageObserveLoad.get().addLoadCompleteEvent(new PageLoadComplete());
//		// PageObserveLoad.get().addLoadCompleteEvent(new PageLoadComplete2());
//	}
//
//	public void clearEventsPageLoadComplete() {
//		PageObserveLoad.get().deleteLoadCompleteEvents();
//	}

}
