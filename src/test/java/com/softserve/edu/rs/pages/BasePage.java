package com.softserve.edu.rs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

	protected WebDriver webDriver;
	@FindBy(id = "changeLanguage")
	private WebElement changeLanguage;

	public BasePage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public Select getChangeLanguage() {
		return new Select(changeLanguage);
	}

	public String getChangeLanguageSelectedText() {
		return getChangeLanguage().getFirstSelectedOption().getText();
	}

	public void setChangeLanguage(ChangeLanguageFields language) {
		getChangeLanguage().selectByVisibleText(language.toString());
	}

}
