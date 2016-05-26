package com.softserve.edu.rs.pages;

import java.util.List;

import com.softserve.edu.atqc.controls.ILabelClickable;

public interface ISearchParameters {
	void init();

	void input(String... args);

	List<ILabelClickable> getElements();
}
