package com.softserve.edu.atqc.controls;

abstract class ARadioButton <TComponent> extends AButton<TComponent> implements IRadioButton {

    // implements constructor
    protected ARadioButton() {
    }

    // implements interface
    public ILabelClickable getLabelClickable(){
		
		return null;
	}
    public boolean isSelected() {
        return getControlWrapper().isSelected();
    }
    
  
   

}
