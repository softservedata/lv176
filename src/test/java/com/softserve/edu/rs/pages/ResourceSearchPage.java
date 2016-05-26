package com.softserve.edu.rs.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.atqc.controls.Component;
import com.softserve.edu.atqc.controls.IButton;
import com.softserve.edu.atqc.controls.IComponent;
import com.softserve.edu.atqc.controls.ILabel;
import com.softserve.edu.atqc.controls.ILabelClickable;
import com.softserve.edu.atqc.controls.ISelect;
import com.softserve.edu.atqc.controls.ITextField;
import com.softserve.edu.atqc.controls.Label;
import com.softserve.edu.atqc.controls.LabelClickable;
import com.softserve.edu.atqc.controls.Select;
import com.softserve.edu.atqc.controls.TextField;
import com.softserve.edu.atqc.tools.BrowserUtils;
import com.softserve.edu.rs.pages.TopPage.ChangeLanguageFields;

public class ResourceSearchPage extends RegistratorCommonPage {
	public static enum ObjectSubclasses {
		LAND("земельний"), RADIO("радіочастотний");

		private String field;

		private ObjectSubclasses(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}

	private class SearchResultsTable implements ISearchResultsTable {
		private IComponent tableOfResults;
		private ILabel dataTextInfo;
		private ILabel paginateInfo;
		private ITextField searchTableTextInput;
		private ISelect numberResultsByPage;
		// private WebDriver driver;

		public ITextField getSearchTableTextInput() {
			return searchTableTextInput;
		}

		public SearchResultsTable(boolean b) {
			tableOfResults = Component.get().getById("datatable");
			if (b)
				searchTableTextInput = TextField.get().getByCssSelector("#datatable_filter input");
			else
				searchTableTextInput = TextField.get().getByCssSelector("input[aria-controls='datatable']");
			numberResultsByPage=Select.get().getByCssSelector("#datatable_length select");
			dataTextInfo = Label.get().getById("datatable_info");
			paginateInfo = Label.get().getById("datatable_paginate");
		}

		public IComponent getTableOfResults() {
			return tableOfResults;
		}

		public ILabel getDataTextInfo() {
			return dataTextInfo;
		}

		public ILabel getPaginateInfo() {
			return paginateInfo;
		}

		public List<WebElement> getSearchResultValues() {
			return Component.get().getElementsByCssSelector("tbody td");
		}

		public List<String> getSearchResultTextValues() {
			List<WebElement> elements = Component.get().getElementsByCssSelector("tbody td");
			List<String> result = new ArrayList<>();
			for (WebElement e : elements) {
				result.add(e.getText());
			}
			return result;

		}

		public List<String> getSearchResultIdValues() {
			List<WebElement> elements = Component.get().getElementsByCssSelector(" td:nth-child(3)");
			List<String> result = new ArrayList<>();
			for (WebElement e : elements) {
				result.add(e.getText());
			}
			return result;

		}

		public List<WebElement> getSearchResultRows() {
			return Component.get().getElementsByCssSelector("tbody tr");
		}
	}

	private class SearchByAreaComponent implements ISearchByArea {
		private static final String SELECTOR_LATITUDE_DEGREES_1 = "#first_point .latitudeDegrees.form-control";
		private static final String SELECTOR_LATITUDE_MINUTES_1 = "#first_point .latitudeMinutes.form-control";
		private static final String SELECTOR_LATITUDE_SECONDS_1 = "#first_point .latitudeSeconds.form-control";
		private static final String SELECTOR_LONGITUDE_DEGREES_1 = "#first_point .longitudeDegrees.form-control";
		private static final String SELECTOR_LONGITUDE_MINUTES_1 = "#first_point .longitudeMinutes.form-control";
		private static final String SELECTOR_LONGITUDE_SECONDS_1 = "#first_point .longitudeSeconds.form-control";
		private static final String SELECTOR_LATITUDE_DEGREES_2 = "#second_point .latitudeDegrees.form-control";
		private static final String SELECTOR_LATITUDE_MINUTES_2 = "#second_point .latitudeMinutes.form-control";
		private static final String SELECTOR_LATITUDE_SECONDS_2 = "#second_point .latitudeSeconds.form-control";
		private static final String SELECTOR_LONGITUDE_DEGREES_2 = "#second_point .longitudeDegrees.form-control";
		private static final String SELECTOR_LONGITUDE_MINUTES_2 = "#second_point .longitudeMinutes.form-control";
		private static final String SELECTOR_LONGITUDE_SECONDS_2 = "#second_point .longitudeSeconds.form-control";

		private ITextField searchByAreaLatitudeDegrees1;
		private ITextField searchByAreaLatitudeMinutes1;
		private ITextField searchByAreaLatitudeSeconds1;
		private ITextField searchByAreaLongitudeDegrees1;
		private ITextField searchByAreaLongitudeMinutes1;
		private ITextField searchByAreaLongitudeSeconds1;
		private ITextField searchByAreaLatitudeDegrees2;
		private ITextField searchByAreaLatitudeMinutes2;
		private ITextField searchByAreaLatitudeSeconds2;
		private ITextField searchByAreaLongitudeDegrees2;
		private ITextField searchByAreaLongitudeMinutes2;
		private ITextField searchByAreaLongitudeSeconds2;

		public SearchByAreaComponent() {
			searchByAreaLatitudeDegrees1 = TextField.get().getByCssSelector(SELECTOR_LATITUDE_DEGREES_1);
			searchByAreaLatitudeMinutes1 = TextField.get().getByCssSelector(SELECTOR_LATITUDE_MINUTES_1);
			searchByAreaLatitudeSeconds1 = TextField.get().getByCssSelector(SELECTOR_LATITUDE_SECONDS_1);
			searchByAreaLongitudeDegrees1 = TextField.get().getByCssSelector(SELECTOR_LONGITUDE_DEGREES_1);
			searchByAreaLongitudeMinutes1 = TextField.get().getByCssSelector(SELECTOR_LONGITUDE_MINUTES_1);
			searchByAreaLongitudeSeconds1 = TextField.get().getByCssSelector(SELECTOR_LONGITUDE_SECONDS_1);
			searchByAreaLatitudeDegrees2 = TextField.get().getByCssSelector(SELECTOR_LATITUDE_DEGREES_2);
			searchByAreaLatitudeMinutes2 = TextField.get().getByCssSelector(SELECTOR_LATITUDE_MINUTES_2);
			searchByAreaLatitudeSeconds2 = TextField.get().getByCssSelector(SELECTOR_LATITUDE_SECONDS_2);
			searchByAreaLongitudeDegrees2 = TextField.get().getByCssSelector(SELECTOR_LONGITUDE_DEGREES_2);
			searchByAreaLongitudeMinutes2 = TextField.get().getByCssSelector(SELECTOR_LONGITUDE_MINUTES_2);
			searchByAreaLongitudeSeconds2 = TextField.get().getByCssSelector(SELECTOR_LONGITUDE_SECONDS_2);
		}

		public ITextField getSearchByAreaLatitudeDegrees1() {
			return searchByAreaLatitudeDegrees1;
		}

		public ITextField getSearchByAreaLatitudeMinutes1() {
			return searchByAreaLatitudeMinutes1;
		}

		public ITextField getSearchByAreaLatitudeSeconds1() {
			return searchByAreaLatitudeSeconds1;
		}

		public ITextField getSearchByAreaLongitudeDegrees1() {
			return searchByAreaLongitudeDegrees1;
		}

		public ITextField getSearchByAreaLongitudeMinutes1() {
			return searchByAreaLongitudeMinutes1;
		}

		public ITextField getSearchByAreaLongitudeSeconds1() {
			return searchByAreaLongitudeSeconds1;
		}

		public ITextField getSearchByAreaLatitudeDegrees2() {
			return searchByAreaLatitudeDegrees2;
		}

		public ITextField getSearchByAreaLatitudeMinutes2() {
			return searchByAreaLatitudeMinutes2;
		}

		public ITextField getSearchByAreaLatitudeSeconds2() {
			return searchByAreaLatitudeSeconds2;
		}

		public ITextField getSearchByAreaLongitudeDegrees2() {
			return searchByAreaLongitudeDegrees2;
		}

		public ITextField getSearchByAreaLongitudeMinutes2() {
			return searchByAreaLongitudeMinutes2;
		}

		public ITextField getSearchByAreaLongitudeSeconds2() {
			return searchByAreaLongitudeSeconds2;
		}

		public void setLatitudeDegrees1Clear(String latitudeDegrees1) {
			getSearchByAreaLatitudeDegrees1().sendKeysClear(latitudeDegrees1);
		}

		public void setLatitudeMinutes1Clear(String latitudeMinutes1) {
			getSearchByAreaLatitudeMinutes1().sendKeysClear(latitudeMinutes1);
		}

		public void setLatitudeSeconds1Clear(String latitudeSeconds1) {
			getSearchByAreaLatitudeSeconds1().sendKeysClear(latitudeSeconds1);
		}

		public void setLatitudeDegrees2Clear(String latitudeDegrees2) {
			getSearchByAreaLatitudeDegrees2().sendKeysClear(latitudeDegrees2);
		}

		public void setLatitudeMinutes2Clear(String latitudeMinutes2) {
			getSearchByAreaLatitudeMinutes2().sendKeysClear(latitudeMinutes2);
		}

		public void setLatitudeSeconds2Clear(String latitudeSeconds2) {
			getSearchByAreaLatitudeSeconds2().sendKeysClear(latitudeSeconds2);
		}

		public void setLongitudeDegrees1Clear(String LongitudeDegrees1) {
			getSearchByAreaLongitudeDegrees1().sendKeysClear(LongitudeDegrees1);
		}

		public void setLongitudeMinutes1Clear(String LongitudeMinutes1) {
			getSearchByAreaLongitudeMinutes1().sendKeysClear(LongitudeMinutes1);
		}

		public void setLongitudeSeconds1Clear(String LongitudeSeconds1) {
			getSearchByAreaLongitudeSeconds1().sendKeysClear(LongitudeSeconds1);
		}

		public void setLongitudeDegrees2Clear(String LongitudeDegrees2) {
			getSearchByAreaLongitudeDegrees2().sendKeysClear(LongitudeDegrees2);
		}

		public void setLongitudeMinutes2Clear(String LongitudeMinutes2) {
			getSearchByAreaLongitudeMinutes2().sendKeysClear(LongitudeMinutes2);
		}

		public void setLongitudeSeconds2Clear(String LongitudeSeconds2) {
			getSearchByAreaLongitudeSeconds2().sendKeysClear(LongitudeSeconds2);
		}

		public SearchByAreaComponent putAreaSearchCoordinate(int latitudeDegrees1, int latitudeMinutes1,
				double latitudeSeconds1, int longitudeDegrees1, int longitudeMinutes1, double longitudeSeconds1,
				int latitudeDegrees2, int latitudeMinutes2, double latitudeSeconds2, int longitudeDegrees2,
				int longitudeMinutes2, double longitudeSeconds2) {

			setLatitudeDegrees1Clear(Integer.toString(latitudeDegrees1));
			setLatitudeMinutes1Clear(Integer.toString(latitudeMinutes1));
			setLatitudeSeconds1Clear(Double.toString(latitudeSeconds1));
			setLongitudeDegrees1Clear(Integer.toString(longitudeDegrees1));
			setLongitudeMinutes1Clear(Integer.toString(longitudeMinutes1));
			setLongitudeSeconds1Clear(Double.toString(longitudeSeconds1));

			setLatitudeDegrees2Clear(Integer.toString(latitudeDegrees2));
			setLatitudeMinutes2Clear(Integer.toString(latitudeMinutes2));
			setLatitudeSeconds2Clear(Double.toString(latitudeSeconds2));
			setLongitudeDegrees2Clear(Integer.toString(longitudeDegrees2));
			setLongitudeMinutes2Clear(Integer.toString(longitudeMinutes2));
			setLongitudeSeconds2Clear(Double.toString(longitudeSeconds2));
			return this;
		}
	}

	private class SearchByPointComponent implements ISearchByPoint {
		private static final String SELECTOR_LATITUDE_DEGREES = "#searchByPointDiv .latitudeDegrees.form-control";
		private static final String SELECTOR_LATITUDE_MINUTES = "#searchByPointDiv .latitudeMinutes.form-control";
		private static final String SELECTOR_LATITUDE_SECONDS = "#searchByPointDiv .latitudeSeconds.form-control";
		private static final String SELECTOR_LONGITUDE_DEGREES = "#searchByPointDiv .longitudeDegrees.form-control";
		private static final String SELECTOR_LONGITUDE_MINUTES = "#searchByPointDiv .longitudeMinutes.form-control";
		private static final String SELECTOR_LONGITUDE_SECONDS = "#searchByPointDiv .longitudeSeconds.form-control";

		private ITextField searchByCoordinateLatitudeDegrees;
		private ITextField searchByCoordinateLatitudeMinutes;
		private ITextField searchByCoordinateLatitudeSeconds;
		private ITextField searchByCoordinateLongitudeDegrees;
		private ITextField searchByCoordinateLongitudeMinutes;
		private ITextField searchByCoordinateLongitudeSeconds;

		public SearchByPointComponent() {
			searchByCoordinateLatitudeDegrees = TextField.get().getByCssSelector(SELECTOR_LATITUDE_DEGREES);
			searchByCoordinateLatitudeMinutes = TextField.get().getByCssSelector(SELECTOR_LATITUDE_MINUTES);
			searchByCoordinateLatitudeSeconds = TextField.get().getByCssSelector(SELECTOR_LATITUDE_SECONDS);
			searchByCoordinateLongitudeDegrees = TextField.get().getByCssSelector(SELECTOR_LONGITUDE_DEGREES);
			searchByCoordinateLongitudeMinutes = TextField.get().getByCssSelector(SELECTOR_LONGITUDE_MINUTES);
			searchByCoordinateLongitudeSeconds = TextField.get().getByCssSelector(SELECTOR_LONGITUDE_SECONDS);
		}

		public ITextField getSearchByCoordinateLatitudeDegrees() {
			return searchByCoordinateLatitudeDegrees;
		}

		public ITextField getSearchByCoordinateLatitudeMinutes() {
			return searchByCoordinateLatitudeMinutes;
		}

		public ITextField getSearchByCoordinateLatitudeSeconds() {
			return searchByCoordinateLatitudeSeconds;
		}

		public ITextField getSearchByCoordinateLongitudeDegrees() {
			return searchByCoordinateLongitudeDegrees;
		}

		public ITextField getSearchByCoordinateLongitudeMinutes() {
			return searchByCoordinateLongitudeMinutes;
		}

		public ITextField getSearchByCoordinateLongitudeSeconds() {
			return searchByCoordinateLongitudeSeconds;
		}

		public void setLatitudeDegreesClear(String latitudeDegrees) {
			getSearchByCoordinateLatitudeDegrees().sendKeysClear(latitudeDegrees);
		}

		public void setLatitudeMinutesClear(String latitudeMinutes) {
			getSearchByCoordinateLatitudeMinutes().sendKeysClear(latitudeMinutes);
		}

		public void setLatitudeSecondsClear(String latitudeSeconds) {
			getSearchByCoordinateLatitudeSeconds().sendKeysClear(latitudeSeconds);
		}

		public void setLongitudeDegreesClear(String LongitudeDegrees) {
			getSearchByCoordinateLongitudeDegrees().sendKeysClear(LongitudeDegrees);
		}

		public void setLongitudeMinutesClear(String LongitudeMinutes) {
			getSearchByCoordinateLongitudeMinutes().sendKeysClear(LongitudeMinutes);
		}

		public void setLongitudeSecondsClear(String LongitudeSeconds) {
			getSearchByCoordinateLongitudeSeconds().sendKeysClear(LongitudeSeconds);
		}

		public SearchByPointComponent putPointSearchCoordinate(int latitudeDegrees, int latitudeMinutes,
				double latitudeSeconds, int longitudeDegrees, int longitudeMinutes, double longitudeSeconds) {

			setLatitudeDegreesClear(Integer.toString(latitudeDegrees));
			setLatitudeMinutesClear(Integer.toString(latitudeMinutes));
			setLatitudeSecondsClear(Double.toString(latitudeSeconds));
			setLongitudeDegreesClear(Integer.toString(longitudeDegrees));
			setLongitudeMinutesClear(Integer.toString(longitudeMinutes));
			setLongitudeSecondsClear(Double.toString(longitudeSeconds));

			return this;
		}
	}

	private class SearchByParametersComponent implements ISearchByParameter {

		private static final String SELECTOR_INPUT_PERIMETER = "div[param_id='1'] .form-control.value";
		private static final String SELECTOR_INPUT_AREA = "div[param_id='2'] .form-control.value";
		private static final String SELECTOR_MAX_POWER = "div[param_id='3'] .form-control.value";
		// private Select listObjectSubclasses;
		private ISelect listObjectSubclasses;

		private ISearchParameters searchParameters;

		private class LandResourceParameters implements ISearchParameters {
			private ITextField inputPerimeter;

			private ITextField inputArea;

			@Override
			public void init() {
				inputPerimeter = TextField.get().getByCssSelector(SELECTOR_INPUT_PERIMETER);
				inputArea = TextField.get().getByCssSelector(SELECTOR_INPUT_AREA);

			}

			@Override
			public void input(String... args) {
				if (args.length != 2)
					throw new IllegalArgumentException("Wrong number of parameters");
				inputPerimeter.sendKeysClear(args[0]);
				inputPerimeter.sendKeysClear(args[1]);
				// if (args.length==2) searchByArea.
			}

			@Override
			public List<ILabelClickable> getElements() {

				return new ArrayList<ILabelClickable>(Arrays.asList(inputPerimeter, inputArea));
			}

		}

		private class RadioResourceParameters implements ISearchParameters {
			private ITextField inputMaxPower;

			@Override
			public void init() {
				inputMaxPower = TextField.get().getByCssSelector(SELECTOR_MAX_POWER);

			}

			@Override
			public void input(String... args) {
				if (args.length != 1)
					throw new IllegalArgumentException("Wrong number of parameters");
				inputMaxPower.sendKeysClear(args[0]);
			}

			@Override
			public List<ILabelClickable> getElements() {

				return new ArrayList<ILabelClickable>(Arrays.asList(inputMaxPower));
			}

		}

		private ILabelClickable btnShowAll;

		public SearchByParametersComponent(ObjectSubclasses subclass) {
			listObjectSubclasses = Select.get().getById("resourcesTypeSelect");
			switch (subclass){
			case LAND: searchParameters = new LandResourceParameters();break;
			case RADIO: searchParameters = new RadioResourceParameters();break;
			}
			searchParameters.init();

		}

//		public SearchByParametersComponent(boolean bool) {
//			if (bool)
//				listObjectSubclasses = Select.get().getById("resourcesTypeSelect");
//		}

		public ISelect getListObjectSubclasses() {
			return listObjectSubclasses;
		}

		public ILabelClickable getListObjectSubclassesSelected() {
			return getListObjectSubclasses().getFirstSelectedOption();
		}

		public String getListObjectSubclassesSelectedText() {
			return getListObjectSubclasses().getText();
		}

		public void setListObjectSubclasses(ObjectSubclasses subclass) {
			getListObjectSubclasses().selectByVisibleText(subclass.toString());
		}

		public void setListObjectSubclassesByPartialText(String partialText) {
			getListObjectSubclasses().selectByPartialText(partialText);
		}

		public ITextField getInputPerimeter() {
			if (searchParameters.getElements().get(0) instanceof ITextField)
				return (ITextField) searchParameters.getElements().get(0);
			return null;
		}

		public ITextField getInputArea() {
			if (searchParameters.getElements().get(1) instanceof ITextField)
				return (ITextField) searchParameters.getElements().get(1);
			return null;
		}

		public ILabelClickable getBtnShowAll() {
			return btnShowAll;
		}

		public void setInputPerimeter(String inputPerimeter) {
			searchParameters.input(inputPerimeter, "");
		}

		public void setInputArea(String inputArea) {
			searchParameters.input("", inputArea);
		}
	}

	private ILabelClickable searchByCoordinate;
	private ILabelClickable searchByArea;
	private ILabelClickable searchByParameters;
	private ILabelClickable btnSearch;
	private ILabelClickable btnSearchArea;

	private SearchResultsTable searchResultsTable;
	private ILabelClickable searchResultDiv;
	private SearchByAreaComponent searchByAreaComponent;
	private SearchByParametersComponent searchByParametersComponent;
	private SearchByPointComponent searchByPointComponent;
	private JavascriptExecutor jsExecutor;

	public ISearchResultsTable getSearchResultsTable() {

		return searchResultsTable;
	}

	public ISearchByPoint getSearchByPointComponent() {
		return searchByPointComponent;
	}

	public ISearchByArea getSearchByAreaComponent() {
		return searchByAreaComponent;
	}

	public ISearchByParameter getSearchByParametersComponent() {
		return searchByParametersComponent;
	}

	public ResourceSearchPage() {
		searchByCoordinate = LabelClickable.get().getById("searchByPointButton");
		searchByArea = LabelClickable.get().getById("searchByAreaButton");
		searchByParameters = LabelClickable.get().getById("searchByParameterButton");
		jsExecutor = (JavascriptExecutor) BrowserUtils.get().getBrowser().getWebDriver();

	}

	public ILabelClickable getSearchByCoordinate() {
		return searchByCoordinate;
	}

	public ILabelClickable getSearchByArea() {
		return searchByArea;
	}

	public ILabelClickable getSearchByParameters() {
		return searchByParameters;
	}

	public ILabelClickable getBtnSearch() {
		return btnSearch;
	}

	public ILabelClickable getBtnSearchArea() {
		return btnSearchArea;
	}

	public JavascriptExecutor getJsExecutor() {
		return jsExecutor;
	}

	public ResourceSearchPage clickSearchByCoordinate() {
		getSearchByCoordinate().click();
		searchByPointComponent = new SearchByPointComponent();
		btnSearch = LabelClickable.get().getById("searchOnMapButton");
		return this;
	}

	public ResourceSearchPage clickSearchByArea() {
		getSearchByArea().click();
		searchByAreaComponent = new SearchByAreaComponent();
		btnSearchArea = LabelClickable.get().getById("searchOnMapButton_area");
		return this;
	}

	public ResourceSearchPage clickSearchByParameters() {
		getSearchByParameters().click();
		searchByParametersComponent = new SearchByParametersComponent(ObjectSubclasses.LAND);
		searchByParametersComponent.btnShowAll = LabelClickable.get().getById("showAllResources");
		return this;
	}

	public ResourceSearchPage clickSearchButton() {
		getBtnSearch().click();
		return this;
	}

	public ResourceSearchPage clickSearchAreaButton() {
		if (getBtnSearchArea() == null)
			System.out.println("NULL!");
		getBtnSearchArea().click();
		return this;
	}

	public ILabelClickable getSearchResultDiv() {
		return searchResultDiv;
	}

	public ResourceSearchPage initElementsAfterSuccessfulSearch() {
		searchResultsTable = new SearchResultsTable(true);
		return this;
	}

	public ResourceSearchPage initElementsAfterUnsuccessfulSearch() {
		searchResultDiv = LabelClickable.get().getById("searchResult");
		return this;
	}

	public RegistratorHomePage gotoHomePage() {
		clickHomeItem();
		return new RegistratorHomePage();
	}

	public ResourceSearchPage searchTableByText(String searchText) {
		searchResultsTable.getSearchTableTextInput().clear();
		searchResultsTable.getSearchTableTextInput().sendKeys(searchText);
		return this;
	}

	public ResourceSearchPage putPointSearchCoordinate(int latitudeDegrees, int latitudeMinutes, double latitudeSeconds,
			int longitudeDegrees, int longitudeMinutes, double longitudeSeconds) {
		searchByPointComponent.putPointSearchCoordinate(latitudeDegrees, latitudeMinutes, latitudeSeconds,
				longitudeDegrees, longitudeMinutes, longitudeSeconds);

		return this;
	}

	public ResourceSearchPage putAreaSearchCoordinate(int latitudeDegrees1, int latitudeMinutes1,
			double latitudeSeconds1, int longitudeDegrees1, int longitudeMinutes1, double longitudeSeconds1,
			int latitudeDegrees2, int latitudeMinutes2, double latitudeSeconds2, int longitudeDegrees2,
			int longitudeMinutes2, double longitudeSeconds2) {
		searchByAreaComponent.putAreaSearchCoordinate(latitudeDegrees1, latitudeMinutes1, latitudeSeconds1,
				longitudeDegrees1, longitudeMinutes1, longitudeSeconds1, latitudeDegrees2, latitudeMinutes2,
				latitudeSeconds2, longitudeDegrees2, longitudeMinutes2, longitudeSeconds2);
		return this;
	}

	public ResourceSearchPage changeParameters() {
		ResourceSearchPage rsp = new ResourceSearchPage();
		rsp.searchByParametersComponent = new SearchByParametersComponent(ObjectSubclasses.RADIO);
		rsp.searchByParametersComponent.btnShowAll = LabelClickable.get().getById("showAllResources");
		return rsp;
	}

	public ResourceSearchPage initElementsAfterSuccessfulSearch1() {
		searchResultsTable = new SearchResultsTable(false);
		return this;
	}

}
