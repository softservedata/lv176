package com.softserve.edu.rs.data.testdata;

public class CoordinatesDataRepository {
	private static volatile CoordinatesDataRepository instance = null;

	private CoordinatesDataRepository() {
	}

	public static CoordinatesDataRepository get() {
		if (instance == null) {
			synchronized (CoordinatesDataRepository.class) {
				if (instance == null) {
					instance = new CoordinatesDataRepository();
				}
			}
		}
		return instance;
	}

	
	public CoordinatesData getCoordinatesData(){
		return CoordinatesData.get()
				.setp1LatitudeGrad("45")
				.setp1LongitudedeGrad("28")
				.setp2LatitudeGrad("46")
				.setp2LongitudedeGrad("29")
				.setp3LatitudeGrad("47")
				.setp3LongitudedeGrad("30")
				.build();
	}
	
}
