package com.softserve.edu.rs.data.testdata;

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
	
}
