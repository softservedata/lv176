package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;

public class ConfirmDecisionPage {
	private class ConfirmDecisionPageUIMap {
		public final IButton confirmButtonOk;

		public ConfirmDecisionPageUIMap() {
			this.confirmButtonOk = Button.get().getByCssSelector("button[data-bb-handler$='confirm");

		}
	}

	private ConfirmDecisionPageUIMap controls;

	public ConfirmDecisionPage() {
		controls = new ConfirmDecisionPageUIMap();
	}

	public IButton getConfirmDecision() {
		return this.controls.confirmButtonOk;
	}

	public ShowAllCommunitiesPage clickConfirmButtonOk() {
		getConfirmDecision().click();
		return new ShowAllCommunitiesPage();
	}

	public UnsuccessDeleteAtemptPage clickConfirmUnsuccessAtempt() {
		getConfirmDecision().click();
		return new UnsuccessDeleteAtemptPage();
	}

}
