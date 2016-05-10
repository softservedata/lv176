package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ILink;
import com.softserve.edu.atqc.controls.Link;
import com.softserve.edu.rs.data.resources.ISubclass;

public class SubclassesOfObjectsPage extends RegistratorHomePage {

	private class SubclassesOfObjectsPageUIMap {
		public final ILink newSubclass;

		public SubclassesOfObjectsPageUIMap() {
			this.newSubclass = Link.get().getByCssSelector("a.btn.btn-success");
		}
	}

	// ---------------------------------------------------------------------------------

	private class DeleteSubclassMenuUIMap {
		public final ILink deleteSubclass;

		public DeleteSubclassMenuUIMap(String subclass) {
			this.deleteSubclass = Link.get().getByXpath("//table[@id='datatable']//tr[td='" + subclass + "']//a");
		}
	}

	// ---------------------------------------------------------------------------------

	private class PopUpMenuUIMap {
		public final IButton ok;
		public final IButton cancel;
		public final IButton close;

		public PopUpMenuUIMap() {
			this.ok = Button.get().getByXpath("//button[.='OK']");
			this.cancel = Button.get().getByCssSelector("button.btn.btn-default");
			this.close = Button.get().getByCssSelector("button.bootbox-close-button.close");
		}
	}

	// ---------------------------------------------------------------------------------

	private SubclassesOfObjectsPageUIMap controls;
	private DeleteSubclassMenuUIMap deleteSubclassMenuControls;
	private PopUpMenuUIMap popUpMenuControls;

	public SubclassesOfObjectsPage() {
		controls = new SubclassesOfObjectsPageUIMap();
	}

	// PageObject - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Get Elements

	public ILink getNewSubclass() {
		return this.controls.newSubclass;
	}

	public String getNewSubclassText() {
		return getNewSubclass().getText();
	}

	// ---------------------------------------------------------------------------------

	public ILink getDeleteSubclass(String subclass) {
		deleteSubclassMenuControls = new DeleteSubclassMenuUIMap(subclass);
		return this.deleteSubclassMenuControls.deleteSubclass;
	}

	// ---------------------------------------------------------------------------------

	public IButton getOk(String subclass) {
		clickDeleteSubclass(subclass);
		return this.popUpMenuControls.ok;
	}

	public IButton getCancel(String subclass) {
		clickDeleteSubclass(subclass);
		return this.popUpMenuControls.cancel;
	}

	public IButton getClose(String subclass) {
		clickDeleteSubclass(subclass);
		return this.popUpMenuControls.close;
	}

	// Set Data

	public void clickDeleteSubclass(String subclass) {
		getDeleteSubclass(subclass).click();
		popUpMenuControls = new PopUpMenuUIMap();
	}

	public void clickOk(String subclass) {
		getOk(subclass).click();
	}

	public void clickCancel(String subclass) {
		getCancel(subclass).click();
	}

	public void clickClose(String subclass) {
		getClose(subclass).click();
	}

	public void clickNewSubclass() {
		getNewSubclass().click();
	}

	// business - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	// Functional
	
	public boolean visibleDeleteSubclass(ISubclass subclass) {
		try {
		getDeleteSubclass(subclass.getSubclassName()).isDisplayed();		
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	public SubclassesOfObjectsPage changeLanguage(ChangeLanguageFields language) {
		setChangeLanguage(language);
		return new SubclassesOfObjectsPage();
	}

	public SubclassesOfObjectsPage deleteSubclass(ISubclass subclass) {
		clickOk(subclass.getSubclassName());
		return new SubclassesOfObjectsPage();
	}
	
	public AddSubclassPage gotoAddSubclassPage() {
		clickNewSubclass();
		return new AddSubclassPage();
	}
}
