package com.softserve.edu.rs.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.application.CheckResult;
import com.softserve.edu.entity.IUser;

public class CreateNewUserPage extends CommonAdminCommissionerHomePage {
	private final String EMPTY_STRING = "";
	private final String DEFAULT_COMMUNITY = "Виберіть громаду";
	// for main information
	@FindBy(xpath = "//div[@class ='personal_header col-lg-4']/h4")
	private WebElement labelMainInformation;
	@FindBy(xpath = "//label[@for='firstName']")
	private WebElement labelFirstName;
	@FindBy(xpath = "//label[@for='lastName']")
	private WebElement labelLastName;
	@FindBy(xpath = "//label[@for='middleName']")
	private WebElement labelMiddleName;
	@FindBy(xpath = "//label[@for='email']")
	private WebElement labelEmail;
	@FindBy(xpath = "//label[@for='login']")
	private WebElement labelLogin;
	@FindBy(xpath = "//label[@for='password']")
	private WebElement labelPassword;
	@FindBy(xpath = "//label[@for='confirmPassword']")
	private WebElement labelConfirmPassword;
	@FindBy(id = "firstName")
	private WebElement fieldForFirstName;
	@FindBy(id = "lastName")
	private WebElement fieldForLastName;
	@FindBy(id = "middleName")
	private WebElement fieldForMiddleName;
	@FindBy(id = "email")
	private WebElement fieldForEmail;
	@FindBy(id = "login")
	private WebElement fieldForLogin;
	@FindBy(id = "password")
	private WebElement fieldForPassword;
	@FindBy(id = "confirmPassword")
	private WebElement fieldForConfirmPassword;

	// for address data
	@FindBy(xpath = "//div[@class ='address_header col-lg-4']/h4")
	private WebElement labelAddressData;
	@FindBy(xpath = "//label[text()='Місто']")
	private WebElement labelCity;
	@FindBy(xpath = "//label[@for='region']")
	private WebElement labelRegion;
	@FindBy(xpath = "//label[@for='district']")
	private WebElement  labelDistrict;
	@FindBy(xpath = "//label[@for='street']")
	private WebElement  labelStreet;
	@FindBy(xpath = "//label[@for='building']")
	private WebElement labelBuilding;
	@FindBy(xpath = "//label[@for='flat']")
	private WebElement labelFlat;
	@FindBy(xpath = "//label[@for='postcode']")
	private WebElement labelPostcode;
	@FindBy(id = "city")
	private WebElement fieldForCity;
	@FindBy(id = "region")
	private WebElement fieldForRegion;
	@FindBy(id = "district")
	private WebElement fieldForDistrict;
	@FindBy(id = "street")
	private WebElement fieldForStreet;
	@FindBy(id = "building")
	private WebElement fieldForBuilding;
	@FindBy(id = "flat")
	private WebElement fieldForFlat;
	@FindBy(id = "postcode")
	private WebElement fieldForPostcode;

	// for passport data
	@FindBy(xpath = "//h4[contains(text(),'Паспортні дані')]")
	private WebElement labelPassportData;
	@FindBy(xpath = "//label[@for='passport_seria']")
	private WebElement labelPassportSeria;
	@FindBy(xpath = "//label[@for='passport_number']")
	private WebElement labelPassportNumber;
	@FindBy(xpath = "//label[@for='published_by_data']")
	private WebElement labelPublishedByData;
	@FindBy(id = "passport_seria")
	private WebElement  fieldForPassportSeria;
	@FindBy(id = "passport_number")
	private WebElement fieldForPassportNumber;
	@FindBy(id = "published_by_data")
	private WebElement fieldForPublishedByData;

	// for other data
	@FindBy(xpath = "//h4[contains(text(),'Інші дані')]")
	private WebElement labelOtherDate;
	@FindBy(xpath = "//label[@for='phone_number']")
	private WebElement labelPhoneNumber;
	@FindBy(xpath = "//label[@for='territorial_Community']")
	private WebElement labelTerritoryalCommunity;
	@FindBy(xpath = "//label[@for='dateOfAccession']")
	private WebElement labelDateOfAccession;
	@FindBy(id = "phone_number")
	private WebElement fieldForPhoneNumber;
	@FindBy(xpath = "//select[@id='territorial_Community']/option[1]")
	private WebElement fieldForTerritorialCommunityDefault;
	@FindBy(id = "datepicker")
	private WebElement fieldForDateOfAccession;
	@FindBy(id = "territorial_Community")
	private WebElement territorialCommunity;

	// for buttons
	@FindBy(id = "submit")
	private WebElement buttonSend;
	@FindBy(xpath = "//button[@type='reset']")
	private WebElement buttonReset;

	public CreateNewUserPage (WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
	}
	
	public WebElement getLabelMainInformation() {
		return this.labelMainInformation;
	}

	public WebElement getLabelFirstName() {
		return this.labelFirstName;
	}

	public WebElement getLabelLastName() {
		return this.labelLastName;
	}

	public WebElement getLabelMiddleName() {
		return this.labelMiddleName;
	}

	public WebElement getLabelEmail() {
		return this.labelEmail;
	}

	public WebElement getLabelLogin() {
		return this.labelLogin;
	}

	public WebElement getLabelPassword() {
		return this.labelPassword;
	}

	public WebElement getLabelConfirmPassword() {
		return this.labelConfirmPassword;
	}

	public WebElement getFieldForFirstName() {
		return this.fieldForFirstName;
	}

	public String getFieldForFirstNameText() {
		return getFieldForFirstName().getText();
	}
	
	public WebElement getFieldForLastName() {
		return this.fieldForLastName;
	}
	
	public String getFieldForLastNameText() {
		return getFieldForLastName().getText();
	}

	public WebElement getFieldForMiddleName() {
		return this.fieldForMiddleName;
	}
	
	public String getFieldForMiddleNameText() {
		return getFieldForMiddleName().getText();
	}

	public WebElement getFieldForEmail() {
		return this.fieldForEmail;
	}
	
	public String getFieldForEmailText() {
		return getFieldForEmail().getText();
	}

	public WebElement getFieldForLogin() {
		return this.fieldForLogin;
	}
	
	public String getFieldForLoginText() {
		return getFieldForLogin().getText();
	}

	public WebElement getFieldForPassword() {
		return this.fieldForPassword;
	}
	
	public String getFieldForPasswordText() {
		return getFieldForPassword().getText();
	}

	public WebElement getFieldForConfirmPassword() {
		return this.fieldForConfirmPassword;
	}
	
	public String getFieldForConfirmPasswordText() {
		return getFieldForConfirmPassword().getText();
	}

	public WebElement getLabelAddressData() {
		return this.labelAddressData;
	}

	public WebElement getLabelCity() {
		return this.labelCity;
	}

	public WebElement getLabelRegion() {
		return this.labelRegion;
	}

	public WebElement getLabelDistrict() {
		return this.labelDistrict;
	}

	public WebElement getLabelStreet() {
		return this.labelStreet;
	}

	public WebElement getLabelBuilding() {
		return this.labelBuilding;
	}

	public WebElement getLabelFlat() {
		return this.labelFlat;
	}

	public WebElement getLabelPostcode() {
		return this.labelPostcode;
	}

	public WebElement getFieldForCity() {
		return this.fieldForCity;
	}
	
	public String getFieldForCityText() {
		return getFieldForCity().getText();
	}

	public WebElement getFieldForRegion() {
		return this.fieldForRegion;
	}
	
	public String getFieldForRegionText() {
		return getFieldForRegion().getText();
	}

	public WebElement getFieldForDistrict() {
		return this.fieldForDistrict;
	}
	
	public String getFieldForDistrictText() {
		return getFieldForDistrict().getText();
	}

	public WebElement getFieldForStreet() {
		return this.fieldForStreet;
	}
	
	public String getFieldForStreetText() {
		return getFieldForStreet().getText();
	}

	public WebElement getFieldForBuilding() {
		return this.fieldForBuilding;
	}
	
	public String getFieldForBuildingText() {
		return getFieldForBuilding().getText();
	}

	public WebElement getFieldForFlat() {
		return this.fieldForFlat;
	}
	
	public String getFieldForFlatText() {
		return getFieldForFlat().getText();
	}

	public WebElement getFieldForPostcode() {
		return this.fieldForPostcode;
	}
	
	public String getFieldForPostcodeText() {
		return getFieldForPostcode().getText();
	}

	public WebElement getLabelPassportData() {
		return this.labelPassportData;
	}

	public WebElement getLabelPassportSeria() {
		return this.labelPassportSeria;
	}

	public WebElement getLabelPassportNumber() {
		return this.labelPassportNumber;
	}

	public WebElement getLabelPublishedByData() {
		return this.labelPublishedByData;
	}

	public WebElement getFieldForPassportSeria() {
		return this.fieldForPassportSeria;
	}
	
	public String getFieldForPassportSeriaText() {
		return getFieldForPassportSeria().getText();
	}

	public WebElement getFieldForPassportNumber() {
		return this.fieldForPassportNumber;
	}
	
	public String getFieldForPassportNumberText() {
		return getFieldForPassportNumber().getText();
	}

	public WebElement getFieldForPublishedByData() {
		return this.fieldForPublishedByData;
	}
	
	public String getFieldForPublishedByDataText() {
		return getFieldForPublishedByData().getText();
	}

	public WebElement getLabelOtherDate() {
		return this.labelOtherDate;
	}

	public WebElement getLabelPhoneNumber() {
		return this.labelPhoneNumber;
	}

	public WebElement getLabelTerritoryalCommunity() {
		return this.labelTerritoryalCommunity;
	}

	public WebElement getLabelDateOfAccession() {
		return this.labelDateOfAccession;
	}

	public WebElement getFieldForPhoneNumber() {
		return this.fieldForPhoneNumber;
	}
	
	public String getFieldForPhoneNumberText() {
		return getFieldForPhoneNumber().getText();
	}

	public WebElement getFieldForTerritorialCommunityDefault() {
		return this.fieldForTerritorialCommunityDefault;
	}
	
	public String getFieldForTerritorialCommunityDefaultText() {
		return getFieldForTerritorialCommunityDefault().getText();
	}
	
	public WebElement getFieldForDateOfAccession() {
		return this.fieldForDateOfAccession;
	}
	
	public Object getFieldForDateOfAccessionValue() {
		return	((JavascriptExecutor) webDriver)
				.executeScript("return $('#datepicker').datepicker({ dateFormat: 'yy-mm-dd' }).val();");
	}

	public WebElement getTerritorialCommunity() {
		return this.territorialCommunity;
	}

	public WebElement getButtonSend() {
		return this.buttonSend;
	}

	public WebElement getButtonReset() {
		return this.buttonReset;
	}

	public void setFieldForFirstName(String firstName) {
		getFieldForFirstName().sendKeys(firstName);
	}

	public void setFieldForLastName(String lastName) {
		getFieldForLastName().sendKeys(lastName);
	}

	public void setFieldForMiddleName(String middleName) {
		getFieldForPassportNumber().sendKeys(middleName);
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

	public void setFieldForTerritorialCommunityDefault(String territorialCommunityDefault) {
		getFieldForTerritorialCommunityDefault().sendKeys(territorialCommunityDefault);
	}

	public void setFieldForDateOfAccession(String dateOfAccession) {
		getFieldForDateOfAccession().sendKeys(dateOfAccession);
	}

	public void setTerritorialCommunity(String territorialCommunity) {
		new Select(getTerritorialCommunity()).selectByValue(territorialCommunity);
	}

	public void clickButtonSend() {
		getButtonSend().click();
	}

	public void clickButtonReset() {
		getButtonReset().click();
	}
	
	public NonConfirmedUsersPage successCreateUser(IUser user) {
		typeRequiredFields(user);
		clickButtonSend();
		return new NonConfirmedUsersPage(webDriver);
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
				.add(getButtonReset().isEnabled(), true).check();
	}
}
