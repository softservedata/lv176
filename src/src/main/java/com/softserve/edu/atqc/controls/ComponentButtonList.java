package com.softserve.edu.atqc.controls;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.atqc.tools.ControlLocation;
import com.softserve.edu.atqc.tools.ControlWrapper;

public class ComponentButtonList implements IComponentButtonList {

	public List<IButton> buttonList;

	private ComponentButtonList(String id) {
		this.buttonList = getByControlWrapper(ControlWrapper.getVisibleWebElements(ControlLocation.getByXPath(id)));
	}

	public static ComponentButtonList getByXpath(String xpath) {
		return new ComponentButtonList(xpath);
	}

	private static List<IButton> getByControlWrapper(List<ControlWrapper> arr) {
		List<IButton> result = new ArrayList<IButton>();
		for (ControlWrapper cw : arr) {
			result.add(Button.get().getByControlWrapper(cw));
		}
		return result;
	}

	public List<Button> getListOfButton() {
		List<Button> result = new ArrayList<Button>();
		for (IButton lc : buttonList) {
			result.add(0, (Button) lc);
		}
		return result;
	}

}
