package com.softserve.edu.atqc.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.softserve.edu.atqc.exceptions.GeneralCustomException;

public class ExcelUtils implements IExternalData {
	private final String FILE_NOT_READ = " File %s could not be read";
	private final String FILE_NOT_ACCESIBLE = " File %s could not be Accesible";
	private final String FILE_NOT_CLOSE = " File %s could not be closed";

	public List<List<String>> getAllCells(String absoluteFilePath) {
		List<List<String>> allRows = new ArrayList<List<String>>();
		InputStream inputStream = null;
		DataFormatter formatter = new DataFormatter();  
		XSSFWorkbook workBook = null;
		Sheet sheet = null;
		try {
			inputStream = new FileInputStream(absoluteFilePath);
			workBook = new XSSFWorkbook(inputStream);
			sheet =workBook.getSheetAt(0);
		} catch (FileNotFoundException e) {
			throw new GeneralCustomException(String.format(FILE_NOT_READ, absoluteFilePath));
		} catch (IOException e) {
			throw new GeneralCustomException(String.format(FILE_NOT_ACCESIBLE, absoluteFilePath));
		}
		Iterator<Row> rowsIterator = sheet.iterator();
		while (rowsIterator.hasNext()) {
			Row row = rowsIterator.next();
			Iterator<Cell> cellsIterator = row.iterator();
			List<String> allCells = new ArrayList<String>();
			while (cellsIterator.hasNext()) {
				String cell = formatter.formatCellValue(cellsIterator.next());
				allCells.add(cell);
			}
			allRows.add(allCells);
		}
		if (workBook != null) {
			try {
				workBook.close();
			} catch (IOException e) {
				throw new GeneralCustomException(String.format(FILE_NOT_CLOSE, absoluteFilePath), e);
			}
		}
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				throw new GeneralCustomException(String.format(FILE_NOT_CLOSE, absoluteFilePath), e);
			}
		}
		return allRows;
	}
}
