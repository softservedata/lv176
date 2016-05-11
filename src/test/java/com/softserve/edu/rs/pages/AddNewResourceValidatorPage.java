package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.Label;

public class AddNewResourceValidatorPage extends AddNewResourceHomePage {
	
	
	public static final String START_VALIDATOR_MESSAGE = 
			"Реєстраційний номер повинен відповідати формату xxx:xx:xx:xxx:xxxxx:xxxx";
	
	private class AddNewResourceValidatorUIMap{
		public final ILabel validator;
		
		public AddNewResourceValidatorUIMap(){
			this.validator = Label.get().getById("identifier.errors");
		}
	}
	
	private AddNewResourceValidatorUIMap controls;
	public AddNewResourceValidatorPage(){
		this.controls = new AddNewResourceValidatorUIMap();
	}
	
	public ILabel getValidator(){
		return this.controls.validator;
	}
	
	public String getValidatorText() {
		return getValidator().getText();
	}
	
	public String getStartValidatorText() {
		return getValidatorText().substring(0, START_VALIDATOR_MESSAGE.length());
	}



}
