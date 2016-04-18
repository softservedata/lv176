package com.softserve.edu.rs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public abstract class TopPage extends AbstractAppPage {
	
	public static enum ChangeLanguageFields {
        UKRAINIAN("українська"),
        RUSSIAN("русский"),
        ENGLISH("english");
        
        private String field;

        private ChangeLanguageFields(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }

	private WebElement changeLanguage;

	public TopPage(WebDriver driver) {
		super(driver);
		this.changeLanguage = findById("changeLanguage");
	}
	

	// Get Elements

	public Select getChangeLanguage() {
		return new Select(changeLanguage);
	}

	public String getChangeLanguageSelectedText() {
		return getChangeLanguage().getFirstSelectedOption().getText();
	}

	// Set Data

	public void setChangeLanguage(ChangeLanguageFields language) {
		getChangeLanguage().selectByVisibleText(language.toString());
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
