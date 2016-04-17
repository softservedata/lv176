package com.softserve.edu.rs.pages.regist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.softserve.edu.rs.data.testdata.CoordinatesData;

public class PointsPage extends AddNewResourceHomePage {
   
	@FindBy(xpath = "//div[@id='areaInput1']/div[2]/input")
	private WebElement p1LatitudeGrad;
	@FindBy(xpath = "//div[@id='areaInput1']/div[5]/input")
	private WebElement p1LongitudeGrad;

	@FindBy(xpath = "//div[@id='areaInput2']/div[2]/input")
	private WebElement p2LatitudeGrad;
	@FindBy(xpath = "//div[@id='areaInput2']/div[5]/input")
	private WebElement p2LongitudeGrad;

	@FindBy(xpath = "//div[@id='areaInput3']/div[2]/input")
	private WebElement p3LatitudeGrad;
	@FindBy(xpath = "//div[@id='areaInput3']/div[5]/input")
	private WebElement p3LongitudeGrad;


	@FindBy(id = "btnAddAreaPoint")
	private WebElement addPoint;
	@FindBy(id = "addPointsToMap")
	private WebElement showOnMap;
	@FindBy(id = "delAllPolygons")
	private WebElement dellAllTer;

	public PointsPage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
	}

	// Get Elements

	public WebElement getP1LatitudeGrad() {
		return this.p1LatitudeGrad;
	}



	public WebElement getP1LongitudeGrad() {
		return this.p1LongitudeGrad;
	}



	public WebElement getP2LatitudeGrad() {
		return this.p2LatitudeGrad;
	}



	public WebElement getP2LongitudeGrad() {
		return this.p2LongitudeGrad;
	}



	public WebElement getP3LatitudeGrad() {
		return this.p3LatitudeGrad;
	}



	public WebElement getP3LongitudeGrad() {
		return this.p3LongitudeGrad;
	}



	public WebElement getAddPoint() {
		return this.addPoint;
	}

	public WebElement getShowOnMap() {
		return this.showOnMap;
	}
	
	public WebElement getDelAllter() {
		return this.dellAllTer;
	}
	
	public String getDellAllTerText(){
		return getDelAllter().getText();
	}
	

	// Set Elements

	public void clicP1LatitudeGrad() {
		getP1LatitudeGrad().click();
	}


	public void clicP1LongitudeGrad() {
		getP1LongitudeGrad().click();
	}



	public void clicP2LatitudeGrad() {
		getP2LatitudeGrad().click();
	}



	public void clicP2LongitudeGrad() {
		getP2LongitudeGrad().click();
	}



	public void clicP3LatitudeGrad() {
		getP3LatitudeGrad().click();
	}



	public void clicP3LongitudeGrad() {
		getP3LongitudeGrad().click();
	}



	public void clickAddPoint() {
		getAddPoint().click();
	}

	public void clickShowOnMap() {
		getShowOnMap().click();
	}
	
	public void clickDelAllTer() {
		getDelAllter().click();
	}

	public void clearP1LatitudeGrad() {
		getP1LatitudeGrad().clear();
	}



	public void clearP1LongitudeGrad() {
		getP1LongitudeGrad().clear();
	}



	public void clearP2LatitudeGrad() {
		getP2LatitudeGrad().clear();
	}



	public void clearP2LongitudeGrad() {
		getP2LongitudeGrad().clear();
	}



	public void clearP3LatitudeGrad() {
		getP3LatitudeGrad().clear();
	}


	public void clearP3LongitudeGrad() {
		getP3LongitudeGrad().clear();
	}

	

	public void setP1LatitudeGrad(String grad) {
		getP1LatitudeGrad().sendKeys(grad);
	}



	public void setP1LongitudeGrad(String grad) {
		getP1LongitudeGrad().sendKeys(grad);
	}



	public void setP2LatitudeGrad(String grad) {
		getP2LatitudeGrad().sendKeys(grad);
	}


	public void setP2LongitudeGrad(String grad) {
		getP2LongitudeGrad().sendKeys(grad);
	}


	public void setP3LatitudeGrad(String grad) {
		getP3LatitudeGrad().sendKeys(grad);
	}


	public void setP3LongitudeGrad(String grad) {
		getP3LongitudeGrad().sendKeys(grad);
	}


	// Business Logic
	// Functional

	public void enterPoints(CoordinatesData coordinates) {

		clicP1LatitudeGrad();
		clearP1LatitudeGrad();
		setP1LatitudeGrad(coordinates.getP1LatitudeGrad());
		
		clicP1LongitudeGrad();
		clearP1LongitudeGrad();
		setP1LongitudeGrad(coordinates.getP1LLongitudeGrad());

		
		clickAddPoint();
		
		clicP2LatitudeGrad();
		clearP2LatitudeGrad();
		setP2LatitudeGrad(coordinates.getP2LatitudeGrad());

		
		clicP2LongitudeGrad();
		clearP2LongitudeGrad();
		setP2LongitudeGrad(coordinates.getP2LLongitudeGrad());

		
		clickAddPoint();
		
		clicP3LatitudeGrad();
		clearP3LatitudeGrad();
		setP3LatitudeGrad(coordinates.getP3LatitudeGrad());
		

		
		clicP3LongitudeGrad();
		clearP3LongitudeGrad();
		setP3LongitudeGrad(coordinates.getP3LLongitudeGrad());
		
		clickShowOnMap();
		
	}

}
