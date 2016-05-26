package com.softserve.edu.rs.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import com.softserve.edu.atqc.tools.Coordinate;

public class DataTestRepository {
	 private static volatile DataTestRepository instance = null;

		private DataTestRepository() {
		}
		
	    public static DataTestRepository get() {
	        if (instance == null) {
	            synchronized (DataTestRepository.class) {
	                if (instance == null) {
	                    instance = new DataTestRepository();
	                }
	            }
	        }
	        return instance;
	    }
	    
	    public Object[][] getSearchByPointCoordinates(){
	    	return new Object[][] { { new Coordinate(49, 45, 0), new Coordinate(24, 40, 0) },
				{ new Coordinate(49, 45, 6.1), new Coordinate(24, 40, 3.7) }, };
	    	
	    }
	    public Object[][] getSearchByPointCoordinatesNotFound(){
	    	return new Object[][] { { new Coordinate(49, 45, 0), new Coordinate(35, 40, 0) },
				{ new Coordinate(49, 45, 6.1), new Coordinate(37, 40, 3.7) }, };
	    	
	    }
	    
	    public Object[][] getSearchByAreaCoordinates(){
	    	return new Object[][] {
				{ new Coordinate(49, 45, 0), new Coordinate(24, 40, 0), new Coordinate(49, 5, 0),
						new Coordinate(24, 1, 0), new HashSet<String>(Arrays.asList("123:44:35:445:34567:3457", 
								"123:44:35:445:34567:1096","123:66:99:678:78868:1222","123:33:33:333:33333:2222")) },
				{ new Coordinate(49, 45, 11.8), new Coordinate(24, 40, 7.7), new Coordinate(49, 5, 6.34),
						new Coordinate(24, 0, 48.96342) ,new HashSet<String>(Arrays.asList("123:44:35:445:34567:3457", 
								"123:44:35:445:34567:1096","123:66:99:678:78868:1222","123:33:33:333:33333:2222"))} };
	    	
	    }
	    public Object[][] getSearchByAreaCoordinatesNotFound(){
	    	return new Object[][] {
				{ new Coordinate(59, 45, 0), new Coordinate(24, 40, 0), new Coordinate(59, 55, 0),
						new Coordinate(24, 1, 0) },
				{ new Coordinate(58, 0, 0), new Coordinate(24, 30, 0), new Coordinate(59, 0, 0),
						new Coordinate(24, 0, 0) }, };
	    	
	    }

		public Object[][] getShowAll() {
			return new Object[][] {
				{ new HashSet<String>
				(Arrays.asList("123:44:35:445:34567:3459",
						"123:66:99:678:78868:1235",
						"123:44:35:445:34567:3457",
						"123:44:35:445:34567:1096",
						"123:66:99:678:78868:3100",
						"123:66:99:678:78868:3101",
						"123:66:99:678:78868:3103",
						"123:44:35:445:34567:1380",
						"123:44:35:445:34567:1321",
						"123:66:99:678:78868:1123"))
					,"Showing 1 to 10 of 14 entries",
					}
				 };
		}

		public Object[][] getShowAllSelect() {
			return new Object[][] {
				{ new HashSet<String>
				(Arrays.asList("298:67:78:999:58791:4757", 
						"123:33:33:333:33333:2222"))
					,"Showing 1 to 2 of 2 entries",
					}
				 };
		}

		public Object[][] getTableSearchText() {
			return new Object[][] {
				{ new Coordinate(49, 45, 0), new Coordinate(24, 40, 0), new Coordinate(49, 5, 0),
						new Coordinate(24, 1, 0), new HashSet<String>(Arrays.asList("123:44:35:445:34567:3457", 
								"123:44:35:445:34567:1096","123:66:99:678:78868:1222")) },
				{ new Coordinate(49, 45, 11.8), new Coordinate(24, 40, 7.7), new Coordinate(49, 5, 6.34),
						new Coordinate(24, 0, 48.96342) ,new HashSet<String>(Arrays.asList("123:44:35:445:34567:3457", 
								"123:44:35:445:34567:1096","123:66:99:678:78868:1222"))} };
		}

		public Object[][] getPaginationNumberResults() {
			return new Object[][] {
				{ new Coordinate(47, 0, 0), new Coordinate(23, 0, 0), new Coordinate(51, 0, 0),
						new Coordinate(27, 0, 0), "Showing 1 to 10 of 14 entries", "Showing 1 to 14 of 14 entries"},
			 };
		}
}
