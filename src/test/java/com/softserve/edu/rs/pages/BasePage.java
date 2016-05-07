package com.softserve.edu.rs.pages;


import org.openqa.selenium.support.ui.Select;

public abstract class BasePage {

	public static enum ChangeLanguageFields {
		UKRAINIAN("українська"), 
		RUSSIAN("російська"), 
		ENGLISH("english");

		private String language;

		private ChangeLanguageFields(String language) {
			this.language = language;
		}

		@Override
		public String toString() {
			return this.language;
		}
	}
	
	private class BasePageUIMap {
    	//public final Select changeLanguage;
    	// TODO Develop select component
    	public Select changeLanguage;
    	
    	public BasePageUIMap() {
    		//this.changeLanguage = new Select(driver.findElement(By.id("changeLanguage")));
    	}
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
    // Elements
    private BasePageUIMap controls;

	public  BasePage() {
		this.controls = new BasePageUIMap();
	}

	public Select getChangeLanguage() {
		return this.controls.changeLanguage;
	}

	public String getChangeLanguageSelectedText() {
		return getChangeLanguage().getFirstSelectedOption().getText();
	}

	public void setChangeLanguage(ChangeLanguageFields language) {
		getChangeLanguage().selectByVisibleText(language.toString());
	}
}
