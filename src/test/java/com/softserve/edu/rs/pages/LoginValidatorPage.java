package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.Label;



public class LoginValidatorPage extends LoginPage {
	
	private class LoginValidatorPageUIMap {
		public final ILabel validator;
    	
    	public LoginValidatorPageUIMap() {
    		this.validator = Label.get().getByXpath("//div[@style='color: red;']");
    	}
    }
	
	public static final String START_VALIDATOR_MESSAGE = "You have entered wrong login or password.";
	private LoginValidatorPageUIMap controls;
	
	public LoginValidatorPage(){
		controls = new LoginValidatorPageUIMap();
	}
	
	public ILabel getValidator() {
		return this.controls.validator;
	}

	public String getValidatorText() {
		return getValidator().getText();
	}

	public String getStartValidatorText() {
		return getValidatorText().substring(0, START_VALIDATOR_MESSAGE.length());
	}
}
