package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.Label;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.rs.data.users.AddNewCommunity;

public class AddNewCommunityPage {

	private class AddNewCommunityPageUIMap {
		public final ITextField newCommunityField;
		public final ITextField newRegisterNumberField;
		public final IButton saveButtonCommunity;
		public final ILabel headPageAddNewCommunityPage;
		public final IButton clearButton;

		public AddNewCommunityPageUIMap() {
			this.newCommunityField = TextField.get().getByCssSelector(".col-sm-3 .form-control[required]");
			this.newRegisterNumberField = TextField.get()
					.getByCssSelector(".col-sm-3  .form-control[name='registrationNumber']");
			this.saveButtonCommunity = Button.get().getByCssSelector(".btn.btn-success");
			this.headPageAddNewCommunityPage = Label.get().getByCssSelector("div#body h2");
			this.clearButton = Button.get().getByCssSelector(".btn.btn-default");
		}
	}

	private class AddCommunityValidatorPageUIMap {
		public final ILabel validatorAddCommunity;

		public AddCommunityValidatorPageUIMap() {
			this.validatorAddCommunity = Label.get().getById("name.errors");
		}
	}

	private class AddRegNumberValidatorPageUIMap {
		public final ILabel validatorRegNumber;

		public AddRegNumberValidatorPageUIMap() {
			this.validatorRegNumber = Label.get().getById("registrationNumber.errors");
		}
	}

	private AddNewCommunityPageUIMap controls;
	private AddCommunityValidatorPageUIMap controlsValidator;
	private AddRegNumberValidatorPageUIMap controlsValidatorRegNumber;

	public AddNewCommunityPage() {
		controls = new AddNewCommunityPageUIMap();
	}

	public ITextField getNewCommunityField() {
		return this.controls.newCommunityField;
	}

	public ITextField getNewRegisterNumberField() {
		return this.controls.newRegisterNumberField;
	}

	public IButton getSaveButtonCommunity() {
		return this.controls.saveButtonCommunity;
	}

	public ILabel getHeadPageAddNewCommunityPage() {
		return this.controls.headPageAddNewCommunityPage;
	}

	public IButton getClearButton() {
		return this.controls.clearButton;
	}

	public String getHeadPageAddNewCommunityPageText() {
		return getHeadPageAddNewCommunityPage().getText();
	}

	public String getNewCommunityFieldText() {
		return getNewCommunityField().getText();
	}

	public String getNewRegisterNumberFieldText() {
		return getNewRegisterNumberField().getText();
	}

	public void setNewCommunity(String NewCommunity) {
		getNewCommunityField().sendKeys(NewCommunity);
	}

	public void setNewCommunityClear(String NewCommunity) {
		getNewCommunityField().sendKeysClear(NewCommunity);
	}

	public void setNewRegisterNumber(String NewRegisterNumber) {
		getNewRegisterNumberField().sendKeys(NewRegisterNumber);
	}

	public void setNewRegisterNumberClear(String NewRegisterNumber) {
		getNewRegisterNumberField().sendKeysClear(NewRegisterNumber);
	}

	public void clearNewCommunityField() {
		getNewCommunityField().clear();
	}

	public void clearNewRegisterNumberField() {
		getNewRegisterNumberField().clear();
	}

	public void clickNewCommunityField() {
		getNewCommunityField().click();
	}

	public void clickNewRegisterNumberField() {
		getNewRegisterNumberField().click();
	}

	public void clickSaveButtonCommunity() {
		getSaveButtonCommunity().click();
	}

	public AddNewCommunityPage clickClearButton() {
		getClearButton().click();
		return new AddNewCommunityPage();
	}

	private void setDataForCreateCommunity(AddNewCommunity newData) {
		clickNewCommunityField();
		clearNewCommunityField();
		setNewCommunity(newData.getnameCommunity());
		clickNewRegisterNumberField();
		clearNewRegisterNumberField();
		setNewRegisterNumber(newData.getregisterNumber());
	}

	public AddNewCommunityPage successInputData(AddNewCommunity newData) {
		setDataForCreateCommunity(newData);
		return new AddNewCommunityPage();
	}

	public ShowAllCommunitiesPage saveCommunityButton() {
		clickSaveButtonCommunity();
		return new ShowAllCommunitiesPage();
	}

	public AddCommunityPageValidator VerifyCommunityFieldValidator() {
		getSaveButtonCommunity().click();
		return new AddCommunityPageValidator();
	}

	public AddCommunityValidatorRegNumber VerifyRegNumberFieldValidator() {
		getSaveButtonCommunity().click();
		return new AddCommunityValidatorRegNumber();
	}

	public ILabel getValidatorMessageCommunity() {
		return this.controlsValidator.validatorAddCommunity;
	}

	public String getValidatorCommunityText() {
		return getValidatorMessageCommunity().getText();
	}

	private void setDataForVerifyCommunity(AddNewCommunity invalidCommunity) {
		clickNewCommunityField();
		clearNewCommunityField();
		setNewCommunity(invalidCommunity.getnameCommunity());
		clickSaveButtonCommunity();
	}

	public AddNewCommunityPage unsuccessInputCommunityData(AddNewCommunity invalidCommunity) {
		setDataForVerifyCommunity(invalidCommunity);
		controls = new AddNewCommunityPageUIMap();
		controlsValidator = new AddCommunityValidatorPageUIMap();
		return this;
	}

	public ILabel getValidatorMessageRegNumber() {
		return this.controlsValidatorRegNumber.validatorRegNumber;
	}

	public String getValidatorRegNumberText() {
		return getValidatorMessageRegNumber().getText();
	}

	private void setDataForVerifyRegNumber(AddNewCommunity RegNumber) {
		clickNewCommunityField();
		clearNewCommunityField();
		setNewCommunity(RegNumber.getnameCommunity());
		clickNewRegisterNumberField();
		clearNewRegisterNumberField();
		setNewRegisterNumber(RegNumber.getregisterNumber());
		clickSaveButtonCommunity();
	}

	public AddNewCommunityPage unsuccessInputRegNumberData(AddNewCommunity RegNumber) {
		setDataForVerifyRegNumber(RegNumber);
		controls = new AddNewCommunityPageUIMap();
		controlsValidatorRegNumber = new AddRegNumberValidatorPageUIMap();
		return this;
	}
}
