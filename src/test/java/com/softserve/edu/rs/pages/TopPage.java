package com.softserve.edu.rs.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

//import org.openqa.selenium.support.ui.Select;
import com.softserve.edu.atqc.controls.ILabelClickable;
import com.softserve.edu.atqc.controls.ISelect;
import com.softserve.edu.atqc.controls.Select;
import com.softserve.edu.atqc.data.apps.PageObserveLoad;

import com.softserve.edu.atqc.tools.BrowserUtils;

public abstract class TopPage {

	public static enum ChangeLanguageFields {
		UKRAINIAN("українська"), RUSSIAN("русский"), ENGLISH("english");
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
		// public final Select changeLanguage;
		// TODO Develop select component
		public ISelect changeLanguage;

		public TopPageUIMap() {
			// try {
			// Thread.sleep(5000);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// this.changeLanguage = new
			// Select(BrowserUtils.get().getBrowser().getWebDriver().findElement(By.id("changeLanguage")));
			this.changeLanguage = Select.get().getById("changeLanguage");
			// new Select(driver.findElement(By.id("changeLanguage")));
		}
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Elements
	private TopPageUIMap controls;

	public TopPage() {
		// TODO Add Observe
		PageObserveLoad.get().deleteLoadCompleteEvents();
		this.controls = new TopPageUIMap();
	}

	// PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Get Elements

	public ISelect getChangeLanguage() {
		return this.controls.changeLanguage;
	}

	public ILabelClickable getChangeLanguageSelected() {
		return getChangeLanguage().getFirstSelectedOption();
	}

	public String getChangeLanguageSelectedText() {
		return getChangeLanguageSelected().getText();
	}

	// Set Data

	public void setChangeLanguage(ChangeLanguageFields language) {
		getChangeLanguage().selectByVisibleText(language.toString());
	}

	public void setChangeLanguageByPartialText(String partialText) {
		getChangeLanguage().selectByPartialText(partialText);
	}

	public void explWait() {
		Actions actions = new Actions(BrowserUtils.get().getBrowser().getWebDriver());
		actions.moveToElement(BrowserUtils.get().getBrowser().getWebDriver().findElement(By.id("showAllResources")), 1,
				1).click().build().perform();
		// spage.getSearchByParametersComponent().getBtnShowAll().click();
		BrowserUtils.get().getBrowser().getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
}
