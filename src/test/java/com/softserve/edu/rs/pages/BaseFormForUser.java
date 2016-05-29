package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.ILabelClickable;
import com.softserve.edu.atqc.controls.ISelect;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.TextField;

public abstract class BaseFormForUser {
	// for main data
	public ILabel labelMainInformation;
	public ILabel labelFirstName;
	public ILabel labelLastName;
	public ILabel labelMiddleName;
	public ILabel labelEmail;
	public ILabel labelLogin;
	public ITextField fieldForFirstName;
	public ITextField fieldForLastName;
	public ITextField fieldForMiddleName;
	public ITextField fieldForEmail;
	public ITextField fieldForLogin;

	// for address data
	public ILabel labelAddressData;
	public ILabel labelCity;
	public ILabel labelRegion;
	public ILabel labelDistrict;
	public ILabel labelStreet;
	public ILabel labelBuilding;
	public ILabel labelFlat;
	public ILabel labelPostcode;
	public ITextField fieldForCity;
	public ITextField fieldForRegion;
	public ITextField fieldForDistrict;
	public ITextField fieldForStreet;
	public ITextField fieldForBuilding;
	public ITextField fieldForFlat;
	public ITextField fieldForPostcode;

	// for passport data
	public ILabel labelPassportData;
	public ILabel labelPassportSeria;
	public ILabel labelPassportNumber;
	public ILabel labelPublishedByData;
	public ITextField fieldForPassportSeria;
	public ITextField fieldForPassportNumber;
	public ITextField fieldForPublishedByData;
	
	public ILabel labelTerritorialCommunity;
	public ISelect territorialCommunity;

	public BaseFormForUser() {
		this.fieldForFirstName = TextField.get().getById("firstName");
		this.fieldForEmail = TextField.get().getById("email");
		this.fieldForLogin = TextField.get().getById("login");
		this.fieldForCity = TextField.get().getById("city");
		this.fieldForRegion = TextField.get().getById("region");
		this.fieldForDistrict = TextField.get().getById("district");
		this.fieldForStreet = TextField.get().getById("street");
		this.fieldForBuilding = TextField.get().getById("building");
		this.fieldForFlat = TextField.get().getById("flat");
		this.fieldForPostcode = TextField.get().getById("postcode");
	}
	
	public ILabel getLabelMainInformation() {
		return this.labelMainInformation;
	}
	
	public ILabel getLabelFirstName() {
		return this.labelFirstName;
	}

	public ILabel getLabelLastName() {
		return this.labelLastName;
	}

	public ILabel getLabelMiddleName() {
		return this.labelMiddleName;
	}

	public ILabel getLabelEmail() {
		return this.labelEmail;
	}

	public ILabel getLabelLogin() {
		return this.labelLogin;
	}
	
	public ITextField getFieldForFirstName() {
		return this.fieldForFirstName;
	}

	public String getFieldForFirstNameText() {
		return getFieldForFirstName().getText();
	}
	
	public ITextField getFieldForLastName() {
		return this.fieldForLastName;
	}
	
	public String getFieldForLastNameText() {
		return getFieldForLastName().getText();
	}

	public ITextField getFieldForMiddleName() {
		return this.fieldForMiddleName;
	}
	
	public String getFieldForMiddleNameText() {
		return getFieldForMiddleName().getText();
	}

	public ITextField getFieldForEmail() {
		return this.fieldForEmail;
	}
	
	public String getFieldForEmailText() {
		return getFieldForEmail().getText();
	}

	public ITextField getFieldForLogin() {
		return this.fieldForLogin;
	}
	
	public String getFieldForLoginText() {
		return getFieldForLogin().getText();
	}
	
	public ILabel getLabelAddressData() {
		return this.labelAddressData;
	}

	public ILabel getLabelCity() {
		return this.labelCity;
	}

	public ILabel getLabelRegion() {
		return this.labelRegion;
	}

	public ILabel getLabelDistrict() {
		return this.labelDistrict;
	}

	public ILabel getLabelStreet() {
		return this.labelStreet;
	}

	public ILabel getLabelBuilding() {
		return this.labelBuilding;
	}

	public ILabel getLabelFlat() {
		return this.labelFlat;
	}

	public ILabel getLabelPostcode() {
		return this.labelPostcode;
	}

	public ITextField getFieldForCity() {
		return this.fieldForCity;
	}
	
	public String getFieldForCityText() {
		return getFieldForCity().getText();
	}

	public ITextField getFieldForRegion() {
		return this.fieldForRegion;
	}
	
	public String getFieldForRegionText() {
		return getFieldForRegion().getText();
	}

	public ITextField getFieldForDistrict() {
		return this.fieldForDistrict;
	}
	
	public String getFieldForDistrictText() {
		return getFieldForDistrict().getText();
	}

	public ITextField getFieldForStreet() {
		return this.fieldForStreet;
	}
	
	public String getFieldForStreetText() {
		return getFieldForStreet().getText();
	}

	public ITextField getFieldForBuilding() {
		return this.fieldForBuilding;
	}
	
	public String getFieldForBuildingText() {
		return getFieldForBuilding().getText();
	}

	public ITextField getFieldForFlat() {
		return this.fieldForFlat;
	}
	
	public String getFieldForFlatText() {
		return getFieldForFlat().getText();
	}

	public ITextField getFieldForPostcode() {
		return this.fieldForPostcode;
	}
	
	public String getFieldForPostcodeText() {
		return getFieldForPostcode().getText();
	}
	
	public ILabel getLabelPassportData() {
		return this.labelPassportData;
	}

	public ILabel getLabelPassportSeria() {
		return this.labelPassportSeria;
	}

	public ILabel getLabelPassportNumber() {
		return this.labelPassportNumber;
	}

	public ILabel getLabelPublishedByData() {
		return this.labelPublishedByData;
	}

	public ITextField getFieldForPassportSeria() {
		return this.fieldForPassportSeria;
	}
	
	public String getFieldForPassportSeriaText() {
		return getFieldForPassportSeria().getText();
	}

	public ITextField getFieldForPassportNumber() {
		return this.fieldForPassportNumber;
	}
	
	public String getFieldForPassportNumberText() {
		return getFieldForPassportNumber().getText();
	}

	public ITextField getFieldForPublishedByData() {
		return this.fieldForPublishedByData;
	}
	
	public String getFieldForPublishedByDataText() {
		return getFieldForPublishedByData().getText();
	}
	
	public ILabel getLabelTerritoryalCommunity() {
		return this.labelTerritorialCommunity;
	}
	
	public ISelect getTerritorialCommunity() {
		return this.territorialCommunity;
	}
	
	public ILabelClickable getTerritorialCommunitySelected() {
		return getTerritorialCommunity().getFirstSelectedOption();
	}
	
	public String getTerritorialCommunitySelectedText() {
		return getTerritorialCommunitySelected().getText();
	}
	
	public void setFieldForFirstName(String firstName) {
		getFieldForFirstName().sendKeysClear(firstName);
	}

	public void setFieldForLastName(String lastName) {
		getFieldForLastName().sendKeysClear(lastName);
	}

	public void setFieldForMiddleName(String middleName) {
		getFieldForMiddleName().sendKeysClear(middleName);
	}

	public void setFieldForEmail(String email) {
		getFieldForEmail().sendKeysClear(email);
	}

	public void setFieldForLogin(String login) {
		getFieldForLogin().sendKeysClear(login);
	}
	
	public void setFieldForCity(String city) {
		getFieldForCity().sendKeysClear(city);
	}

	public void setFieldForRegion(String region) {
		getFieldForRegion().sendKeysClear(region);
	}

	public void setFieldForDistrict(String district) {
		getFieldForDistrict().sendKeysClear(district);
	}

	public void setFieldForStreet(String street) {
		getFieldForStreet().sendKeysClear(street);
	}

	public void setFieldForBuilding(String building) {
		getFieldForBuilding().sendKeysClear(building);
	}

	public void setFieldForFlat(String flat) {
		getFieldForFlat().sendKeysClear(flat);
	}

	public void setFieldForPostcode(String postcode) {
		getFieldForPostcode().sendKeysClear(postcode);
	}

	public void setFieldForPassportSeria(String passportSeria) {
		getFieldForPassportSeria().sendKeysClear(passportSeria);
	}

	public void setFieldForPassportNumber(String passportNumber) {
		getFieldForPassportNumber().sendKeysClear(passportNumber);
	}

	public void setFieldForPublishedByData(String publishedByData) {
		getFieldForPublishedByData().sendKeysClear(publishedByData);
	}
	
	public void setTerritorialCommunity(String territorialCommunity) {
		getTerritorialCommunity().selectByValue(territorialCommunity);
	}
}
