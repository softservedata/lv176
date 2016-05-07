package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ISelect;
import com.softserve.edu.atqc.controls.SelectField;
import com.softserve.edu.entity.IUser;

public class EditProfilUserPage extends CommonPage {
	public static final String EMPTY_FIELD_WARNING = "Поле є обов\'язковим для введення";
	public static final String INCORRECT_FIELD_WARNING = "Некоректне введення, лише літери";
	public static final String INCORRECT_WARNING_FOR_EMAIL = "Це не емейл";
	public static final String NO_ALLOWED_SIZE_FOR_FIRST_NAME = "Імя повиннe містити від 1 до 30 символів";
	public static final String NO_ALLOWED_SIZE_FOR_LAST_NAME = "Прізвище повинне містити від 1 до 30 символів";
	public static final String INCORRECT_WARNING_FOR_PASSPORT_SERIA = "Поле повинне містити 2 великі літери";
	public static final String INCORRECT_WARNING_FOR_PASSPORT_NUMBER = "Поле повинне містити 6 цифр";
	
	private class EditProfilUserPageUIMap {
		public final ISelect selectStatus;
		public final IButton buttonOK;
		
		public EditProfilUserPageUIMap() {
			this.selectStatus = SelectField.get().getById("userStatusId");
			this.buttonOK = Button.get().getById("ok");
		}
	}
	
	private EditProfilUserPageUIMap controls;
	
	public EditProfilUserPage() {
		super();
		controls = new EditProfilUserPageUIMap();
	}
//	@FindBy(id = "lastname")
//	private WebElement fieldForLastName;

//	public WebElement getFieldForLastName() {
//		return this.fieldForLastName;
//	}

//	public String getFieldForLastNameText() {
//		return getFieldForLastName().getText();
//	}
//	
	public ISelect getSelectStatus() {
		return this.controls.selectStatus;
	}
	
	public IButton getButtonOk() {
		return this.controls.buttonOK;
	}
	
//	public void setFieldForLastName(String lastName) {
//		getFieldForLastName().sendKeys(lastName);
//	}
//	
//	public EditProfilUserPage clearInputForFirstName() {
//		controls.getFieldForFirstName().clear();
//		return this;
//	}
//	
//	public EditProfilUserPage typeInputForFirstName(String firstName) {
//		controls.setFieldForFirstName(firstName);
//		return new EditProfilUserPage(webDriver);
//	}
//	
//	public EditProfilUserPage clearInputForLastName() {
//		getFieldForLastName().clear();
//		return this;
//	}
//	
//	public EditProfilUserPage typeInputForLastName(String lastName) {
//		setFieldForLastName(lastName);
//		return new EditProfilUserPage(webDriver);
//	}
//	
//	public EditProfilUserPage clearInputForEmail() {
//		controls.getFieldForEmail().clear();
//		return this;
//	}
//	
//	public EditProfilUserPage typeInputForEmail(String email) {
//		controls.setFieldForEmail(email);
//		return new EditProfilUserPage(webDriver);
//	}
//	
//	public EditProfilUserPage clearInputForPassportSeria() {
//		controls.getFieldForPassportSeria().clear();
//		return this;
//	}
//	
//	public EditProfilUserPage typeInputForPassportSeria(String passportSeria) {
//		controls.setFieldForPassportSeria(passportSeria);
//		return new EditProfilUserPage(webDriver);
//	}
//	
//	public EditProfilUserPage clearInputForPassportNumber() {
//		controls.getFieldForPassportNumber().clear();
//		return this;
//	}
//	
//	public EditProfilUserPage typeInputForPassportNumber(String passportNumber) {
//		controls.setFieldForPassportNumber(passportNumber);
//		return new EditProfilUserPage(webDriver);
//	}
//	
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
	
//	public String getWarningText(String warning) {
//		return webDriver.findElement(By.xpath("//*[@class=\"error\"][text()=\""+ warning +"\"]")).getText();
//	}
}
