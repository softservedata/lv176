package com.softserve.edu.rs.pages;

import java.util.List;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.ComponentButtonList;
import com.softserve.edu.atqc.controls.ComponentsList;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.IComponentButtonList;
import com.softserve.edu.atqc.controls.IComponentsList;
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

		public IButton editCommunityButton(String NameOfEditCommunity) {
			return Button.get().getByXpath("//td[contains(text(),'" + NameOfEditCommunity + "')]/following-sibling::td[2]/descendant::div[1]/a[@id ='editcommunity']");

		}

		public IButton deleteCommunityButton(String NameOfDeleteCommunity) {
			return Button.get().getByXpath("//td[contains(text(),'" + NameOfDeleteCommunity + "')]/following-sibling::td[2]/descendant::div[2]/a[@id ='deletecommunity']");

		}

		public ILabel verifyEnabledOfCommunity(String NameOfCommunity) {
			return Label.get().getByXpath("//td[contains(text(),'" + NameOfCommunity + "')]");
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

	public ILabel verifyEnabledOfCommunity(String NameOfCommunity) {
		return this.controls.verifyEnabledOfCommunity(NameOfCommunity);
	}

	public String verifyEnabledOfCommunityText(String NameOfCommunity) {
		return verifyEnabledOfCommunity(NameOfCommunity).getText();
	}

	public void clickAddNewCommunity() {
		getAddNewCommunity().click();
	}
	
	public boolean Dis(String NameOfCommunity) {
		return verifyEnabledOfCommunityText( NameOfCommunity).isEmpty();
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

	public ConfirmDecisionPage DeleteCommunity(List<String> CommunityList, List<Button> ButtonDeleteList,
			String CommunityName) {

		for (String element : CommunityList) {
			for (Button elementSS : ButtonDeleteList) {
				if ((element.contains(CommunityName) == true) && (elementSS.getText().contains(CommunityName) == true)) {
						break;
					
				}
			}
		}
		return clickDeleteButton(CommunityName);
	}

	public ConfirmDecisionPage clickDeleteCommunityButton(String NameOfCommunity) {
		getDeleteCommunityButton(NameOfCommunity).click();
		return new ConfirmDecisionPage();
	}

	public EditCommunityPage clickEditCommunityButton(String NameOfEditCommunity) {
		getEditCommunityButton(NameOfEditCommunity).click();
		return new EditCommunityPage();
	}

	public EditCommunityPage EditCommunity(List<String> CommunityList, List<Button> ButtonEditList,
			String CommunityName) {
		for (String element : CommunityList) {
			for (Button elementSS : ButtonEditList) {
				if ((element.contains(CommunityName) == true)
						&& (elementSS.getText().contains(CommunityName) == true)) {
					break;

				}
			}
		}

		return clickEditCommunityButton(CommunityName);
	}
	
	

}
