package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.ILabelClickable;
import com.softserve.edu.atqc.controls.ISelect;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.LabelClickable;
import com.softserve.edu.atqc.controls.Link;
import com.softserve.edu.atqc.controls.SelectField;
import com.softserve.edu.atqc.controls.TextField;

public class EnteringData extends RegistratorHomePage {

	public static enum EnteringDataCount {
		TEN("10"), TWENTY_FIVE("25"), FIFTY("50"), ONE_HUNDRED("100");
		//
		private String field;

		private EnteringDataCount(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}

	private class EnteringDataUIMap {

		public final ILabel localPageName;
		public final ISelect enteringDataCount;
		public final ITextField searchField;
		public final ILabelClickable procurationDate;
		public final ILabelClickable partOwner;
		public final ILabelClickable registar;
		public final ILabelClickable objectRegNumb;
		public final ILabelClickable resourceStatus;
		public final ILabelClickable actions;
		public final ILabelClickable procurationShow;

		public EnteringDataUIMap() {
			this.localPageName = Link.get().getByCssSelector("h4");
			this.enteringDataCount = SelectField.get().getByCssSelector("#datatable_length>label>select");
			this.searchField = TextField.get().getByCssSelector("input");
			this.procurationDate = LabelClickable.get().getByXpath(".//th[3]");
			this.partOwner = LabelClickable.get().getByXpath(".//th[4]");
			this.registar = LabelClickable.get().getByXpath(".//th[5]");
			this.objectRegNumb = LabelClickable.get().getByXpath(".//th[7]");
			this.resourceStatus = LabelClickable.get().getByXpath(".//th[8]");
			this.actions = LabelClickable.get().getByXpath(".//th[9]");
			this.procurationShow = LabelClickable.get().getByCssSelector("tbody tr div a");
		}

	}

	private EnteringDataUIMap controls;

	public EnteringData() {
		this.controls = new EnteringDataUIMap();
	}

	// get elements
	public ILabel getLocalPageName() {
		return this.controls.localPageName;
	}

	public String localPageNameGetTExt() {
		return getLocalPageName().getText();
	}

	public ISelect getEnteringDataCount() {
		return this.controls.enteringDataCount;
	}

	public ITextField getSearchField() {
		return this.controls.searchField;
	}

	public String searchFieldGetText() {
		return getSearchField().getContent();
	}

	public ILabelClickable getProcurationDate() {
		return this.controls.procurationDate;
	}

	public String procurationDateGetTExt() {
		return getProcurationDate().getText();
	}

	public ILabelClickable getPartOwner() {
		return this.controls.partOwner;
	}

	public String partOwnerGetTExt() {
		return getPartOwner().getText();
	}

	public ILabelClickable getRegistar() {
		return this.controls.registar;
	}

	public String registarGetText() {
		return getRegistar().getText();
	}

	public ILabelClickable getObjectRegNumb() {
		return this.controls.objectRegNumb;
	}

	public String objectRegNumbGetText() {
		return getObjectRegNumb().getText();
	}

	public ILabelClickable getResourceStatus() {
		return this.controls.resourceStatus;
	}

	public String resourcesStatusGetTExt() {
		return getResourceStatus().getText();
	}

	public ILabelClickable getActions() {
		return this.controls.actions;
	}

	public String actionsGetTExt() {
		return getActions().getText();
	}
	// todo business logic

	public void setEnteringDataCount(EnteringDataCount count) {
		getEnteringDataCount().selectByVisibleText(count.toString());
	}

	public String getItemsPerPageSelectedText() {
		return controls.enteringDataCount.getFirstSelectedOption().getText();
	}

	public ProcurationPage getProcurations() {
		this.controls.procurationShow.click();
		return new ProcurationPage();

	}
}
