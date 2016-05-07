package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.Label;

public class LoginValidatorPage extends LoginPage {
	public static final String VALIDATOR_MESSAGE = "You have entered wrong login or password.";
	
	private class LoginValidatorPageUIMap {
		public final ILabel validator;
		
		public LoginValidatorPageUIMap() {
			this.validator = Label.get().getByXpath("//div[@style='color: red;']");
		}
	}
	
	private LoginValidatorPageUIMap controls;
	
	public LoginValidatorPage() {
		controls = new LoginValidatorPageUIMap();
	}
	
	public ILabel getValidator() {
		return this.controls.validator;
	}

	public String getValidatorText() {
		return getValidator().getText();
	}
}
