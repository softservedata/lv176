package com.softserve.edu.atqc.data;

import java.util.List;

import com.softserve.edu.atqc.data.apps.ApplicationSources;
import com.softserve.edu.atqc.exceptions.GeneralCustomException;

public final class ListUtils {
	private static final String COLUMNS_NUMBER_ERROR = "Columns Number must be bigger than 1";
	private static final String LISTS_EQUAL_ERROR = "Size of Lists must be equal";
	private static final String ARRAY_LISTS_ERROR = "Array of Lists is Empty";
	//
	private static volatile ListUtils instance = null;

	private ListUtils() {
	}

	public static ListUtils get() {
		if (instance == null) {
			synchronized (ListUtils.class) {
				if (instance == null) {
					instance = new ListUtils();
				}
			}
		}
		return instance;
	}

	public Object[][] toMultiArray(List<?> list) {
		Object[][] array = new Object[list.size()][1];
		for (int i = 0; i < list.size(); i++) {
			array[i][0] = list.get(i);
		}
		return array;
	}

	public Object[][] toMultiArrayNumber(List<?> list, int columnsNumber) {
		if (columnsNumber < 2) {
			throw new GeneralCustomException(COLUMNS_NUMBER_ERROR);
		}
		Object[][] array = new Object[list.size()][columnsNumber];
		for (int i = 0; i < list.size(); i++) {
			array[i][0] = list.get(i);
			for (int j = 1; j < columnsNumber; j++)
				array[i][j] = null;
		}
		return array;
	}

	public Object[][] toMultiArrayNumber(int columnsNumber, List<?> list) {
		if (columnsNumber < 2) {
			throw new GeneralCustomException(COLUMNS_NUMBER_ERROR);
		}
		Object[][] array = new Object[list.size()][columnsNumber];
		for (int i = 0; i < list.size(); i++) {
			array[i][columnsNumber - 1] = list.get(i);
			for (int j = 0; j < columnsNumber - 1; j++)
				array[i][j] = null;
		}
		return array;
	}

	public Object[][] toMultiArrayNumber(ApplicationSources applicationSources, List<?> list) {
		Object[][] array = toMultiArrayNumber(2, list);
		for (int i = 0; i < list.size(); i++) {
			array[i][0] = applicationSources;
		}
		return array;
	}

	public Object[][] toMultiArrayNumber(List<ApplicationSources> applicationSources, List<?> list) {
		if (applicationSources.size() != list.size()) {
			throw new GeneralCustomException(LISTS_EQUAL_ERROR);
		}
		Object[][] array = toMultiArrayNumber(2, list);
		for (int i = 0; i < list.size(); i++) {
			array[i][0] = applicationSources.get(i);
		}
		return array;
	}

	public Object[][] toMultiArrayNumberParams(ApplicationSources applicationSources, List<?>... list) {
		if ((list == null) || (list.length == 0)) {
			throw new GeneralCustomException(ARRAY_LISTS_ERROR);
		}
		for (int i = 1; i < list.length; i++) {
			if (list[0].size() != list[i].size()) {
				throw new GeneralCustomException(LISTS_EQUAL_ERROR);
			}
		}
		Object[][] array = new Object[list[0].size()][list.length + 1];
		for (int i = 0; i < list[0].size(); i++) {
			array[i][0] = applicationSources;
			//array[i][columnsNumber - 1] = list.get(i);
			for (int j = 0; j < list.length; j++)
				array[i][j+1] = list[j].get(i);
		}
		return array;
	}

	// TODO
//	public Object[][] toMultiArrayNumberParams(List<ApplicationSources> applicationSources, List<?>... list) {
//		return null;
//	}

}
