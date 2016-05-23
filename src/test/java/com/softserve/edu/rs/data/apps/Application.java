package com.softserve.edu.rs.data.apps;

import com.softserve.edu.atqc.data.apps.ABaseApplication;
import com.softserve.edu.atqc.data.apps.ApplicationSources;
import com.softserve.edu.rs.pages.LoginPage;

public final class Application extends ABaseApplication<LoginPage> {

	protected Application(ApplicationSources applicationSources) {
		super(applicationSources);
	}

	public static Application get(ApplicationSources applicationSources) {
		return new Application(applicationSources);
	}

	protected LoginPage getStartPage() {
		return new LoginPage();
	}

}
