package com.softserve.edu.rs.data.testdata;

import java.util.List;

import com.softserve.edu.atqc.data.ExcelUtils;

public class ResourceDataRepository {
	private static volatile ResourceDataRepository instance = null;

	private ResourceDataRepository() {
	}

	public static ResourceDataRepository get() {
		if (instance == null) {
			synchronized (ResourceDataRepository.class) {
				if (instance == null) {
					instance = new ResourceDataRepository();
				}
			}
		}
		return instance;
	}

	public ResourceData getResourceData(){
		return ResourceData.get()
				.setResourceName("земля")
				.setResourceNumber("0004");
	}
	
	public ResourceData getUnseccesData(){
		return ResourceData.get()
				.setResourceName("озеро")
				.setResourceNumber("0000000000");
	}
	
	public List<ResourceData> getResourcesExcel() {
        return new ResourceUtils("/resourceData.xlsx", new ExcelUtils()).getAllResourcesData();
    }
	
	public List<ResourceData> getResourcesNegativExcel() {
        return new ResourceUtils("/resourceDataNegativ.xlsx", new ExcelUtils()).getAllResourcesData();
    }
	
	public List<ResourceData> getResourcesCsv() {
        return new ResourceUtils("/resourceData.csv").getAllResourcesData();
    }
	
	public List<ResourceData> getResourcesNegativCsv() {
        return new ResourceUtils("/resourceDataNegativ.csv").getAllResourcesData();
    }
	
}
