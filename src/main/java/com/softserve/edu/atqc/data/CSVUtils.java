package com.softserve.edu.atqc.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.softserve.edu.atqc.exceptions.GeneralCustomException;

public final class CSVUtils implements IExternalData {
	private final String PROPERTIES_EXCEPTION_FOUND = "File %s could not be found";
	private final String PROPERTIES_EXCEPTION_READ = "File %s could not be read";
	private final String CSV_SPLIT_BY = ";";
	private final String DATA_FOR_FIRST_NAME = "src/test/resources/TestDataForFirstName.csv";
	private final String DATA_FOR_LAST_NAME = "src/test/resources/TestDataForLastName.csv";
	private final String DATA_FOR_EMAIL = "src/test/resources/TestDataForEmail.csv";
	private final String NAME_OF_MESSAGES_COLUMN = "messages";

	public List<List<String>> getAllCells(String absoluteFilePath) {
		List<List<String>> allCells = new ArrayList<List<String>>();
		String row;		
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(absoluteFilePath));) {
			while ((row = bufferedReader.readLine()) != null) {
				if (!row.contains(NAME_OF_MESSAGES_COLUMN))
				allCells.add(Arrays.asList(row.split(CSV_SPLIT_BY)));
			}
		} catch (FileNotFoundException e) {
			throw new GeneralCustomException(String.format(PROPERTIES_EXCEPTION_FOUND, absoluteFilePath), e);
		} catch (IOException e) {
			throw new GeneralCustomException(String.format(PROPERTIES_EXCEPTION_READ, absoluteFilePath), e);
		} 
		return allCells;
	}	
	
	public List<List<String>> readDataForFirstName() {
		return getAllCells(DATA_FOR_FIRST_NAME);
	}
	
	public List<List<String>> readDataForLastName() {
		return getAllCells(DATA_FOR_LAST_NAME);
	}
	
	public List<List<String>> readDataForEmail() {
		return getAllCells(DATA_FOR_EMAIL);
	}
}
