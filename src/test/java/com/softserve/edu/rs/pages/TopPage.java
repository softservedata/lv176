package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.atqc.tools.BrowserUtils;

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
//    		try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
    		this.changeLanguage = new Select(BrowserUtils.get().getBrowser().getWebDriver().findElement(By.id("changeLanguage")));
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
