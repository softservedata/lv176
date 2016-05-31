package com.softserve.edu.atqc.controls;
import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.atqc.tools.ControlLocation;
import com.softserve.edu.atqc.tools.ControlWrapper;

public class ComponentsList implements IComponentsList {
	public List<ILabelClickable> labeleList;
	
	private ComponentsList(String tagName){
		this.labeleList = getByControlWrapper(ControlWrapper.getVisibleWebElements(ControlLocation.getByTagName(tagName)));
	}
	
	public static ComponentsList getByTagName(String tagName){
		return new ComponentsList(tagName);
	}
	
	private static List<ILabelClickable> getByControlWrapper(List<ControlWrapper> arr){
		List<ILabelClickable> result = new ArrayList<ILabelClickable>();
		for (ControlWrapper cw : arr){
			result.add(LabelClickable.get().getByControlWrapper(cw));
		}
		
		return result;
	}
	
	public List<String> getListStrings(){
		List<String> result = new ArrayList<String>();
		for (ILabelClickable lc : labeleList) {
			result.add(lc.getText());
		}
		
		return result;
	}
	
	public int labeleListSize(){
		return labeleList.size();
	}
	
	
	
	
	
	
	
}