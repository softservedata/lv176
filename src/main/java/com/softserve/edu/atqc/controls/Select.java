package com.softserve.edu.atqc.controls;

public final class Select extends ASelect<ISelect> {

	// implements constructor
	private Select() {
	}

	// implements static factory

	public static ABaseComponent<ISelect> get() {
		Select instance = new Select();
		instance.setTComponent(instance);
		return instance;
	}

}
