package com.softserve.edu.rs.pages;



import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.ILabelClickable;

import com.softserve.edu.atqc.controls.Label;
import com.softserve.edu.atqc.controls.LabelClickable;



public class ResourcePage extends RegistratorHomePage {
	
	private class ResourcePageUIMap {
		public final ILabel resourceNumber;
		public final ILabelClickable deleteResource;
		
		public ResourcePageUIMap(){
			this.resourceNumber = Label.get().getById("resourceIdentifier");
			this.deleteResource = LabelClickable.get().getById("deleteResource");
	
		}
	}

	private class DialogResoursePageUIMap{
		public final IButton ok;
		
		public DialogResoursePageUIMap(){
			this.ok = Button.get().getByXpath("//button[contains(text(),'OK')]");
		}
	}

    
	private ResourcePageUIMap control;
	private DialogResoursePageUIMap dialogResource;
	
	public ResourcePage() {
		this.control = new ResourcePageUIMap();
 
	}

	// Get Elements

	public ILabel getResorceNumber() {
		return this.control.resourceNumber;
	}
	
	public ILabelClickable getDeleteResource() {
		return this.control.deleteResource;
	}
	
	public String getResorceNumberText(){
		return getResorceNumber().getText();
	}
	
	public IButton getOk(){
		clickDeleteResource();
		return this.dialogResource.ok;
	}
	
	
	public void clickDeleteResource() {
		getDeleteResource().click();
		this.dialogResource = new DialogResoursePageUIMap();
	}
	
	
	public ResourceSearchPage clickOk(){
	    getOk().click();
	    return new ResourceSearchPage();
	}

}
