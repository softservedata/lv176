package com.softserve.edu.atqc.tools;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

import com.csvreader.CsvReader;
import com.softserve.edu.atqs.tools.loggers.Log4jWrapper;

public class CsvReaderData {
	private final static String DATA_FOR_FIRST_NAME = "src/test/resources/TestDataForFirstName.csv";
	private final static String DATA_FOR_LAST_NAME = "src/test/resources/TestDataForLastName.csv";
	private final static String DATA_FOR_EMAIL = "src/test/resources/TestDataForEmail.csv";
	private final static String NAME_OF_DATA_COLUMN = "testData";
	private final static String NAME_OF_MESSAGES_COLUMN = "messages";
	
	public static HashMap<String, String> read(String path) {
		HashMap<String, String> validatorMessage = new HashMap<>();
		try {
			CsvReader csvReader = new CsvReader(new InputStreamReader(new FileInputStream(path), "UTF-8"), ';');
			csvReader.readHeaders();
			while (csvReader.readRecord()) {
				validatorMessage.put(csvReader.get(NAME_OF_DATA_COLUMN), csvReader.get(NAME_OF_MESSAGES_COLUMN));
			}
			csvReader.close();
		} catch (IOException e) {
			Log4jWrapper.get().info("Could not correctly read test data from " + path);
		}
		return validatorMessage;
	}
	
	public static Object[][] convertHashMapToObjectArray(HashMap<String, String> hashMap) {
		Object[][] testData = new Object[hashMap.size()][2];
		int i = 0;
		for (Entry<String, String> entry : hashMap.entrySet()) {
			testData[i][0] = entry.getKey().toString();
			testData[i][1] = entry.getValue().toString();
			i++;
		}
		return testData;
	}
	
	public static Object[][] readDataForFirstName() {
		return convertHashMapToObjectArray(read(DATA_FOR_FIRST_NAME));
	}
	
	public static Object[][] readDataForLastName() {
		return convertHashMapToObjectArray(read(DATA_FOR_LAST_NAME));
	}
	
	public static Object[][] readDataForEmail() {
		return convertHashMapToObjectArray(read(DATA_FOR_EMAIL));
	}
}
