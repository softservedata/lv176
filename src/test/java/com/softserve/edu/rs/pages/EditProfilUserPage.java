package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.ISelect;
import com.softserve.edu.atqc.controls.Label;
import com.softserve.edu.atqc.controls.SelectField;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.entity.IUser;

public class EditProfilUserPage extends CommonPage {
	public static final String EMPTY_FIELD_WARNING = "Поле є обов\'язковим для введення";
	public static final String INCORRECT_FIELD_WARNING = "Некоректне введення, лише літери";
	public static final String INCORRECT_WARNING_FOR_EMAIL = "Це не емейл";
	public static final String NO_ALLOWED_SIZE_FOR_FIRST_NAME = "Імя повиннe містити від 1 до 30 символів";
	public static final String NO_ALLOWED_SIZE_FOR_LAST_NAME = "Прізвище повинне містити від 1 до 30 символів";
	
	private class EditProfilUserPageUIMap extends BaseFormForUser {
		public final ISelect selectStatus;
		public final IButton buttonOK;
		
		public EditProfilUserPageUIMap() {
			this.fieldForLastName = TextField.get().getById("lastname");
			this.selectStatus = SelectField.get().getById("userStatusId");
			this.buttonOK = Button.get().getById("ok");
		}
		
		public ILabel getWarningLabel(String warning) {
			return Label.get().getByXpath("//*[@class=\"error\"][text()=\"" + warning + "\"]");
		}
	}
	
	private EditProfilUserPageUIMap editControls;
	
	public EditProfilUserPage() {
		editControls = new EditProfilUserPageUIMap();
	}
	
	public ISelect getSelectStatus() {
		return this.editControls.selectStatus;
	}
	
	public IButton getButtonOk() {
		return this.editControls.buttonOK;
	}
	
	public String getWarningText(String warning) {
		return editControls.getWarningLabel(warning).getText();
	}
	
	public EditProfilUserPage typeInputForFirstName(String firstName) {
		editControls.setFieldForFirstName(firstName);
		return new EditProfilUserPage();
	}

	public EditProfilUserPage typeInputForLastName(String lastName) {
		editControls.setFieldForLastName(lastName);
		return new EditProfilUserPage();
	}
	
	public EditProfilUserPage typeInputForEmail(String email) {
		editControls.setFieldForEmail(email);
		return new EditProfilUserPage();
	}
	
	public void clickButtonOk() {
		getButtonOk().click();
	}
	
	public void setStatus(IUser user) {
		getSelectStatus().selectByValue(user.getAccount().getStatus());
	}
	
	public EditProfilUserPage changeStatusToActive(IUser user) {
		setStatus(user);
		return this;
	}
}
