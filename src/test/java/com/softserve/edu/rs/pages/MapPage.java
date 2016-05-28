package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.ILabelClickable;
import com.softserve.edu.atqc.controls.Label;
import com.softserve.edu.atqc.controls.LabelClickable;
import com.softserve.edu.atqc.data.apps.PageObserveLoad;


public class MapPage extends AddNewResourceHomePage {
	
	private class MapPageUIMap {
		public final ILabelClickable instrUsingMapButt;
		public final ILabel instrUsingMap;
		
		
		public MapPageUIMap() {
			this.instrUsingMapButt = LabelClickable.get().getById("mapManual");
			this.instrUsingMap = Label.get().getPresentByCssSelector("div.spoiler.col-md-12");

		}

	}
	
	private class PerSquLabelUIMap{
		public final ILabel squareTerr;
		public final ILabel perimetrTerr;
		
		public PerSquLabelUIMap() {
			this.squareTerr = Label.get().getPresentByXpath("//span[@id='infoBox']/div/span[1]");
			this.perimetrTerr = Label.get().getPresentByXpath("//span[@id='infoBox']/div/span[2]");
		}
	}

	private MapPageUIMap controls;
	private PerSquLabelUIMap perSquLabel;
	
	public MapPage() {
		PageObserveLoad.get().deleteLoadCompleteEvents();
         controls = new MapPageUIMap();
	}

	// Get Elements

	public ILabelClickable getInstrUsingMapButt() {
		return this.controls.instrUsingMapButt;
	}

	public ILabel getInstrUsingMap() {
		return this.controls.instrUsingMap;
	}

	public String getInstrUsingMapText() {
		return getInstrUsingMap().getText();
	}
	
	public ILabel getSquareTerr() {
		this.perSquLabel = new PerSquLabelUIMap();
		return this.perSquLabel.squareTerr;
	}
	
	public ILabel getPerimetrTerr() {
		this.perSquLabel = new PerSquLabelUIMap();
		return this.perSquLabel.perimetrTerr;
	}

	public String getSquareTerrText() {
		
		//String text = this.perSquLabel.squareTerr.getText();
		String text = getSquareTerr().getText();
		return text.substring(text.indexOf(" ")+1, text.lastIndexOf(" "));
	}
	
	public String getPerimetrTerrText() {
		
		//String text = this.perSquLabel.perimetrTerr.getText();
		String text =  getPerimetrTerr().getText();
		return text.substring(text.indexOf(" ")+1, text.lastIndexOf(" "));
	}
	
	// Set Data

	public void clicInstrUsingMapButt() {
		getInstrUsingMapButt().click();
	}
	
	
	// Business Logic
	// Functional
	
	public String verifyInstrUsingMap(){
		clicInstrUsingMapButt();
		return getInstrUsingMapText().substring(0, getInstrUsingMapText().indexOf('.'));
	}
	
	
	

}
