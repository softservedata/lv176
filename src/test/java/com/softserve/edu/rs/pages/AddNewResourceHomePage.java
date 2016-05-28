package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ILabelClickable;
import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.ISelect;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.LabelClickable;
import com.softserve.edu.atqc.controls.Link;
import com.softserve.edu.atqc.controls.Select;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.rs.data.testdata.CoordinatesData;
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
	
	private class AddNewResourceHomePageUIMap {
		public final ITextField selectUser;
		public final ITextField objectName;
		public final ISelect objectSubclas;
		public final ITextField numberObject;
		public final IButton btnEdit;
		public final ITextField textarea;
		public final ILabelClickable procurations;
		public final ILabelClickable passport;
		public final ILink map;
		public final ILink points;
		public final ILink perimetrSquare;
		public final ILabelClickable  btnSaveForm;
		
		
    	
    	public AddNewResourceHomePageUIMap() {
    		this.selectUser = TextField.get().getById("owner_search");
    		this.objectName = TextField.get().getById("w-input-search");
    		this.objectSubclas = Select.get().getById("resourcesTypeSelect"); 
    		this.numberObject = TextField.get().getById("identifier");
    		this.btnEdit = Button.get().getById("editNumber");
    		this.textarea = TextField.get().getById("reasonInclusion");
    		this.procurations = LabelClickable.get().getById("delivery");
    		this.passport = LabelClickable.get().getById("pass");
    		this.map = Link.get().getByXpath("//a[contains(@data-target,'#map')]");
    		this.points = Link.get().getByXpath("//a[contains(@data-target,'#points')]");
    		this.perimetrSquare = Link.get().getPresentByXpath("//a[contains(@data-target,'#calculatedParams')]");
    		this.btnSaveForm = LabelClickable.get().getById("submitForm");
    	}
    }
	

	// Elements
    private AddNewResourceHomePageUIMap controls;

	public AddNewResourceHomePage() {
		this.controls = new AddNewResourceHomePageUIMap();
	}
	
	
	// PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	// Get Elements
	

	public ISelect getChangeObjectSubclas() {
		return this.controls.objectSubclas;
	}

	public String getChangeObjectSubclasSelectedText() {
		return getChangeObjectSubclas().getFirstSelectedOption().getText();
	}
	
	public ITextField getSelectUser() {
		return this.controls.selectUser;
	}
	
	public ITextField getObjectName() {
		return this.controls.objectName;
	}
	
	public ITextField getNumberObject() {
		return this.controls.numberObject;
	}
	
	public IButton getBtnEdit() {
		return this.controls.btnEdit;
	}
	
	public ITextField getTextarea() {
		return this.controls.textarea;
	}
	
	public ILabelClickable getProcurations() {
		return this.controls.procurations;
	}
	
	public ILabelClickable getPassport() {
		return this.controls.passport;
	}
	
	public ILink getMap() {
		return this.controls.map;
	}
	
	public ILink getPoints() {
		return this.controls.points;
	}
	
	public ILink getPerimetrSquare() {
		return this.controls.perimetrSquare;
	}
	
	public ILabelClickable getBtnSaveForm() {
		return this.controls.btnSaveForm;
	}
	
	public String getTextAreaText() {
		return getTextarea().getAttribute("value");
	}
	
	public String getNumberObjectText() {
		return getNumberObject().getAttribute("value");
	}
	
	
	// Set Elements

	public void setChangeObjectSubclas(ChangeObjectSubclas objectSubclas) {
		getChangeObjectSubclas().selectByVisibleText(objectSubclas.toString());
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
		getPerimetrSquare().click();
	}
	
	public void clickBtnSaveForm() {
		getBtnSaveForm().click();
	}
	
	public void setSelectUserClear(String userName) {
		getSelectUser().sendKeysClear(userName);
	}
	
	public void setObjectNameClear(String objectName) {
		getObjectName().sendKeysClear(objectName);
	}
	
	public void setNumberObjectClear(String numberObject) {
		getNumberObject().sendKeysClear(numberObject);
	}
	

	// Business Logic
	// Functional

	
	public AddNewResourceHomePage selectObjectSubclas(ChangeObjectSubclas objectSubclas) {
		AddNewResourceHomePage page = null;
		if (objectSubclas.equals(ChangeObjectSubclas.LANDED)){
			setChangeObjectSubclas(ChangeObjectSubclas.LANDED);
			clickPerimetrSquare();
			page =  new SquarePerimetrPage();
			
		}
			
		if (objectSubclas.equals(ChangeObjectSubclas.RADIOFREGUENCY)){
			setChangeObjectSubclas(ChangeObjectSubclas.RADIOFREGUENCY);
			page =  new RadioFrequencyPage();
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
		return new MapPage();
	}

	public PointsPage gotoPointsPage() {
		clickPoints();
		return new PointsPage();
	}
	
	
	public void setData(IUser user, IUser registrator, ResourceData resourceData, CoordinatesData coordinates){
		
		clickSelectUser();
		setSelectUserClear(user.getAccount().getLogin());
		
		clickObjectName();
		setObjectNameClear(resourceData.getResourceName());
		
		clickBtnEdit();
		clickNumberObject();
		setNumberObjectClear(registrator.getAccount().getRegistratorNumber()+resourceData.getResourceNumber());
		
		clickProcurations();
		
		PointsPage pointsPage = gotoPointsPage();
		
		pointsPage.enterPoints(coordinates);
		
		String square = pointsPage.gotoMapPage().getSquareTerrText();
		String perimetr = pointsPage.gotoMapPage().getPerimetrTerrText();
		
		SquarePerimetrPage squarePerimetrPage =(SquarePerimetrPage) pointsPage
				.selectObjectSubclas(ChangeObjectSubclas.LANDED);
		
		squarePerimetrPage.setDataPerSq(square, perimetr);
		
		clickBtnSaveForm();
		
	}
	
	
	public ResourcePage successGotoResource(IUser user, IUser registrator, ResourceData resourceData, CoordinatesData coordinates){
		setData(user, registrator, resourceData, coordinates);
		return new ResourcePage();
	}
	
	public AddNewResourceValidatorPage unsuccessRegistratorNumber(IUser user, IUser registrator,
			 ResourceData invalidresourceData, CoordinatesData coordinates){
		setData(user, registrator, invalidresourceData, coordinates);
		return new AddNewResourceValidatorPage();
	}

}
