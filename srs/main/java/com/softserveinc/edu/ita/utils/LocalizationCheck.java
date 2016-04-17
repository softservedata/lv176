package com.softserveinc.edu.ita.utils;

import static com.codeborne.selenide.Selenide.page;

import com.codeborne.selenide.Condition;
import com.softserveinc.edu.ita.ProcurationsTable;



public class LocalizationCheck {
	
	public static void registratorPageLocalizationTest(Integer Language, String LanguageChoose) throws Exception{
		
		TableUtils.setLocalizationDataTableFile();
		ProcurationsTable procurationTable = page(ProcurationsTable.class);
		procurationTable.getEnteringData().shouldBe(Condition.exist);
		procurationTable.changeLanguage(LanguageChoose);
		procurationTable.getChangeLanguageDropMenu().shouldHave(Condition.text(TableUtils.getCellData(4, Language)));
		procurationTable.getChangePasswordButton().shouldHave(Condition.text(TableUtils.getCellData(2, Language)));
		procurationTable.getResetPasswordButon().shouldHave(Condition.text(TableUtils.getCellData(3, Language)));
		procurationTable.getSignoutButton().shouldHave(Condition.text(TableUtils.getCellData(5, Language)));
		procurationTable.getResourceSearchLnkText().shouldHave(Condition.text(TableUtils.getCellData(6, Language)));
		procurationTable.getSubclassesOfResourcesLnkText().shouldHave(Condition.text(TableUtils.getCellData(7, Language)));
		procurationTable.getProcurationsLnkText().shouldHave(Condition.text(TableUtils.getCellData(8, Language)));
		procurationTable.getEnteringDataText().shouldHave(Condition.text(TableUtils.getCellData(9, Language)));
		procurationTable.getExtractFromRegisterLnkText().shouldHave(Condition.text(TableUtils.getCellData(10, Language)));
		procurationTable.getAddNewResourceLnkText().shouldHave(Condition.text(TableUtils.getCellData(11, Language)));
		procurationTable.getEnteringData().click();
		procurationTable.getActualPageName().shouldHave(Condition.text(TableUtils.getCellData(12, Language)));
		procurationTable.dataSortButtonGetText().shouldHave(Condition.text(TableUtils.getCellData(13, Language)));
		procurationTable.coownerSortButtonGetText().shouldHave(Condition.text(TableUtils.getCellData(14, Language)));
		procurationTable.registratorNameSortButtonGetText().shouldHave(Condition.text(TableUtils.getCellData(15, Language)));
		procurationTable.resorceRegistrationNumberSortButtonGetText()
				.shouldHave(Condition.text(TableUtils.getCellData(16, Language)));
		procurationTable.resourceStatusSortButtonGetText().shouldHave(Condition.text(TableUtils.getCellData(17, Language)));
		procurationTable.actionWithProcurationSortButtonGetTExt()
				.shouldHave(Condition.text(TableUtils.getCellData(18, Language)));
	};
	
	public void main(String[] args) {

	}
	
	
	

}