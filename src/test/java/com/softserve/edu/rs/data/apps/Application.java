package com.softserve.edu.rs.data.apps;

import com.softserve.edu.atqc.data.apps.ABaseApplication;
import com.softserve.edu.atqc.data.apps.ApplicationSources;
import com.softserve.edu.rs.pages.LoginPage;
import com.softserve.edu.rs.pages.TopPage.ChangeLanguageFields;

public final class Application extends ABaseApplication<LoginPage> {
	//TODO Develop Singleton and use for all Threads 
	//private static volatile Application instance = null;
	//private final HashMap<Long, List<ABaseApplication<LoginPage>>> applications;
	//
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

}
