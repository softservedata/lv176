package com.softserve.edu;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

import com.csvreader.CsvReader;

public class CsvReaderData {
	private final static  String CSV_FILE = "src/test/resources/TestDataForFirstName - копия.csv";
	private static HashMap<String, String> validatorMessages = new HashMap<>();

	public static HashMap<String, String> read() {
		try {
			CsvReader csvReader = new CsvReader(new InputStreamReader(new FileInputStream(CSV_FILE), "UTF-8"), ';');
			csvReader.readHeaders();
			while (csvReader.readRecord()) {
				validatorMessages.put(csvReader.get("test data"), csvReader.get("messages"));
			}
			csvReader.close();
			return validatorMessages;
		} catch (IOException e) {
			throw new IllegalArgumentException("Could not correctly read test data from " + CSV_FILE);
		}
	}
	
	public static Object[][] convertHashMapToObjectArray(HashMap<String, String> hashMap) {
		Object[][] testData = new Object[hashMap.size()][2];
		int i = 0;
		for (Entry<String, String> entry : hashMap.entrySet()){
			if (entry.getKey() == ""){
				testData[i][0] = " ";
			} else {
				testData[i][0] = entry.getKey().toString();
			}
			//testData[i][0] = entry.getKey().toString();
			System.out.println(entry.getKey().toString());
			testData[i][1] = entry.getValue().toString();
			i++;
		}
		return testData;
	}
}
