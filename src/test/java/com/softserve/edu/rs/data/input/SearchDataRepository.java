package com.softserve.edu.rs.data.input;

import java.util.List;

import com.softserve.edu.atqc.data.CSVUtils;


public class SearchDataRepository {
	
	public static final String EMAILSPATH = "C:/lv176-multilayer/src/test/resources/emails.csv";
	public static final String LOGINSPATH = "C:/lv176-multilayer/src/test/resources/logins.csv";
	public static final String NAMESPATH = "C:/lv176-multilayer/src/test/resources/names.csv";
	public static final String LASTNAMESSPATH = "C:/lv176-multilayer/src/test/resources/lastnames.csv";
	public static final String COMMUNITIESSPATH = "C:/lv176-multilayer/src/test/resources/communities.csv";
	
	private static volatile SearchDataRepository instance = null;
	
	private SearchDataRepository(){
	}
	
	public static SearchDataRepository get() {
        if (instance == null) {
            synchronized (SearchDataRepository.class) {
                if (instance == null) {
                    instance = new SearchDataRepository();
                }
            }
        }
        return instance;
    }
	
	public List<String> getInputFromCVS(String filePath) {
		return new CSVUtils().getAllSingleCells(filePath);
    }
	
	public List<String> getLoginsFromCVS() {
		return new CSVUtils().getAllSingleCells(LOGINSPATH);
    }
	
	public List<String> getNamesFromCVS() {
		return new CSVUtils().getAllSingleCells(NAMESPATH);
    }
	
	public List<String> getLastNamesFromCVS() {
		return new CSVUtils().getAllSingleCells(LASTNAMESSPATH);
    }
	
	public List<String> getCommunitiesFromCVS() {
		return new CSVUtils().getAllSingleCells(COMMUNITIESSPATH);
    }
	
	public List<String> getEmailsFromCVS() {
		return new CSVUtils().getAllSingleCells(EMAILSPATH);
    }
	
	
	
	
	
	
	
	
	
}
