package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.Label;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.rs.data.users.AddNewCommunity;

public class EditCommunityPage {

	private class EditCommunityPageUIMap {
		public final ITextField editCommunityField;
		public final ITextField editRegisterNumberField;
		public final IButton saveEditedCommunityButton;
		public final ILabel headPageEditCommunityPage;

		public EditCommunityPageUIMap() {
			this.editCommunityField = TextField.get().getByCssSelector(".col-sm-3 .form-control[name='name']");
			this.editRegisterNumberField = TextField.get()
					.getByCssSelector(".col-sm-3 .form-control[name='registrationNumber']");
			this.saveEditedCommunityButton = Button.get().getByCssSelector(".btn.btn-success");
			this.headPageEditCommunityPage = Label.get().getByCssSelector("#body>h2");
		}
	}

	private EditCommunityPageUIMap controls;

	public EditCommunityPage() {
		controls = new EditCommunityPageUIMap();
	}

	public ITextField getEditCommunityField() {
		return this.controls.editCommunityField;
	}

	public ITextField getEditRegisterNumberField() {
		return this.controls.editRegisterNumberField;
	}

	public IButton getSaveEditedCommunityButton() {
		return this.controls.saveEditedCommunityButton;
	}

	public ILabel getHeadPageEditCommunityPage() {
		return this.controls.headPageEditCommunityPage;
	}

	public String HeadPageEditCommunityPageText() {
		return getHeadPageEditCommunityPage().getText();
	}

	public String getEditCommunityFieldText() {
		return getEditCommunityField().getText();
	}

	public String getEditRegisterNumberFieldText() {
		return getEditRegisterNumberField().getText();
	}

	public void setEditCommunity(String NewCommunity) {
		getEditCommunityField().sendKeys(NewCommunity);
	}

	public void setEditCommunityClear(String NewCommunity) {
		getEditCommunityField().sendKeysClear(NewCommunity);
	}

	public void setEditRegisterNumber(String NewRegisterNumber) {
		getEditRegisterNumberField().sendKeys(NewRegisterNumber);
	}

	public void setEditRegisterNumberClear(String NewRegisterNumber) {
		getEditRegisterNumberField().sendKeysClear(NewRegisterNumber);
	}

	public void clearEditCommunityField() {
		getEditCommunityField().clear();
	}

	public void clearEditRegisterNumberField() {
		getEditRegisterNumberField().clear();
	}

	public void clickEditCommunityField() {
		getEditCommunityField().click();
	}

	public void clickEditRegisterNumberField() {
		getEditRegisterNumberField().click();
	}

	public void clickSaveEditedCommunityButton() {
		getSaveEditedCommunityButton().click();
	}

	private void setDataForEditCommunity(AddNewCommunity newData) {

		clickEditCommunityField();
		clearEditCommunityField();
		setEditCommunity(newData.getnameCommunity());

		clickEditRegisterNumberField();
		clearEditRegisterNumberField();
		setEditRegisterNumber(newData.getregisterNumber());

	}

	public ShowAllCommunitiesPage successInputData(AddNewCommunity newData) {
		setDataForEditCommunity(newData);
		clickSaveEditedCommunityButton();
		return new ShowAllCommunitiesPage();
	}

}
