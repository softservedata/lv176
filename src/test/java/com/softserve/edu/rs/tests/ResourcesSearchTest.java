package com.softserve.edu.rs.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.controls.ILabelClickable;
import com.softserve.edu.atqc.data.apps.ABaseApplication;
import com.softserve.edu.atqc.data.apps.ApplicationSources;
import com.softserve.edu.atqc.specs.FlexAssert;
import com.softserve.edu.rs.data.DataTestRepository;
import com.softserve.edu.rs.data.apps.Application;
import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.atqc.tools.BrowserUtils;
import com.softserve.edu.atqc.tools.Coordinate;
import com.softserve.edu.rs.pages.RegistratorHomePage;
import com.softserve.edu.rs.pages.ResourceSearchPage;
import com.softserve.edu.rs.pages.ResourceSearchPage.ObjectSubclasses;
import com.softserve.edu.rs.pages.TopPage.ChangeLanguageFields;
import com.softserve.edu.rs.utils.JSInjection;
import com.softserve.edu.rs.utils.ResourceBrief;
import com.softserve.edu.rs.utils.ResourceBriefUtils;

public class ResourcesSearchTest {
	private static final String UNSUCCESSFUL_SEARCH_LABEL_UKR = "За заданими параметрами ресурси не знайдено.";
	private static final String UNSUCCESSFUL_SEARCH_LABEL_RUS = "По заданным параметрам ресурсы не найдены.";
	private static final String UNSUCCESSFUL_SEARCH_LABEL_ENG = "Resources not found.";
	private static final String SEARCH_TABLE_TEXT = "Ділянка";
	private static final String SEARCH_UNSUCCESSFUL_TABLE_TEXT = "Ділюнка";
	private static final String TEXT_INFO_1_2 = "Showing 1 to 2 of 2 entries";
	private static final String TEXT_INFO_1_10 = "Showing 1 to 10 of 14 entries";
	private static final String TEXT_INFO_11_14 = "Showing 11 to 14 of 14 entries";
	private static final String TEXT_INFO_FILTER_1_3 = "Showing 1 to 3 of 3 entries (filtered from 4 total entries)";
	private static final String RESULTS_BY_PAGE_1="10";
	private static final String RESULTS_BY_PAGE_2="25";
	private RegistratorHomePage registratorHomePage;
	private ResourceSearchPage resourcesSearchPage;
	private ResourceSearchPage spage;

	@DataProvider
	public Object[][] getApplicationSources() {
		return new Object[][] { { ApplicationSourcesRepository.get().getLocalHostByFirefoxTemporary(),
				UserRepository.get().getRegistrator() }, };
	}

	@BeforeSuite
	public void oneTimeSetUp() {

		IUser registrator = UserRepository.get().getRegistrator();
		ApplicationSources applicationSources = ApplicationSourcesRepository.get().getLocalHostByFirefoxTemporary();
		Application application = Application.get(applicationSources);
		registratorHomePage = application.load().successRegistratorLogin(registrator);
		registratorHomePage.changeLanguage(ChangeLanguageFields.UKRAINIAN);
		resourcesSearchPage = registratorHomePage.gotoResourcesSearchPage();
	}

	@AfterSuite
	public void oneTimeTearDown() {
		Application.quitAll();
	}

	@DataProvider
	public Object[][] testCoordinates() {
		return DataTestRepository.get().getSearchByPointCoordinates();
	}

	@Test(groups = "main", dataProvider = "testCoordinates")
	public void testFound(Coordinate latitude, Coordinate longitude, Set<String> expectedIds) {
		spage = resourcesSearchPage.clickSearchByCoordinate()
				.putPointSearchCoordinate(latitude.getDegrees(), latitude.getMinutes(), latitude.getSeconds(),
						longitude.getDegrees(), longitude.getMinutes(), longitude.getSeconds())
				.clickSearchButton().initElementsAfterSuccessfulSearch();
		List<String> tablevalues = spage.getSearchResultsTable().getSearchResultIdValues();
		Set<String> ids = new HashSet<>(tablevalues);
		assertTrue(expectedIds.equals(ids), "Search by point results are not correct");
		assertEquals(spage.getSearchResultsTable().getSearchResultRows().size(), expectedIds.size(),
				"Search by point number of results are not correct");
		assertEquals(spage.getSearchResultsTable().getDataTextInfo().getText(), TEXT_INFO_1_2,
				"Search by point result text info incorrect");
	}

	@DataProvider
	public Object[][] testCoordinates_() {
		return DataTestRepository.get().getSearchByPointCoordinatesNotFound();
	}

	@Test(groups = "main", dataProvider = "testCoordinates_")
	public void testNotFound(Coordinate latitude, Coordinate longitude) {
		spage = resourcesSearchPage.clickSearchByCoordinate()
				.putPointSearchCoordinate(latitude.getDegrees(), latitude.getMinutes(), latitude.getSeconds(),
						longitude.getDegrees(), longitude.getMinutes(), longitude.getSeconds())
				.clickSearchButton().initElementsAfterUnsuccessfulSearch();
		FlexAssert.get().forElement(spage.getSearchResultDiv().getText()).valueMatch(UNSUCCESSFUL_SEARCH_LABEL_UKR);
	}

	@DataProvider
	public Object[][] testAreaCoordinates() {
		return DataTestRepository.get().getSearchByAreaCoordinates();
	}

	@Test(groups = "main", dataProvider = "testAreaCoordinates")
	public void testAreaFound(Coordinate latitude1, Coordinate longitude1, Coordinate latitude2, Coordinate longitude2,
			Set<String> expectedIds) {
		spage = resourcesSearchPage.clickSearchByArea()
				.putAreaSearchCoordinate(latitude1.getDegrees(), latitude1.getMinutes(), latitude1.getSeconds(),
						longitude1.getDegrees(), longitude1.getMinutes(), longitude1.getSeconds(),
						latitude2.getDegrees(), latitude2.getMinutes(), latitude2.getSeconds(), longitude2.getDegrees(),
						longitude2.getMinutes(), longitude2.getSeconds())
				.clickSearchAreaButton().initElementsAfterSuccessfulSearch();
		List<String> tablevalues = spage.getSearchResultsTable().getSearchResultIdValues();
		Set<String> ids = new HashSet<>(tablevalues);
		assertTrue(expectedIds.equals(ids), "Search by area results are not correct");
		assertEquals(spage.getSearchResultsTable().getSearchResultRows().size(), expectedIds.size(),
				"Number of search by area results are not correct");
		assertEquals(spage.getSearchResultsTable().getDataTextInfo().getText(),
				"Showing 1 to " + expectedIds.size() + " of " + expectedIds.size() + " entries",
				"Search by area result text info incorrect");
	}

	@DataProvider
	public Object[][] testAreaCoordinates_() {
		return DataTestRepository.get().getSearchByAreaCoordinatesNotFound();
	}

	@Test(groups = "main", dataProvider = "testAreaCoordinates_")
	public void testAreaNotFound(Coordinate latitude1, Coordinate longitude1, Coordinate latitude2,
			Coordinate longitude2) {
		spage = resourcesSearchPage.clickSearchByArea()
				.putAreaSearchCoordinate(latitude1.getDegrees(), latitude1.getMinutes(), latitude1.getSeconds(),
						longitude1.getDegrees(), longitude1.getMinutes(), longitude1.getSeconds(),
						latitude2.getDegrees(), latitude2.getMinutes(), latitude2.getSeconds(), longitude2.getDegrees(),
						longitude2.getMinutes(), longitude2.getSeconds())
				.clickSearchAreaButton().initElementsAfterUnsuccessfulSearch();
		FlexAssert.get().forElement(spage.getSearchResultDiv().getText()).valueMatch(UNSUCCESSFUL_SEARCH_LABEL_UKR);
	}

	@DataProvider
	public Object[][] testTableSearchText() {
		return DataTestRepository.get().getTableSearchText();
	}

	@Test(groups = "main", dataProvider = "testTableSearchText")
	public void testTableSearchText(Coordinate latitude1, Coordinate longitude1, Coordinate latitude2,
			Coordinate longitude2, Set<String> expectedIdsSearch) {
		spage = resourcesSearchPage.clickSearchByArea()
				.putAreaSearchCoordinate(latitude1.getDegrees(), latitude1.getMinutes(), latitude1.getSeconds(),
						longitude1.getDegrees(), longitude1.getMinutes(), longitude1.getSeconds(),
						latitude2.getDegrees(), latitude2.getMinutes(), latitude2.getSeconds(), longitude2.getDegrees(),
						longitude2.getMinutes(), longitude2.getSeconds())
				.clickSearchAreaButton().initElementsAfterSuccessfulSearch().searchTableByText(SEARCH_TABLE_TEXT);
		List<String> tablevalues = spage.getSearchResultsTable().getSearchResultIdValues();
		Set<String> ids = new HashSet<>(tablevalues);
		assertTrue(expectedIdsSearch.equals(ids), "Incorrect results of search in results table");
		assertEquals(spage.getSearchResultsTable().getSearchResultRows().size(), expectedIdsSearch.size(),
				"Incorrect number of results of search in results table");
		assertEquals(spage.getSearchResultsTable().getDataTextInfo().getText(), TEXT_INFO_FILTER_1_3,
				"Search in result table text info incorrect");
	}

	@Test(groups = "main", dataProvider = "testTableSearchText")
	public void testTableUnsuccessSearchText(Coordinate latitude1, Coordinate longitude1, Coordinate latitude2,
			Coordinate longitude2, Set<String> expectedIdsSearch) {
		spage = resourcesSearchPage.clickSearchByArea()
				.putAreaSearchCoordinate(latitude1.getDegrees(), latitude1.getMinutes(), latitude1.getSeconds(),
						longitude1.getDegrees(), longitude1.getMinutes(), longitude1.getSeconds(),
						latitude2.getDegrees(), latitude2.getMinutes(), latitude2.getSeconds(), longitude2.getDegrees(),
						longitude2.getMinutes(), longitude2.getSeconds())
				.clickSearchAreaButton().initElementsAfterSuccessfulSearch()
				.searchTableByText(SEARCH_UNSUCCESSFUL_TABLE_TEXT);
		FlexAssert.get().forElement(spage.getUnsuccessfulSearchResultLabel().getText()).valueMatch("No matching records found")
		.next().forElement(spage.getSearchResultsTable().getSearchResultRows().size()).valueMatch(1);
	}

	@BeforeGroups(groups = { "pagination" })
	public void setPagination() {
		double[] coordsData = DataTestRepository.get().getCoords();
		spage = resourcesSearchPage.clickSearchByArea()
				.putAreaSearchCoordinate((int) coordsData[0], (int) coordsData[1], coordsData[2], (int) coordsData[3],
						(int) coordsData[4], coordsData[5], (int) coordsData[6], (int) coordsData[7], coordsData[8],
						(int) coordsData[9], (int) coordsData[10], coordsData[11])
				.clickSearchAreaButton().initElementsAfterSuccessfulSearch();
	}

	@DataProvider
	public Object[][] testPaginationNumberResults() {
		return DataTestRepository.get().getPaginationNumberResults();
	}

	@Test(groups = "pagination", dataProvider = "testPaginationNumberResults")
	public void testPaginationNumberResults(Coordinate latitude1, Coordinate longitude1, Coordinate latitude2,
			Coordinate longitude2, String messageTableFooterBy10, String messageTableFooterBy25) {
		assertEquals(spage.getSearchResultsTable().getDataTextInfo().getText(), messageTableFooterBy10,
				"Incorrect pagination info");
		spage.getSearchResultsTable().setNumberResultsByPageByPartialText(RESULTS_BY_PAGE_2);
		assertEquals(spage.getSearchResultsTable().getDataTextInfo().getText(), messageTableFooterBy25,
				"Incorrect pagination info");
		spage.getSearchResultsTable().setNumberResultsByPageByPartialText(RESULTS_BY_PAGE_1);
	}

	@Test(groups = "pagination", dataProvider = "testPaginationNumberResults")
	public void testPaginationNextResults(Coordinate latitude1, Coordinate longitude1, Coordinate latitude2,
			Coordinate longitude2, String messageTableFooterBy10, String messageTableFooterBy25) {
		spage.getSearchResultsTable().getBtnPaginateNext().click();
		spage = new ResourceSearchPage().initElementsAfterSuccessfulSearch();

		assertEquals(spage.getSearchResultsTable().getDataTextInfo().getText(), TEXT_INFO_11_14,
				"Search by area result text info incorrect");
		assertEquals(spage.getSearchResultsTable().getSearchResultRows().size(), 4);
		spage.getSearchResultsTable().getBtnPaginatePrevious().click();
		spage = new ResourceSearchPage().initElementsAfterSuccessfulSearch();
		assertEquals(spage.getSearchResultsTable().getDataTextInfo().getText(), TEXT_INFO_1_10,
				"Search by area result text info incorrect");
		assertEquals(spage.getSearchResultsTable().getSearchResultRows().size(), 10);
	}

	@DataProvider
	public Object[][] sortedByDateResults() {
		return DataTestRepository.get().getSortedByDateResults();
	}

	@Test(groups = "pagination", dataProvider = "sortedByDateResults")
	public void testSortTableColumnDate(List<ResourceBrief> resources) throws ParseException {
		spage.getSearchResultsTable().getTableColumnDate().click();
		spage = new ResourceSearchPage().initElementsAfterSuccessfulSearch();
		ResourceBriefUtils.sortByDate(resources);
		List<Date> expectedDates = ResourceBriefUtils.getDates(resources);
		List<Date> tableDates = spage.getSearchResultsTable().getSearchResultDateValues();
		for (int i = 0; i < 10; i++) {
			System.out.println("" + expectedDates.get(i) + "  " + tableDates.get(i));
			assertEquals(expectedDates.get(i), tableDates.get(i), "Sort by date is incorrect");
		}
	}

	@Test(groups = "pagination", dataProvider = "sortedByDateResults")
	public void testSortTableColumnIdentifier(List<ResourceBrief> resources) {
		spage.getSearchResultsTable().getTableColumnId().click();
		spage = new ResourceSearchPage().initElementsAfterSuccessfulSearch();
		ResourceBriefUtils.sortById(resources);
		List<String> expectedIds = ResourceBriefUtils.getIdentifiers(resources);
		List<String> tableIds = spage.getSearchResultsTable().getSearchResultIdValues();
		System.out.println(expectedIds);
		System.out.println(tableIds);
		for (int i = 0; i < 10; i++) {
			assertEquals(expectedIds.get(i), tableIds.get(i), "Sort by identifier is incorrect");
		}
	}
	// tests with Javascript injection

	@Test(groups = "JScript", dataProvider = "testCoordinates")
	public void testOnMapByPointFound(Coordinate latitude, Coordinate longitude, Set<String> expectedIds) {
		ResourceSearchPage spage = resourcesSearchPage;
		JSInjection.executeClickMap(spage, latitude, longitude);
		spage.initElementsAfterSuccessfulSearch();
		List<String> tablevalues = spage.getSearchResultsTable().getSearchResultIdValues();
		Set<String> ids = new HashSet<>(tablevalues);
		assertTrue(expectedIds.equals(ids), "Incorrect results in search by point (map click)");
		spage.initElementsAfterSuccessfulSearch();
		assertEquals(spage.getSearchResultsTable().getSearchResultRows().size(), expectedIds.size(),
				"Incorrect number of results in search by point (map click)");
		assertEquals(spage.getSearchResultsTable().getDataTextInfo().getText(), TEXT_INFO_1_2,
				"Incorrect text label in search by point (map click)");
	}

	@Test(groups = "JScript", dataProvider = "testCoordinates_")
	public void testOnMapByPointNotFound(Coordinate latitude, Coordinate longitude) {
		ResourceSearchPage spage = resourcesSearchPage;
		JSInjection.executeClickMap(spage, latitude, longitude);
		spage.initElementsAfterUnsuccessfulSearch();
		assertEquals(spage.getSearchResultDiv().getText(), UNSUCCESSFUL_SEARCH_LABEL_UKR,
				"No unsuccessful search by point(click map) text label found");
	}

	@DataProvider
	public Object[][] testShowAll() {
		return DataTestRepository.get().getShowAll();
	}

	@Test(groups = "params", dataProvider = "testShowAll")
	public void testFindAll(HashSet<String> expectedIds, String textInfo) {
		spage = resourcesSearchPage.clickSearchByParameters();
		spage.getSearchByParametersComponent().getBtnShowAll().click();
		List<String> tablevalues = spage.initElementsAfterSuccessfulSearch().getSearchResultsTable()
				.getSearchResultIdValues();
		Set<String> ids = new HashSet<>(tablevalues);
		assertTrue(expectedIds.equals(ids), "Search by area results are not correct");
		assertEquals(spage.getSearchResultsTable().getSearchResultRows().size(), expectedIds.size(),
				"Number of search by area results are not correct");
		assertEquals(spage.getSearchResultsTable().getDataTextInfo().getText(), textInfo,
				"Search by area result text info incorrect");
	}

	@DataProvider
	public Object[][] testShowAllSelect() {
		return DataTestRepository.get().getShowAllSelect();
	}

	@Test(groups = "params", dataProvider = "testShowAllSelect")
	public void testFindAllSelect(HashSet<String> expectedIds, String textInfo) {
		spage = resourcesSearchPage.clickSearchByParameters();
		spage.getSearchByParametersComponent().setListObjectSubclasses(ObjectSubclasses.RADIO);
		spage = spage.changeParameters();
		List<String> tablevalues = spage.initElementsAfterSuccessfulSearch1().getSearchResultsTable()
				.getSearchResultIdValues();
		Set<String> ids = new HashSet<>(tablevalues);
		assertTrue(expectedIds.equals(ids), "Search by area results are not correct");
		assertEquals(spage.getSearchResultsTable().getSearchResultRows().size(), expectedIds.size(),
				"Number of search by area results are not correct");
		assertEquals(spage.getSearchResultsTable().getDataTextInfo().getText(), textInfo,
				"Search by area result text info incorrect");
	}
}
