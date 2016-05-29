package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.Component;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.Label;
import com.softserve.edu.atqc.controls.Select;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.atqc.data.apps.PageObserveLoad;
import com.softserve.edu.atqc.specs.FlexAssert;
import com.softserve.edu.users.IUser;

public class CreateNewUserPage extends CommonPage {
	private final String EMPTY_STRING = "";
	private final String DEFAULT_COMMUNITY = "Виберіть громаду";
	
	private class CreateNewUserPageUIMap extends BaseFormForUser {
		public final ILabel labelPassword;
		public final ILabel labelConfirmPassword;
		public final ITextField fieldForPassword;
		public final ITextField fieldForConfirmPassword;

		// for other data
		public final ILabel labelOtherDate;
		public final ILabel labelPhoneNumber;
		public final ILabel labelDateOfAccession;
		public final ITextField fieldForPhoneNumber;
		public final ITextField fieldForDateOfAccession;

		// for buttons
		public final IButton buttonSend;
		public final IButton buttonReset;
		public final IButton buttonCancel;
		
		public CreateNewUserPageUIMap() {
			this.labelMainInformation = Label.get().getByXpath("//div[@class ='personal_header col-lg-4']/h4");
			this.labelLastName = Label.get().getByXpath("//label[@for='lastName']");
			this.labelMiddleName = Label.get().getByXpath("//label[@for='middleName']");
			this.labelEmail = Label.get().getByXpath("//label[@for='email']");
			this.labelLogin = Label.get().getByXpath("//label[@for='login']");
			this.labelPassword = Label.get().getByXpath("//label[@for='password']");
			this.labelConfirmPassword = Label.get().getByXpath("//label[@for='confirmPassword']");
			this.fieldForLastName = TextField.get().getById("lastName");
			this.fieldForMiddleName = TextField.get().getById("middleName");
			this.fieldForPassword = TextField.get().getById("password");
			this.fieldForConfirmPassword = TextField.get().getById("confirmPassword");
			this.labelAddressData = Label.get().getByXpath("//div[@class ='address_header col-lg-4']/h4");
			this.labelCity  = Label.get().getByXpath("//label[text()='Місто']");
			this.labelRegion = Label.get().getByXpath("//label[@for='region']");
			this.labelDistrict = Label.get().getByXpath("//label[@for='district']");
			this.labelStreet = Label.get().getByXpath("//label[@for='street']");
			this.labelBuilding = Label.get().getByXpath("//label[@for='building']");
			this.labelFlat = Label.get().getByXpath("//label[@for='flat']");
			this.labelPostcode= Label.get().getByXpath("//label[@for='postcode']");
			this.labelPassportData = Label.get().getByXpath("//h4[contains(text(),'Паспортні дані')]");
			this.labelPassportSeria = Label.get().getByXpath("//label[@for='passport_seria']");
			this.labelPassportNumber = Label.get().getByXpath("//label[@for='passport_number']");
			this.labelPublishedByData= Label.get().getByXpath("//label[@for='published_by_data']");
			this.fieldForPassportSeria = TextField.get().getById("passport_seria");
			this.fieldForPassportNumber = TextField.get().getById("passport_number");
			this.fieldForPublishedByData = TextField.get().getById("published_by_data");
			this.labelOtherDate = Label.get().getByXpath("//h4[contains(text(),'Інші дані')]");
			this.labelPhoneNumber = Label.get().getByXpath("//label[@for='phone_number']");
			this.labelTerritorialCommunity = Label.get().getByXpath("//label[@for='territorial_Community']");
			this.labelDateOfAccession = Label.get().getByXpath("//label[@for='dateOfAccession']");		
			this.fieldForPhoneNumber = TextField.get().getById("phone_number");
			this.fieldForDateOfAccession = TextField.get().getById("datepicker");
			this.territorialCommunity = Select.get().getById("territorial_Community");
			this.buttonSend = Button.get().getById("submit");
			this.buttonReset = Button.get().getByCssSelector(".btn.btn-warning.reset");
			this.buttonCancel = Button.get().getByXpath("//button[@class='btn btn-primary']");
		}
	}
	
	private CreateNewUserPageUIMap controls;
	
	public CreateNewUserPage() {
		PageObserveLoad.get().deleteLoadCompleteEvents();
		controls = new CreateNewUserPageUIMap();
	}

	public ILabel getLabelPassword() {
		return this.controls.labelPassword;
	}

	public ILabel getLabelConfirmPassword() {
		return this.controls.labelConfirmPassword;
	}

	public ITextField getFieldForPassword() {
		return this.controls.fieldForPassword;
	}
	
	public String getFieldForPasswordText() {
		return getFieldForPassword().getText();
	}

	public ITextField getFieldForConfirmPassword() {
		return this.controls.fieldForConfirmPassword;
	}
	
	public String getFieldForConfirmPasswordText() {
		return getFieldForConfirmPassword().getText();
	}

	public ILabel getLabelOtherDate() {
		return this.controls.labelOtherDate;
	}

	public ILabel getLabelPhoneNumber() {
		return this.controls.labelPhoneNumber;
	}

	public ILabel getLabelDateOfAccession() {
		return this.controls.labelDateOfAccession;
	}

	public ITextField getFieldForPhoneNumber() {
		return this.controls.fieldForPhoneNumber;
	}
	
	public String getFieldForPhoneNumberText() {
		return getFieldForPhoneNumber().getText();
	}
	
	public ITextField getFieldForDateOfAccession() {
		return this.controls.fieldForDateOfAccession;
	}
	
	public String getValueFromDateOfAccession() {
		return (String)Component.get().runJavaScript("return $('#datepicker').datepicker({ dateFormat: 'yy-mm-dd' }).val();");
	}

	public IButton getButtonSend() {
		return this.controls.buttonSend;
	}

	public IButton getButtonReset() {
		return this.controls.buttonReset;
	}
	
	public IButton getButtonCancel() {
		return this.controls.buttonCancel;
	}

	public void setFieldForPassword(String password) {
		getFieldForPassword().sendKeysClear(password);
	}

	public void setFieldForConfirmPassword(String confirmPassword) {
		getFieldForConfirmPassword().sendKeysClear(confirmPassword);
	}
	
	public void setFieldForPhoneNumber(String phoneNumber) {
		getFieldForPhoneNumber().sendKeysClear(phoneNumber);
	}

	public void setFieldForDateOfAccession(String dateOfAccession) {
		getFieldForDateOfAccession().sendKeysClear(dateOfAccession);
	}

	public void clickButtonSend() {
		getButtonSend().click();
	}

	public void clickButtonReset() {
		getButtonReset().click();
	}
	
	public CommonAdminCommissionerHomePage clickButtonCancel() {
		getButtonCancel().click();
		return new CommonAdminCommissionerHomePage();
	}
	
	public NonConfirmedUsersPage successCreateUser(IUser user) {
		typeRequiredFields(user);
		clickButtonSend();
		return new NonConfirmedUsersPage();
	}
	
	public CreateNewUserPage clearFormForCreateNewUser() {
		clickButtonReset();
		return this;
	}

	public CreateNewUserPage typeAllFields(IUser user) {
		// type main information
		typeRequiredFields(user);
		controls.setFieldForMiddleName(user.getPerson().getMiddleName());
		// type address data
		controls.setFieldForCity(user.getAddress().getCity());
		controls.setFieldForRegion(user.getAddress().getRegion());
		controls.setFieldForDistrict(user.getAddress().getDistrict());
		controls.setFieldForStreet(user.getAddress().getStreet());
		controls.setFieldForBuilding(user.getAddress().getBuilding());
		controls.setFieldForFlat(user.getAddress().getFlat());
		controls.setFieldForPostcode(user.getAddress().getPostcode());
		// type passport data
		controls.setFieldForPassportSeria(user.getPassport().getPassportSeria());
		controls.setFieldForPassportNumber(user.getPassport().getPassportNumber());
		controls.setFieldForPublishedByData(user.getPassport().getPublishedByData());
		// type other data
		setFieldForPhoneNumber(user.getPerson().getPhoneNumber());
		return this;
	}

	public CreateNewUserPage typeRequiredFields(IUser user) {
		// type main information
		controls.setFieldForFirstName(user.getPerson().getFirstName());
		controls.setFieldForLastName(user.getPerson().getLastName());
		controls.setFieldForEmail(user.getPerson().getEmail());
		controls.setFieldForLogin(user.getAccount().getLogin());
		setFieldForPassword(user.getAccount().getPassword());
		setFieldForConfirmPassword(user.getAccount().getPassword());
		controls.setTerritorialCommunity(user.getAccount().getCommunity());
		return this;
	}
	
	public void verifyPageForCreateUserIsLoadedCorrectly() {
		FlexAssert.get()
			// for main information
			.forElement(controls.getFieldForFirstNameText()).valueMatch(EMPTY_STRING).next()
			.forElement(controls.getFieldForLastNameText()).valueMatch(EMPTY_STRING).next()
			.forElement(controls.getFieldForMiddleNameText()).valueMatch(EMPTY_STRING).next()
			.forElement(controls.getFieldForEmailText()).valueMatch(EMPTY_STRING).next()
			.forElement(controls.getFieldForLoginText()).valueMatch(EMPTY_STRING).next()
			.forElement(getFieldForPasswordText()).valueMatch(EMPTY_STRING).next()
			.forElement(getFieldForConfirmPasswordText()).valueMatch(EMPTY_STRING).next()
			// for address data
			.forElement(controls.getFieldForCityText()).valueMatch(EMPTY_STRING).next()
			.forElement(controls.getFieldForRegionText()).valueMatch(EMPTY_STRING).next()
			.forElement(controls.getFieldForDistrictText()).valueMatch(EMPTY_STRING).next()
			.forElement(controls.getFieldForStreetText()).valueMatch(EMPTY_STRING).next()
			.forElement(controls.getFieldForBuildingText()).valueMatch(EMPTY_STRING).next()
			.forElement(controls.getFieldForFlatText()).valueMatch(EMPTY_STRING).next()
			.forElement(controls.getFieldForPostcodeText()).valueMatch(EMPTY_STRING).next()
			// for passport data
			.forElement(controls.getFieldForPassportSeriaText()).valueMatch(EMPTY_STRING).next()
			.forElement(controls.getFieldForPassportNumberText()).valueMatch(EMPTY_STRING).next()
			.forElement(controls.getFieldForPublishedByDataText()).valueMatch(EMPTY_STRING).next()
			// for other data
			.forElement(getFieldForPhoneNumberText()).valueMatch(EMPTY_STRING).next()
			.forElement(controls.getTerritorialCommunitySelectedText()).valueMatch(DEFAULT_COMMUNITY).next();
	}
}
