package com.softserve.edu.rs.data.testdata;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.atqc.data.CSVUtils;
import com.softserve.edu.atqc.data.IExternalData;

public final class ResourceUtils {
	private String filename;
	private IExternalData externalData;

	public ResourceUtils(String filename) {
		this.filename = filename;
		this.externalData = new CSVUtils();
	}
	
	public ResourceUtils(String filename, IExternalData externalData) {
		this.filename = filename;
		this.externalData = externalData;
	}

	public List<ResourceData> getAllResourcesData() {
		return getAllResourcesData(this.getClass().getResource(filename).getPath().substring(1));
	}

	public List<ResourceData> getAllResourcesData(String absoluteFilePath) {
		List<ResourceData> resources = new ArrayList<ResourceData>();
		for (List<String> row : externalData.getAllCells(absoluteFilePath)) {
			if (row.get(1).toLowerCase().contains("resource")) {
				continue;
			}
			resources.add(ResourceData.get()
					.setResourceName(row.get(0))
					.setResourceNumber(row.get(1))
			);
		}
		
		return resources;			
		}

}
