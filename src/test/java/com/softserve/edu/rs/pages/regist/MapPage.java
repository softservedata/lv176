package com.softserve.edu.rs.pages.regist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MapPage extends AddNewResourceHomePage {
	
	@FindBy(id = "mapManual")
	private WebElement instrUsingMapButt;
	@FindBy(css = "div.spoiler.col-md-12")
	private WebElement instrUsingMap;
	@FindBy(xpath = "//span[@id='infoBox']/div/span[1]")
	private  WebElement squareTerr;
	@FindBy(xpath = "//span[@id='infoBox']/div/span[2]")
	private  WebElement perimetrTerr;

	public MapPage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
	}

	// Get Elements

	public WebElement getInstrUsingMapButt() {
		return this.instrUsingMapButt;
	}

	public WebElement getInstrUsingMap() {
		return this.instrUsingMap;
	}

	public String getInstrUsingMapText() {
		return getInstrUsingMap().getText();
	}
	
	public WebElement getSquareTerr() {
		return this.squareTerr;
	}
	
	public WebElement getPerimetrTerr() {
		return this.perimetrTerr;
	}

	public String getSquareTerrText() {
		
		String text = this.squareTerr.getText();
		return text.substring(text.indexOf(" ")+1, text.lastIndexOf(" "));
	}
	
	public String getPerimetrTerrText() {
		
		String text = this.perimetrTerr.getText();
		return text.substring(text.indexOf(" ")+1, text.lastIndexOf(" "));
	}
	
	// Set Data

	public void clicInstrUsingMapButt() {
		getInstrUsingMapButt().click();
	}
	
	
	// Business Logic
	// Functional
	
	public String verifyInstrUsingMap(){
		clicInstrUsingMapButt();
		return getInstrUsingMapText().substring(0, getInstrUsingMapText().indexOf('.'));
	}
	
	
	

}
