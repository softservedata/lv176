package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.Label;

public class AddNewCommunityPageValidator extends AddNewCommunityPage {

	public static final String START_VALIDATOR_MESSAGE = "Підклас з вказаним іменем вже існує";

	private class AddNewCommunityPageValidatorUIMap {
		public final ILabel validatorMessage;

		public AddNewCommunityPageValidatorUIMap() {
			this.validatorMessage = Label.get().getByCssSelector(".error[style]");

		}
	}

	// Elements
	private AddNewCommunityPageValidatorUIMap controls;

	public AddNewCommunityPageValidator() {
		controls = new AddNewCommunityPageValidatorUIMap();
	}

	public ILabel getValidator() {
		return this.controls.validatorMessage;
	}

	public String getValidatorText() {
		return getValidator().getText();
	}

	public String getStartValidatorText() {
		return getValidatorText().substring(0, START_VALIDATOR_MESSAGE.length());
	}
}
