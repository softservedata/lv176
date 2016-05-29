package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.Label;

public class AddCommunityPageValidator extends AddNewCommunityPage {

	public static final String START_VALIDATOR_MESSAGE_FOR_COMMUNITY = "Підклас з вказаним іменем вже існує";

	private class AddNewCommunityPageValidatorUIMap {
		public final ILabel validatorMessageCommunity;
		
        public AddNewCommunityPageValidatorUIMap() {
			this.validatorMessageCommunity = Label.get().getByCssSelector(".error[style]");

		}
	}
	
	private AddNewCommunityPageValidatorUIMap controls;

	public AddCommunityPageValidator() {
		controls = new AddNewCommunityPageValidatorUIMap();
	}

	public ILabel getValidatorCommunity() {
		return this.controls.validatorMessageCommunity;
	}
	
	public String getValidatorCommunityText() {
		return getValidatorCommunity().getText();
	}

	public String getStartValidatorCommunity() {
		return getValidatorCommunityText().substring(0, START_VALIDATOR_MESSAGE_FOR_COMMUNITY.length());
	}
	
}
