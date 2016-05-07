package com.softserve.edu.rs.pages;

import com.softserve.edu.application.CheckResult;
import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.ISelect;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.Label;
import com.softserve.edu.atqc.controls.SelectField;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.atqc.tools.JSInjection;
import com.softserve.edu.entity.IUser;

public class CreateNewUserPage extends CommonPage {
	private final String EMPTY_STRING = "";
	private final String DEFAULT_COMMUNITY = "Виберіть громаду";
	
	private class CreateNewUserPageUIMap {
		// for main data
		public final ILabel labelMainInformation;
		public final ILabel labelFirstName;
		public final ILabel labelLastName;
		public final ILabel labelMiddleName;
		public final ILabel labelEmail;
		public final ILabel labelLogin;
		public final ILabel labelPassword;
		public final ILabel labelConfirmPassword;
		public final ITextField fieldForFirstName;
		public final ITextField fieldForLastName;
		public final ITextField fieldForMiddleName;
		public final ITextField fieldForEmail;
		public final ITextField fieldForLogin;
		public final ITextField fieldForPassword;
		public final ITextField fieldForConfirmPassword;
		
		// for address data
		public final ILabel labelAddressData;
		public final ILabel labelCity;
		public final ILabel labelRegion;
		public final ILabel labelDistrict;
		public final ILabel labelStreet;
		public final ILabel labelBuilding;
		public final ILabel labelFlat;
		public final ILabel labelPostcode;
		public final ITextField fieldForCity;
		public final ITextField fieldForRegion;
		public final ITextField fieldForDistrict;
		public final ITextField fieldForStreet;
		public final ITextField fieldForBuilding;
		public final ITextField fieldForFlat;
		public final ITextField fieldForPostcode;
		
		// for passport data
		public final ILabel labelPassportData;
		public final ILabel labelPassportSeria;
		public final ILabel labelPassportNumber;
		public final ILabel labelPublishedByData;
		public final ITextField fieldForPassportSeria;
		public final ITextField fieldForPassportNumber;
		public final ITextField fieldForPublishedByData;
		
		// for other data
		public final ILabel labelOtherDate;
		public final ILabel labelPhoneNumber;
		public final ILabel labelTerritoryalCommunity;
		public final ILabel labelDateOfAccession;
		public final ITextField fieldForPhoneNumber;
		public final ISelect fieldForTerritorialCommunityDefault;
		public final ITextField fieldForDateOfAccession;
		public final ISelect territorialCommunity;
		
		// for buttons
		public final IButton buttonSend;
		public final IButton buttonReset;
		public final IButton buttonCancel;
		
		public CreateNewUserPageUIMap() {
			this.labelMainInformation = Label.get().getByXpath("//div[@class ='personal_header col-lg-4']/h4");
			this.labelFirstName  = Label.get().getByXpath("//label[@for='firstName']");
			this.labelLastName = Label.get().getByXpath("//label[@for='lastName']");
			this.labelMiddleName = Label.get().getByXpath("//label[@for='middleName']");
			this.labelEmail = Label.get().getByXpath("//label[@for='email']");
			this.labelLogin = Label.get().getByXpath("//label[@for='login']");
			this.labelPassword = Label.get().getByXpath("//label[@for='password']");
			this.labelConfirmPassword = Label.get().getByXpath("//label[@for='confirmPassword']");
			this.fieldForFirstName = TextField.get().getById("firstName");
			this.fieldForLastName = TextField.get().getById("lastName");
			this.fieldForMiddleName = TextField.get().getById("middleName");
			this.fieldForEmail = TextField.get().getById("email");
			this.fieldForLogin = TextField.get().getById("login");
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
			this.fieldForCity = TextField.get().getById("city");
			this.fieldForRegion = TextField.get().getById("region");
			this.fieldForDistrict = TextField.get().getById("district");
			this.fieldForStreet = TextField.get().getById("street");
			this.fieldForBuilding = TextField.get().getById("building");
			this.fieldForFlat = TextField.get().getById("flat");
			this.fieldForPostcode = TextField.get().getById("postcode");
			this.labelPassportData = Label.get().getByXpath("//h4[contains(text(),'Паспортні дані')]");
			this.labelPassportSeria = Label.get().getByXpath("//label[@for='passport_seria']");
			this.labelPassportNumber = Label.get().getByXpath("//label[@for='passport_number']");
			this.labelPublishedByData= Label.get().getByXpath("//label[@for='published_by_data']");
			this.fieldForPassportSeria = TextField.get().getById("passport_seria");
			this.fieldForPassportNumber = TextField.get().getById("passport_number");
			this.fieldForPublishedByData = TextField.get().getById("published_by_data");
			this.labelOtherDate = Label.get().getByXpath("//h4[contains(text(),'Інші дані')]");
			this.labelPhoneNumber = Label.get().getByXpath("//label[@for='phone_number']");
			this.labelTerritoryalCommunity = Label.get().getByXpath("//label[@for='territorial_Community']");
			this.labelDateOfAccession = Label.get().getByXpath("//label[@for='dateOfAccession']");		
			this.fieldForPhoneNumber = TextField.get().getById("phone_number");
			this.fieldForTerritorialCommunityDefault = SelectField.get().getByXpath("//select[@id='territorial_Community']/option[1]");
			this.fieldForDateOfAccession = TextField.get().getById("datepicker");
			this.territorialCommunity = SelectField.get().getById("territorial_Community");
			this.buttonSend = Button.get().getById("submit");
			this.buttonReset = Button.get().getByCssSelector(".btn.btn-warning.reset");
			this.buttonCancel = Button.get().getByXpath("//button[@class='btn btn-primary']");
		}
	}
	
	private CreateNewUserPageUIMap controls;
	
	public CreateNewUserPage() {
		controls = new CreateNewUserPageUIMap();
	}

	public ILabel getLabelMainInformation() {
		return this.controls.labelMainInformation;
	}

	public ILabel getLabelFirstName() {
		return this.controls.labelFirstName;
	}

	public ILabel getLabelLastName() {
		return this.controls.labelLastName;
	}

	public ILabel getLabelMiddleName() {
		return this.controls.labelMiddleName;
	}

	public ILabel getLabelEmail() {
		return this.controls.labelEmail;
	}

	public ILabel getLabelLogin() {
		return this.controls.labelLogin;
	}

	public ILabel getLabelPassword() {
		return this.controls.labelPassword;
	}

	public ILabel getLabelConfirmPassword() {
		return this.controls.labelConfirmPassword;
	}

	public ITextField getFieldForFirstName() {
		return this.controls.fieldForFirstName;
	}

	public String getFieldForFirstNameText() {
		return getFieldForFirstName().getText();
	}
	
	public ITextField getFieldForLastName() {
		return this.controls.fieldForLastName;
	}
	
	public String getFieldForLastNameText() {
		return getFieldForLastName().getText();
	}

	public ITextField getFieldForMiddleName() {
		return this.controls.fieldForMiddleName;
	}
	
	public String getFieldForMiddleNameText() {
		return getFieldForMiddleName().getText();
	}

	public ITextField getFieldForEmail() {
		return this.controls.fieldForEmail;
	}
	
	public String getFieldForEmailText() {
		return getFieldForEmail().getText();
	}

	public ITextField getFieldForLogin() {
		return this.controls.fieldForLogin;
	}
	
	public String getFieldForLoginText() {
		return getFieldForLogin().getText();
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

	public ILabel getLabelAddressData() {
		return this.controls.labelAddressData;
	}

	public ILabel getLabelCity() {
		return this.controls.labelCity;
	}

	public ILabel getLabelRegion() {
		return this.controls.labelRegion;
	}

	public ILabel getLabelDistrict() {
		return this.controls.labelDistrict;
	}

	public ILabel getLabelStreet() {
		return this.controls.labelStreet;
	}

	public ILabel getLabelBuilding() {
		return this.controls.labelBuilding;
	}

	public ILabel getLabelFlat() {
		return this.controls.labelFlat;
	}

	public ILabel getLabelPostcode() {
		return this.controls.labelPostcode;
	}

	public ITextField getFieldForCity() {
		return this.controls.fieldForCity;
	}
	
	public String getFieldForCityText() {
		return getFieldForCity().getText();
	}

	public ITextField getFieldForRegion() {
		return this.controls.fieldForRegion;
	}
	
	public String getFieldForRegionText() {
		return getFieldForRegion().getText();
	}

	public ITextField getFieldForDistrict() {
		return this.controls.fieldForDistrict;
	}
	
	public String getFieldForDistrictText() {
		return getFieldForDistrict().getText();
	}

	public ITextField getFieldForStreet() {
		return this.controls.fieldForStreet;
	}
	
	public String getFieldForStreetText() {
		return getFieldForStreet().getText();
	}

	public ITextField getFieldForBuilding() {
		return this.controls.fieldForBuilding;
	}
	
	public String getFieldForBuildingText() {
		return getFieldForBuilding().getText();
	}

	public ITextField getFieldForFlat() {
		return this.controls.fieldForFlat;
	}
	
	public String getFieldForFlatText() {
		return getFieldForFlat().getText();
	}

	public ITextField getFieldForPostcode() {
		return this.controls.fieldForPostcode;
	}
	
	public String getFieldForPostcodeText() {
		return getFieldForPostcode().getText();
	}

	public ILabel getLabelPassportData() {
		return this.controls.labelPassportData;
	}

	public ILabel getLabelPassportSeria() {
		return this.controls.labelPassportSeria;
	}

	public ILabel getLabelPassportNumber() {
		return this.controls.labelPassportNumber;
	}

	public ILabel getLabelPublishedByData() {
		return this.controls.labelPublishedByData;
	}

	public ITextField getFieldForPassportSeria() {
		return this.controls.fieldForPassportSeria;
	}
	
	public String getFieldForPassportSeriaText() {
		return getFieldForPassportSeria().getText();
	}

	public ITextField getFieldForPassportNumber() {
		return this.controls.fieldForPassportNumber;
	}
	
	public String getFieldForPassportNumberText() {
		return getFieldForPassportNumber().getText();
	}

	public ITextField getFieldForPublishedByData() {
		return this.controls.fieldForPublishedByData;
	}
	
	public String getFieldForPublishedByDataText() {
		return getFieldForPublishedByData().getText();
	}

	public ILabel getLabelOtherDate() {
		return this.controls.labelOtherDate;
	}

	public ILabel getLabelPhoneNumber() {
		return this.controls.labelPhoneNumber;
	}

	public ILabel getLabelTerritoryalCommunity() {
		return this.controls.labelTerritoryalCommunity;
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

	public ISelect getFieldForTerritorialCommunityDefault() {
		return this.controls.fieldForTerritorialCommunityDefault;
	}
	
	public String getFieldForTerritorialCommunityDefaultText() {
		return getFieldForTerritorialCommunityDefault().getText();
	}
	
	public ITextField getFieldForDateOfAccession() {
		return this.controls.fieldForDateOfAccession;
	}
	
	public Object getValueForDateOfAccession() {
		return	new JSInjection().runScript("return $('#datepicker').datepicker({ dateFormat: 'yy-mm-dd' }).val();");
	}

	public ISelect getTerritorialCommunity() {
		return this.controls.territorialCommunity;
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

	public void setFieldForFirstName(String firstName) {
		getFieldForFirstName().sendKeys(firstName);
	}

	public void setFieldForLastName(String lastName) {
		getFieldForLastName().sendKeys(lastName);
	}

	public void setFieldForMiddleName(String middleName) {
		getFieldForMiddleName().sendKeys(middleName);
	}

	public void setFieldForEmail(String email) {
		getFieldForEmail().sendKeys(email);
	}

	public void setFieldForLogin(String login) {
		getFieldForLogin().sendKeys(login);
	}

	public void setFieldForPassword(String password) {
		getFieldForPassword().sendKeys(password);
	}

	public void setFieldForConfirmPassword(String confirmPassword) {
		getFieldForConfirmPassword().sendKeys(confirmPassword);
	}

	public void setFieldForCity(String city) {
		getFieldForCity().sendKeys(city);
	}

	public void setFieldForRegion(String region) {
		getFieldForRegion().sendKeys(region);
	}

	public void setFieldForDistrict(String district) {
		getFieldForDistrict().sendKeys(district);
	}

	public void setFieldForStreet(String street) {
		getFieldForStreet().sendKeys(street);
	}

	public void setFieldForBuilding(String building) {
		getFieldForBuilding().sendKeys(building);
	}

	public void setFieldForFlat(String flat) {
		getFieldForFlat().sendKeys(flat);
	}

	public void setFieldForPostcode(String postcode) {
		getFieldForPostcode().sendKeys(postcode);
	}

	public void setFieldForPassportSeria(String passportSeria) {
		getFieldForPassportSeria().sendKeys(passportSeria);
	}

	public void setFieldForPassportNumber(String passportNumber) {
		getFieldForPassportNumber().sendKeys(passportNumber);
	}

	public void setFieldForPublishedByData(String publishedByData) {
		getFieldForPublishedByData().sendKeys(publishedByData);
	}

	public void setFieldForPhoneNumber(String phoneNumber) {
		getFieldForPhoneNumber().sendKeys(phoneNumber);
	}

//	public void setFieldForTerritorialCommunityDefault(String territorialCommunityDefault) {
//		//getFieldForTerritorialCommunityDefault().sendKeys(territorialCommunityDefault);
//		getFieldForTerritorialCommunityDefault().selectByValue("");
//	}

	public void setFieldForDateOfAccession(String dateOfAccession) {
		getFieldForDateOfAccession().sendKeys(dateOfAccession);
	}

	public void setTerritorialCommunity(String territorialCommunity) {
		getTerritorialCommunity().selectByValue(territorialCommunity);
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
		setFieldForMiddleName(user.getPerson().getMiddleName());
		// type address data
		setFieldForCity(user.getAddress().getCity());
		setFieldForRegion(user.getAddress().getRegion());
		setFieldForDistrict(user.getAddress().getDistrict());
		setFieldForStreet(user.getAddress().getStreet());
		setFieldForBuilding(user.getAddress().getBuilding());
		setFieldForFlat(user.getAddress().getFlat());
		setFieldForPostcode(user.getAddress().getPostcode());
		// type passport data
		setFieldForPublishedByData(user.getPassport().getPublishedByData());
		// type other data
		setFieldForPhoneNumber(user.getPerson().getPhoneNumber());
		return this;
	}

	public CreateNewUserPage typeRequiredFields(IUser user) {
		// type main information
		setFieldForFirstName(user.getPerson().getFirstName());
		setFieldForLastName(user.getPerson().getLastName());
		setFieldForEmail(user.getPerson().getEmail());
		setFieldForLogin(user.getAccount().getLogin());
		setFieldForPassword(user.getAccount().getPassword());
		setFieldForConfirmPassword(user.getAccount().getPassword());
		setFieldForPassportSeria(user.getPassport().getPassportSeria());
		setFieldForPassportNumber(user.getPassport().getPassportNumber());
		setTerritorialCommunity(user.getAccount().getCommunity());
		return this;
	}

	public boolean verifyPageForCreateUserIsLoadedCorrectly() {
		// for main information
		return new CheckResult().add(getLabelMainInformation().isEnabled(), true)
				.add(getLabelFirstName().isEnabled(), true)
				.add(getFieldForFirstNameText(), EMPTY_STRING)
				.add(getLabelLastName().isEnabled(), true)
				.add(getFieldForLastNameText(), EMPTY_STRING)
				.add(getLabelMiddleName().isEnabled(), true)
				.add(getFieldForMiddleNameText(), EMPTY_STRING)
				.add(getLabelEmail().isEnabled(), true)
				.add(getFieldForEmailText(), EMPTY_STRING)
				.add(getLabelLogin().isEnabled(), true)
				.add(getFieldForLoginText(), EMPTY_STRING)
				.add(getLabelPassword().isEnabled(), true)
				.add(getFieldForPasswordText(), EMPTY_STRING)
				.add(getLabelConfirmPassword().isEnabled(), true)
				.add(getFieldForConfirmPasswordText(), EMPTY_STRING)
				// for address data
				.add(getLabelAddressData().isEnabled(), true)
				.add(getLabelCity().isEnabled(), true)
				.add(getFieldForCityText(), EMPTY_STRING)
				.add(getLabelRegion().isEnabled(), true)
				.add(getFieldForRegionText(), EMPTY_STRING)
				.add(getLabelDistrict().isEnabled(), true)
				.add(getFieldForDistrictText(), EMPTY_STRING)
				.add(getLabelStreet().isEnabled(), true)
				.add(getFieldForStreetText(), EMPTY_STRING)
				.add(getLabelBuilding().isEnabled(), true)
				.add(getFieldForBuildingText(), EMPTY_STRING)
				.add(getLabelFlat().isEnabled(), true)
				.add(getFieldForFlatText(), EMPTY_STRING)
				.add(getLabelPostcode().isEnabled(), true)
				.add(getFieldForPostcodeText(), EMPTY_STRING)
				// for passport data
				.add(getLabelPassportData().isEnabled(), true)
				.add(getLabelPassportSeria().isEnabled(), true)
				.add(getFieldForPassportSeriaText(), EMPTY_STRING)
				.add(getLabelPassportNumber().isEnabled(), true)
				.add(getFieldForPassportNumberText(), EMPTY_STRING)
				.add(getLabelPublishedByData().isEnabled(), true)
				.add(getFieldForPublishedByDataText(), EMPTY_STRING)
				// for other data
				.add(getLabelOtherDate().isEnabled(), true)
				.add(getLabelPhoneNumber().isEnabled(), true)
				.add(getFieldForPhoneNumberText(), EMPTY_STRING)
				.add(getLabelTerritoryalCommunity().isEnabled(), true)
				.add(getFieldForTerritorialCommunityDefaultText(),DEFAULT_COMMUNITY)
				.add(getLabelDateOfAccession().isEnabled(), true)
				// for button
				.add(getButtonSend().isEnabled(), true)
				.add(getButtonReset().isEnabled(), true)
				.add(getButtonCancel().isEnabled(), true).check();
	}
}
