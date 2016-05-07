package com.softserve.edu.atqc.data.apps;

import com.softserve.edu.atqc.tools.BrowserUtils;
import com.softserve.edu.rs.pages.NonConfirmedUsersPage;

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

	public TApplication load() {
		if (BrowserUtils.get().getBrowser().getCurrentUrl().contains(applicationSources.getServerUrl())
				&& (!BrowserUtils.get().getBrowser().getCurrentUrl().contains(applicationSources.getLoginUrl()))) {
			logout();
		}
		BrowserUtils.get().getBrowser().loadPage(applicationSources.getLoginUrl());
		return getStartPage();
	}

	public TApplication logout() {
		BrowserUtils.get().getBrowser().loadPage(applicationSources.getLogoutUrl());
		return getStartPage();
	}
	
	public NonConfirmedUsersPage loadNonConfirmedUsersPage() {
		BrowserUtils.get().getBrowser().loadPage("http://localhost:8080/resources/administrator/users/get-all-users?statusType=notcomfirmed");
		return new NonConfirmedUsersPage();
	}

	public void quit() {
		BrowserUtils.get().quitBrowser();
	}

	public static void quitAll() {
		BrowserUtils.quitAll();
	}

}
