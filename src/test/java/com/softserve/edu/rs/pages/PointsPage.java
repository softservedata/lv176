package com.softserve.edu.rs.pages;

import com.softserve.edu.atqc.controls.Button;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.rs.data.testdata.CoordinatesData;


public class PointsPage extends AddNewResourceHomePage {
	
	
	private class FirstPointPageUIMap {
		public final ITextField p1LatitudeGrad;
		public final ITextField p1LongitudeGrad;
		
        public FirstPointPageUIMap() {
        	this.p1LatitudeGrad = TextField.get().getByXpath("//div[@id='areaInput1']/div[2]/input");
        	this.p1LongitudeGrad = TextField.get().getByXpath("//div[@id='areaInput1']/div[5]/input");
        }				
	}
	
	private class SecondPointPageUIMap {
		public final ITextField p2LatitudeGrad;
		public final ITextField p2LongitudeGrad;
		
        public SecondPointPageUIMap() {
        	this.p2LatitudeGrad = TextField.get().getByXpath("//div[@id='areaInput2']/div[2]/input");
        	this.p2LongitudeGrad = TextField.get().getByXpath("//div[@id='areaInput2']/div[5]/input");
        }				
	}
	
	private class ThirdPointPageUIMap {
		public final ITextField p3LatitudeGrad;
		public final ITextField p3LongitudeGrad;
		
        public ThirdPointPageUIMap() {
        	this.p3LatitudeGrad = TextField.get().getByXpath("//div[@id='areaInput3']/div[2]/input");
        	this.p3LongitudeGrad = TextField.get().getByXpath("//div[@id='areaInput3']/div[5]/input");
        }				
	}
	
	
	private class ManagePointsUIMap {
		public final IButton addPoint;
		public final IButton showOnMap;
		public final IButton dellAllTer;
		
		public ManagePointsUIMap() {
			this.addPoint = Button.get().getById("btnAddAreaPoint");
			this.showOnMap = Button.get().getById("addPointsToMap");
			this.dellAllTer = Button.get().getById("delAllPolygons");
		}
	}
   
	private FirstPointPageUIMap firstPointPageUIMap;
	private SecondPointPageUIMap secondPointPageUIMap;
	private ThirdPointPageUIMap thirdPointPageUIMap;
	private ManagePointsUIMap managePointsUIMap;

	public PointsPage() {
		this.firstPointPageUIMap = new FirstPointPageUIMap();
		this.managePointsUIMap = new ManagePointsUIMap();
	}

	// Get Elements

	public ITextField getP1LatitudeGrad() {
		return this.firstPointPageUIMap.p1LatitudeGrad;
	}



	public ITextField getP1LongitudeGrad() {
		return this.firstPointPageUIMap.p1LongitudeGrad;
	}



	public ITextField getP2LatitudeGrad() {
		//TODO
		return this.secondPointPageUIMap.p2LatitudeGrad;
	}



	public ITextField getP2LongitudeGrad() {
		//TODO
		return this.secondPointPageUIMap.p2LongitudeGrad;
	}



	public ITextField getP3LatitudeGrad() {
		//TODO
		return this.thirdPointPageUIMap.p3LatitudeGrad;
	}


	
	public ITextField getP3LongitudeGrad() {
		//TODO
		return this.thirdPointPageUIMap.p3LongitudeGrad;
	}



	public IButton getAddPoint() {
		return this.managePointsUIMap.addPoint;
	}

	public IButton getShowOnMap() {
		return this.managePointsUIMap.showOnMap;
	}
	
	public IButton getDelAllter() {
		return this.managePointsUIMap.dellAllTer;
	}
	
	
	
	public String getDellAllTerText(){
		return getDelAllter().getText();
	}
	

	// Set Elements

	public void clicP1LatitudeGrad() {
		getP1LatitudeGrad().click();
	}


	public void clicP1LongitudeGrad() {
		getP1LongitudeGrad().click();
	}



	public void clicP2LatitudeGrad() {
		getP2LatitudeGrad().click();
	}



	public void clicP2LongitudeGrad() {
		getP2LongitudeGrad().click();
	}



	public void clicP3LatitudeGrad() {
		getP3LatitudeGrad().click();
	}



	public void clicP3LongitudeGrad() {
		getP3LongitudeGrad().click();
	}



	public void clickAddPoint() {
		getAddPoint().click();
	}

	public void clickShowOnMap() {
		getShowOnMap().click();
	}
	
	public void clickDelAllTer() {
		getDelAllter().click();
	}
	

	public void setP1LatitudeGradClear(String grad) {
		getP1LatitudeGrad().sendKeysClear(grad);
	}



	public void setP1LongitudeGradClear(String grad) {
		getP1LongitudeGrad().sendKeysClear(grad);
	}



	public void setP2LatitudeGradClear(String grad) {
		getP2LatitudeGrad().sendKeysClear(grad);
	}


	public void setP2LongitudeGradClear(String grad) {
		getP2LongitudeGrad().sendKeysClear(grad);
	}


	public void setP3LatitudeGradClear(String grad) {
		getP3LatitudeGrad().sendKeysClear(grad);
	}


	public void setP3LongitudeGradClear(String grad) {
		getP3LongitudeGrad().sendKeysClear(grad);
	}


	// Business Logic
	// Functional

	public void enterPoints(CoordinatesData coordinates) {

		clicP1LatitudeGrad();
		setP1LatitudeGradClear(coordinates.getP1LatitudeGrad());
		
		clicP1LongitudeGrad();
		setP1LongitudeGradClear(coordinates.getP1LLongitudeGrad());

		
		clickAddPoint();
		this.secondPointPageUIMap = new SecondPointPageUIMap();
		
		clicP2LatitudeGrad();
		setP2LatitudeGradClear(coordinates.getP2LatitudeGrad());

		
		clicP2LongitudeGrad();
		setP2LongitudeGradClear(coordinates.getP2LLongitudeGrad());

		
		clickAddPoint();
		this.thirdPointPageUIMap = new ThirdPointPageUIMap();
		
		clicP3LatitudeGrad();
		setP3LatitudeGradClear(coordinates.getP3LatitudeGrad());
		

		clicP3LongitudeGrad();
		setP3LongitudeGradClear(coordinates.getP3LLongitudeGrad());
		
		clickShowOnMap();
		
	}

}
