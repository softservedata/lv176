package com.softserve.edu.rs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public abstract class TopPage2 {

	public static enum ChangeLanguageFields2 {
        UKRAINIAN("українська"),
        RUSSIAN("русский"),
        ENGLISH("english");
        //
        private String field;

        private ChangeLanguageFields2(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return this.field;
        }
    }
	
	protected WebDriver driver;
	//
	@FindBy(id = "changeLanguage")
	private WebElement changeLanguage;

	public TopPage2(WebDriver driver) {
		this.driver = driver;
		//
		PageFactory.initElements(driver, this);
	}

	// Get Elements

	public Select getChangeLanguage() {
		return new Select(changeLanguage);
	}

	public String getChangeLanguageSelectedText() {
		return getChangeLanguage().getFirstSelectedOption().getText();
	}

	// Set Data

	public void setChangeLanguage(ChangeLanguageFields2 language) {
		getChangeLanguage().selectByVisibleText(language.toString());
	}

}
