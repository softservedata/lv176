package com.softserve.edu.rs.pages;

import java.util.List;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.ComponentsList;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.IComponentsList;
import com.softserve.edu.atqc.controls.ISelect;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.Select;
import com.softserve.edu.atqc.controls.TextField;

public class ActiveAdminSearchPage extends AdminHomePage {
	
	public static enum ItemsPerPage {
		TEN(10), TWENTYFIVE(25), FIFTY(50), HUNDRED(100);

		private int field;

		private ItemsPerPage(int field) {
			this.field = field;
		}

		public int toInt() {
			return this.field;
		}
	}
	
	public static enum RolesForSearch {
		ALL(""), ADMIN("ADMIN"), REGISTRATOR("REGISTRATOR"), CO_OWNER("USER"), COMMISSIONER("COMMISSIONER");

		private String field;

		private RolesForSearch(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}
	
	private class ActiveAdminSearchPageUIMap {
		public final ISelect itemsPerPage;
		public final IButton searchButton;
		public final ITextField firstNameSearchField;
		public final ITextField lastNameSearchField;
		public final ITextField loginSearchField;
		public final ITextField communitySearchField;
		public final ITextField emailSearchField;
		public final ISelect roleSelectBox;
		
		public ActiveAdminSearchPageUIMap (){
			this.searchButton = Button.get().getById("bth-search");
			this.itemsPerPage = Select.get().getByXpath("//select[@name='example_length']");
			this.firstNameSearchField = TextField.get().getById("inputIndex1");
			this.lastNameSearchField = TextField.get().getById("inputIndex2");
			this.loginSearchField = TextField.get().getById("inputIndex3");
			this.communitySearchField = TextField.get().getById("inputIndex4");
			this.emailSearchField = TextField.get().getById("inputIndex5");
			this.roleSelectBox = Select.get().getById("inputIndex6");
		}
	}

	private class SearchTableUIMap {
		public final IComponentsList firstNames;
		public final IComponentsList lastNames;
		public final IComponentsList logins;
		public final IComponentsList communities;
		public final IComponentsList emails;
		public final IComponentsList roles;

		public SearchTableUIMap() {
			this.firstNames = ComponentsList.getByCss("td.firstName");
			this.lastNames = ComponentsList.getByCss("td.lastName");
			this.logins = ComponentsList.getByCss(".login.sorting_1");
			this.communities = ComponentsList.getByCss("td.territorialCommunity_name");
			this.emails = ComponentsList.getByCss("td.email");
			this.roles = ComponentsList.getByCss("td.role_type");
			
		}
	}
	
	private ActiveAdminSearchPageUIMap controls;
	private SearchTableUIMap tableControls;

	public ActiveAdminSearchPage() {
		this.controls = new ActiveAdminSearchPageUIMap();
		this.tableControls = new SearchTableUIMap();
	}
	
	public int getSearchTableItemQuantity(){
		return getListLogins().size();
	}
	
	public IComponentsList getLogins(){
		return tableControls.logins;
	}
	
	public IComponentsList getCommunitiesTableList(){
		return tableControls.communities;
	}
	
	public IComponentsList getEmailsTableList(){
		return tableControls.emails;
	}
	
	public IComponentsList getNamesTableList(){
		return tableControls.firstNames;
	}
	
	public IComponentsList getLastNamesTableList(){
		return tableControls.lastNames;
	}
	
	public List<String> getListNames(){
		return tableControls.firstNames.getListStrings();
	}
	
	public List<String> getListLastNames(){
		return tableControls.lastNames.getListStrings();
	}
	
	public List<String> getListLogins(){
		return tableControls.logins.getListStrings();
	}

	public List<String> getListCommunities(){
		return tableControls.communities.getListStrings();
	}
	
	public List<String> getListEmails(){
		return tableControls.emails.getListStrings();
	}
	
	public List<String> getListRoles(){
		return tableControls.roles.getListStrings();
	}
	
	public String getItemsPerPageSelectedText() {
		return controls.itemsPerPage.getFirstSelectedOption().getText();
	}
	
	private ActiveAdminSearchPage search(ITextField field, String text){
		field.click();
		field.clear();
		field.sendKeys(text);
		controls.searchButton.click();
		return new ActiveAdminSearchPage();
	}
	
	public ActiveAdminSearchPage searhByName(String text){
		return search(controls.firstNameSearchField, text);
	}
	
	public ActiveAdminSearchPage searhByLastName(String text){
		return search(controls.lastNameSearchField, text);
	}
	
	public ActiveAdminSearchPage searhByLogin(String text){
		return search(controls.loginSearchField, text);
	}
	
	public ActiveAdminSearchPage searhByCommunity(String text){
		return search(controls.communitySearchField, text);
	}
	
	public ActiveAdminSearchPage searhByEmail(String text){
		return search(controls.emailSearchField, text);
	}
	
	public ActiveAdminSearchPage setItemsPerPage(ItemsPerPage items){
		controls.itemsPerPage.selectByValue(items.toString());
		return new ActiveAdminSearchPage();
	}
	
	public ActiveAdminSearchPage searhByRole(RolesForSearch role){
		controls.roleSelectBox.selectByValue(role.toString());
		controls.searchButton.click();
		return new ActiveAdminSearchPage();
	}
	
	
	
}
