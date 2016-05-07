package com.softserve.edu.atqc.controls;

public class SelectField extends ASelect<ISelect> {
	private SelectField(){
	}
	
	public static ABaseComponent<ISelect> get() {
		SelectField instance = new SelectField();
        instance.setTComponent(instance);
        return instance;
    }
}
