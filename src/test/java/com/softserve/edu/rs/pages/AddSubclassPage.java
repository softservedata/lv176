package com.softserve.edu.rs.pages;

import org.openqa.selenium.By;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.ISelect;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.Label;
import com.softserve.edu.atqc.controls.SelectField;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.atqc.tools.BrowserUtils;
import com.softserve.edu.rs.data.resources.ISubclass;
import com.softserve.edu.rs.data.resources.ParameterType;

public class AddSubclassPage extends RegistratorHomePage {

	private class AddSubclassPageUIMap {
		public final ITextField subclassField;
		public final IButton showParameterBtn;
		public final IButton hideParameterBtn;
		public final IButton addParameterBtn;
		public final IButton delParameterBtn;
		public final IButton addNewSubclassBtn;
		public final IButton clearFormBtn;

		public AddSubclassPageUIMap() {
			this.subclassField = TextField.get().getByName("typeName");
			this.showParameterBtn = Button.get().getById("clickmeshow");
			this.hideParameterBtn = Button.get().getById("clickmehide");
			this.addParameterBtn = Button.get().getById("btnAdd");
			this.delParameterBtn = Button.get().getById("btnDel");
			this.addNewSubclassBtn = Button.get().getById("valid");
			this.clearFormBtn = Button.get().getByCssSelector("button.btn.btn-default");
		}
	}

	// ---------------------------------------------------------------------------------

	private class OptionsSubclassMenuUIMap {
		public final ITextField descriptionParametrField;
		public final ITextField unitOfMeasurementField;
		public final ISelect chooseTypeSelect;
		public final ILabel conteinerWithParameters;
		public final ILabel optionsTable;

		public OptionsSubclassMenuUIMap() {
			this.descriptionParametrField = TextField.get().getByName("parameters[0].description");
			this.unitOfMeasurementField = TextField.get().getByName("parameters[0].unitName");
			this.chooseTypeSelect = SelectField.get().getByName("parameters[0].parametersType");
			this.conteinerWithParameters = Label.get().getById("input1");
			this.optionsTable = Label.get().getByXpath("//*[@id='newrestype']/div[3]");
		}

		public OptionsSubclassMenuUIMap(int i) {
			this.descriptionParametrField = TextField.get().getByName("parameters[" + (i - 1) + "].description");
			this.unitOfMeasurementField = TextField.get().getByName("parameters[" + (i - 1) + "].unitName");
			this.chooseTypeSelect = SelectField.get().getByName("parameters[" + (i - 1) + "].parametersType");
			this.conteinerWithParameters = Label.get().getById("input1");
			this.optionsTable = Label.get().getByXpath("//*[@id='newrestype']/div[3]");
		}
	}

	// ---------------------------------------------------------------------------------

	private AddSubclassPageUIMap controls;
	private OptionsSubclassMenuUIMap optionsSubclassMenuUIMap;

	public AddSubclassPage() {
		controls = new AddSubclassPageUIMap();
	}
	
	// PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Get Elements

	public ITextField getSubclassField() {
		return this.controls.subclassField;
	}

	public IButton getShowParameterBtn() {
		return this.controls.showParameterBtn;
	}

	public IButton getHideParameterBtn() {
		return this.controls.hideParameterBtn;
	}

	public IButton getAddParameterBtn() {
		return this.controls.addParameterBtn;
	}

	public IButton getDelParameterBtn() {
		return this.controls.delParameterBtn;
	}

	public IButton getAddNewSubclassBtn() {
		return this.controls.addNewSubclassBtn;
	}

	public IButton getClearFormBtn() {
		return this.controls.clearFormBtn;
	}

	public String getSubclassFieldText() {
		return getSubclassField().getText();
	}

	// ---------------------------------------------------------------------------------

	public ILabel getConteinerWithParameters() {
		return this.optionsSubclassMenuUIMap.conteinerWithParameters;
	}

	public ILabel getOptionsTable() {
		return this.optionsSubclassMenuUIMap.optionsTable;
	}
	
	public ITextField getDescriptionParametrField() {
		return this.optionsSubclassMenuUIMap.descriptionParametrField;
	}

	public ITextField getUnitOfMeasurementField() {
		return this.optionsSubclassMenuUIMap.unitOfMeasurementField;
	}

	public ISelect getChooseTypeSelect() {
		return this.optionsSubclassMenuUIMap.chooseTypeSelect;
	}

	public String getDescriptionParametrFieldText() {
		return getDescriptionParametrField().getText();
	}

	public String getUnitOfMeasurementFieldText() {
		return getUnitOfMeasurementField().getText();
	}

	public int getElementCount() {
		return BrowserUtils.get().getBrowser().getWebDriver().findElement(By.xpath("//*[@id='newrestype']/div[3]"))
			.findElements(By.tagName("div")).size();
	}

	// Set Data

	public void setSubclass(String subclass) {
		getSubclassField().sendKeys(subclass);
	}

	public void setDescriptionParametr(String descriptionParametr) {
		getDescriptionParametrField().sendKeys(descriptionParametr);
	}

	public void setUnitOfMeasurement(String unitOfMeasurement) {
		getUnitOfMeasurementField().sendKeys(unitOfMeasurement);
	}

	public void setChooseTypeSelect(ParameterType parameterType ) {
		this.getChooseTypeSelect().selectByValue(parameterType.getValue());
	}

	// ---------------------------------------------------------------------------------
	
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
		this.optionsSubclassMenuUIMap = new OptionsSubclassMenuUIMap();
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

	// business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Functional
	
	public AddSubclassPage addNewSubclass(ISubclass subclass) {
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
		return new AddSubclassPage();
	}

	public AddSubclassPage clearSubParamUnitField() {
		clickClearFormBtn();
		return new AddSubclassPage();
	}

	public AddSubclassPage fillSubParamUnitField(ISubclass subclass, int parameterNumber) {
		this.optionsSubclassMenuUIMap = new OptionsSubclassMenuUIMap(parameterNumber);
		setDescriptionParametr(subclass.getDescriptionParametr());
		setUnitOfMeasurement(subclass.getUnitOfMeasurement());
		setChooseTypeSelect(subclass.getParameterType());
		return new AddSubclassPage();
	}
	
	public AddSubclassPage showParameter() {
		clickShowParameterBtn();
		return new AddSubclassPage();
	}

	public AddSubclassPage hideParameter() {
		clickHideParameterBtn();
		return new AddSubclassPage();
	}

	public AddSubclassPage addParameter() {
		clickAddParameterBtn();
		return new AddSubclassPage();
	}

	public AddSubclassPage delParameter() {
		clickDelParameterBtn();
		return new AddSubclassPage();
	}

	public SubclassesOfObjectsPage clickAddNewSubclass() {
		clickAddNewSubclassBtn();
		return new SubclassesOfObjectsPage();
	}
}
