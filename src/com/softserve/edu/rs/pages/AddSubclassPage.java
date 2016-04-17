package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.rs.data.resources.ISubclass;

public class AddSubclassPage extends RegistratorHomePage {
	private WebElement subclassField;
	private WebElement showParameterBtn;
	private WebElement hideParameterBtn;
	private WebElement addParameterBtn;
	private WebElement delParameterBtn;
	private WebElement addNewSubclassBtn;
	private WebElement clearFormBtn;
	private WebElement descriptionParametrField;
	private WebElement unitOfMeasurementField;
	private Select chooseTypeSelect;
	private WebElement conteinerWithParameters;
	private WebElement parameterTable;

	public AddSubclassPage(WebDriver driver) {
		super(driver);
		this.subclassField = driver.findElement(By.xpath("//*[@id='newrestype']/div[1]/div/input"));
		this.showParameterBtn = driver.findElement(By.id("clickmeshow"));
		this.hideParameterBtn = driver.findElement(By.id("clickmehide"));
		this.addParameterBtn = driver.findElement(By.id("btnAdd"));
		this.delParameterBtn = driver.findElement(By.id("btnDel"));
		this.addNewSubclassBtn = driver.findElement(By.id("valid"));
		this.clearFormBtn = driver.findElement(By.xpath("//*[@id='newrestype']/div[5]/button"));
		this.descriptionParametrField = driver.findElement(By.id("myparam0"));
		this.unitOfMeasurementField = driver.findElement(By.id("myparam1"));
		this.chooseTypeSelect = new Select(driver.findElement(By.id("myparam2")));
		this.conteinerWithParameters = driver.findElement(By.id("input1"));
		this.parameterTable = driver.findElement(By.xpath("//*[@id='newrestype']/div[3]"));
	}

	// get--------------------

	public WebElement getSubclassField() {
		return this.subclassField;
	}

	public WebElement getShowParameterBtn() {
		return this.showParameterBtn;
	}

	public WebElement getHideParameterBtn() {
		return this.hideParameterBtn;
	}

	public WebElement getAddParameterBtn() {
		return this.addParameterBtn;
	}

	public WebElement getDelParameterBtn() {
		return this.delParameterBtn;
	}

	public WebElement getAddNewSubclassBtn() {
		return this.addNewSubclassBtn;
	}

	public WebElement getClearFormBtn() {
		return this.clearFormBtn;
	}

	public WebElement getDescriptionParametrField() {
		return this.descriptionParametrField;
	}

	public WebElement getUnitOfMeasurementField() {
		return this.unitOfMeasurementField;
	}

	public Select getChooseTypeSelect() {
		return this.chooseTypeSelect;
	}

	public WebElement getConteinerWithParameters() {
		return this.conteinerWithParameters;
	}

	public WebElement getParameterTable() {
		return this.parameterTable;
	}

	public String getSubclassFieldText() {
		return this.subclassField.getText();
	}

	public String getDescriptionParametrFieldText() {
		return this.descriptionParametrField.getText();
	}

	public String getUnitOfMeasurementFieldText() {
		return this.unitOfMeasurementField.getText();
	}
	
	public int getElementCount()
	{
		return parameterTable.findElements(By.tagName("div")).size();
	}	

	// set-----------------------------

	public void setSubclass(String subclass) {
		getSubclassField().sendKeys(subclass);
	}

	public void setDescriptionParametr(String descriptionParametr) {
		getDescriptionParametrField().sendKeys(descriptionParametr);
	}
	
	public void setUnitOfMeasurement(String unitOfMeasurement) {
		getUnitOfMeasurementField().sendKeys(unitOfMeasurement);
	}

	public void clearSubclass() {
		getSubclassField().clear();
	}

	public void clearDescriptionParametr() {
		getDescriptionParametrField().clear();
	}

	public void clearUnitOfMeasurement() {
		getUnitOfMeasurementField().clear();
	}

	public void clickSubclassName() {
		getSubclassField().click();
	}

	public void clickDescriptionParametr() {
		getDescriptionParametrField().click();
	}

	public void clickUnitOfMeasurement() {
		getUnitOfMeasurementField().click();
	}

	public void clickShowParameterBtn() {
		getShowParameterBtn().click();
	}

	public void clickHideParameterBtn() {
		getHideParameterBtn().click();
	}

	public void clickAddParameterBtn() {
		getAddParameterBtn().click();
	}

	public void clickDelParameterBtn() {
		getDelParameterBtn().click();
	}

	public void clickAddNewSubclassBtn() {
		getAddNewSubclassBtn().click();
	}

	public void clickClearFormBtn() {
		getClearFormBtn().click();
	}

	// Business Logic ----------------

	public String visibleParametrsBlockVisible() {
		String check = conteinerWithParameters.getCssValue("display");
		return check;
	}
	
	public String readSubclassField() {
		return ((JavascriptExecutor) driver).executeScript("return document.getElementsByName('typeName')[0].value;").toString();
	}
	
	public String readDescriptionParametrField() {
		return ((JavascriptExecutor) driver).executeScript("return document.getElementById('myparam0').value;").toString();
	}
	
	public String readUnitOfMeasurementField() {
		return ((JavascriptExecutor) driver).executeScript("return document.getElementById('myparam1').value;").toString();
	}

	// Functional---------------------

	public ShowSubclassPage addNewSubclass(ISubclass subclass) {
		setSubclass(subclass.getSubclassName());
		if (!(subclass.getDescriptionParametr().equals(null) || subclass.getUnitOfMeasurement().equals(null))) {
			clickShowParameterBtn();
			if (!subclass.getDescriptionParametr().equals(null)) {
				setDescriptionParametr(subclass.getDescriptionParametr());
			}
			if (!subclass.getUnitOfMeasurement().equals(null)) {
				setUnitOfMeasurement(subclass.getUnitOfMeasurement());
			}
		}
		clickAddNewSubclassBtn();
		return new ShowSubclassPage(driver);
	}

	public AddSubclassPage clearSubParamUnitField(ISubclass subclass) {
		setSubclass(subclass.getSubclassName());
		setDescriptionParametr(subclass.getDescriptionParametr());
		setUnitOfMeasurement(subclass.getUnitOfMeasurement());
		clickClearFormBtn();
		return new AddSubclassPage(driver);
	}

	public AddSubclassPage showParameter() {
		clickShowParameterBtn();
		return new AddSubclassPage(driver);
	}

	public AddSubclassPage hideParameter() {
		clickHideParameterBtn();
		return new AddSubclassPage(driver);
	}

	public AddSubclassPage addParameter() {
		clickAddParameterBtn();
		return new AddSubclassPage(driver);
	}

	public AddSubclassPage delParameter() {
		clickDelParameterBtn();
		return new AddSubclassPage(driver);
	}
	
	public AddSubclassPage waitHideParameters(){
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
			webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("myparam0")));
			return new AddSubclassPage(driver);
		}
		
	public AddSubclassPage fillClearSubParamUnitField(ISubclass subclass) {
		setSubclass(subclass.getSubclassName());
		setDescriptionParametr(subclass.getDescriptionParametr());
		setUnitOfMeasurement(subclass.getUnitOfMeasurement());
		clickClearFormBtn();
		return new AddSubclassPage(driver);
	}
}
