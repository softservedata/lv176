package com.softserve.edu.atqc.specs;

import com.softserve.edu.atqc.controls.IButton;

public final class ButtonCriteria extends ABaseCriteria implements IButtonCriteria {
    private final String IT_IS_NOT_VISIBLE = "Button it's not visible";
    private IButton button;

    private ButtonCriteria(IButton button) {
        this.button = button;
    }
    
    public static IButtonCriteria get(IButton button) {
		return new ButtonCriteria(button);
	}

	public IButtonCriteria isVisible() {
		FlexAssert.get().verify(button.isDisplayed(), IT_IS_NOT_VISIBLE);
		return this;
	}
}
