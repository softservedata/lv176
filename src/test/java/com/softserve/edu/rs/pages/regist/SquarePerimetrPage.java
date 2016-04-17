package com.softserve.edu.rs.pages.regist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class SquarePerimetrPage extends AddNewResourceHomePage {

	@FindBy(xpath = "//input[@name='resourceDiscrete[0].valueDiscretes[0].value']")
	private WebElement perimetr;
	@FindBy(xpath = "//input[@name='resourceDiscrete[1].valueDiscretes[0].value']")
	private WebElement square;

	public SquarePerimetrPage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
	}

	// Get Elements

	public WebElement getPerimetr() {
		return this.perimetr;
	}

	public WebElement getSquare() {
		return this.square;
	}

	// Set Elements

	public void clickPerimetr() {
		getPerimetr().click();
	}
	
	public void clickSquare() {
		getSquare().click();
	}
	
	public void clearPerimetr() {
		getPerimetr().clear();
	}
	
	public void clearSquare() {
		getSquare().clear();
	}
	
	public void setPerimetr(String value){
		getPerimetr().sendKeys(value);
	}
	
	public void setSquare(String value){
		getSquare().sendKeys(value);
	}
	
	public void setDataPerSq(String square, String perimetr){
		clickPerimetr();
		clearPerimetr();
		setPerimetr(perimetr);
		
		clickSquare();
		clearSquare();
		setSquare(square);
	}
	
	

}
