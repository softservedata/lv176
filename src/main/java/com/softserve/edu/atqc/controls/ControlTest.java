package com.softserve.edu.atqc.controls;

public class ControlTest {

	public static void main(String[] args) throws Exception {
		IComponent component = Component.get().getById("id");
		component.getAttribute("");
		ILabel label = Label.get().getByPartialLinkText("");
		label.getText();
	}
}
