package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.Label;

public class AddCommunityValidatorRegNumber extends AddNewCommunityPage {
	
	private class AddCommunityValidatorRegNumberUIMap {
		public final ILabel validatorMessageRegNumber;
		

		public AddCommunityValidatorRegNumberUIMap() {
			this.validatorMessageRegNumber = Label.get().getByCssSelector(".error[id = 'registrationNumber.errors']");

		}
	}
	
	private AddCommunityValidatorRegNumberUIMap controls;

	public AddCommunityValidatorRegNumber() {
		controls = new AddCommunityValidatorRegNumberUIMap();
	}
	
	public ILabel getValidatorRegNumber(){
		return this.controls.validatorMessageRegNumber;
	}
	
	public String getValidatorRegNumberText(){
		return getValidatorRegNumber().getText();
	}

}
