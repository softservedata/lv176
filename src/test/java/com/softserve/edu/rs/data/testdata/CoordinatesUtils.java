package com.softserve.edu.rs.data.testdata;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.atqc.data.CSVUtils;
import com.softserve.edu.atqc.data.IExternalData;

public final class CoordinatesUtils {
	private String filename;
	private IExternalData externalData;

	public CoordinatesUtils() {
		filename = "/coordinates.csv";
		externalData = new CSVUtils();
	}

	public CoordinatesUtils(String filename, IExternalData externalData) {
		this.filename = filename;
		this.externalData = externalData;
	}

	public List<CoordinatesData> getAllCoordinatesData() {
		return getAllCoordinatesData(this.getClass().getResource(filename).getPath().substring(1));
	}

	public List<CoordinatesData> getAllCoordinatesData(String absoluteFilePath) {
		List<CoordinatesData> coordinates = new ArrayList<CoordinatesData>();
		for (List<String> row : externalData.getAllCells(absoluteFilePath)) {
			if (row.get(1).toLowerCase().contains("grad")) {
				continue;
			}

		    coordinates.add(CoordinatesData.get()
						.setp1LatitudeGrad(row.get(0))
						.setp1LongitudedeGrad(row.get(1))
						.setp2LatitudeGrad(row.get(2))
						.setp2LongitudedeGrad(row.get(3))
						.setp3LatitudeGrad(row.get(4))
						.setp3LongitudedeGrad(row.get(5))
						.build()
				);
		}
		return coordinates;			
		}  


}
