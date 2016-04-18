package com.softserve.edu.rs.testutils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TestDataPreparator {
	
	public static Object[][] convertToMultidimensionalArray (List<String> elements){
		Object[][] result = new Object[elements.size()][1];
		for (int i = 0; i<elements.size(); i++){
			result[i][0]=elements.get(i);
		}		
		return result;
	}
	
	public static List<String> gerDataFromFile(String wayToFile) throws Exception{
		BufferedReader reader;
		String line;
		List<String> lines = new ArrayList<String>();
		reader = new BufferedReader(new FileReader(wayToFile));
				
		while ((line = reader.readLine()) != null) {
            lines.add(line);
		}
		
		if (reader != null) {
			try {
				reader.close();
			} catch (IOException e) {}
		}		
		return lines;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
