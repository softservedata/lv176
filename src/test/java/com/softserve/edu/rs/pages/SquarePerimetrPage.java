package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.TextField;



public class SquarePerimetrPage extends AddNewResourceHomePage {
	
	private class SquarePerimetrPageUIMap {
		public final ITextField perimetr;
		public final ITextField square;
		
		public SquarePerimetrPageUIMap(){
			this.perimetr = TextField.get().getByXpath("//input[@name='resourceDiscrete[0].valueDiscretes[0].value']");
			this.square = TextField.get().getByXpath("//input[@name='resourceDiscrete[1].valueDiscretes[0].value']");
		}
	}
	
	private SquarePerimetrPageUIMap control;
	
	public SquarePerimetrPage(){
		this.control = new SquarePerimetrPageUIMap();
	}
	


	// Get Elements

	public ITextField getPerimetr() {
		return this.control.perimetr;
	}

	public ITextField getSquare() {
		return this.control.square;
	}

	// Set Elements

	public void clickPerimetr() {
		getPerimetr().click();
	}
	
	public void clickSquare() {
		getSquare().click();
	}
	

	
	public void setPerimetrClear(String value){
		getPerimetr().sendKeysClear(value);
	}
	
	public void setSquareClear(String value){
		getSquare().sendKeysClear(value);
	}
	
	public void setDataPerSq(String square, String perimetr){
		clickPerimetr();
		setPerimetrClear(perimetr);
		
		clickSquare();
		setSquareClear(square);
	}
	
	

}
