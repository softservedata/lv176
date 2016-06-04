package com.softserve.edu.rs.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ResourceBrief {
	private String description;
	private String subclass;
	private String identifier;

	private Date inputDate;

	public ResourceBrief(String description, String subclass, String identifier, Date inputDate) {
		super();
		this.description = description;
		this.subclass = subclass;
		this.identifier = identifier;
		this.inputDate = inputDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSubclass() {
		return subclass;
	}

	public void setSubclass(String subclass) {
		this.subclass = subclass;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}


}
