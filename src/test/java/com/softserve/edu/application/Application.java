package com.softserve.edu.application;

import com.softserve.edu.atqc.data.apps.ABaseApplication;
import com.softserve.edu.atqc.data.apps.ApplicationSources;
import com.softserve.edu.atqc.tools.BrowserUtils;
import com.softserve.edu.rs.pages.LoginPage;
import com.softserve.edu.rs.pages.NonConfirmedUsersPage;
import com.softserve.edu.rs.pages.ProfilUserPage;

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
	
	public NonConfirmedUsersPage loadNonConfirmedUsersPage() {
		BrowserUtils.get().getBrowser().loadPage("http://localhost:8080/resources/administrator/users/get-all-users?statusType=notcomfirmed");
		return new NonConfirmedUsersPage();
	}
	
	public ProfilUserPage gotoEditPage(String login) {
		BrowserUtils.get().getBrowser().loadPage("http://localhost:8080/resources/administrator/users/edit-registrated-user/?login=" + login);
		return new ProfilUserPage();
	}

}
