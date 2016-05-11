package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.ISelect;
import com.softserve.edu.atqc.controls.SelectField;

public abstract class TopPage {

	public static enum ChangeLanguageFields {
        UKRAINIAN("українська"),
        RUSSIAN("русский"),
        ENGLISH("english");
        //
        private String field;

        private ChangeLanguageFields(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }
	
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	private class TopPageUIMap {
 
    	public final ISelect changeLanguage;
    	
    	public TopPageUIMap() {
    		this.changeLanguage = SelectField.get().getById("changeLanguage");
    	}
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
    // Elements
    private TopPageUIMap controls;

	public TopPage() {
		this.controls = new TopPageUIMap();
	}

    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Get Elements

	public ISelect getChangeLanguage() {
		return this.controls.changeLanguage;
	}

	public String getChangeLanguageSelectedText() {
		return getChangeLanguage().getFirstSelectedOption().getText();
	}

	// Set Data

	public void setChangeLanguage(ChangeLanguageFields language) {
		getChangeLanguage().selectByVisibleText(language.toString());
	}

}
