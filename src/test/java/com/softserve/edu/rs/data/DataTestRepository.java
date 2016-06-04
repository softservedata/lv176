package com.softserve.edu.rs.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import com.softserve.edu.atqc.tools.Coordinate;
import com.softserve.edu.rs.utils.ResourceBrief;

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

	public Object[][] getSearchByPointCoordinates() {
		return new Object[][] { { new Coordinate(49, 45, 0), new Coordinate(24, 40, 0), new HashSet<String>(Arrays.asList( "123:44:35:445:34567:3457", "123:33:33:333:33333:2222" )) },
				{ new Coordinate(49, 45, 6.1), new Coordinate(24, 40, 3.7) ,new HashSet<String>(Arrays.asList( "123:44:35:445:34567:3457", "123:33:33:333:33333:2222" )) }, };

	}

	public Object[][] getSearchByPointCoordinatesNotFound() {
		return new Object[][] { { new Coordinate(49, 45, 0), new Coordinate(35, 40, 0) },
				{ new Coordinate(49, 45, 6.1), new Coordinate(37, 40, 3.7) }, };

	}

	public Object[][] getSearchByAreaCoordinates() {
		return new Object[][] {
				{ new Coordinate(49, 45, 0), new Coordinate(24, 40, 0), new Coordinate(49, 5, 0),
						new Coordinate(24, 1, 0),
						new HashSet<String>(Arrays.asList("123:44:35:445:34567:3457", "123:44:35:445:34567:1096",
								"123:66:99:678:78868:1222", "123:33:33:333:33333:2222")) },
				{ new Coordinate(49, 45, 11.8), new Coordinate(24, 40, 7.7), new Coordinate(49, 5, 6.34),
						new Coordinate(24, 0, 48.96342),
						new HashSet<String>(Arrays.asList("123:44:35:445:34567:3457", "123:44:35:445:34567:1096",
								"123:66:99:678:78868:1222", "123:33:33:333:33333:2222")) } };

	}

	public Object[][] getSearchByAreaCoordinatesNotFound() {
		return new Object[][] {
				{ new Coordinate(51, 45, 0), new Coordinate(24, 40, 0), new Coordinate(51, 55, 0),
						new Coordinate(24, 1, 0) },
				{ new Coordinate(52, 0, 0), new Coordinate(24, 30, 0), new Coordinate(53, 0, 0),
						new Coordinate(24, 0, 0) }, 
						{ new Coordinate(47, 0, 11), new Coordinate(24, 30, 0), new Coordinate(46, 0, 10.468),
							new Coordinate(24, 0, 0) }, 	
						{ new Coordinate(47, 0, 11), new Coordinate(24, 30, 0), new Coordinate(47, 0, 46),
								new Coordinate(24, 0, 0) }
							};

	}

	public Object[][] getShowAll() {
		return new Object[][] { {
				new HashSet<String>(Arrays.asList("123:44:35:445:34567:3459", "123:66:99:678:78868:1235",
						"123:44:35:445:34567:3457", "123:44:35:445:34567:1096", "123:66:99:678:78868:3100",
						"123:66:99:678:78868:3101", "123:66:99:678:78868:3103", "123:44:35:445:34567:1380",
						"123:44:35:445:34567:1321", "123:66:99:678:78868:1123")),
				"Showing 1 to 10 of 14 entries", } };
	}

	public Object[][] getShowAllSelect() {
		return new Object[][] {
				{ new HashSet<String>(Arrays.asList("298:67:78:999:58791:4757", "123:33:33:333:33333:2222")),
						"Showing 1 to 2 of 2 entries", } };
	}

	public Object[][] getTableSearchText() {
		return new Object[][] {
				{ new Coordinate(49, 45, 0), new Coordinate(24, 40, 0), new Coordinate(49, 5, 0),
						new Coordinate(24, 1, 0),
						new HashSet<String>(Arrays.asList("123:44:35:445:34567:3457", "123:44:35:445:34567:1096",
								"123:66:99:678:78868:1222")) },
				{ new Coordinate(49, 45, 11.8), new Coordinate(24, 40, 7.7), new Coordinate(49, 5, 6.34),
						new Coordinate(24, 0, 48.96342), new HashSet<String>(Arrays.asList("123:44:35:445:34567:3457",
								"123:44:35:445:34567:1096", "123:66:99:678:78868:1222")) } };
	}

	public Object[][] getPaginationNumberResults() {
		return new Object[][] { { new Coordinate(47, 0, 0), new Coordinate(23, 0, 0), new Coordinate(51, 0, 0),
				new Coordinate(27, 0, 0), "Showing 1 to 10 of 14 entries", "Showing 1 to 14 of 14 entries" }, };
	}

	public double[] getCoords() {
		return new double[] { 47, 0, 0, 23, 0, 0, 51, 0, 0, 27, 0, 0 };
	}

	public Object[][] getSortedByDateResults() {
		Object[][] res = new Object[][] { { new ArrayList<ResourceBrief>(Arrays.asList(
				new ResourceBrief("PlotC", "земельний", "123:44:35:445:34567:3459",    new Date(116, 03, 13)),
				new ResourceBrief("ДілянкаА", "земельний", "123:66:99:678:78868:1235", new Date(116, 02, 15)),
				new ResourceBrief("ДілянкаБ", "земельний", "123:44:35:445:34567:3457", new Date(116, 02, 16)),
				new ResourceBrief("ДілянкаВ", "земельний", "123:66:99:678:78868:3100", new Date(116, 04, 15)),
				new ResourceBrief("ДілянкаВ", "земельний", "123:66:99:678:78868:3101", new Date(116, 04, 15)),
				new ResourceBrief("ДілянкаВ", "земельний", "123:66:99:678:78868:3103", new Date(116, 04, 15)),
				new ResourceBrief("ДілянкаВ", "земельний", "123:66:99:678:78868:3100", new Date(116, 04, 15)),
				new ResourceBrief("ДілянкаЕ", "земельний", "123:44:35:445:34567:1380", new Date(116, 04, 24)),
				new ResourceBrief("ДілянкаК", "земельний", "123:44:35:445:34567:1321", new Date(116, 04, 24)),
				new ResourceBrief("ДілянкаМ", "земельний", "123:66:99:678:78868:1123", new Date(116, 04, 24)),
				new ResourceBrief("ДілянкаН", "земельний", "123:44:35:445:34567:1096", new Date(116, 04, 24)),
				new ResourceBrief("ділянкаП", "земельний", "123:66:99:678:78868:1222", new Date(116, 04, 24)),
				//new ResourceBrief("ДілянкаР", "земельний", "123:44:35:445:34567:2133", new Date(116, 04, 24)),
				new ResourceBrief("ДілянкаУ", "земельний", "123:44:35:445:34567:1290", new Date(116, 04, 24)),
				new ResourceBrief("ДіілянкаО", "земельний", "123:44:35:445:34567:1100", new Date(116, 04, 24)),
				new ResourceBrief("ЧастотаММ", "радіочастотний", "123:33:33:333:33333:2222",new Date(116, 03, 13)))) } };
		return res;
		// },
		// { new
		// ArrayList<ResourceBrief>(Arrays.asList("123:44:35:445:34567:1380",
		// "123:44:35:445:34567:1321",
		// "123:66:99:678:78868:1123", "123:44:35:445:34567:1096",
		// "123:66:99:678:78868:1222",
		// "123:44:35:445:34567:2133", "123:44:35:445:34567:1290",
		// "123:44:35:445:34567:1100",
		// "123:44:35:445:34567:3457", "123:66:99:678:78868:3100")) } };
	}
}
