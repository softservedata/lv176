package com.softserve.edu.atqc.controls;

public final class RadioButton extends ARadioButton<IRadioButton> {

    // implements constructor
    private RadioButton() {
    }

    // implements static factory

    public static ABaseComponent<IRadioButton> get() {
        RadioButton instance = new RadioButton();
        instance.setTComponent(instance);
        return instance;
    }

}
