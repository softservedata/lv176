package com.softserve.edu.rs.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ResourceBriefUtils {
	private ResourceBriefUtils() {
	}

	public static List<ResourceBrief> sortByDate(List<ResourceBrief> resources) {
		Collections.sort(resources, new Comparator<ResourceBrief>() {
			@Override
			public int compare(ResourceBrief o1, ResourceBrief o2) {
				return o1.getInputDate().compareTo(o2.getInputDate());
			}
		});
		return resources;
	}

	public static List<ResourceBrief> sortById(List<ResourceBrief> resources) {
		Collections.sort(resources, new Comparator<ResourceBrief>() {
			@Override
			public int compare(ResourceBrief o1, ResourceBrief o2) {
				return o1.getIdentifier().compareTo(o2.getIdentifier());
			}
		});
		return resources;
	}

	public static List<Date> getDates(List<ResourceBrief> resources) {
		List<Date> result = new ArrayList<>();
		for (ResourceBrief res : resources)
			result.add(res.getInputDate());
		return result;
	}

	public static List<String> getIdentifiers(List<ResourceBrief> resources) {
		List<String> result = new ArrayList<>();
		for (ResourceBrief res : resources)
			result.add(res.getIdentifier());
		return result;
	}
}
