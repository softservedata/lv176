package com.softserve.edu.rs.pages;

public class AdminHomePage extends CommonPage {

	private class AdminHomePageUIMap {
		//public final ITextField login;
    	
    	public AdminHomePageUIMap() {
    		//this.login = TextField.get().getById("login");
    	}
    }

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
    // Elements
    private AdminHomePageUIMap controls;

    public AdminHomePage() {
        //super();
    	controls = new AdminHomePageUIMap();
    }

    // Get Elements
    
//    public WebElement getListAllusers() {
//        return this.listAllusers;
//    }
//
//    public WebElement getRegisteredUsers() {
//        return this.registeredUsers;
//    }

    // PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Set Data
    
//    public void clickListAllusers() {
//    	getListAllusers().click();
//    }
//    
//    public void clickRegisteredUsers() {
//    	clickListAllusers();
//    	getRegisteredUsers().click();
//    }

    // business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Functional
	
    public AdminHomePage changeLanguage(ChangeLanguageFields language) {
    	setChangeLanguage(language);
        // Return a new page object representing the destination.
        return new AdminHomePage();
    }

    public LoginPage logout() {
    	clickLogout();
        // Return a new page object representing the destination.
        return new LoginPage();
    }
    
//    public RegisteredUsersHomePage gotoRegisteredUsers() {
//    	clickRegisteredUsers();
//        return new RegisteredUsersHomePage();
//    }

}
