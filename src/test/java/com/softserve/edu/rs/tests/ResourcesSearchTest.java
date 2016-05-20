package com.softserve.edu.rs.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.atqc.data.apps.ABaseApplication;
import com.softserve.edu.atqc.data.apps.ApplicationSources;
import com.softserve.edu.rs.data.apps.Application;
import com.softserve.edu.rs.data.apps.ApplicationSourcesRepository;
import com.softserve.edu.rs.data.users.IUser;
import com.softserve.edu.rs.data.users.UserRepository;
import com.softserve.edu.atqc.tools.Coordinate;
import com.softserve.edu.rs.pages.RegistratorHomePage;
import com.softserve.edu.rs.pages.ResourceSearchPage;
import com.softserve.edu.rs.pages.TopPage.ChangeLanguageFields;

public class ResourcesSearchTest {
	private static final String UNSUCCESSFUL_SEARCH_LABEL_UKR = "За заданими параметрами ресурси не знайдено.";
	private static final String UNSUCCESSFUL_SEARCH_LABEL_RUS = "По заданным параметрам ресурсы не найдены.";
	private static final String UNSUCCESSFUL_SEARCH_LABEL_ENG = "Resources not found.";
	private static final String SEARCH_TABLE_TEXT = "Ділянка";
	private static final String[] RESOURCE_ID = { "123:44:35:445:34567:3457", "123:33:33:333:33333:2222" };
	private static final String[] RESOURCE_ID_SEARCH = { "123:44:35:445:34567:3457" };
	private static Set<String> expectedIds;
	private static Set<String> expectedIdsSearch;
	private Application application;
	private RegistratorHomePage registratorHomePage;
	private ResourceSearchPage resourcesSearchPage;
	private ResourceSearchPage spage;

	@DataProvider
	public Object[][] getApplicationSources() {
		return new Object[][] { { ApplicationSourcesRepository.get().getLocalHostByFirefoxTemporary(),
				UserRepository.get().getRegistrator() }, };
	}

	@BeforeClass(groups = { "main", "JScript" })
	public void oneTimeSetUp() {

		IUser registrator = UserRepository.get().getRegistrator();
		ApplicationSources applicationSources = ApplicationSourcesRepository.get().getLocalHostByFirefoxTemporary();
		Application application = Application.get(applicationSources);
		registratorHomePage = application.load().successRegistratorLogin(registrator);
		registratorHomePage.changeLanguage(ChangeLanguageFields.UKRAINIAN);
		resourcesSearchPage = registratorHomePage.gotoResourcesSearchPage();
		expectedIds = new HashSet<String>(Arrays.asList(RESOURCE_ID));
		expectedIdsSearch = new HashSet<String>(Arrays.asList(RESOURCE_ID_SEARCH));
	}

	@AfterClass(groups = { "main", "JScript" })
	public void oneTimeTearDown() {
		application.quitAll();
	}

	@DataProvider
	public Object[][] testCoordinates() {
		return DataTestRepository.get().getSearchByPointCoordinates();
	}

	@Test(groups = "main", dataProvider = "testCoordinates")
	public void testFound(Coordinate latitude, Coordinate longitude) {
		spage = resourcesSearchPage.clickSearchByCoordinate()
				.putPointSearchCoordinate(latitude.getDegrees(), latitude.getMinutes(), latitude.getSeconds(),
						longitude.getDegrees(), longitude.getMinutes(), longitude.getSeconds())
				.clickSearchButton().initElementsAfterSuccessfulSearch();
		List<String> tablevalues = spage.getSearchResultsTable().getSearchResultIdValues();
		Set<String> ids = new HashSet<>(tablevalues);
		assertTrue(expectedIds.equals(ids), "Search by point results are not correct");
		assertEquals(spage.getSearchResultsTable().getSearchResultRows().size(), expectedIds.size(),
				"Search by point number of results are not correct");
		assertEquals(spage.getSearchResultsTable().getDataTextInfo().getText(), "Showing 1 to 2 of 2 entries",
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

		assertEquals(spage.getSearchResultDiv().getText(), UNSUCCESSFUL_SEARCH_LABEL_UKR,
				"No unsuccessful search by point text label found");
	}

	@DataProvider
	public Object[][] testAreaCoordinates() {
		return DataTestRepository.get().getSearchByAreaCoordinates();
	}

	@Test(groups = "main", dataProvider = "testAreaCoordinates")
	public void testAreaFound(Coordinate latitude1, Coordinate longitude1, Coordinate latitude2,
			Coordinate longitude2) {
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
		assertEquals(spage.getSearchResultsTable().getDataTextInfo().getText(), "Showing 1 to 2 of 2 entries",
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
		assertEquals(spage.getSearchResultDiv().getText(), UNSUCCESSFUL_SEARCH_LABEL_UKR,
				"No unsuccessful search by area text label found");
	}

	@Test(groups = "main", dataProvider = "testAreaCoordinates")
	public void testTableSearchText(Coordinate latitude1, Coordinate longitude1, Coordinate latitude2,
			Coordinate longitude2) {
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
		assertEquals(spage.getSearchResultsTable().getDataTextInfo().getText(),
				"Showing 1 to 1 of 1 entries (filtered from 2 total entries)",
				"Search in result table text info incorrect");
	}

	// tests with Javascript injection

	@Test(groups = "JScript", dataProvider = "testCoordinates")
	public void testOnMapByPointFound(Coordinate latitude, Coordinate longitude) {
		ResourceSearchPage spage = resourcesSearchPage;
		JSInjection.executeClickMap(spage, latitude, longitude);
		spage.initElementsAfterSuccessfulSearch();
		List<String> tablevalues = spage.getSearchResultsTable().getSearchResultIdValues();
		Set<String> ids = new HashSet<>(tablevalues);
		assertTrue(expectedIds.equals(ids), "Incorrect results in search by point (map click)");
		spage.initElementsAfterSuccessfulSearch();
		assertEquals(spage.getSearchResultsTable().getSearchResultRows().size(), expectedIds.size(),
				"Incorrect number of results in search by point (map click)");
		assertEquals(spage.getSearchResultsTable().getDataTextInfo().getText(), "Showing 1 to 2 of 2 entries",
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
}