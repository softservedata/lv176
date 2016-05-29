package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.Label;

public class UnsuccessDeleteAtemptPage {
	public final String VALIDATOR_MESSAGE = "Дану територіальну громаду видалити неможливо, оскільки є користувачі, які належать до неї";

	private class UnsuccessDeleteAtemptUIMap {
		public final IButton UnsuccessAtempt;
		public final ILabel validatorMessage;

		public UnsuccessDeleteAtemptUIMap() {
			this.UnsuccessAtempt = Button.get().getByCssSelector("button[data-bb-handler$='ok");
			this.validatorMessage = Label.get().getByCssSelector(".bootbox-body");
		}
	}

	private UnsuccessDeleteAtemptUIMap controls;

	public UnsuccessDeleteAtemptPage() {
		controls = new UnsuccessDeleteAtemptUIMap();
	}

	public IButton getUnsuccessDeleteAtempt() {
		return this.controls.UnsuccessAtempt;
	}

	public ILabel getValidatorMessage() {
		return this.controls.validatorMessage;
	}

	public String getValidatorMessageText() {
		return getValidatorMessage().getText();
	}

	public ShowAllCommunitiesPage confirmOkButtom() {
		getUnsuccessDeleteAtempt().click();
		return new ShowAllCommunitiesPage();
	}

}
