package com.softserve.edu.rs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

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
		
    	//public final Select changeLanguage;
    	// TODO Develop select component
    	public Select changeLanguage;
    	
    	public TopPageUIMap() {
    		//this.changeLanguage = new Select(driver.findElement(By.id("changeLanguage")));
    	}
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
    // Elements
    private TopPageUIMap controls;
    protected WebDriver driver;
    
	public TopPage(WebDriver driver) {
		this.driver = driver;
		this.controls = new TopPageUIMap();
	}

    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Get Elements

	public Select getChangeLanguage() {
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
