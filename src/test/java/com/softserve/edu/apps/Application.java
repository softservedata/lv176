package com.softserve.edu.apps;

import com.softserve.edu.atqc.data.apps.ABaseApplication;
import com.softserve.edu.atqc.data.apps.ApplicationSources;
import com.softserve.edu.atqc.tools.BrowserUtils;
import com.softserve.edu.rs.pages.LoginPage;
import com.softserve.edu.rs.pages.NonConfirmedUsersPage;
import com.softserve.edu.rs.pages.ProfilUserPage;
import com.softserve.edu.rs.pages.TopPage.ChangeLanguageFields;

public final class Application extends ABaseApplication<LoginPage> {

	private ChangeLanguageFields changeLanguageFields = ChangeLanguageFields.ENGLISH;

	protected Application(ApplicationSources applicationSources) {
		super(applicationSources);
		setChangeLanguageFields(applicationSources.getLanguage());
	}

	public static Application get(ApplicationSources applicationSources) {
		return new Application(applicationSources);
	}

	protected LoginPage getStartPage() {
		LoginPage loginPage = new LoginPage();
		return loginPage.changeLanguage(changeLanguageFields);
	}

	public ChangeLanguageFields getChangeLanguageFields() {
		return changeLanguageFields;
	}

	private void setChangeLanguageFields(String language) {
    	for (ChangeLanguageFields languageField : ChangeLanguageFields.values()) {
    		if (languageField.toString().contains(language)) {
    			changeLanguageFields = languageField;
    		}
    	}
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
