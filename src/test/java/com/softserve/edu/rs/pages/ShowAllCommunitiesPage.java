package com.softserve.edu.rs.pages;

import java.util.List;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.Label;

public class ShowAllCommunitiesPage {

	private class ShowAllCommunitiesPageUIMap {
		public final IButton addNewCommunityButton;
		public final ILabel nameOfTable;

		public ShowAllCommunitiesPageUIMap() {
			this.addNewCommunityButton = Button.get().getByCssSelector(".btn.btn-success[href='addCommunity']");
			this.nameOfTable = Label.get().getByCssSelector("div[style='text-align: center;'] h4");

		}

		// TODO
		public ILabel communityName(String CommunityName) {
			return Label.get().getByXpath("//td[contains(text(),'" + CommunityName + "')]");
		}

		public IButton editCommunityButton(String NameOfEditCommunity) {
			return Button.get().getByXpath("//td[contains(text(),'" + NameOfEditCommunity
					+ "')]/following-sibling::td[2]/descendant::div[1]/a[@id ='editcommunity']");
		}

		public IButton deleteCommunityButton(String NameOfDeleteCommunity) {
			return Button.get().getByXpath("//td[contains(text(),'" + NameOfDeleteCommunity
					+ "')]/following-sibling::td[2]/descendant::div[2]/a[@id ='deletecommunity']");

		}

		public boolean EnabledOfCommunity(String NameOfCommunity) {
			try {
				return Label.get().getByXpath("//td[contains(text(),'" + NameOfCommunity + "')]").isDisplayed();

			} catch (Exception e) {
				return false;
			}
		}

	}

	private ShowAllCommunitiesPageUIMap controls;

	public ShowAllCommunitiesPage() {

		controls = new ShowAllCommunitiesPageUIMap();
	}

	public IButton getAddNewCommunity() {
		return this.controls.addNewCommunityButton;
	}

	public ILabel getNameOfTable() {
		return this.controls.nameOfTable;
	}

	public IButton getEditCommunityButton(String NameOfEditedCommunity) {
		return this.controls.editCommunityButton(NameOfEditedCommunity);
	}

	public IButton getDeleteCommunityButton(String NameOfDeletedCommunity) {
		return this.controls.deleteCommunityButton(NameOfDeletedCommunity);
	}

	public boolean VerifyDisplayedOfCommunity(String NameOfCommunity) {
		return this.controls.EnabledOfCommunity(NameOfCommunity);
	}

	// TODO
	public ILabel getCommunityName(String CommunityName) {
		return this.controls.communityName(CommunityName);
	}

	public String getCommunityNameText(String CommunityName) {
		return getCommunityName(CommunityName).getText();
	}

	public void clickAddNewCommunity() {
		getAddNewCommunity().click();
	}

	public String getNameOfTableText() {
		return getNameOfTable().getText();
	}

	public AddNewCommunityPage gotoAddNewCommunityPage() {
		clickAddNewCommunity();
		return new AddNewCommunityPage();
	}

	public EditCommunityPage gotoEditCommunityPage(String NameOfEditCommunity) {
		getEditCommunityButton(NameOfEditCommunity).click();
		return new EditCommunityPage();
	}

	public ConfirmDecisionPage clickDeleteButton(String NameOfDeletedCommunity) {
		getDeleteCommunityButton(NameOfDeletedCommunity).click();
		return new ConfirmDecisionPage();
	}

	public static boolean CheckListCommunities(List<String> searchResult, String expected) {
		boolean result = false;
		for (String element : searchResult) {
			if (element.contains(expected) == true) {
				result = true;
			}
		}
		return result;
	}

	public ConfirmDecisionPage clickDeleteCommunityButton(String NameOfCommunity) {
		getDeleteCommunityButton(NameOfCommunity).click();
		return new ConfirmDecisionPage();
	}

	public EditCommunityPage clickEditCommunityButton(String NameOfEditCommunity) {
		getEditCommunityButton(NameOfEditCommunity).click();
		return new EditCommunityPage();
	}

}
