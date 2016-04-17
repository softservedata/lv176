package com.softserve.edu.rs.pages.regist;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.rs.data.testdata.ResourceData;
import com.softserve.edu.rs.data.users.IUser;

public class AddNewResourceHomePage extends RegistratorHomePage {

	public static enum ChangeObjectSubclas {
		LANDED("земельний"), RADIOFREGUENCY("радіочастотний");

		//
		private String field;

		private ChangeObjectSubclas(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}
	
	@FindBy(id = "resourcesTypeSelect")
	private WebElement objectSubclas;
	@FindBy(id = "reasonInclusion")
	private WebElement textarea;
	@FindBy(id = "delivery")
	private WebElement procurations;
	@FindBy(id = "pass")
	private WebElement passport;
	@FindBy(xpath = "//a[contains(@data-target,'#map')]")
	private WebElement map;
	@FindBy(xpath = "//a[contains(@data-target,'#points')]")
	private WebElement points;
	@FindBy(xpath = "//a[contains(@data-target,'#calculatedParams')]")
	private WebElement perimetrSquare;
	
	@FindBy(id = "owner_search")
	private WebElement selectUser;
	@FindBy(id = "w-input-search")
	private WebElement objectName; 
	@FindBy(id = "identifier")
	private WebElement numberObject;
	@FindBy(id = "editNumber")
	private WebElement btnEdit; 
	@FindBy(id = "submitForm")
	private WebElement btnSaveForm; 

	public AddNewResourceHomePage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
	}

	// Get Elements

	public Select getChangeObjectSubclas() {
		return new Select(objectSubclas);
	}

	public String getChangeObjectSubclasSelectedText() {
		return getChangeObjectSubclas().getFirstSelectedOption().getText();
	}

	public WebElement getTextArea() {
		return this.textarea;
	}

	public WebElement getProcurations() {
		return this.procurations;
	}

	public WebElement getPassport() {
		return this.passport;
	}

	public WebElement getMap() {
		return this.map;
	}

	public WebElement getPoints() {
		return this.points;
	}
	
	public WebElement getPerimetrSuare() {
		return this.perimetrSquare;
	}
	
	public String getTextAreaText() {
		return this.textarea.getAttribute("value");
	}
	
	public WebElement getSelectUser() {
		return this.selectUser;
	}
	
	public WebElement getObjectName() {
		return this.objectName;
	}
	
	public WebElement getNumberObject() {
		return this.numberObject;
	}
	
	public WebElement getBtnEdit() {
		return this.btnEdit;
	}
	
	
	public WebElement getBtnSaveForm() {
		return this.btnSaveForm;
	}
	
	public String getNumberObjectText() {
		return this.numberObject.getAttribute("value");
	}
	

	

	// Set Elements

	public void setChangeObjectSubclas(ChangeObjectSubclas objectSubclas) {
		getChangeObjectSubclas().selectByVisibleText(objectSubclas.toString());
	}
	
	public void clickProcurations() {
		getProcurations().click();
	}

	public void clickPassport() {
		getPassport().click();
	}

	public void clickMap() {
		getMap().click();
	}
	
	public void clickPoints() {
		getPoints().click();
	}
	
	public void clickPerimetrSquare() {
		getPerimetrSuare().click();
	}
	
	public void clickSelectUser() {
		getSelectUser().click();
	}
	
	public void clickObjectName() {
		getObjectName().click();
	}
	
	public void clickNumberObject() {
		getNumberObject().click();
	}
	
	public void clickBtnEdit() {
		getBtnEdit().click();
	}
	
	public void clickBtnSaveForm() {
		getBtnSaveForm().click();
	}
	
	public void clearSelectUser() {
		getSelectUser().clear();
	}
	
	public void clearObjectName() {
		getObjectName().clear();
	}
	
	public void clearNumberObject() {
		getNumberObject().clear();
	}
	
	public void setSelectUser(String value) {
		getSelectUser().sendKeys(value);
	}
	
	public void setObjectName(String value) {
		getObjectName().sendKeys(value);
	}
	
	public void setNumberObject(String value) {
		getNumberObject().sendKeys(value);
	}

	// Business Logic
	// Functional

	
	public AddNewResourceHomePage selectObjectSubclas(ChangeObjectSubclas objectSubclas) {
		AddNewResourceHomePage page = null;
		if (objectSubclas.equals(ChangeObjectSubclas.LANDED)){
			setChangeObjectSubclas(ChangeObjectSubclas.LANDED);
			clickPerimetrSquare();
			page =  new SquarePerimetrPage(driver);
			
		}
			
		if (objectSubclas.equals(ChangeObjectSubclas.RADIOFREGUENCY)){
			setChangeObjectSubclas(ChangeObjectSubclas.RADIOFREGUENCY);
			page =  new RadioFrequencyPage(driver);
		}
			
		return page;
	}  
	
	public String oneClicProcurations() {
		clickProcurations();
		String[] parts = getTextAreaText().split(";");
		return parts[0];
	}
	
	public String twoClicProcurations() {
		clickProcurations();
		return getTextAreaText();
	}
	
	public String oneClicPassport(){
		clickPassport();
		return getTextAreaText();
	}

	public MapPage gotoMapPage() {
		clickMap();
		return new MapPage(driver);
	}

	public PointsPage gotoPointsPage() {
		clickPoints();
		return new PointsPage(driver);
	}
	

	public PointsPage setDataGoPointPage(IUser user, IUser registrator, ResourceData resourceData){
		
		clickSelectUser();
		clearSelectUser();
		setSelectUser(user.getAccount().getLogin());
		
		clickObjectName();
		clearObjectName();
		setObjectName(resourceData.getResourceName());
		
		clickBtnEdit();
		clickNumberObject();
		clearNumberObject();
		setNumberObject(registrator.getAccount().getRegistratorNumber()+resourceData.getResourceNumber());
		
		clickProcurations();
		return gotoPointsPage();
	}
	
	public ResourcePage gotoResource(){
		clickBtnSaveForm();
		return new ResourcePage(driver);
	}
	
	

}
