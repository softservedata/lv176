package com.softserve.edu.rs.data.testdata;

import java.util.List;

import com.softserve.edu.rs.testutils.TestDataPreparator;


public class SearchDataRepository {
	
	public final static String FIRSTNAMESLOCATION = "src/test/java/com/softserve/edu/rs/data/testdata/namesearch";
	public final static String LASTNAMESLOCATION = "src/test/java/com/softserve/edu/rs/data/testdata/lastnamesearch";
	public final static String LOGINSLOCATION = "src/test/java/com/softserve/edu/rs/data/testdata/loginsearch";
	public final static String EMAILSLOCATION = "src/test/java/com/softserve/edu/rs/data/testdata/emailsearch";
	public final static String COMMUNITIESLOCATION = "src/test/java/com/softserve/edu/rs/data/testdata/communitysearch";
	public final static String ROLELOCATION = "src/test/java/com/softserve/edu/rs/data/testdata/rolesearch";
	
	private SearchDataRepository(){
		
	}
	
	public static List<String> getDataForNameField() {
		List<String> result = null;
		try{
			result = TestDataPreparator.gerDataFromFile(FIRSTNAMESLOCATION);
		} catch(Exception e){ }
		return result;
	}
	
	public static List<String> getDataForLastNameField() {
		List<String> result = null;
		try{
			result = TestDataPreparator.gerDataFromFile(LASTNAMESLOCATION);
		} catch(Exception e){ }
		return result;
	}
	
	public static List<String> getDataForLoginField() {
		List<String> result = null;
		try{
			result = TestDataPreparator.gerDataFromFile(LOGINSLOCATION);
		} catch(Exception e){ }
		return result;
	}
	
	public static List<String> getDataForEmailField() {
		List<String> result = null;
		try{
			result = TestDataPreparator.gerDataFromFile(EMAILSLOCATION);
		} catch(Exception e){ }
		return result;
	}
	
	public static List<String> getDataForCommunityField() {
		List<String> result = null;
		try{
			result = TestDataPreparator.gerDataFromFile(COMMUNITIESLOCATION);
		} catch(Exception e){ }
		return result;
	}
	
	public static List<String> getDataForRoleField() {
		List<String> result = null;
		try{
			result = TestDataPreparator.gerDataFromFile(ROLELOCATION);
		} catch(Exception e){ }
		return result;
	}
	
}
