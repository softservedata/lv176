package com.softserve.edu.rs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	
	protected WebDriver driver;
	//
	@FindBy(id = "changeLanguage")
	private WebElement changeLanguage;

	public TopPage(WebDriver driver) {
		this.driver = driver;
		//
		//this.changeLanguage = new Select(driver.findElement(By.id("changeLanguage")));
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

	public void setChangeLanguage(ChangeLanguageFields language) {
		getChangeLanguage().selectByVisibleText(language.toString());
	}

}
